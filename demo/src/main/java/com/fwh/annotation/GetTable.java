package com.fwh.annotation;

import java.io.File;
import java.io.FilenameFilter;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * �õ����е�tableע��
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
	        // �ų��ڲ���
	        return !name.contains("$");
	      }
	    };
	}
	/**
	 * ɨ��ָ�����µ�������
	 * @param packagePath
	 * @return
	 * @throws ClassNotFoundException
	 */
	public Map<String, Class<?>> getClasss(String packagePath) throws ClassNotFoundException{
		 String packPrefix = Thread.currentThread().getContextClassLoader().getResource("").getPath();//��Ŀ·��
		 File dir;
		 File[] fs;
		 if(System.getProperty("file.separator").equals("\\")){
		        packPrefix = packPrefix.substring(1);
		}		
		 String packTmp = packagePath.replace('.', '/');//��·��
		 dir = new File(packPrefix, packTmp);
		 if(dir.isDirectory()){
			 fs = dir.listFiles(javaClassFilter);//��ȡ���·���µ�ȫ���ļ� 
			 if(fs!=null&&fs.length>0){
				for(int i=0;i<fs.length;i++){					 
				 File a = fs[i];
				 String path = a.getAbsolutePath().replace("\\", "/");
			     // ���������ļ�
			     if(path.endsWith(CLASS_FILE_SUFFIX)){
			     String className = (path.substring(path.indexOf(packPrefix)+packPrefix.length())).replace("/", "."); 
			     className = className.substring(0, className.lastIndexOf("."));// ��ȡ����
			     classes.put(className, Class.forName(className));//��class�������map��
			     }
			   }
			}
		 }				
		return classes;
	}
	/**
	 * �ҵ���tableע�����ƴ��sql���
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
	 * �������е�tableע��õ�tablename
	 * @param clazz
	 * @return
	 */
	public  String getTableName(Class<?> clazz) {
		// �ж��Ƿ����Tableע��
		if (clazz.isAnnotationPresent(Table.class)) {
			// ��ȡע�����
			Table table = clazz.getAnnotation(Table.class);
			return "".equals(table.name()) ? clazz.getSimpleName() : table
					.name();
		}else{
			return null;
		}
	}
	/**
	 * �������е�columnע��õ����е�column
	 * @param clazz
	 * @return
	 */
	public String getColumn(Class<?> clazz){
		Field[] fields = clazz.getDeclaredFields();//ͨ������õ��������������
		if(fields!=null&&fields.length>0){
			StringBuilder columns = new StringBuilder();
			for(int i=0;i<fields.length;i++){
				if(fields[i].isAnnotationPresent(Column.class)){
					fields[i].setAccessible(true);//�Ը�˽�г�Ա�������д˲�����ſ��Խ��в���
					Column column = fields[i].getAnnotation(Column.class);//�õ�column����
					//����
					String  columnName = "".equals(column.name()) ? fields[i].getName()
							: column.name();
					//������
					String type = ("".equals(column.types()) ? fields[i].getName()
							: column.types());					
					//����
					String length = "".equals(column.lengths()) ? fields[i].getName()
							: column.lengths();
					//�Ƿ����Ϊ��
					String isnull = (column.isnull() ? "" : " not null");
					//�Ƿ�������
					String primarykey = (column.primarykey() ? " primary key" : "");					
					columns.append(columnName);
					columns.append(" "+type);
					columns.append("("+length+")");
					columns.append(isnull);
					columns.append(primarykey);
					columns.append(",");
				}				
			}
			columns.deleteCharAt(columns.length()-1);//ȥ�����һ����
			return columns.toString();
		}else{
			return null;
		}
	}		
}
