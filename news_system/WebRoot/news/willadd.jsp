<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<%@taglib uri="/WEB-INF/tlds/mytaglib.tld" prefix="mytag"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
    <link rel="stylesheet" type="text/css" href="/news_system/css/all.css">
  </head>
  
  <body>
  	<br/>
  		<form method="POST" action="Action/NewsAction?method=willadd">
	   		<table border="0" align="center" style="border-collapse: collapse">   
			   <tr>
				   <td>请选择所要添加的新闻类别：</td>
				   <td><mytag:catall/></td>
				</tr>
			</table>
			<p align="center">
			   <input type="submit" value="提交"/>
			   <input type="button" value="取消" onclick="window.history.back()"/>
			</p >
	   </form>
  </body>
</html>
