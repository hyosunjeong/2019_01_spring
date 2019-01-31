<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta name = "viewport" content="width=divice-width, initial-scale=1">
<meta charset="UTF-8">
<title>메모장</title>
<!--  본문에 포함된 css 내용을 별도 파일로 분리 -->
<!--  
	webapp에서 폴더를 css라고 생성하고
	css파일을 memo_main이름으로 생성한다.
	(생성된 파일에 본문에서 작성된 style부분을 붙여넣기
	현재 파일로 돌아와서 link rel을 작성해준다.)
 -->
<link rel="stylesheet" href=<c:url value="/css/memo_main.css"/>>

</head>
<body>
<%@ include file="/WEB-INF/include/include-header.jspf" %> <!-- tomcat이 참조한다. -->
<!-- link 파일은 절대 web-inf 폴더에 넣을 수 없다. -->


<section> <!--  본문이 들어갈 자리 -->

</section>
<footer>
	<address>CopyRight &copy; jeong8161@naver.com</address>
</footer>



</body>
</html>