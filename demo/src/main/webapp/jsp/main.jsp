<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
	<link rel="stylesheet" href="<%=request.getContextPath() %>/css/bootstrap.min.css">
	<link rel="stylesheet" href="<%=request.getContextPath() %>/css/style.css">
	<link rel="stylesheet" href="<%=request.getContextPath() %>/css/mtree.css">
	<link rel="stylesheet" href="<%=request.getContextPath() %>/webupload/webuploader.css" >
	<script type="text/javascript" src="<%=request.getContextPath() %>/js/jquery.min.js"></script>
	<script type="text/javascript" src="<%=request.getContextPath() %>/js/bootstrap.js"></script>
	<script type="text/javascript" src='<%=request.getContextPath() %>/js/jquery.velocity.min.js'></script>	
	<script type="text/javascript" src='<%=request.getContextPath() %>/webupload/webuploader.js'></script>
	<script type="text/javascript" src="<%=request.getContextPath() %>/js/layer.js"></script>
	<script>

	</script>
	<style type="text/css">	
	.webuploader-pick{
		width:40px;
		height:28px;
		background:none;
		padding-top:5px;
		float:right;

	}
	#clear{
		width:14px;
		height:30px;	
		float:right;
		padding-top:6px;	
		cursor: pointer;	
		display:none;
	}
	#rt_rt_1bojbl17acpk70c11sf17hu13i51{
		width:30px;
		left:20px;
	}
	</style>
<title>index</title>
</head>
<body>
<div id="head">
	<div id="logo"><img id="img" src=""></img></div>
	<div id="welcome">欢迎您，${user.userName}</div>
	<div id="time" style="padding-left:20px"></div>
	<div id="menu">
		<div class="menus">
			<a id="out" href="<%=request.getContextPath() %>/user/logout.do">
			<span class="glyphicon glyphicon-user"></span> 退出</a>			
		</div>		
	</div>
</div>
<div id="main">
	<div id="main-left">		
		<ul class="mtree bubba">
		  <li><a href="#">用户信息管理</a>			
		  </li>
		  <li><a href="<%=request.getContextPath() %>/book/get">图书信息管理</a>
		  	<ul>
		  		<li><a href="#">1</a></li>
				<li><a href="#">2</a></li>
				<li><a href="#">3</a></li>
				<li><a href="#">4</a></li>
		  	</ul>
		  </li>
		  <li><a href="#">图书借阅管理</a>
		  	<ul>
		  		<li><a href="#">1</a></li>
				<li><a href="#">2</a></li>
				<li><a href="#">3</a></li>
				<li><a href="#">4</a></li>
		  	</ul>
		  </li>
		  <li><a href="#">信息统计</a>
		  	<ul>
		  		<li><a href="#">1</a></li>
				<li><a href="#">2</a></li>
				<li><a href="#">3</a></li>
				<li><a href="#">4</a></li>
		  	</ul>
		  </li>
		  <li><a href="#">系统维护</a>
		  	<ul>
		  		<li><a href="#">1</a></li>
				<li><a href="#">2</a></li>
				<li><a href="#">3</a></li>
				<li><a href="#">4</a></li>
		  	</ul>
		  </li>
		</ul>
	</div>
	<div id="main-right">
		<div id="uploader" class="wu-example">
    		<!--用来存放文件信息-->
	    	<div id="thelist" class="uploader-list"></div>	    	
	    	<div class="filemes" style="margin:0;width:400px;height:30px;line-height:30px;border:1px solid gray">	    	
	    		<span style="width:330px;float:left">
	    			<input type="text" id="copyfilename" onfocus="this.blur()"  style="width:330px;height:28px;display:block;border:0;color:#24a092">
	    			<input type="hidden" name="fileName" id="fileName">
	    			<input type="hidden" name="fileurl" id="fileUrl">
	    		</span>	  	    		 
	    		<a id="picker"><img src="<%=request.getContextPath()%>/images/upload.png"></a>
	    		<a id="clear"><img src="<%=request.getContextPath() %>/images/close02.png"></a> 	
	    	</div>		   
		</div>
		<input type="button" value="上传" onclick="ok()">
	</div>
	<div id="footer">
		<a href="<%=request.getContextPath() %>/book/getallbook.do">查看书籍</a>	
	</div>
</div>
</body>
<script type="text/javascript" src="<%=request.getContextPath() %>/js/mtree.js"></script>
<script>
function gettime(){
	var myDate = new Date();			 
	var year=myDate.getFullYear(); //获取完整的年份(4位,1970-????)  
	var month=myDate.getMonth()+1; //获取当前月份(0-11,0代表1月)  
	var day=myDate.getDate(); //获取当前日(1-31)  
	var date=myDate.getDay(); //获取当前星期X(0-6,0代表星期天)
	if(date==1){
		date="星期一";
	}else if(date==2){
		date="星期二";
	}else if(date==3){
		date="星期三";
	}else if(date==4){
		date="星期四";
	}else if(date==5){
		date="星期五";
	}else if(date==6){
		date="星期六";
	}else if(date==0){
		date="星期天"
	}
	
	var currenttime=year+"年"+month+"月"+day+"日"+"&nbsp;&nbsp;&nbsp;&nbsp;"+date;		
	return currenttime;
	
}
$(document).ready(function(){
	document.getElementById("time").innerHTML=gettime();
});

<%-- layui.use('upload',function(){
	debugger;
	layui.upload({
		url:'<%=request.getContextPath()%>/upload/upload.do',
		success:function(res){
			layer.msg("上传成功",{icon: 1});
		}	
	});

}); --%>
var uploader = WebUploader.create({
    // swf文件路径
    swf: '<%=request.getContextPath()%>/webupload/Uploader.swf',
    // 文件接收服务端。
    server: '<%=request.getContextPath()%>/file/upload.do',
    // 选择文件的按钮。可选。
    // 内部根据当前运行是创建，可能是input元素，也可能是flash.
    pick: '#picker',
    // 不压缩image, 默认如果是jpeg，文件上传前会压缩一把再上传！
    resize: false
});
var name = "";//文件名称如果有多个则用；隔开
var num = 0; //上传的文件个数
var num1=0; // 上传成功的文件个数
var url=""; // 返回的url
//文件加入上传队列
uploader.on( 'fileQueued', function(file) {	
	if(name!=""){
		name= name+";"+file.name;
	}else{
		name=file.name;
	}
	num = name.split(";").length;
   $("#copyfilename").val(name);
   $("#fileName").val(name);
   $("#clear").css("display",'block');
});	

//上传成功
uploader.on( 'uploadSuccess', function(file,response) {
	if(response&&response.url){
		debugger;
		url=url+";"+response.url;
		num1++;
		if(num==num1){
			url = url.substring(1);			
			$("#fileUrl").attr(url);
		    layer.msg("上传成功",{icon: 1});
		}
	}  
});
//上传失败
uploader.on( 'uploadError', function(file) { 
	uploadfail();
	alert('error')
});
$("#clear").click(function(){
	uploadfail();
	
});
//上传失败重置上传
function uploadfail(){
	name="";
	$("#copyfilename").val("");
	$("#fileName").val("");
	$("#clear").css("display",'none');
	uploader.reset();
}
function ok(){
	if(name==""||name==null){
		layer.msg("请选择要上传的文件",{icon:7});
		return false;
	}
	uploader.upload();
}
</script>
</html>