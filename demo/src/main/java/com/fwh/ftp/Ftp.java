package com.fwh.ftp;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.commons.net.ftp.FTPClient;
import org.apache.log4j.Logger;

import com.fwh.controller.FileController;

/** 
* @author dieeman
* @date 2017年8月30日 下午2:31:47 
* ftp 文件上传
*/
public class Ftp {
	private static Logger logger = Logger.getLogger(Ftp.class);
	//private static FTPClient ftp;
	private static String URL         = "192.168.1.68";
	private static String USERNAME    ="";
	private static String PASSWORD    ="";
	private static int PORT           =21;
	public static FTPClient getconnect(){
		FTPClient ftp = new FTPClient();
		try {
			ftp.connect(URL,PORT);
			ftp.login(USERNAME,PASSWORD);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			logger.error("服务器连接失败");
		}          
        try {
			ftp.setFileType(FTPClient.BINARY_FILE_TYPE);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return ftp;
	}
	public static boolean upload(File file){
		FTPClient ftp = getconnect();
		boolean flag=false;
		String path = "F:/tools/upload/";
		if(!file.isDirectory()){
			try {
				ftp.changeWorkingDirectory(path);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				System.out.println("创建文件夹失败");
			}
			File file2 = new File(path+file.getName());
			FileInputStream input;
			try {
				input = new FileInputStream(file2);
				try {
					ftp.storeFile(file2.getName(), input);
					flag=true;
					
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}      
		        try {
					input.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			} catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}      
			
		}
		return flag;
	}
}
