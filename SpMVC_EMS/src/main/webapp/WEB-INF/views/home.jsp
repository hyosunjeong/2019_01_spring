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
<style>
	.main-header{
		margin: 0 auto;
		padding:20px;
		background-color: pink;
		color: white;
		text-align: center;
		font-weight: bold;
	}
	
	table {
	border-collapse:collapse;
	border-spacing: 0;
	width:100%;
	border:1px solid #ccc;
}

tr {
	border:1px solid #ddd;
}

tr:nth-child(even) {
	background-color: #ccc;
}
tr:nth-child(odd) {
	background-color: #fff;
}

tr:hover {
	background-color: #ddd;
}

td {
	text-align: center;
}

td, th {
	padding: 8px 8px;
	vertical-align: top;
	border: 1px sold blue;
	
}

td:first-child, th:first-child {
	padding-left:16px;
}
.empty-mail{
	width:100%;
}

button{
		background-color: white; 
  		color: black; 
  		border: 2px solid pink;
  		padding: 10px;
  		border-radius: 30px;
		
	}
	button:hover{
		 background-color: pink;
  		color: white;
  		padding: 10px;
	}
	
</style>
<script src="https://ajax.aspnetcdn.com/ajax/jQuery/jquery-3.3.1.min.js"></script>
<script>

$(function(){
	$("#btn-mail").click(function(){
		location.replace("<c:url value='/mail' />")
	})
	
	$(".mail_tr").click(function(){
		let id = $(this).attr("data-id")
		location.href="<c:url value='/view' />" + "?id="+id
		
	})
})

</script>

<body>
<header class="main-header"><h2>메일 리스트</h2></header>
	<section>
	<table class="mail-list">
		<tr>
			<th>NO</th>
			<th>작성일자</th>
			<th>작성시각</th>
			<th>보내는 Email</th>
			<th>받는 Email</th>
			<th>제목</th>
			<th>파일1</th>
			<th>파일2</th>
		</tr>

	
	<c:choose>
		<c:when test="${empty MAIL}">
			<tr><td colspan=8 ">mail이 없습니다</td></tr>
		</c:when>
		<c:otherwise>
			<c:forEach items="${MAIL}" var="mail" varStatus="i">
				<tr class="mail_tr" data-id="${mail.id}">
					<td>${i.count}</td>
					<td>${mail.s_date}</td>
					<td>${mail.s_time}</td>
					<td>${mail.from_email}</td>
					<td>${mail.to_email}</td>
					<td>${mail.s_subject}</td>
					<td>
						<c:if test="${mail.s_file1 != ''}" >
							<img src="<c:url value='/files/${mail.s_file1}' /> ">							
						</c:if>
					</td>
					
					<td>
						<c:if test="${mail.s_file2 != ''}" >
							<img src="<c:url value='/files/${mail.s_file2}' /> ">							
						</c:if>
					</td>
					
					</tr>
				</c:forEach>
			</c:otherwise>
		</c:choose>
	</table>
</section>
	<hr/>
	<button id="btn-mail">메일작성</button>
	

</body>
</html>