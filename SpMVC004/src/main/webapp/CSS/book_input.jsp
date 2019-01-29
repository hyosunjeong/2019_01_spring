<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="java.sql.*"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/sql" prefix="sql"%>

<sql:setDataSource var="booksDataSource"
	driver="oracle.jdbc.driver.OracleDriver"
	url="jdbc:oracle:thin:@localhost:1521:xe" user="mybts" password="1234" />
<sql:query dataSource="${booksDataSource}" var="bookList">
	SELECT * FROM tbl_books
</sql:query>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>도서정보 관리</title>
<style>
header {
	background-color: #00aba9;
	color: #fff;
	padding: 10px;
	font-size: 20pt;
	font-weight: bold;
	text-align: center;
}

nav {
	width: 100%;
	color: #fff;
	background-color: #00aba9;
	font-weight: normal;
	font-size: 10px;
}

table{
	border-spacing : 0px;
	display: table;
	width:100%;
	text-align:center;
	border: 1px solid black;
	margin: 0 auto;
	
}
tr{
	border: 1px solid black;
}
td,th{
	border: 1px solid black;
}
#id button{
	width:100%;
	margin:3px;
	
}

</style>


</head>
<body>
	<header>
		<h2>도서정보</h2>
		<nav>
			<a href="#">홈</a> 
			<a href="#">도서정보보기</a> 
			<a href="#">로그인</a> 
			<a href="#">회원가입</a> 
			<a href="#">About</a>
		</nav>
	</header>
	<section>
	
	<c:choose>
		<c:when test="${empty param.id}" >
			<form action="/sp004/controller/book_input.jsp">
		</c:when>
		<c:otherwise>
			<form action="/sp004/controller/book_update.jsp">	
		</c:otherwise>
	</c:choose>
	

		<fieldset>
			<legend>도서입력</legend>
			<label for="tb_name">도서명</label>
			<input type="text" id="tb_name" name="tb_name"/><br/>
			
			<label for="tb_comp">출판사</label>	
			<input type="text" id="tb_comp" name="tb_comp"/><br/>
			
			<label for="tb_auth">저자</label>
			<input type="text" id="tb_auth" name="tb_auth"/><br/>
			
			<label for="tb_price">가격</label>
			<input type="text" id="tb_pirce" name="tb_price"/><br/>
			
			
			
				<tr>
					<td>${row.tb_name }</td>
					<td>${row.tb_comp }</td>
					<td>${row.tb_auth }</td>
					<th>${row.tb_price }</th>
				</tr>
	
		</fieldset>
		
		
			<div id="button-add">
			<button>도서추가</button>
			<button>취소</button>
			</div>
		
		
		
	</section>

</body>
</html>