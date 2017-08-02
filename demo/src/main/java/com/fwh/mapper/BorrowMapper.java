package com.fwh.mapper;

import java.util.List;
import com.fwh.domain.BorrowBook;
public interface BorrowMapper {
	//≤È—ØŒ¥ªπ ÈºÆ
	public List<BorrowBook> getBorrowBooks(String userId);
	
}
