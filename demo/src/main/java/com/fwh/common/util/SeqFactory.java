package com.fwh.common.util;
import java.sql.ResultSet;
import java.sql.SQLException;
import org.apache.log4j.Logger;
import org.apache.tomcat.jdbc.pool.DataSource;
import com.fwh.util.SpringGetBean;
import com.mysql.jdbc.Connection;
import com.mysql.jdbc.Statement;

/** 
* @author dieeman
* @date 2017��7��25�� ����3:33:10 
* 
*/
public class SeqFactory {
	public Logger logger = Logger.getLogger(SeqFactory.class);
	public static DataSource dataSource = (DataSource) SpringGetBean.getBean("dataSource");
	private static SeqFactory seqFactory = null;
	/**
	 * ����ģʽ��������ʽ 
	 */
	private SeqFactory(){}
	public static SeqFactory getInstance(){
		if(seqFactory==null){
			return new SeqFactory();
		}else{	
			return seqFactory;
		}
	}
	public  String get(String tableName) throws SQLException{
		Connection conn = (Connection) dataSource.getConnection();
		String gettablesql="select name from information_schema.tables where table_schema='maven3'";
		Statement stmt = (Statement) conn.createStatement();
		ResultSet rs = stmt.executeQuery(gettablesql);
		while(rs.next()){
			System.out.println(rs.getString(0));
		}
		return null;
	}
	public static void main(String args[]) throws SQLException{
		SeqFactory.getInstance().get("");
	}
/**
 * �������ݿ�
 * �ҵ����б�
 * �жϴ���ı����Ƿ����
 * ������� ��ѯ�ñ��е����id
 * ��id+1�󷵻�
 */
	
}
