package com.fwh.annotation;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import javax.sql.DataSource;

import com.fwh.util.SpringGetBean;

/**
 * ����ע���Զ�������
 * @author dieeman
 *
 */
public class sqlUtil{
	private DataSource dataSource=(DataSource) SpringGetBean.getBean("dataSource");
	private GetTable getTable = new GetTable();
	private sqlUtil sqlutil;
	public sqlUtil getIntance(){	
		if(sqlutil==null){
			sqlutil = new sqlUtil();
		}
		return sqlutil;
	}
	
	public void createTable(String packageName) throws ClassNotFoundException, SQLException{
		Connection conn= null;
		PreparedStatement ptsmt=null;
		Map<String, Class<?>> a = getTable.getClasss(packageName);
		List<String> sql = getTable.getsql(a);
		try {
			 conn= (Connection)dataSource.getConnection();
			 for(int i=0;i<sql.size();i++){
				 ptsmt = conn.prepareStatement(sql.get(i));
				 ptsmt.execute();
				 System.out.println("�����ɹ�");
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println("���ݲ���ʧ��");
			e.printStackTrace();
		}
		ptsmt.close();
		conn.close();
	}
	
}
