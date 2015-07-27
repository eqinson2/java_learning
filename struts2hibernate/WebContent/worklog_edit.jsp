<%@ page contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<title><s:text name="worklog.page.title" /></title>
<link rel="stylesheet" type="text/css" href="styles.css">
</head>
<body>

<TABLE width="100%" class="position">
	<TR>
		<TD><s:text name="worklog_edit.page.position" /></TD>
		<TD align="right"><a href="worklog!list.do"><s:text name="worklog_edit.page.back" /></a></TD>
		<TD width="20"></TD>
	</TR>
</TABLE>

<s:form name="form1" action="worklogedit!update.do" method="post">
<s:actionerror /> <s:actionmessage />
<TABLE border="0" width="100%">
	<TR>
		<TD><s:text name="worklog.page.year" /></TD>
		<TD><s:textfield name="year" maxlength="4"/><s:fielderror><s:param>year</s:param></s:fielderror></TD>
	</TR>
	<TR>
		<TD><s:text name="worklog.page.month" /></TD>
		<TD><s:textfield name="month" maxlength="2"/><s:fielderror><s:param>month</s:param></s:fielderror></TD>
	</TR>
	<TR>
		<TD><s:text name="worklog.page.day" /></TD>
		<TD><s:textfield name="day" maxlength="2"/><s:fielderror><s:param>day</s:param></s:fielderror></TD>
	</TR>
	<TR>
		<TD><s:text name="worklog.page.title" /></TD>
		<TD><s:textfield name="title" maxlength="100"/><s:fielderror><s:param>title</s:param></s:fielderror></TD>
	</TR>
	<TR>
		<TD><s:text name="worklog.page.description" /></TD>
		<TD><s:textarea name="description" cols="60" rows="15"/><s:fielderror><s:param>description</s:param></s:fielderror></TD>
	</TR>
	<TR>
		<TD colspan="2"><s:submit key="button.submit" /></TD>
	</TR>
</TABLE>
</s:form>


</body>
</html>