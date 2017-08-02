package com.fwh.util;
import org.apache.log4j.Logger;

import com.fwh.service.BookService;
import com.fwh.service.UserService;
public class CreateIdUtil{
	private static final Logger logger = Logger.getLogger(CreateIdUtil.class);
	/*
	 * 因为service中dao是通过spring注入的方式获得的，所以这里的service不能用new的方式创建
	 * 要去spring容器中获得 因为service和dao都是通过spring容器创建的，这样才能进行注入。
	 */	   
	
	public static BookService bookService = (BookService) SpringGetBean.getBean("bookServiceImpl");
	public static UserService userService = (UserService) SpringGetBean.getBean("userServiceImpl");
	public static String getBookId(){
		String bookid = bookService.getBiggestBookId();
		if((bookid==null)||("".equals(bookid))){
			bookid="1001";
		}else{
		int newbookid = Integer.parseInt(bookid)+1;
		bookid = String.valueOf(newbookid);
		}
		return bookid;
	}
	public static String getUserId(){
		String userid = userService.getBiggestUserId();
		if(userid==null||"".equals(userid)){
			userid="10001";
		}else{
			int newuserid = Integer.parseInt(userid)+1;
			userid = String.valueOf(newuserid);
		}
		return userid;
	}
	/**
	 * 根据表名得到表id
	 * @param tableName
	 * @return
	 */
	public String getTableId(String tableName){
		/**
		 * 得到所有bean 根据表名得到bean
		 */
		return null;
	}
}
