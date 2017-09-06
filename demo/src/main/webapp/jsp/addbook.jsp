<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<link rel="stylesheet" href="<%=request.getContextPath() %>/layui/css/layui.css">
<script type="text/javascript" src="<%=request.getContextPath() %>/js/jquery.min.js"></script>
<script type="text/javascript" src="<%=request.getContextPath() %>/js/layer.js"></script>
<script type="text/javascript" src="<%=request.getContextPath() %>/layui/layui.js"></script>
<title>添加书籍</title>
<style type="text/css">

</style>

</head>
<body>
<div id="main" style="width:650px;height:600px">
<form class="layui-form" style="padding-top:30px">
			
	<div class="layui-form-item">
		<label class="layui-form-label">书籍名称</label>
		<div class="layui-input-block">
			<input  id="bookName" name="bookName" style="width:500px" type="text" class="layui-input"/>
		</div>
	</div>
	<div class="layui-form-item">
		<label class="layui-form-label">书籍作者</label>
		<div class="layui-input-block">
			<input id="author" name="author" style="width:500px" type="text" class="layui-input"/>
		</div>
	</div>
	<div class="layui-form-item">
		<label class="layui-form-label">出版时间</label>
		<div class="layui-input-block">
			<input id="calendar" name="publishTime" type="text" style="width:500px" class="layui-input"/>
		</div>
	</div>
	<div class="layui-form-item">
		<label class="layui-form-label">库&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;存</label>
		<div class="layui-input-block">
			<input id="repertory" type="text" id="repertory" name="repertory" style="width:500px" class="layui-input"/>
		</div>
	</div>
		<div class="layui-form-item">
		<label class="layui-form-label">书籍类型</label>
		<div class="layui-input-block" style="width:500px">
		 <select name="bookType" style="width:500px" onclick="getOption(bookType)">
			  <option value=''>请选择</option>		  
		 </select>
		</div>
	</div>
</form>
<div style="margin-top:60px">
	<div style="margin-left:240px;float:left;">
		<input id="save" type="button" onclick="saves()" class="layui-btn" value="保存" />
	</div>
	<div style="float:left;margin-left:50px">
		<input id="cancle" onclick="onCancle()" type="button" class="layui-btn" value="取消" />
	</div>
</div>
<div>
<script>
	function onCancle(){
		var index = parent.layer.getFrameIndex(window.name);
		parent.layer.close(index);
	}
	function saves(){
		var index = parent.layer.getFrameIndex(window.name);
		var bookName = $("#bookName").val();
		var bookType = $("#bookType").val();
		var author = $("#author").val();
		var publishTime = $("#calendar").val();
		var repertory = $("#repertory").val();
		if(valcheck()==false){return;}
		var data = {bookName:bookName,bookType:bookType,author:author,publishTime:publishTime,repertory:repertory};
		$.ajax({
			url:"<%=request.getContextPath()%>/book/addbook.do",
			data:data,
			type:'post',
			success:function(data){
				if(data!=null&&data!=""){										
					layer.msg("添加成功",{icon: 1},function(){
						parent.layer.close(index);
					});
				}else{
					layer.msg("添加失败",{icon: 2});
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
		var publishTime = $("#calendar").val();
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
	layui.use('laydate', function(){
		  var laydate = layui.laydate;		  
		  //执行一个laydate实例
		  laydate.render({
		    elem: '#calendar' //指定元素
		    ,theme: '#009688'//设置背景可以自定义颜色
		  });
		});
	layui.use('form');
	function getOption(a){
		$.ajax({
			url:'',
			data:{a:a},
			type:'post',
			success:function(data){
				if(data!=null){
					for(var i=0;i<data.data.length;i++){
						
					}
				}
			}
		});
	}
</script>
</body>
</html>