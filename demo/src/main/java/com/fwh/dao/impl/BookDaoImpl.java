package com.fwh.dao.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import com.fwh.dao.BookDao;
import com.fwh.domain.Book;
import com.fwh.mapper.BookMapper;
@Repository
public class BookDaoImpl implements BookDao {	
	@Autowired
	public BookMapper bookMapper;
	public List<Book> getBookById(String bookId) {
		// TODO Auto-generated method stub
		List<Book> book = bookMapper.getBookById(bookId);
		return book;
	}

	public String getBiggestBookId() {
		// TODO Auto-generated method stub
		String bookid = bookMapper.getBiggestBookId();
		return bookid;
	}

	public void addBook(Book book) {
		// TODO Auto-generated method stub
		 bookMapper.addBook(book);
		
	}

	@Override
	public void deleteBook(String bookId) {
		// TODO Auto-generated method stub
		bookMapper.deleteBook(bookId);
	}

	@Override
	public List<Book> getAllBook() {
		// TODO Auto-generated method stub
		List<Book> booklist=bookMapper.getAllBook();
		return booklist;
	}
	
}
