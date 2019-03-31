<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>


<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
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
  					<a href="index.jsp">返回首页</a>
  					<a href="admin/admin.jsp">进入后台</a>
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
	         		<li><a href="news/" target="content">政治</a></li>
	         		<li><a href="news/" target="content">娱乐</a></li>
	         		<li><a href="news/" target="content">军事</a></li>
	         		<li><a href="news/" target="content">科学</a></li>
	         		<li><a href="news/" target="content">法制</a></li>
	         		<li><a href="news/" target="content">动物世界</a></li>
	         		<li><a href="news/" target="content" class="last">社会</a></li>
	    		</ul>
	    	</div>
	    </div><br/>
	    <div id="pagebody">
	    <br/>
	    	<div id="left">
	    	<br/><br/>
	    		<div id="news_search">
		    		<table border="0" align="center" width="200" cellpadding="3"
		  					style="border-collapse: collapse">
		  				<tr>
	    					<td>新闻关键词：</td>
	    					<td align="left"><input type="text" name="news_title" size="20"/></td>
	    				</tr>
	    				<tr>
					        <td align="left"><mytag:NsNewsTag/></td>
					        <td><input  type="submit" value="确认查询"/></td>
					    </tr>
		    		</table><br/>
	    		</div><br/> <!--搜素-->
	    		<div id="human">
		    		<table border="1" align="center" width="160" cellpadding="3"
	  					style="border-collapse: collapse">
	  					<tr bgcolor="#146C9C">
	  						<td align="center" width="160">相关投票</td>
	  					</tr>
	  					<tr>
	  						<td align="center">
	  							<li><a href="human/human_select.jsp" target="content">年度新闻人物评选</a></li>
	  							<li><a href="human/human_number.jsp" target="content">年度新闻人物票数</a></li>
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
	    				<ul>
	    					<td align="center">
		    					<li><a href="http://www.baidu.com" target="view_window">百度</a></li>
		         				<li><a href="http://www.sina.com.cn" target="view_window">新浪</a></li>
		         				<li><a href="http://www.yahoo.com" target="view_window">雅虎</a></li>
		         				<li><a href="http://www.163.com" target="view_window">网易</a></li>
		         			</td>	
	    				</ul>
	    			</table>
	    		</div>
	    	</div>
		    <div id="right"><!--首页显示-->
		    	<iframe id="content" name="content" frameborder="0" width="100%"
		    		height="100%" src="first.jsp"></iframe>
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
