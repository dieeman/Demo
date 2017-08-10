package com.fwh.service;
import com.fwh.domain.Book;
public interface BookService {
	public Book getBookById(String bookId);
	public String getBiggestBookId();
	public void addBook(Book book);
}
