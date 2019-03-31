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
  <form action="Action/AdminAction?method=add" method="post">
  	<table align="center">
	  	<tr>
	  		<td>账号:</td>
	  		<td><input type="text" name="adminName"></td>
	  	</tr>
	  	<tr>
	  		<td>真实姓名:</td>
  			<td><input type="text" name="adminRname"></td>
	  	</tr>
	  	<tr>
	  		<td>密码:</td>
	  		<td><input type="text" name="adminPassword"></td>
	  	</tr>
	  	<tr>
	  		<td>管理员类别:</td>
	  		<td>
	  			<select name="adminType">
		  			<option value="1">普通管理员</option>
		  			<option value="0">超级管理员</option>
	  			</select>
	  		</td>
	  	</tr>
	  	<tr>
	  		<td colspan="2" align="center"><input type="submit" value="提交">
	  		<input type="button" value="取消添加" onclick="window.history.back()"></td>
	  	</tr>
  	</table>
  </form>
  </body>
</html>
