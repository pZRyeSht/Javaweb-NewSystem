<%@page import="com.ns.pojo.NsAdmin"%>
<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
NsAdmin admin = (NsAdmin)request.getAttribute("admin");
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
  	<base href="<%=basePath%>">
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
  </head>
  
  <body>
  <form action="Action/UserAction?method=edit" method="post">
  	<table align="center">
	  	<tr>
	  		<td>账号:<input type="hidden" value="${user.user_id }" name="userId"></td>
	  		<td><input type="text" value="${user.user_name }" name="userName"></td>
	  	</tr>
	  	<tr>
	  		<td>真实姓名:&nbsp</td>
  			<td><input type="text" value="${user.user_rname }" name="userRname"></td>
	  	</tr>
	  	<tr>
	  		<td>密码:</td>
	  		<td><input type="text" value="${user.user_password }" name="userPassword"></td>
	  	</tr>
	  	<tr>
	  		<td>电子邮件:</td>
	  		<td><input type="text" value="${user.user_email }" name="userEmail"></td>
	  	</tr>
	  	<tr>
	  		<td>电话:</td>
	  		<td><input type="text" value="${user.user_tel }" name="userTel"></td>
	  	</tr>
	  	<tr>
	  		<td colspan="2" align="center"><input type="submit" value="提交">
	  		<input type="button" value="取消修改" onclick="window.history.back()"></td>
	  	</tr>
  	</table>
  </form>
  </body>
</html>
