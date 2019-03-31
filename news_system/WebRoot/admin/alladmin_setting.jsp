<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
    <link rel="stylesheet" type="text/css" href="/news_system/css/all.css">
  </head>
  
  <body>
  	<table border="1" align="center" width="640" cellpadding="3"
	  	style="border-collapse: collapse">
	  	<tr bgcolor="#00FFFF">
	  		<td align="center" width="80">数据库ID</td>
	  		<td align="center" width="120">账号</td>
	  		<td align="center" width="120">真实姓名</td>
	  		<td align="center" width="120">注册时间</td>
	  		<td align="center" width="120">管理员类别</td>
	  		<td align="center" width="80">操作</td>
	  	</tr>
	  	<c:forEach items="${plist.list}" var="n">
	  		<tr>
	  			<td align="center">${n.amdin_id}</td>
	  			<td align="left" >
	  				<a href="com/ns/Action/NsAdminAction?method=show&AdminId=${n.amdin_id}"
	  					target="_blank">${n.amdin_name}</a></td>
	  			<td align="center">${n.amdin_rname}</td>
	  			<td align="center">${n.amdin_datetime}</td>
	  			<td align="center">${n.amdin_type}</td>
	  			<td align="center">
	  				<a href="com/ns/Action/NsAdminAction?method=update&AdminId=${n.amdin_id}">修改</a>
	  				<a href="com/ns/Action/NsAdminAction?method=delete&AdminId=${n.amdin_id}">删除</a>
					</a>
	  			</td>
	  		</tr>
	  	</c:forEach>
  	</table><br/>
  </body>
</html>
