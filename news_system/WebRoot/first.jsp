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
    <meta http-equiv="Content-Type" content="text/heml; charest=UTF-8">
	<link rel="stylesheet" type="text/css" href="css/all.css">
  </head>
  
  <body>
    <div id="news_taday">
    	<div>今日速推</div><br/>
    	<div id="title">
    		<table border="1" align="center" width="500" cellpadding="3"
		  					style="border-collapse: collapse">
		  		<tr bgcolor="#00FFFF">
			  		<td align="center" width="300">新闻标题</td>
			  		<td align="center" width="120">新闻发布时间</td>
			  		<td align="center" width="80">新闻详细类型</td>
  				</tr>
  				<c:forEach items="${newsFlist}" var="n">
  					<tr>
			  			<td align="left" >
			  				<a href="Action/NewsAction?method=show&newsId=${n.news_id}"
			  					target="_blank">${n.news_title}</a></td>
			  			<td align="center">${n.news_datetime}</td>
			  			<td align="center">${n.dc_name}</td>
			  		</tr>
			  	</c:forEach>
		  	</table>
    	</div>
    </div>
  </body>
</html>
