package com.fwh.service.impl;

import java.util.HashMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fwh.dao.DataDao;
import com.fwh.mapper.DataMapper;
@Service
public class DataTransfer {
	@Autowired
	private DataDao dataDao;
	public  String Transfer(String dataIdentify,String dataType){
		HashMap<String, String> sqlMap = new HashMap<>();
		sqlMap.put("dataIdentify", dataIdentify);
		sqlMap.put("dataType", dataType);
		String value = dataDao.Transfer(sqlMap);
		return value;
	}
}
