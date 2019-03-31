<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@taglib uri="/WEB-INF/tlds/mytaglib.tld" prefix="mytag"%>
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
  		<form method="POST" action="Action/DcAction?method=add">
	   		<table border="0" align="center" width="562"
	          style="border-collapse: collapse">   
			   <tr>
				   <td>详细类别名称</td>
				   <td align="left"><input type="text" name="dcName" size="40"/></td>
				   <td align="left"><mytag:catall/></td>
				</tr>
			</table>
			<p align="center">
			   <input type="submit" value="提交"/>
			   <input type="button" value="取消" onclick="window.history.back()"/>
			</p >
	   </form>
  </body>
</html>
