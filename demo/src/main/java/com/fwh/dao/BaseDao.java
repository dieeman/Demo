package com.fwh.dao;

import org.apache.tomcat.jdbc.pool.DataSource;
import org.springframework.beans.factory.annotation.Autowired;

/** 
* @author dieeman
* @date 2017年7月25日 上午11:53:09 
* 
*/
public class BaseDao {
	@Autowired
	public DataSource dataSource;
}
