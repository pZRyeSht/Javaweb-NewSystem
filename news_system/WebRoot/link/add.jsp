<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
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
  	<br/>
  		<form method="POST" action="Action/LinkAction?method=add">
	   		<table border="0" align="center" width="562"
	          style="border-collapse: collapse">   
			   <tr>
				   <td>网站名称</td>
				   <td align="left"><input type="text" name="linkName" size="40"/></td>
				</tr>
				<tr>
				   <td>链接地址</td>
				   <td align="left"><input type="text" name="linkAddress" size="40"/></td>
			   </tr>
			</table>
			<p align="center">
			   <input type="submit" value="提交"/>
			   <input type="button" value="取消" onclick="window.history.back()"/>
			</p >
	   </form>
  </body>
</html>
