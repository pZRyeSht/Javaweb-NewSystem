<%@page import="com.ns.pojo.NsAdmin"%>
<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="/WEB-INF/tlds/mytaglib.tld" prefix="mytag"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
NsAdmin admin = (NsAdmin)request.getAttribute("admin");
NsAdmin adminsession = (NsAdmin)session.getAttribute("admin");
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
  	<base href="<%=basePath%>">
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
  </head>
  
  <body>
  <form action="Action/AdminAction?method=edit" method="post">
  	<table align="center">
	  	<tr>
	  		<td>账号:</td>
	  		<td>${admin.admin_name}</td>
	  	</tr>
	  	<tr>
	  		<td>真实姓名:</td>
  			<td>${admin.admin_rname}</td>
	  	</tr>
	  	<tr>
	  		<td>密码:</td>
	  		<td>${admin.admin_password}</td>
	  	</tr>
  	</table>
  </form>
  </body>
</html>
