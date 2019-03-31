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
    <script type="text/javascript">
    function del() {
		var msg = "确定要删除?";
		if (confirm(msg)==true){
			return true;
		}else{
			return false;
		}
	}
	</script>
  </head>
  
  <body>
  	<table border="1" align="center" width="640" cellpadding="3"
	  	style="border-collapse: collapse">
	  	<tr bgcolor="#00FFFF">
	  		<td align="center" width="80">ID</td>
	  		<td align="center" width="120">网站链接名称</td>
	  		<td align="center" width="120">链接的地址</td>
	  		<td align="center" width="120">发布时间</td>
	  		<td align="center" width="80">操作</td>
	  	</tr>
	  	<c:forEach items="${linklist}" var="n">
	  		<tr>
	  			<td align="center" >
	  				<a href="Action/LinkAction?method=show"
	  					target="_blank">${n.link_id}</a></td>
	  			<td align="center">${n.link_name}</td>
	  			<td align="center">${n.link_address}</td>
	  			<td align="center">${n.link_datetime}</td>
	  			<td align="center">
	  				<a href="Action/LinkAction?method=willEdit&linkId=${n.link_id}">修改</a>
	  				<a href="Action/LinkAction?method=delete&linkId=${n.link_id}" onclick="javascript:return del();">删除</a>
	  			</td>
	  		</tr>
	  	</c:forEach>
  	</table><br/>
  	<center><a href="link/add.jsp">添加链接</a></center>
  </body>
</html>
