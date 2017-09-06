package com.fwh.domain;

import java.io.Serializable;

public class Book implements Serializable{
	private static final long serialVersionUID = 4715522777423331688L;
	/**
	 * �鼮id
	 */
	private String bookId;
	/**
	 * �鼮����
	 */
	private String bookName;
	/**
	 * �鼮����
	 */
	private String author;
	/**
	 * ����ʱ��
	 */
	private String publishTime;
	/**
	 * ���
	 */
	private int repertory;
	/**
	 * �鼮����
	 */
	private String bookType;
	/**
	 * �鼮����ͼƬ��ַ
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
