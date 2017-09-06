package com.fwh.domain;

import java.io.Serializable;

public class Book implements Serializable{
	private static final long serialVersionUID = 4715522777423331688L;
	/**
	 * 书籍id
	 */
	private String bookId;
	/**
	 * 书籍名称
	 */
	private String bookName;
	/**
	 * 书籍作者
	 */
	private String author;
	/**
	 * 出版时间
	 */
	private String publishTime;
	/**
	 * 库存
	 */
	private int repertory;
	/**
	 * 书籍类型
	 */
	private String bookType;
	/**
	 * 书籍封面图片地址
	 */
	private String bookUrl;	
	
	public String getBookType() {
		return bookType;
	}
	public void setBookType(String bookType) {
		this.bookType = bookType;
	}
	public String getBookId() {
		return bookId;
	}
	public void setBookId(String bookId) {
		this.bookId = bookId;
	}
	public String getBookName() {
		return bookName;
	}
	public void setBookName(String bookName) {
		this.bookName = bookName;
	}
	public String getAuthor() {
		return author;
	}
	public void setAuthor(String author) {
		this.author = author;
	}
	public String getPublishTime() {
		return publishTime;
	}
	public void setPublishTime(String publishTime) {
		this.publishTime = publishTime;
	}
	public int getRepertory() {
		return repertory;
	}
	public void setRepertory(int repertory) {
		this.repertory = repertory;
	}
	public String getBookUrl() {
		return bookUrl;
	}
	public void setBookUrl(String bookUrl) {
		this.bookUrl = bookUrl;
	}
	@Override
	public String toString() {
		return "Book [bookId=" + bookId + ", bookName=" + bookName + ", author=" + author + ", publishTime="
				+ publishTime + ", repertory=" + repertory + ", bookType=" + bookType + ", bookUrl=" + bookUrl + "]";
	}
	

}
