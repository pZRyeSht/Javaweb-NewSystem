<%@page import="com.ns.pojo.NsAdmin"%>
<%@page import="com.ns.pojo.NsUser"%>
<%@page import="javafx.scene.control.Alert"%>
<%@page contentType="text/html"%>
<%@page pageEncoding="UTF-8"%>
<%@taglib uri="/WEB-INF/tlds/mytaglib.tld" prefix="mytag"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
NsAdmin admin = (NsAdmin)session.getAttribute("admin");
%>
<!DOCTYPE html>
<html>
    <head>
    	<base href="<%=basePath%>">
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>后台登录</title>
    </head>
    <body>
    	<mytag:admincheck right="1"/>
	    <form method="post" action="Action/AdminAction?method=login">
	    	<table align="center">
	    		<tr>
	    			<td>账号:</td>
	    			<td align="left"><input type="text" name="adminName" size="20"></td>
	    		</tr>
	    		<tr>
	    			<td>密码:</td>
	    			<td align="left"><input type="password" name="adminPwd" size="20"></td>
	    		</tr>
	    		<tr>
	    			<td><input type="submit" value="提交"></td>
	    			<td><input type="reset" value="重置"></td>
	    		</tr>
	    		<tr>
	    			<td colspan="2" align="center"><a href="index">返回</a></td>
	    		</tr>
	    	</table>
	    </form>
	    <%
			String str=(String)request.getSession().getAttribute("mrgss");
		if(str==null||"".equals(str)){
		}else{%>
			<script type="text/javascript">
			alert("<%=str%>");
			</script><%} %><%
		session.setAttribute("mrgss", "");
		%>
 	</body>
</html>