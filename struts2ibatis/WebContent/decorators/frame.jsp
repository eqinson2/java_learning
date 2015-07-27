<%@ page contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ page import="com.demo.struts2.util.Constants"%>
<%@ taglib uri="http://www.opensymphony.com/sitemesh/decorator"
	prefix="decorator"%>
<html>
<head>
<title>企业信息管理系统 - <decorator:title default="Welcome!" /></title>
<link rel="stylesheet" type="text/css" href="styles.css">
<decorator:head />
</head>

<%
	if (session.getAttribute(Constants.USERNAME_KEY) != null) {
%>
<body>
<div align="center">
<table height="108" background="images/banner.jpg" border="0"
	cellspacing="0" cellpadding="0" width="100%">
	<tr>
		<td></td>
	</tr>
</table>
<table width="100%">
	<tr>
		<td width="160" bgcolor="#EEEEEE" valign="top">
		<table width="100%" bgcolor="#EEEEEE">
			<tr>
				<td>
				<ul class="ulnotab">
					<li><a href="welcome.do">首页面</a></li>
				</ul>
				</td>
			</tr>
			<tr>
				<td>
				<ul class="ulnotab">
					<li><a href="#">通讯工具</a></li>
				</ul>
				<ul>
					<li><a href="address!init.do">通讯录管理</a></li>
					<li><a href="sms!init.do">短消息管理</a></li>
				</ul>
				</td>
			</tr>
			<tr>
				<td>
				<ul class="ulnotab">
					<li><a href="#">个人管理</a></li>
				</ul>
				<ul>
					<li><a href="schedule!init.do">日程安排</a></li>
					<li><a href="worklog!init.do">工作记录</a></li>
				</ul>
				</td>
			</tr>
			<tr>
				<td>
				<ul class="ulnotab">
					<li><a href="#">企业管理</a></li>
				</ul>
				<ul>
					<li><a href="notice!init.do">公司公告</a></li>
					<li><a href="meeting!init.do">工作会议</a></li>
				</ul>
				</td>
			</tr>
			<tr>
				<td>
				<ul class="ulnotab">
					<li><a href="logout.do">退出</a></li>
				</ul>
				</td>
			</tr>
		</table>
		</td>
		<td align="left" valign="top"><decorator:body /></td>
	</tr>
</table>
<hr>
<font face="仿宋">Copyright <span class="fontArial">&copy;</span>Java研究室
版权所有</font></div>
</body>
<%
	} else {
%><body bgcolor="#52BDFE">
<div align="center"><decorator:body /></div>
</body>
<%
	}
%>
</html>
