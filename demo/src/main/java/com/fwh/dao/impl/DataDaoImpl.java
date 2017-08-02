package com.fwh.dao.impl;

import java.util.HashMap;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.fwh.dao.DataDao;
import com.fwh.mapper.DataMapper;
@Repository
public class DataDaoImpl implements DataDao {
	@Autowired
	public DataMapper dataMaper;
	@Override
	public String Transfer(HashMap<String, String> sqlmap) {
		// TODO Auto-generated method stub
		String value=dataMaper.Transfer(sqlmap);
		return value;
	}

}
