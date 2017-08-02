package com.fwh.service;

import java.util.List;

import com.fwh.domain.BorrowBook;

public interface BorrowService {
	public List<BorrowBook> getBorrowBooks(String userId);

}
