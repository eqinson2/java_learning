<%@ page contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<title><s:text name="meeting.page.title" /></title>
<link rel="stylesheet" type="text/css" href="styles.css">
</head>
<body>

<TABLE width="100%" class="position">
	<TR>
		<TD><s:text name="meeting_edit.page.position" /></TD>
		<TD align="right"><a href="meeting!list.do"><s:text name="meeting_edit.page.back" /></a></TD>
		<TD width="20"></TD>
	</TR>
</TABLE>

<s:form name="form1" action="meetingedit!update.do" method="post">
<s:actionerror /> <s:actionmessage />
<TABLE border="0" width="100%">
	<TR>
		<TD><s:text name="meeting.page.starttime" /></TD>
		<TD><s:textfield name="starttime" maxlength="100"/><s:fielderror><s:param>starttime</s:param></s:fielderror></TD>
	</TR>
	<TR>
		<TD><s:text name="meeting.page.endtime" /></TD>
		<TD><s:textfield name="endtime" maxlength="100"/><s:fielderror><s:param>endtime</s:param></s:fielderror></TD>
	</TR>
	<TR>
		<TD><s:text name="meeting.page.address" /></TD>
		<TD><s:textfield name="address" maxlength="100"/><s:fielderror><s:param>address</s:param></s:fielderror></TD>
	</TR>
	<TR>
		<TD><s:text name="meeting.page.title" /></TD>
		<TD><s:textfield name="title" maxlength="100"/><s:fielderror><s:param>title</s:param></s:fielderror></TD>
	</TR>
	<TR>
		<TD><s:text name="meeting.page.content" /></TD>
		<TD><s:textarea name="content" cols="60" rows="15"/><s:fielderror><s:param>content</s:param></s:fielderror></TD>
	</TR>
	<TR>
		<TD colspan="2"><s:submit key="button.submit" /></TD>
	</TR>
</TABLE>
</s:form>


</body>
</html>