package com.fwh.mapper;

import java.util.List;
import com.fwh.domain.BorrowBook;
public interface BorrowMapper {
	//��ѯδ���鼮
	public List<BorrowBook> getBorrowBooks(String userId);
	
}
