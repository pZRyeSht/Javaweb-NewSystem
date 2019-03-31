<%@page import="com.ns.pojo.NsAdmin"%>
<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="/WEB-INF/tlds/mytaglib.tld" prefix="mytag"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
NsAdmin admin = (NsAdmin)session.getAttribute("admin");
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <base href="<%=basePath%>">
  <meta http-equiv="Content-Type" content="text/heml; charest=UTF-8">
    <title>网络新闻中心后台</title>
	<link rel="stylesheet" type="text/css" href="css/all.css">
  </head>
  
  <script type="text/javascript">
	function getCurrentTime(){
		var date = new Date();
		var year = date.getFullYear();
		var month = (date.getMonth()+1);
		if(month<10){
			month = "0" + month;
		}
		var day = date.getDate();
		var currentTime = year + "年" + month + "月" + day + "日";
		showCurrentTime.innerHTML = currentTime;
		window.setTimeout("getCurrentTime();",1000);
	}
	window.onload = getCurrentTime;
	</script>
  <body>
  	<mytag:admincheck right="1"/>
	  <div id="container">
	    	<div id="header">
	    		<div id="logo">
	    			网络新闻中心系统
	    		</div>
	    		<div id="logo2">
  					<a href="index">返回首页</a>
  					<%=admin.getAdmin_name() %>
    			</div>
	    	</div>
		    <div id="navigator">
		    	<div id="menu">
		    		<ul>
		    			<li>
		    				<div class="tianqi">
								<div class="tq_con">
									<span id="showCurrentTime"></span>
								</div>
							</div>
		    			</li>
		    			<c:forEach items="${catlist}" var="n" begin="0" end="7">
	         		<li><a href="Action/CatAction?method=show&catId=${n.cat_id}" target="content">${n.cat_name}</a></li>
	    			</c:forEach>
		    		</ul>
		    	</div>
		    </div><br/>
		    <div id="pagebody">
		    <br/>
		    	<div id="left">
		    		<div id="link">
		    			<table border="1" align="center" width="200" cellpadding="3"
		  					style="border-collapse: collapse">
		  					<tr bgcolor="#146C9C">
			    				<ul>
			    					<td align="center">
				    					<br/><li><a href="Action/AdminAction?method=manage" target="content">管理员设置</a></li><br/>
				         				<li><a href="Action/UserAction?method=manage" target="content">用户管理</a></li><br/>
				         				<li><a href="Action/AdminAction?method=willEdit&adminId=<%=admin.getAdmin_id() %>" target="content">修改资料</a></li><br/>
				         				<li><a href="Action/CatAction?method=showall" target="content">新闻类型管理</a></li><br/>
				         				<li><a href="Action/DcAction?method=showall" target="content">新闻详细类型管理</a></li><br/>
				         				<li><a href="Action/NewsAction?method=showall" target="content">新闻信息管理</a></li><br/>
				         				<li><a href="Action/LinkAction?method=show" target="content">链接管理</a></li><br/>
				         				<li><a href="Action/HumanAction?method=manage" target="content">查看新闻人物</a></li><br/>
				         				<li><a href="logout.jsp" >退出后台并注销</a></li><br/>
				         			</td>	
			    				</ul>
		    				</tr>
		    			</table>
		    		</div>
		    	</div>
			    <div id="right"><!--首页显示-->
			    	<iframe id="content" name="content" frameborder="0" width="100%"
			    		height="100%" src="admin/adminfirst.jsp"></iframe>
			    </div>
		  	</div>
	    </div>
  </body>
</html>
