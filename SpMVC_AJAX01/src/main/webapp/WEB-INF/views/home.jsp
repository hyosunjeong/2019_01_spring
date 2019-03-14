<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<c:set var="rootPath" value="${pageContext.request.contextPath}" />

<!DOCTYPE html>
<html>
<head>
<meta name="viewport" content="width=device-width,initial-scale=1">
<meta charset="UTF-8">
<title>나라 Plus</title>
<link rel="stylesheet" href="<c:url value='/css/home.css' />" >
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
<c:if test="${BODY == 'DEPT' }"></c:if>
	<%@ include file="/WEB-INF/views/bodys/dept-main.jspf" %>

</head>
<body>
<header class="main-header"><h2>나라 Plus</h2></header>

<section class="content-container">
	<aside class="sidebar">
		<%@ include file="/WEB-INF/views/include/include-nav.jspf" %>
	</aside>
	<article class="main">
		<div class="page-header">section header</div>
		<div class="content">
			<div class="column sub1">
				<div>
					<c:if test="${BODY == 'DEPT' }"></c:if>
					<form>
						<input type="text" 
							placeholder="거래처 이름을 입력 후 Enter"
							id="dsearch" name="dsearch" >
					</form>
				</div>
				<p id="main-list"></p>
			</div>
			<div class="column sub2">
			<c:if test="${BODY == 'DEPT'}">
				<%@ include file="/WEB-INF/views/bodys/DeptForm.jsp" %>
			</c:if>
			
			<p id="d-list"></p>
			</div>
		</div>
	</article>
</section>

<footer>
	<address>CopyRight &copy; jeong8161@naver.com </address>
</footer>

</body>
</html>