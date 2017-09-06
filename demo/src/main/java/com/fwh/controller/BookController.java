package com.fwh.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import com.fwh.domain.Book;
import com.fwh.domain.User;
import com.fwh.service.BookService;
import com.fwh.util.CreateIdUtil;
import com.fwh.util.DataTransfertionUtil;
import com.fwh.util.Item;
/**
 * 书籍操作controller
 * @author dieeman
 *
 */
@Controller
@RequestMapping("/book")
public class BookController {
	@Autowired
	public BookService bookService;
	/**
	 * 查询所有书籍
	 * @param req
	 * @param rep
	 * @param model
	 * @return
	 */
	@RequestMapping("/getallbook.do")
	public String getAllBook(HttpServletRequest req,HttpServletResponse rep,ModelMap model) {
		List<Book> book = bookService.getAllBook();
		if(book.size()>0){
			DataTransfertionUtil.transfer(book, addItem());
		}
		model.addAttribute("book", book);
		return "book";	
		
	}
	@RequestMapping("/getbook.do")
	public String getBookById(HttpServletRequest request,ModelMap model) throws NoSuchFieldException, SecurityException, IllegalArgumentException, IllegalAccessException{
		String bookId = request.getParameter("bookid");
		List<Book> book = bookService.getBookById(bookId);	
		if(book.size()>0){
			DataTransfertionUtil.transfer(book, addItem());
			//for(int i=0;i<book.size();i++){
			  //book.get(i).setBookType(DataTransfertionUtil.DataTransfer("book_type", book.get(i).getBookType()));			
			}
		model.addAttribute("book", book);
		return "book";		
	}
	@RequestMapping("/getbookbytype.do")
	public List<Book> getBookByType(HttpServletRequest request,ModelMap model){
		return null;
	}
	/**
	 * 添加书籍
	 * @param request
	 * @param reponse
	 * @throws ClassNotFoundException
	 * @throws SQLException
	 */
	@RequestMapping("/addbook.do")
	public void  addBook(HttpServletRequest request,HttpServletResponse reponse) throws ClassNotFoundException, SQLException{
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
		PrintWriter out = null;
		try {
			out= reponse.getWriter();
			out.print("success");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			out.flush();
			out.close();
		}
	}
	/**
	 * 删除选中书籍
	 */
	@RequestMapping("/deleteBook.do")
	public void deleteBook(HttpServletRequest req,HttpServletResponse rep){
		String bookId = req.getParameter("bookId");
		bookService.deleteBook(bookId);
		PrintWriter out = null;
		try {
			out= rep.getWriter();
			out.print("success");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			out.flush();
			out.close();
		}
	}
	public static List addItem(){
		List a = new ArrayList();
		a.add(new Item("book_type","bookType"));
		return a;
	}
}
