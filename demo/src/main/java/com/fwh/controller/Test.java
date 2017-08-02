package com.fwh.controller;

import org.springframework.stereotype.Controller;

import com.fwh.domain.Book;

@Controller
public class Test implements Runnable{
	int a = 1001;
	int b = a/5;
	public void run(){
			System.out.println("kaishichaxun");
	}
}
