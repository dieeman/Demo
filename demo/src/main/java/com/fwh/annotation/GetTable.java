package com.fwh.annotation;

import java.io.File;
import java.io.FilenameFilter;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 得到所有的table注解
 * @author dieeman
 *
 */
public class GetTable {
	private static Map<String, Class<?>> classes = new HashMap<String, Class<?>>();
	private FilenameFilter	javaClassFilter; 
	private String CLASS_FILE_SUFFIX=".class";
	public GetTable(){
	    javaClassFilter = new FilenameFilter(){
	      @Override
	      public boolean accept(File dir, String name){
	        // 排除内部类
	        return !name.contains("$");
	      }
	    };
	}
	/**
	 * 扫描指定包下的所有类
	 * @param packagePath
	 * @return
	 * @throws ClassNotFoundException
	 */
	public Map<String, Class<?>> getClasss(String packagePath) throws ClassNotFoundException{
		 String packPrefix = Thread.currentThread().getContextClassLoader().getResource("").getPath();//项目路径
		 File dir;
		 File[] fs;
		 if(System.getProperty("file.separator").equals("\\")){
		        packPrefix = packPrefix.substring(1);
		}		
		 String packTmp = packagePath.replace('.', '/');//包路径
		 dir = new File(packPrefix, packTmp);
		 if(dir.isDirectory()){
			 fs = dir.listFiles(javaClassFilter);//获取这个路径下的全部文件 
			 if(fs!=null&&fs.length>0){
				for(int i=0;i<fs.length;i++){					 
				 File a = fs[i];
				 String path = a.getAbsolutePath().replace("\\", "/");
			     // 跳过其他文件
			     if(path.endsWith(CLASS_FILE_SUFFIX)){
			     String className = (path.substring(path.indexOf(packPrefix)+packPrefix.length())).replace("/", "."); 
			     className = className.substring(0, className.lastIndexOf("."));// 获取包名
			     classes.put(className, Class.forName(className));//将class对象放入map中
			     }
			   }
			}
		 }				
		return classes;
	}
	/**
	 * 找到有table注解的类拼接sql语句
	 * @param classMap
	 * @return
	 */
	public List<String> getsql(Map<String, Class<?>> classMap){
		List<String> sqls = new ArrayList<String>();	
		StringBuilder sql = new StringBuilder();
		Class<?> a = null;
		if(classMap!=null){
			for(String key:classMap.keySet()){
				a=classMap.get(key);				
				if(a.isAnnotationPresent(Table.class)){					
					sql.append("create table ");
					sql.append(getTableName(a)+" (");
					sql.append(getColumn(a)+")");	
					sqls.add(sql.toString());
					sql.delete(0,sql.length());
				}
				
			}
		}
		return sqls;
	}
	/**
	 * 根据类中的table注解得到tablename
	 * @param clazz
	 * @return
	 */
	public  String getTableName(Class<?> clazz) {
		// 判断是否具有Table注解
		if (clazz.isAnnotationPresent(Table.class)) {
			// 获取注解对象
			Table table = clazz.getAnnotation(Table.class);
			return "".equals(table.name()) ? clazz.getSimpleName() : table
					.name();
		}else{
			return null;
		}
	}
	/**
	 * 根据类中的column注解得到所有的column
	 * @param clazz
	 * @return
	 */
	public String getColumn(Class<?> clazz){
		Field[] fields = clazz.getDeclaredFields();//通过反射得到该类的所有属性
		if(fields!=null&&fields.length>0){
			StringBuilder columns = new StringBuilder();
			for(int i=0;i<fields.length;i++){
				if(fields[i].isAnnotationPresent(Column.class)){
					fields[i].setAccessible(true);//对该私有成员变量进行此操作后才可以进行操作
					Column column = fields[i].getAnnotation(Column.class);//得到column对象
					//列名
					String  columnName = "".equals(column.name()) ? fields[i].getName()
							: column.name();
					//列类型
					String type = ("".equals(column.types()) ? fields[i].getName()
							: column.types());					
					//长度
					String length = "".equals(column.lengths()) ? fields[i].getName()
							: column.lengths();
					//是否可以为空
					String isnull = (column.isnull() ? "" : " not null");
					//是否是主键
					String primarykey = (column.primarykey() ? " primary key" : "");					
					columns.append(columnName);
					columns.append(" "+type);
					columns.append("("+length+")");
					columns.append(isnull);
					columns.append(primarykey);
					columns.append(",");
				}				
			}
			columns.deleteCharAt(columns.length()-1);//去掉最后一个，
			return columns.toString();
		}else{
			return null;
		}
	}		
}
