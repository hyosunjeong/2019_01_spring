<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta name="viewprot" content="width=divice-width, initial-scale=1">
<meta charset="UTF-8">
<title>Insert title here</title>

</head>
<body>
	
<!-- 
	form에서 input box에 입력된 문자열을 보내는 방식(method)은
	GET 방식과 POST 방식이 있다.
	method 속성을 설정하지 않으면 기본값으로 GET 방식으로 보낸다.
	
	GET 방식으로 보내면 URL 뒷부분에 ? 변수명 = 변수값 & 변수명 = 변수값 형식으로 서버로 보내진다.
	이 방식은 일단 변수명과 변수값이 노출이 될 수 있고, 보낼 수 있는 크기가 제한적이다.
	( 보내고자 하는 데이터가 많으면 잘릴 수 있다.)
	
	input 데이터를 서버로 전송할 때는 method를 POST로 설정하는 것이 좋다.
	* 특별한 경우가 아닐때는 항상 method를 POST로 설정한다.
		
	
 -->
	<form action ="/sp007/calc" method="POST">
		<label for="t_num1">숫자1</label>
		<input id="t_num1" input name="txt_num1"><br/> <!-- input 에 있는 name은 변수이다. 숫자 3을 입력받았을 때 txt_num1=3; 을 server에 전송한다는 뜻-->

		<label for="t_num2">숫자2</label>
		<input id="t_num2" input name="txt_num2"><br/> <!-- id는 HTML문서 내에서 구별할 수 있는 키(PK) -->
	
		<label for="t_num3">숫자3</label>
		<input id="t_num3" input name="txt_num3"><br/>

		<button>확인</button>
	</form>



</body>
</html>