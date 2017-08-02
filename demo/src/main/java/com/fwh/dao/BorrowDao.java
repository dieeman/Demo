package com.fwh.dao;

import java.util.List;

import com.fwh.domain.BorrowBook;

public interface BorrowDao {
	public List<BorrowBook> getBorrowBooks(String userId);
}
