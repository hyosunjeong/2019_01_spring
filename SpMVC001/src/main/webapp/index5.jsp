<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	String strID = request.getParameter("userID");
	String strPassword =request.getParameter("pass");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h4>ID : <%= strID %></h4>
	<h4>Passsword : <%= strPassword %></h4>
	

</body>
</html>