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
	  		<td>账号:<input type="hidden" name="adminId" value="${admin.admin_id}"></td>
	  		<td><input type="text" name="adminName" value="${admin.admin_name}"></td>
	  	</tr>
	  	<tr>
	  		<td>真实姓名:</td>
  			<td><input type="text" name="adminRname" value="${admin.admin_rname}"></td>
	  	</tr>
	  	<tr>
	  		<td>密码:</td>
	  		<td><input type="text" name="adminPassword" value="${admin.admin_password}"></td>
	  	</tr>
	  	<%if(adminsession.getAdmin_right()<=0){ %>
	  	<tr>
	  		<td>管理员类别:</td>
	  		<td>
	  			<select name="adminType">
	  			<%if(admin.getAdmin_right()==1){ %>
		  			<option value="1">普通管理员</option>
		  			<option value="0">超级管理员</option>
		  		<%}else if(admin.getAdmin_right()==0){ %>
		  			<option value="0">超级管理员</option>
		  			<option value="1">普通管理员</option>
		  		<%}%>
	  			</select>
	  		</td>
	  	</tr>
	  	<%}else{ %>
	  	<tr><td><input name="adminType" value="1" type="hidden"></td></tr>
	  	<%} %>
	  	<tr>
	  		<td colspan="2" align="center"><input type="submit" value="提交">
	  		<input type="button" value="取消修改" onclick="window.history.back()"></td>
	  	</tr>
  	</table>
  </form>
  </body>
</html>
