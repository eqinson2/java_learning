<%@ page contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<title><s:text name="address.page.title" /></title>
<link rel="stylesheet" type="text/css" href="styles.css">
</head>
<body>

	<TABLE width="100%" class="position">
		<TR>
			<TD><s:text name="address_add.page.position" /></TD>
			<TD align="right"><a href="address!list.do"><s:text
						name="address_add.page.back" /></a></TD>
			<TD width="20"></TD>
		</TR>
	</TABLE>

	<s:form name="form1" action="addressadd!insert.do" method="post">
		<s:actionerror />
		<s:actionmessage />
		<TABLE border="0" width="100%">
			<TR>
				<TD><s:text name="address.page.name" /></TD>
				<TD><s:textfield name="name" maxlength="50" />
					<s:fielderror>
						<s:param>name</s:param>
					</s:fielderror></TD>
			</TR>
			<TR>
				<TD><s:text name="address.page.sex" /></TD>
				<TD><s:textfield name="sex" maxlength="10" />
					<s:fielderror>
						<s:param>sex</s:param>
					</s:fielderror></TD>
			</TR>
			<TR>
				<TD><s:text name="address.page.mobile" /></TD>
				<TD><s:textfield name="mobile" maxlength="20" />
					<s:fielderror>
						<s:param>mobile</s:param>
					</s:fielderror></TD>
			</TR>
			<TR>
				<TD><s:text name="address.page.email" /></TD>
				<TD><s:textfield name="email" maxlength="50" />
					<s:fielderror>
						<s:param>email</s:param>
					</s:fielderror></TD>
			</TR>
			<TR>
				<TD><s:text name="address.page.qq" /></TD>
				<TD><s:textfield name="qq" maxlength="20" />
					<s:fielderror>
						<s:param>qq</s:param>
					</s:fielderror></TD>
			</TR>
			<TR>
				<TD><s:text name="address.page.company" /></TD>
				<TD><s:textfield name="company" maxlength="100" />
					<s:fielderror>
						<s:param>company</s:param>
					</s:fielderror></TD>
			</TR>
			<TR>
				<TD><s:text name="address.page.address" /></TD>
				<TD><s:textfield name="address" maxlength="100" />
					<s:fielderror>
						<s:param>address</s:param>
					</s:fielderror></TD>
			</TR>
			<TR>
				<TD><s:text name="address.page.postcode" /></TD>
				<TD><s:textfield name="postcode" maxlength="10" />
					<s:fielderror>
						<s:param>postcode</s:param>
					</s:fielderror></TD>
			</TR>
			<TR>
				<TD colspan="2"><s:submit key="button.submit" /></TD>
			</TR>
		</TABLE>
	</s:form>
</body>
</html>