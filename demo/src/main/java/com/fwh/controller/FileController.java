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
* @date 2017年7月28日 上午9:58:22 
* 
*/
@RestController
@RequestMapping("/file")
public class FileController {
	private  Logger logger = Logger.getLogger(FileController.class);
	/**
	 * 文件上传
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
		Map<String, MultipartFile> files = Murequest.getFileMap();//得到文件map对象
		//上传文件路径
		String path = request.getServletContext().getRealPath("/upload")+"/"+filenames+"/";
		//在该路径下创建改文件
		File targetFile = new File(path);
		if(!targetFile.exists()){
			targetFile.mkdirs();
		}
		for(MultipartFile file :files.values()){//遍历map
			//文件名称
			String fileName = file.getOriginalFilename();
			//创建文件对象			
			targetFile = new File(path+fileName);
			//if(!targetFile.exists()){//文件不存在
				try {
					targetFile.createNewFile(); 
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				try {
					file.transferTo(targetFile);
					logger.info("文件------"+fileName+"-------保存成功");
					String fileurl = targetFile.toString();
					filename = filename +","+fileName;
					url = url+","+targetFile.toString().substring(fileurl.lastIndexOf("demo"));
				} catch (IllegalStateException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					logger.error("文件------"+fileName+"------保存失败");
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
	 * 文件下载
	 * @param request
	 * @param response
	 */
	@RequestMapping("/download.do")
	public void fileDownload(HttpServletRequest request,HttpServletResponse response){
//		String fileName = "";
//		String fileUrl = "";
	}
	
}
