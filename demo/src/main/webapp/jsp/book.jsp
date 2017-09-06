<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<link rel="stylesheet" href="<%=request.getContextPath() %>/css/bootstrap.min.css">
<link rel="stylesheet" href="<%=request.getContextPath() %>/layui/css/layui.css">
<script type="text/javascript" src="<%=request.getContextPath() %>/js/jquery.min.js"></script>
<script type="text/javascript" src="<%=request.getContextPath() %>/js/bootstrap.js"></script>
<script type="text/javascript" src="<%=request.getContextPath() %>/js/layer.js"></script>
<title>book</title>
<script>
	function addbook(){
		layer.open({
			title:'添加书籍',
			type:2,
			content:['<%=request.getContextPath()%>/jsp/addbook.jsp','no'],
			area:['650px','480px'],
			shade:['0.8','#393D49'],
			end:function(){
				location.reload();
			}
		});
		
	}
</script>
<style type="text/css">
	a:hover{
		cursor: pointer;
	}
</style>
</head>
<body>
<table id="data" class="layui-table" lay-even lay-skin="nob">
	<thead>
	  <tr>
		<th>书籍编号</th>
		<th>书籍名称</th>
		<th>书籍作者</th>
		<th>书籍类型</th>
		
		<th>操&nbsp;&nbsp;&nbsp;&nbsp;作</th>
	  </tr>
	</thead>
	<tbody>
	<c:forEach var="book" items="${book}">
	<tr>
		<td>${book.bookId}</td>
		<td>${book.bookName}</td>
		<td>${book.author}</td>
		<td>${book.bookType}</td>
		
		<td>
			<a style="padding-right:10px;" onclick="update(${book})"><img title="修改"src="<%=request.getContextPath()%>/images/edit_btn16.png"></a>
			<a onclick="del(${book.bookId})"><img title="删除" src="<%=request.getContextPath()%>/images/delet16px.png"></a>
		</td>
	</tr>
	</c:forEach>
	</tbody>
</table>
<input type="button" onclick="addbook()" class="btn btn-primary" value="添加书籍"/>
<script>
	function del(bookId){
		layer.confirm('是否删除？',{icon:3},
			 function(){
				$.ajax({
					url:'<%=request.getContextPath()%>/book/deleteBook.do',
					type:'POST',
					data:{bookId:bookId},
					success:function(data){
						if(data=="success"){
							layer.msg("删除成功",{icon:1},function(){
								location.reload();
							});							
						}else{
							layer.msg("删除失败",{icon:7});
						}
					},
					error:function(){
						layer.msg("删除失败",{icon:7});
					}
				});
			});
		
	}
	function update(book){
		debugger;
		//var row = Table_Layui.GetRowData(1);
		alert(book);
	}	
</script>
</body>
</html>