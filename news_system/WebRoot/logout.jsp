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
<title>注销页面</title>
</head>
<body>
	 <%
	 response.setHeader("refresh","3;URL=index");
	 session.invalidate();
	%>
     <h3>你已经成功退出本系统,3秒后会跳转到首页</h3>
     <h3>如果没有跳转请点击<a href="index">这里</a></h3>
</body>
</html>