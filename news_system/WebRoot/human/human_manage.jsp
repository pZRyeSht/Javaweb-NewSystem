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
    <style type="text/css">
		table{
			table-layout: fixed;/*只有定义表格的算法为fixed,th才有效果*/
			border-collapse: collapse;/*边框合并模式*/
		}
		table tr td{
			overflow:hidden;/*超出的文字隐藏*/
			text-overflow:ellipsis;/*文字超出后,显示省略号*/
			width:100%;
			white-space:nowrap;/*文字不换行*/
			word-break:keep-all;/*文字不换行*/
		}
	</style>
	<script type="text/javascript">
	function del() {
			var msg = "确定要删除?";
			if (confirm(msg)==true){
				return true;
			}else{
				return false;
			}
		}
	function edit() {
			var msg = "确定要修改?";
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
	  		<td align="center" width="80">人物姓名</td>
	  		<td align="center" width="80">人物籍贯</td>
	  		<td align="center" width="60">人物年龄</td>
	  		<td align="center" width="80">人物工作</td>
	  		<td align="center" width="160">人物简介</td>
	  		<td align="center" width="60">人物票数</td>
	  		<td align="center" width="80">操作</td>
	  	</tr>
	  	<c:forEach items="${humanlist}" var="n">
	  		<tr>
	  			<td align="left" >
	  				<a href="Action/HumanAction?method=show&humanId=${n.human_id}">${n.human_name}</a></td>
	  			<td align="center">${n.human_address}</td>
	  			<td align="center">${n.human_age}</td>
	  			<td align="center">${n.human_work}</td>
	  			<td align="center">${n.human_intr}</td>
	  			<td align="center">${n.human_num}</td>
	  			<td align="center">
	  				<a href="Action/HumanAction?method=willEdit&humanId=${n.human_id}" onclick="javascript:return edit();">修改</a>
	  				<a href="Action/HumanAction?method=delete&humanId=${n.human_id}" onclick="javascript:return del();">删除</a>
	  			</td>
	  		</tr>
	  	</c:forEach>
  	</table><br/>
	  	<center><a href="human/add.jsp">添加新闻人物</a></center>
  </body>
</html>
