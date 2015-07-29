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
		<TD><s:text name="meeting.page.position" /></TD>
		<TD align="right"><a href="meeting!add.do"><s:text name="meeting.page.add" /></a></TD>
		<TD width="20"></TD>
	</TR>
</TABLE>

<s:actionerror /> <s:actionmessage />

<TABLE border="0" width="100%">
	<TR class="tableheader">
		<TD><s:text name="meeting.page.sender" /></TD>
		<TD><s:text name="meeting.page.starttime" /></TD>
		<TD><s:text name="meeting.page.endtime" /></TD>
		<TD><s:text name="meeting.page.address" /></TD>
		<TD><s:text name="meeting.page.title" /></TD>
		<TD><s:text name="meeting.page.content" /></TD>
		<TD><s:text name="button.operation" /></TD>
	</TR>
	<s:iterator value="pager.resultList">
	<TR>
		<TD><s:property value="sender"/></TD>
		<TD><s:property value="starttime"/></TD>
		<TD><s:property value="endtime"/></TD>
		<TD><s:property value="address"/></TD>
		<TD><s:property value="title"/></TD>
		<TD><s:property value="content"/></TD>
		<TD><a href='meeting!edit.do?id=<s:property value="id"/>'><s:text name="button.edit" /></a>
		<a href="meeting!delete.do?id=<s:property value="id"/>"><s:text name="button.delete" /></a></TD>
	</TR>
	</s:iterator>
</TABLE>

<TABLE border="0" width="100%" class="pager">
	<TR>
	<s:form action="meeting!list.do" method="post" name="form1">
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