<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<%
String basePath=request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+request.getContextPath()+"/";
%>
<head>
<base href="<%=basePath%>"></base>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>

<body>
<!--applicationScope对应的是Java里的ServletContext  -->
<p>当前在线人数为${empty applicationScope.onLineCount?"0":applicationScope.onLineCount}人</p>
<form action="login.do">
	<table border="1" cellspacing="0">
	<caption>登陆页面</caption>
	<tbody>
		<tr>
			<td>用户名</td>
			<td><input type="text" name="user" /></td>
		</tr>
		<tr>
			<td>密码</td>
			<td><input type="password" name="pwd" /></td>
		</tr>
		<tr>
			<td colspan="2">
				<input type="submit" value="登陆">
				<input type="reset" value="重置">
			</td>
		</tr>
	</tbody>
	</table>
</form>
</body>
</html>