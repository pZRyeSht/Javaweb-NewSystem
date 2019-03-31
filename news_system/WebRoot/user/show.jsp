<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
  	<base href="<%=basePath%>">
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
  </head>
  
  <body>
  	<table align="center">
	  	<tr>
	  		<td>账号:</td>
	  		<td><input type="text" value="${user.user_name }"></td>
	  	</tr>
	  	<tr>
	  		<td>真实姓名:&nbsp</td>
  			<td><input type="text" value="${user.user_rname }"></td>
	  	</tr>
	  	<tr>
	  		<td>密码:</td>
	  		<td><input type="text" value="${user.user_password }"></td>
	  	</tr>
	  	<tr>
	  		<td>电子邮件:</td>
	  		<td><input type="text" value="${user.user_email }"></td>
	  	</tr>
	  	<tr>
	  		<td>电话:</td>
	  		<td><input type="text" value="${user.user_tel }"></td>
	  	</tr>
	  	<tr>
	  		<td>注册时间:</td>
	  		<td><input type="text" value="${user.user_datetime }"></td>
	  	</tr>
	  	<tr>
	  		<td colspan="2" align="center">
	  		<input type="button" value="返回" onclick="window.history.back()"></td>
	  	</tr>
  	</table>
  </body>
</html>
