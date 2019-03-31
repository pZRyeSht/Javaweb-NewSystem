<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<base href="<%=basePath%>">
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>${human.human_name}简介</title>
</head>
<body>
	<table align="center">
		<tr align="center">
			<td>${human.human_name}</td>
		</tr>
		<tr align="left">
			<td>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;${human.human_intr}</td>
		</tr>
		<tr align="center">
			<td><input type="button" value="返回" onclick="window.history.back()"></td>
		</tr>
	</table>
</body>
</html>