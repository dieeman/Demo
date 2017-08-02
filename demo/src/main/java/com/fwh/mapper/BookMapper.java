package com.fwh.mapper;

import java.util.List;

import com.fwh.domain.Book;
public interface BookMapper {
	public Book getBookById(String bookId);
	public String getBiggestBookId();
	public void addBook(Book book);
}
