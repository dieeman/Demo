package com.fwh.dao;

import java.util.List;

import com.fwh.domain.Book;
public interface BookDao {
	public List<Book> getBookById(String bookId);
	public String getBiggestBookId();
	public void addBook(Book book);
	public void deleteBook(String bookId);
	public List<Book> getAllBook();
}
