<%@ page contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<title><s:text name="login.page.title" /></title>
</head>
<body>

<form name="form1" action="login.do" method="post">
<table height="100%" width="100%">
	<tr>
		<td align="center">
		<table width="572" height="307" background="images/login.jpg">
			<tr>
				<td width="60%"></td>
				<td>
				<table>
					<tr>
						<td><s:text name="login.page.username" /></td>
						<td><s:textfield name="username" size="10" cssStyle="width:100px;" /><s:fielderror>
							<s:param>username</s:param>
						</s:fielderror></td>
					</tr>
					<tr>
						<td><s:text name="login.page.password" /></td>
						<td><s:password name="password" size="10" cssStyle="width:100px;" /><s:fielderror>
							<s:param>password</s:param>
						</s:fielderror></td>
					</tr>
					<tr>
						<td colspan="2"><s:submit key="login.page.login" /><a
							href="register!init.do"><s:text name="login.page.register" /></a></td>
					</tr>
				</table>
				</td>
			</tr>
		</table>
		</td>
	</tr>
</table>
<br>
<br>
<s:actionerror /> <s:actionmessage /></form>


</body>
</html>
