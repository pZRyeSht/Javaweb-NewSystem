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
    <title>用户管理</title>
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
  		<td align="center" width="80">账号</td>
  		<td align="center" width="80">真实姓名</td>
  		<td align="center" width="160">密码</td>
  		<td align="center" width="160">电子邮件</td>
  		<td align="center" width="160">电话</td>
  		<td align="center" width="120">注册时间</td>
  		<td align="center" width="80">操作</td>
  	</tr>
  	<c:forEach items="${userlist}" var="n">
  		<tr>
  			<td align="center" ><a href="Action/UserAction?method=show&userId=${n.user_id}">${n.user_name}</a></td>
  			<td align="center">${n.user_rname}</td>
  			<td align="center">${n.user_password}</td>
  			<td align="center">${n.user_email}</td>
  			<td align="center">${n.user_tel}</td>
  			<td align="center">${n.user_datetime}</td>
  			<td align="center">
	  			<a href="Action/UserAction?method=willEdit&userId=${n.user_id}" onclick="javascript:return edit();">修改</a>
	  			<a href="Action/UserAction?method=delete&userId=${n.user_id}" onclick="javascript:return del();">删除</a>
	  		</td>
  		</tr>
  	</c:forEach>
  </table><br/>
  <center><a href="user/add.jsp">添加用户</a></center>
  </body>
</html>
