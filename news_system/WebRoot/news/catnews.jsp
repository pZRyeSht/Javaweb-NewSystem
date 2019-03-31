<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
  	<base href="<%=basePath%>">
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
    <link rel="stylesheet" type="text/css" href="css/catnews.css">
  </head>
  
  <body>
  <div id="news_cat">
  		<div>
			<ul>
			  	<c:forEach items="${dclist}" var="m" begin="0" end="5">
				<li><a href="Action/DcAction?method=show&dcId=${m.dc_id}&catId=${m.cat_id}">${m.dc_name}</a></li>
		  		</c:forEach>
			</ul>
  		</div>
	    <div id="title">
			<br/><br/>
	    	<table border="1" align="center" width="500" cellpadding="3"
			  		style="border-collapse: collapse">
			  	<tr bgcolor="#00FFFF">
				  	<td align="center" width="300">新闻标题</td>
				  	<td align="center" width="120">新闻发布时间</td>
				  	<td align="center" width="100">新闻详细类型</td>
	  			</tr>
	  			<c:forEach items="${newsdclist}" var="n">
	  				<tr>
				  		<td align="left" >
				  			<a href="Action/NewsAction?method=show&newsId=${n.news_id}"
				  				target="_blank">${n.news_title}</a></td>
				  		<td align="center">${n.news_datetime}</td>
				  		<td align="center">${n.dc_name}</td>
				</c:forEach>
			</table>
	    </div>
    </div>
  </body>
</html>
