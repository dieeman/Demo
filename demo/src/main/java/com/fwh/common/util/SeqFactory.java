package com.fwh.common.util;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;
import org.apache.tomcat.jdbc.pool.DataSource;
import com.fwh.util.SpringGetBean;
import com.mysql.jdbc.Connection;
import com.mysql.jdbc.Statement;

/** 
* @author dieeman
* @date 2017年7月25日 下午3:33:10 
* 
*/
public class SeqFactory {
	public Logger logger = Logger.getLogger(SeqFactory.class);
	public static DataSource dataSource = (DataSource) SpringGetBean.getBean("dataSource");
	public SeqFactory seqFactory = null;
	public SeqFactory getInstance(){
		if(seqFactory==null){
			return new SeqFactory();
		}
		else{
			return seqFactory;
		}
	}
	
	public static String get(String tableName) throws SQLException{
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
		SeqFactory.get("");
	}
/**
 * 连接数据库
 * 找到所有表
 * 判断传入的表名是否存在
 * 如果存在 查询该表中的最大id
 * 将id+1后返回
 */
	
}
