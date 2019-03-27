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
	vertical-align: top
}

td:first-child, th:first-child {
	padding-left:16px;
}

</style>
<script src="https://ajax.aspnetcdn.com/ajax/jQuery/jquery-3.3.1.min.js"></script>
<script>

$(function(){
	$("#btn-mail").click(function(){
		location.replace("<c:url value='/mail/' />")
	})
})

</script>

<body>
<header class="main-header">메일 리스트</header>
	<section>
	<table class="mail-list">
		<tr>
			<th>NO</th>
			<th>작성일자</th>
			<th>작성시각</th>
			<th>보내는 Email</th>
			<th>받는 Email</th>
			<th>제목</th>
		</tr>
	</table>
	</section>
	<c:choose>
		<c:when test="${empty MAIL}">
			<tr><td colspan=6>mail이 없습니다</td></tr>
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
						<c:if test="${not empty mail.files}" >
							<c:forEach items="${mail.files}" 
									var="file" varStatus="f">
								<img src="<c:url value='/files/${file.save_file_name}' /> ">							
							</c:forEach>						
						</c:if>
					</td>
				</tr>
			</c:forEach>
		</c:otherwise>
	</c:choose>
	<hr/>
	<button id="btn-mail">메일작성</button>
	

</body>
</html>