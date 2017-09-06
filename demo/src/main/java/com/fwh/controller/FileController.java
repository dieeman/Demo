package com.fwh.controller;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import com.fwh.util.DateUtil;
import com.google.gson.JsonObject;

/** 
* @author dieeman
* @date 2017��7��28�� ����9:58:22 
* 
*/
@RestController
@RequestMapping("/file")
public class FileController {
	private  Logger logger = Logger.getLogger(FileController.class);
	/**
	 * �ļ��ϴ�
	 * @param request
	 * @param response
	 * @throws IOException 
	 */
	@RequestMapping("/upload.do")
	public void fileUpload(HttpServletRequest request,HttpServletResponse response) throws IOException{
		String filenames = DateUtil.getCurrentDate();
		JsonObject result = new JsonObject();
		String url = "";
		String filename="";
		PrintWriter out = response.getWriter();
		MultipartHttpServletRequest Murequest = (MultipartHttpServletRequest)request;
		Map<String, MultipartFile> files = Murequest.getFileMap();//�õ��ļ�map����
		//�ϴ��ļ�·��
		String path = request.getServletContext().getRealPath("/upload")+"/"+filenames+"/";
		//�ڸ�·���´������ļ�
		File targetFile = new File(path);
		if(!targetFile.exists()){
			targetFile.mkdirs();
		}
		for(MultipartFile file :files.values()){//����map
			//�ļ�����
			String fileName = file.getOriginalFilename();
			//�����ļ�����			
			targetFile = new File(path+fileName);
			//if(!targetFile.exists()){//�ļ�������
				try {
					targetFile.createNewFile(); 
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				try {
					file.transferTo(targetFile);
					logger.info("�ļ�------"+fileName+"-------����ɹ�");
					String fileurl = targetFile.toString();
					filename = filename +","+fileName;
					url = url+","+targetFile.toString().substring(fileurl.lastIndexOf("demo"));
				} catch (IllegalStateException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					logger.error("�ļ�------"+fileName+"------����ʧ��");
					e.printStackTrace();
				}
			//}
		}	
		String urls = url.substring(1);
		String filename2 = filename.substring(1);
		result.addProperty("url", urls);
		result.addProperty("filename", filename2);
		out.append(result.toString());
	}
	/**
	 * �ļ�����
	 * @param request
	 * @param response
	 */
	@RequestMapping("/download.do")
	public void fileDownload(HttpServletRequest request,HttpServletResponse response){
//		String fileName = "";
//		String fileUrl = "";
	}
	
}
