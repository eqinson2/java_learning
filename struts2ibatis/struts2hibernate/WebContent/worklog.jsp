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
		<TD><s:text name="worklog.page.position" /></TD>
		<TD align="right"><a href="worklog!add.do"><s:text name="worklog.page.add" /></a></TD>
		<TD width="20"></TD>
	</TR>
</TABLE>

<s:actionerror /> <s:actionmessage />

<TABLE border="0" width="100%">
	<TR class="tableheader">
		<TD><s:text name="worklog.page.year" /></TD>
		<TD><s:text name="worklog.page.month" /></TD>
		<TD><s:text name="worklog.page.day" /></TD>
		<TD><s:text name="worklog.page.title" /></TD>
		<TD><s:text name="worklog.page.description" /></TD>
		<TD><s:text name="worklog.page.logtime" /></TD>
		<TD><s:text name="button.operation" /></TD>
	</TR>
	<s:iterator value="pager.resultList">
	<TR>
		<TD><s:property value="year"/></TD>
		<TD><s:property value="month"/></TD>
		<TD><s:property value="day"/></TD>
		<TD><s:property value="title"/></TD>
		<TD><s:property value="description"/></TD>
		<TD><s:property value="logtime"/></TD>
		<TD><a href='worklog!edit.do?id=<s:property value="id"/>'><s:text name="button.edit" /></a>
		<a href="worklog!delete.do?id=<s:property value="id"/>"><s:text name="button.delete" /></a></TD>
	</TR>
	</s:iterator>
</TABLE>

<TABLE border="0" width="100%" class="pager">
	<TR>
	<s:form action="worklog!list.do" method="post" name="form1">
		<TD align="left"><s:text name="pager.pageSize" />
			<s:select name="pageSize" key="pager.pageSize" list="pager.pageSizeIndexs" value="pager.pageSize" onchange="document.all.pageNo.value='1';document.all.form1.submit();"/>
		</TD>
		<TD align="center">
		<s:text name="pager.rowCount" /><s:property value="pager.rowCount" />
		</TD>
		<TD align="right">
			<a href="javascript:document.all.pageNo.value='<s:property value="pager.firstPageNo" />';document.all.form1.submit();"><s:text name="pager.firstPageNo" /></a>
			<a href="javascript:document.all.pageNo.value='<s:property value="pager.prePageNo" />';document.all.form1.submit();"><s:text name="pager.prePageNo" /></a>
			<a href="javascript:document.all.pageNo.value='<s:property value="pager.nextPageNo" />';document.all.form1.submit();"><s:text name="pager.nextPageNo" /></a>
			<a href="javascript:document.all.pageNo.value='<s:property value="pager.lastPageNo" />';document.all.form1.submit();"><s:text name="pager.lastPageNo" /></a>
			<s:select name="pageNo" list="pager.pageNoIndexs" value="pager.pageNo" onchange="document.all.form1.submit();"/>
		</TD>
		<TD width="20"></TD>
	</TR>
</TABLE>
</s:form>


</body>
</html>