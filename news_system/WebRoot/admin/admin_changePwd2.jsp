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
  	<div id="change_password2">
		<table border="0" align="center" width="360" cellpadding="3"
			style="border-collapse: collapse">
				<tr>
	    			<td>请输入新密码：</td>
	    			<td align="left"><input type="text" name="amdin_password" size="20"/></td>
	    		</tr>
	    		<tr>
	    			<td>请输入再次新密码：</td>
	    			<td align="left"><input type="text" name="amdin_password" size="20"/></td>
	    		</tr>
	    		<tr>
					<td align="right"><input type="button" value="提交"></td>
	    			<td align="left"><input type="reset" value="重置"></td>        
				</tr>
		</table><br/>
	</div><br/>
  </body>
</html>
