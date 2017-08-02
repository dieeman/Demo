package com.fwh.util;
import org.apache.log4j.Logger;

import com.fwh.service.BookService;
import com.fwh.service.UserService;
public class CreateIdUtil{
	private static final Logger logger = Logger.getLogger(CreateIdUtil.class);
	/*
	 * ��Ϊservice��dao��ͨ��springע��ķ�ʽ��õģ����������service������new�ķ�ʽ����
	 * Ҫȥspring�����л�� ��Ϊservice��dao����ͨ��spring���������ģ��������ܽ���ע�롣
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
	 * ���ݱ����õ���id
	 * @param tableName
	 * @return
	 */
	public String getTableId(String tableName){
		/**
		 * �õ�����bean ���ݱ����õ�bean
		 */
		return null;
	}
}
