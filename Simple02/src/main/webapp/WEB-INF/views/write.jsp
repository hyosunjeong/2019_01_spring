<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta name="viewport" content="width=device-width,initial-scale=1">
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

	<form action="write" method="POST">
		<input type="text" name="num1">
		<input type="text" name="op">
		<input type="text" name="num2">
		<button>전송</button>
	</form>
	
	<!-- 
		form으로 감싸서 input만 해 두면 자기자신한테 보내는것 (의미가 없다)
		그래서 form action을 해줘야한다. 
		그런데 action만 해서 보내면 웹주소창에 다 보이므로
		method="POST"로 해준다.
		
		전송버튼을 누르면 
		controller에 있는 @RequestMapping(value="write1",method=RequestMethod.POST) 
		메소드가 실행된다. 
	-->
</body>
</html>