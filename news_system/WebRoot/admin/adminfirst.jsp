<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
	  <style type="text/css">
	  	div#welcome{
	  		text-align: center;
	  		font-size: 30px;
	  		margin-top: 180px;
	  	}
	  </style>
  </head>
  
  <body>
    	<div id="welcome">
    		欢迎光临网络新闻中心
    	</div>
  </body>
</html>
