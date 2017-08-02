package com.fwh.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import com.fwh.annotation.sqlUtil;
import com.fwh.domain.Book;
import com.fwh.service.BookService;
import com.fwh.service.impl.DataTransfer;
import com.fwh.util.CreateIdUtil;
import com.fwh.util.DataTransfertionUtil;
import com.fwh.util.GetSysClientUser;
@Controller
@RequestMapping("/book")
public class BookController {
	@Autowired
	public BookService bookService;
	@RequestMapping("/getallbook.do")
	public String getAllBook(){
		return null;
	}
	@RequestMapping("/getbook.do")
	public String getBookById(HttpServletRequest request,ModelMap model){
		String bookId = request.getParameter("bookid");
		Book book = bookService.getBookById(bookId);	
		if(book!=null){
			book.setBookType(DataTransfertionUtil.DataTransfer("book", book.getBookType()));
			model.addAttribute("book", book);
		}
		return "book";		
	}
	@RequestMapping("/getbookbytype.do")
	public List<Book> getBookByType(HttpServletRequest request,ModelMap model){
		return null;
	}
	@RequestMapping("/addbook.do")
	public void addBook(HttpServletRequest request,HttpServletResponse reponse) throws ClassNotFoundException, SQLException{
		String bookName = request.getParameter("bookName");
		String bookid=CreateIdUtil.getBookId();
		String bookType = request.getParameter("bookType");
		String publishTime = request.getParameter("publishTime");
		String author = request.getParameter("author");
		int repertory =Integer.parseInt(request.getParameter("repertory"));
		Book a = new Book();
		a.setAuthor(author);
		a.setBookId(bookid);
		a.setBookName(bookName);
		a.setPublishTime(publishTime);
		a.setBookType(bookType);
		a.setRepertory(repertory);
		bookService.addBook(a);		
		try {
			PrintWriter out = reponse.getWriter();
			out.print("success");
			out.flush();
			out.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
