<%@ page contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<title><s:text name="schedule.page.title" /></title>
<link rel="stylesheet" type="text/css" href="styles.css">
</head>
<body>

<TABLE width="100%" class="position">
	<TR>
		<TD><s:text name="schedule_edit.page.position" /></TD>
		<TD align="right"><a href="schedule!list.do"><s:text name="schedule_edit.page.back" /></a></TD>
		<TD width="20"></TD>
	</TR>
</TABLE>

<s:form name="form1" action="scheduleedit!update.do" method="post">
<s:actionerror /> <s:actionmessage />
<TABLE border="0" width="100%">
	<TR>
		<TD><s:text name="schedule.page.year" /></TD>
		<TD><s:textfield name="year" maxlength="4"/><s:fielderror><s:param>year</s:param></s:fielderror></TD>
	</TR>
	<TR>
		<TD><s:text name="schedule.page.month" /></TD>
		<TD><s:textfield name="month" maxlength="2"/><s:fielderror><s:param>month</s:param></s:fielderror></TD>
	</TR>
	<TR>
		<TD><s:text name="schedule.page.day" /></TD>
		<TD><s:textfield name="day" maxlength="2"/><s:fielderror><s:param>day</s:param></s:fielderror></TD>
	</TR>
	<TR>
		<TD><s:text name="schedule.page.plan" /></TD>
		<TD><s:textarea name="plan" cols="60" rows="15"/><s:fielderror><s:param>plan</s:param></s:fielderror></TD>
	</TR>
	<TR>
		<TD colspan="2"><s:submit key="button.submit" /></TD>
	</TR>
</TABLE>
</s:form>


</body>
</html>