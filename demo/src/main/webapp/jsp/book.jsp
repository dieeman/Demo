<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<link rel="stylesheet" href="<%=request.getContextPath() %>/css/bootstrap.min.css">
<script type="text/javascript" src="<%=request.getContextPath() %>/js/jquery.min.js"></script>
<script type="text/javascript" src="<%=request.getContextPath() %>/js/bootstrap.js"></script>
<script type="text/javascript" src="<%=request.getContextPath() %>/js/layer.js"></script>
<title>book</title>
<script>
	function addbook(){
		var base = $("#base").val();
		layer.open({
			title:'添加书籍',
			type:2,
			content:[base+'/jsp/addbook.jsp','no'],
			area:['700px','550px'],
			shade:['0.8','#393D49'],
			end:function(action){
				if(action!=null&&action!=''){
					onsearch();
				}
			}
		});
		
	}
</script>
</head>
<body>
<table class="table table-striped">
	<tr>
		<td>书籍编号</td>
		<td>书籍名称</td>
		<td>书籍作者</td>
		<td>书籍类型</td>
		<td>操作</td>
	</tr>
	<tr>
		<td>${book.bookId}</td>
		<td>${book.bookName}</td>
		<td>${book.author}</td>
		<td>${book.bookType}</td>
	</tr>
</table>
<input type="button" onclick="addbook()" class="btn btn-primary" value="添加书籍"/>
<input type="hidden" id="base" value="<%=request.getContextPath()%>">

</body>
</html>