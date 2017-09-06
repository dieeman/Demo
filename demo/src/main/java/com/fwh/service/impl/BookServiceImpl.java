package com.fwh.service.impl;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.fwh.dao.BookDao;
import com.fwh.domain.Book;
import com.fwh.service.BookService;
@Service
public class BookServiceImpl implements BookService {
	@Autowired
	public BookDao bookDao;
//	@Autowired
//	public RedisCacheUtil redisCacheUtil;
	@Override
	public List<Book> getBookById(String bookId) {
		// TODO Auto-generated method stub
		List<Book> book;
		//从缓存中获取
		//book=(Book) redisCacheUtil.getCacheObject(bookId);
//		if(book==null){
			book = bookDao.getBookById(bookId);
			//将查询结果放入缓存
			//redisCacheUtil.setCacheObject(bookId, book);
//		}		
		return book;
	}
	@Override
	public String getBiggestBookId() {
		// TODO Auto-generated method stub
		String bookid = bookDao.getBiggestBookId();
		return bookid;
	}
	@Override
	public void addBook(Book book) {
		// TODO Auto-generated method stub		
		bookDao.addBook(book);
	}
	@Override
	public void deleteBook(String bookId) {
		// TODO Auto-generated method stub
		bookDao.deleteBook(bookId);
	}
	@Override
	public List<Book> getAllBook() {
		// TODO Auto-generated method stub
		List<Book> booklist=bookDao.getAllBook();
		return booklist;
	}
	

}
