<%@ page language="java" contentType="text/html; charset=GB18030"
	pageEncoding="GB18030"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<%@page import="com.eqinson.demo.HelloWorld"%><html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=GB18030">
<title>Insert title here</title>
</head>
<body>
	<%
		String world = request.getParameter("world");
		HelloWorld hello = new HelloWorld();
		String helloworld = hello.sayHello(world);
	%>
	<%=helloworld%>
</body>
</html>