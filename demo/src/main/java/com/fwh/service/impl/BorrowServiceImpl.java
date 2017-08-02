package com.fwh.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fwh.dao.BorrowDao;
import com.fwh.domain.BorrowBook;
import com.fwh.mapper.BorrowMapper;
import com.fwh.service.BorrowService;
@Service
public class BorrowServiceImpl implements BorrowService{
	@Autowired
	public BorrowDao borrowDao;
	@Override
	public List<BorrowBook> getBorrowBooks(String userId) {
		// TODO Auto-generated method stub
		List<BorrowBook> borrowlist = borrowDao.getBorrowBooks(userId);
		return borrowlist;
	}

}
