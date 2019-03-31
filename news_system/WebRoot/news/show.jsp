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
<title>${news.news_title}</title>
</head>
<body>
	<table>
		<tr align="center">
			<td>${news.news_title}</td>
		</tr>
		<tr align="center">
			<td>发布时间：${news.news_datetime}</td>
		</tr>
		<tr align="left">
			<td>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;${news.news_content}</td>
		</tr>
		<tr align="center">
			<td><input type="button" value="返回" onclick="javascrtpt:window.location.href='index'"></td>
		</tr>
	</table>
</body>
</html>