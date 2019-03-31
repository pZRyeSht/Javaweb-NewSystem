<%@page import="com.ns.pojo.NsAdmin"%>
<%@page import="com.ns.pojo.NsUser"%>
<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@taglib uri="/WEB-INF/tlds/mytaglib.tld" prefix="mytag"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
NsUser user = (NsUser)session.getAttribute("user");
NsAdmin admin = (NsAdmin)session.getAttribute("admin");
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
 	<base href="<%=basePath%>">
    <meta http-equiv="Content-Type" content="text/heml; charest=UTF-8">
    <title>网络新闻中心系统</title>
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
    <div id="container">
    	<div id="header">
    		<div id="logo">
    			网络新闻中心系统
    		</div>
    		<div id="logo2">
  					<a href="index">返回首页</a>
  					<a href="adminIndex">进入后台</a>
  					<%
  					if(user!=null){
  					%>
  					user:<%=user.getUser_name() %>
  					<a href="logout.jsp">注销</a>
  					<%
  					}else if(admin!=null){
  					 %>
  					 admin:<%=admin.getAdmin_name() %>
  					 <a href="logout.jsp">注销</a>
  					 <%}else{ %>
  					<a href="user/login.jsp">用户登录</a>
  					<%
  					}
  					%>
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
	    	<br/><br/>
	    		<div id="news_search">
	    			<form action="Action/NewsAction?method=likeshow" method="post" target="content" >
			    		<table border="0" align="center" width="200" cellpadding="3"
			  					style="border-collapse: collapse">
			  				<tr>
		    					<td>新闻关键词：</td>
		    					<td align="left"><input type="text" name="newsTitle" size="20"/></td>
		    				</tr>
		    				<tr>
						        <td align="left"><mytag:catall/></td>
						        <td><input  type="submit" value="确认查询"/></td>
						    </tr>
			    		</table>
	    			</form>
	    		</div><br/> <!--搜素-->
	    		<div id="human">
		    		<table border="1" align="center" width="160" cellpadding="3"
	  					style="border-collapse: collapse">
	  					<tr bgcolor="#146C9C">
	  						<td align="center" width="160">相关投票</td>
	  					</tr>
	  					<tr>
	  						<td align="center">
		  						<ul>
		  							<li><a href="Action/HumanAction?method=browse" target="content">年度新闻人物评选</a></li>
		  							<li><a href="Action/HumanAction?method=shownum" target="content">年度新闻人物票数</a></li>
		  						</ul>
	  						</td>
	  					</tr>
	  				</table><br/>
	    		</div><br/> <!--人物投票-->
	    		<div id="link">
	    			<table border="1" align="center" width="160" cellpadding="3"
	  					style="border-collapse: collapse">
	  					<tr bgcolor="#146C9C">
	  						<td align="center" width="160">友情链接</td>
	  					</tr>
	  					<tr>
		    				<td align="center">
		    						<c:forEach items="${linklist}" var="n" begin="0" end="4">
			    					<li><a href="${n.link_address}" target="view_window">${n.link_name}</a></li>
		    						</c:forEach>
		    				</td>
	  					</tr>
	    			</table>
	    		</div>
	    	</div>
		    <div id="right"><!--首页显示-->
		    	<iframe id="content" name="content" frameborder="0" width="100%"
		    		height="100%" src="index?method=firstshow"></iframe>
		    </div>
	  	</div>
	  	<div id="footer">
	  		<center>
		  		Copyright &copy; 2018-2020 F2-236,All Right Reserved<br/>
		  		F2-236 版权所有<br/>
		  		访问人数：${totalcount}&nbsp;&nbsp;在线人数：${accesscount}
		  	</center>
	  	</div>
    </div>
  </body>
</html>
