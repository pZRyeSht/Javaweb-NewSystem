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
    <link rel="stylesheet" type="text/css" href="/news_system/css/all.css">
  </head>
  
  <body>
  <br/>
  	<form method="POST" action="Action/NewsAction?method=edit">
		<table border="1" width="562" align="center" style="border-collapse:collapse">
			<tr>
				<td>新闻标题<input type="hidden" name="newsId" value="${news.news_id}"></td>
				<td align="left"><input type="text" name="newsTitle" value="${news.news_title}" size="47"></td>
			</tr>
			<tr>
				<td>新闻内容</td>
				<td valign="top" align="left">
					<textarea rows="13" name="newsContent" cols="49">${news.news_content}</textarea>
				</td>
			</tr>
			<tr>
				<td>类型<input type="hidden" name="catId" value="${news.cat_id}"></td>
				<td align="left">${cat.cat_name}</td>
			</tr>
			<tr>
				<td>详细类别</td>
				<td>
					<select name="dcId">
						<c:forEach items="${dclist}" var="n">
							<option value="${n.dc_id}">${n.dc_name}</option>
						</c:forEach>
					</select>
				</td>
			</tr>
			<tr>
				<td>是否今日速推</td>
				<td>
					<select name="newsFirstshow">
							<option value="1">是</option>
							<option value="0">否</option>
					</select>
				</td>
			</tr>
		</table>
		<p align="center">
			<input type="submit" value="提交"/>
			<input type="button" value="取消" onclick="window.history.back()"/>
		</p>
	</form>	
  </body>
</html>