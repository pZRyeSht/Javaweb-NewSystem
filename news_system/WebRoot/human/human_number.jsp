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
    <link rel="stylesheet" type="text/css" href="/news_system/css/all.css">
  </head>
  
  <body>
  	<table border="1" align="center" width="640" cellpadding="3"
	  	style="border-collapse: collapse">
	  	<tr bgcolor="#00FFFF">
	  		<td align="center" width="160">人物姓名</td>
	  		<td align="center" width="160">人物票数</td>
	  	</tr>
	  	<c:forEach items="${humanlist}" var="n">
	  		<tr>
	  			<td align="center" >
	  				<a href="Action/HumanAction?method=show&humanId=${n.human_id}">${n.human_name}</a>
	  			</td>
	  			<td align="center">${n.human_num}</td>
	  		</tr>
	  	</c:forEach>
  	</table><br/>
  </body>
</html>
