<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<link rel="stylesheet" href="<%=request.getContextPath() %>/css/bootstrap.min.css">
<link rel="stylesheet" href="<%=request.getContextPath() %>/css/asDatepicker.css">
<script type="text/javascript" src="<%=request.getContextPath() %>/js/jquery.min.js"></script>
<script type="text/javascript" src="<%=request.getContextPath() %>/js/jquery-asDatepicker.js"></script>
<script type="text/javascript" src="<%=request.getContextPath() %>/js/layer.js"></script>
<title>添加书籍</title>
<style type="text/css">
	.table > tbody > tr > td{
		border:0;
	}
	table > tbody > tr{
		height:50px;
	}
	.calendar-inputWrap{
		height:34px;
	}
</style>
<script type="text/javascript">
	$(document).ready(function(){
		$("#calendar").asDatepicker();
	});
</script>
</head>
<body>
<div id="main" style="width:900px;height:600px">
<form>
	<table class="table" style="width:100%">
		<tr>
			<td style="width:100px;"><span style="float:right;line-height:34px;">出版时间</span></td>
			<td style="width:800px;height:34px">
				<div class="form-group" style="margin-right:0">
					<input id="calendar" id="publishTime" name="publishTime" type="text" style="width:60%" class="form-control"/>
				</div>
			</td>
		</tr>
		<tr>
			<td style="width:100px;"><span style="float:right;line-height:34px">书籍名称</span></td>
			<td style="width:800px;height:34px">
				<div class="form-group">
					<input class="form-control" id="bookName" name="bookName" style="width:60%" type="text"/>
				</div>
			</td>
		</tr>
		<tr>
			<td style="width:100px;"><span style="float:right;line-height:34px">书籍作者</span></td>
			<td style="width:800px">
				<div class="form-group">
					<input class="form-control" id="author" name="author" style="width:60%" type="text"/>
				</div>
			</td>
		</tr>
		<tr>
			<td style="width:100px;"><span style="float:right;line-height:34px;">库&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;存</span></td>
			<td style="width:800px">
				<div class="form-group" style="margin-right:0">
					<input id="repertory" type="text" id="repertory" name="repertory" style="width:60%" class="form-control"/>
				</div>
			</td>
		</tr>
		<tr>
			<td style="width:100px;"><span style="float:right;line-height:34px;">书籍类型</span></td>
			<td style="width:800px">
				<div class="form-group" style="margin-right:0">
					<input id="bookType" type="text" id="bookType" name="bookType" style="width:60%" class="form-control"/>
				</div>
			</td>
		</tr>
		
							
	</table>
	<div style="margin-left:250px;float:left;">
		<input id="save" type="button" onclick="saves()" class="btn btn-primary" value="保存" />
	</div>
	<div style="float:left;margin-left:50px">
		<input id="cancle" onclick="onCancle()" type="button" class="btn btn-primary" value="取消" />
	</div>
</form>
</div>
<script>
	function onCancle(){
		parent.layer.closeAll();
	}
	function saves(){
		debugger;
		var index = parent.layer.getFrameIndex(window.name);
		var bookName = $("#bookName").val();
		var bookType = $("#bookType").val();
		var author = $("#author").val();
		var publishTime = $("#publishTime").val();
		var repertory = $("#repertory").val();
		if(valcheck()==false){return;}
		var data = {bookName:bookName,bookType:bookType,author:author,publishTime:publishTime,repertory:repertory};
		$.ajax({
			url:"<%=request.getContextPath()%>/book/addbook.do",
			data:data,
			type:'post',
			success:function(data){
				debugger;
				if(data!=null||data!=""){										
					layer.msg("添加成功",{icon: 1},function(){
						parent.layer.close(index);
					});
				}
				//parent.layer.closeAll();
			},
			error:function(){
				layer.msg("添加失败",{icon: 2});
			}
		});
		
	}
	function valcheck(){
		var reg = new RegExp("^[0-9]*$");
		var bookName = $("#bookName").val();
		var bookType = $("#bookType").val();
		var author = $("#author").val();
		var publishTime = $("#publishTime").val();
		var repertory = $("#repertory").val();
		if(bookName==null||bookName==""){
			layer.msg("请输入书籍名称");
			return false;
		}
		if(author==null||author==""){
			layer.msg("请输入作者");
			return false;
		}
		if(repertory==""||repertory==null){
			layer.msg("请输入库存量");
			return false;
		}
		if(!reg.test(repertory)){
			layer.msg("请输入正确的库存量");
			return false;
		}
		return true;
	}
</script>
</body>
</html>