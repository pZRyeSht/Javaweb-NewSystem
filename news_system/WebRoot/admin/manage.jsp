<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
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
    <title>管理员设置</title>
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
  <mytag:admincheck right="0"/>
  	<table border="1" align="center" width="640" cellpadding="3"
	  	style="border-collapse: collapse">
	  	<tr bgcolor="#00FFFF">
	  		<td align="center" width="80">账号</td>
	  		<td align="center" width="80">真实姓名</td>
	  		<td align="center" width="60">密码</td>
	  		<td align="center" width="80">注册时间</td>
	  		<td align="center" width="160">管理员类别</td>
	  		<td align="center" width="60">权限值</td>
	  		<td align="center" width="80">操作</td>
	  	</tr>
	  	<c:forEach items="${adminlist}" var="n">
	  		<tr>
	  			<td align="center" >${n.admin_name}</td>
	  			<td align="center">${n.admin_rname}</td>
	  			<td align="center">${n.admin_password}</td>
	  			<td align="center">${n.admin_datetime}</td>
	  			<td align="center">${n.admin_type}</td>
	  			<td align="center">${n.admin_right}</td>
	  			<td align="center">
	  				<a href="Action/AdminAction?method=willEdit&adminId=${n.admin_id}" onclick="javascript:return edit();">修改</a>
	  				<a href="Action/AdminAction?method=delete&adminId=${n.admin_id}" onclick="javascript:return del();">删除</a>
	  			</td>
	  		</tr>
	  	</c:forEach>
  	</table><br/>
	  	<center><a href="admin/add.jsp">添加管理员</a></center>
  </body>
</html>
