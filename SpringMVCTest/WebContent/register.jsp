<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<%@ taglib prefix="spring" uri="/spring"%>
<%@ taglib prefix="form" uri="/spring-form"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<base href="<%=basePath%>">

<title><spring:message code="register.page.title" /></title>

<meta http-equiv="pragma" content="no-cache">
<meta http-equiv="cache-control" content="no-cache">
<meta http-equiv="expires" content="0">
<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
<meta http-equiv="description" content="This is my page">

<!--
    <link rel="stylesheet" type="text/css" href="styles.css">
    -->
</head>

<body>

<form name="form1" action="register.do?method=register" method="post">
<table height="100%" width="100%">
	<tr>
		<td align="center">

		<table width="572" height="307" background="images/login.jpg">
			<tr>
				<td width="60%"></td>
				<td>
				<table width="200" border="0">
					<tr>
						<spring:bind path="command.username">
							<td><spring:message code="register.page.username" /></td>
							<td><input type="text" name="${status.expression }"
								value="${status.value }" size="10" style="width:100px;" /> <font color="red">${status.errorMessage
							}</font></td>
						</spring:bind>
					</tr>
					<tr>
						<spring:bind path="command.password1">
							<td><spring:message code="register.page.password1" /></td>
							<td><input type="password" name="${status.expression }"
								value="${status.value }" size="10" style="width:100px;" /> <font color="red">${status.errorMessage
							}</font></td>
						</spring:bind>
					</tr>
					<tr>
						<spring:bind path="command.password2">
							<td><spring:message code="register.page.password2" /></td>
							<td><input type="password" name="${status.expression }"
								value="${status.value }" size="10" style="width:100px;" /> <font color="red">${status.errorMessage
							}</font></td>
						</spring:bind>
					</tr>
					<tr>
						<spring:bind path="command.email">
							<td><spring:message code="register.page.email" /></td>
							<td><input type="text" name="${status.expression }"
								value="${status.value }" size="10" style="width:100px;" /> <font color="red">${status.errorMessage
							}</font></td>
						</spring:bind>
					</tr>
					<tr>
						<td colspan="2"><input type="submit" name="submit"
							value='<spring:message code="register.page.register" />'>
						<a href="login.do"><spring:message code="register.page.back" /></a></td>
					</tr>
				</table>
				</td>
			</tr>
		</table>
		</td>
	</tr>
</table></form>

</body>
</html>
