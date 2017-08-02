<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE>
	<head>
	<meta charset="utf-8">
	<meta http-equiv="X-UA-Compatible" content="IE=edge">
	<title>login</title>
	<script type="text/javascript" src="<%=request.getContextPath() %>/js/jquery.min.js"></script>
	<link rel="stylesheet" href="<%=request.getContextPath() %>/css/bootstrap.min.css">
	<link rel="stylesheet" href="<%=request.getContextPath() %>/css/animate.css">
	<link rel="stylesheet" href="<%=request.getContextPath() %>/css/style.css">
	</head>
	<body class="style-3">
		<div class="container">			
			<div class="row">
				<div class="col-md-4 col-md-push-8">					
					<form id="form1" action="<%=request.getContextPath() %>/user/login.do" method="post" class="fh5co-form animate-box" data-animate-effect="fadeInRight">
						<h2>账号登录</h2>						
						<div class="form-group">							
							<input type="text" class="form-control" id="username" name="username" placeholder="用户名/手机号/邮箱" autocomplete="off">													
						</div>
						<div class="form-group">
							<input type="password" class="form-control" id="password" name="password" placeholder="请输入密码" autocomplete="off" >
							
						</div>
						<div id="msg" style="color:red">${msg}</div>
						<!-- <div class="form-group">
							<label for="rememberMe"><input type="checkbox" id="remember" name="rememberMe"> 记住账号</label>
						</div> -->						
						<div class="form-group">
							<input type="button" id="login" onclick="onlogin()" value="登录" class="btn btn-primary">
						</div>
						
					</form>
				</div>
			</div>
			
		</div>
	<script src="<%=request.getContextPath() %>/js/jquery.min.js"></script>
	<script src="<%=request.getContextPath() %>/js/md5.js"></script>
	<script>
		window.onload=function(){ 
			if(document.readyState=="complete")
			{
			  	document.getElementById("username").focus();  //激活的文本框ID			  	
			  	document.getElementById("password").value="";
			}
		}
		function onlogin(){
			var form= document.getElementById("form1");
			var pwd = document.getElementById("password").value;
			var hash = hex_md5(pwd);
			document.getElementById("password").value=hash;
			form.submit();			
		}
		
	</script>
	</body>

</html>

