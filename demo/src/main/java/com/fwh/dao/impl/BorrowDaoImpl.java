package com.fwh.dao.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.fwh.dao.BorrowDao;
import com.fwh.domain.BorrowBook;
import com.fwh.mapper.BorrowMapper;
@Repository
public class BorrowDaoImpl implements BorrowDao {
	@Autowired
	public BorrowMapper borrowMapper;
	public List<BorrowBook> getBorrowBooks(String userId) {
		// TODO Auto-generated method stub
		List<BorrowBook> list = borrowMapper.getBorrowBooks(userId);
		return list;
	}

}
