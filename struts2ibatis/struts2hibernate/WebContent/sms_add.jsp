<%@ page contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<title><s:text name="sms.page.title" /></title>
<link rel="stylesheet" type="text/css" href="styles.css">
</head>
<body>

<TABLE width="100%" class="position">
	<TR>
		<TD><s:text name="sms_add.page.position" /></TD>
		<TD align="right"><a href="sms!list.do"><s:text name="sms_add.page.back" /></a></TD>
		<TD width="20"></TD>
	</TR>
</TABLE>

<s:form name="form1" action="smsadd!insert.do" method="post">
<s:actionerror /> <s:actionmessage />
<TABLE border="0" width="100%">
	<TR>
		<TD><s:text name="sms.page.username" /></TD>
		<TD><s:textfield name="username" maxlength="50"/><s:fielderror><s:param>username</s:param></s:fielderror></TD>
	</TR>
	<TR>
		<TD><s:text name="sms.page.message" /></TD>
		<TD><s:textarea name="message" cols="60" rows="15"/><s:fielderror><s:param>message</s:param></s:fielderror></TD>
	</TR>
	<TR>
		<TD colspan="2"><s:submit key="button.submit" /></TD>
	</TR>
</TABLE>
</s:form>


</body>
</html>