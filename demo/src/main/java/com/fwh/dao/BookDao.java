package com.fwh.dao;

import com.fwh.domain.Book;
public interface BookDao {
	public Book getBookById(String bookId);
	public String getBiggestBookId();
	public void addBook(Book book);
}
