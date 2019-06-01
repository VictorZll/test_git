<%@page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<%
String basePath=request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+request.getContextPath()+"/";
%>
<base href="<%=basePath%>"></base>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<style type="text/css">
td{
padding:6px 40px ;
}
table{
width:600px;
}
tr:hover{
 	background:linear-gradient(to right,orange,white);
 	color:white;
}
.a{
text-decoration: none;
color:white;
background:purple;
display: inline-block;
text-align: center;
line-height: 20px;
border-radius:5px;
font-size: 14px;
padding:2px 6px;
}
.a:hover{
color:pink;
background: green;
}
.a:visited{
color:pink;
}
</style>
<title>Insert title here</title>
<script type="text/javascript" src="js/jquery.js"></script>
<script>
//判断数据的合法性
 	function submitform(){
 		var stuNo=$("input[name=stuno]").val();
 		var stuName=$("input[name=stuname]").val();
 		var stuSex=$(":radio:checked").val();
 		var stuAge=$("input[name=stuage]").val();
 		if(stuNo==""||stuName==""||stuAge==""){
 			event.preventDefault();
 		}
 	}
 	function isRepeat(){
 		var stuNo=$("input[name=stuno]").val();
 		location.href="verify.do?stuNo="+stuNo ;
 	}
 	$(function(){
 		$.get("getById",{},function(data){console.log(data)},"json");
 	});
</script>
</head>
<body>
<p>当前在线人数为${empty applicationScope.onLineCount?"0":applicationScope.onLineCount}人</p>
	<form action="manager/updateStu.do">
	<input type="text" name="action" value="${param.action eq 'update'?'update':'add'}" hidden >
		<table border="1" cellspacing="0" align="center">
			<caption>${"update" eq param.action?"修改":"添加"}页面</caption>
			<tr>
				<td><label for="stuno" >学号</label></td>
				<td>
				<input type="text" id="stuno" name="stuno" value="${stu.stuNo}" ${"update" eq param.action?"readonly":""}>

				</td>
			</tr>
			<tr>
				<td><label for="stuname" >姓名</label></td>
				<td><input type="text" id="stuname" name="stuname" value="${stu.stuName}"></td>
			</tr>
			<tr>
				<td><label for="stusex" >性别</label></td>
				<td>
				<input type="radio" id="stusex" name="stusex" value="男"  ${"男" eq stu.stuSex?"checked":""} >男
				<input type="radio" name="stusex" value="女"   ${"女" eq stu.stuSex?"checked":""}>女
				</td>
			</tr>
			<tr>
				<td><label for="stuage" >年龄</label></td>
				<td><input type="number" id="stuage" name="stuage" value="${stu.stuAge}"></td>
			</tr>
			<tr>
				<td colspan="2" align="center">
				<input class="a" type="submit" onclick="submitform()" value="${'update' eq param.action?'修改':'添加'}" />
				<input class="a" type="reset" value="重置" />
				</td>
			</tr>
		</table>
	</form>
</body>
</html>