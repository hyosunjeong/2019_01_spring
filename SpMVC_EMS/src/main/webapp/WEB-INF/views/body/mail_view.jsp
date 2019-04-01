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
.mail_box{
	border: 1px solid pink;
	border-radius: 10px;
	margin: 1 auto;
	padding: 10px;
}
</style>
<script src="https://ajax.aspnetcdn.com/ajax/jQuery/jquery-3.3.1.min.js"></script>
<script>
	$(function(){
		$("#mail_update").click(function(){
			let id = ${emsVO.id}
			location.href="<c:url value='/update' />" + "?id="+id
		})
		
		$("#mail_delete").click(function(){
			let id = ${emsVO.id}
			if(confirm("삭제할까요?")){
				location.href="<c:url value='delete'/>" + "?id="+id
			}
		})
		
	})

</script>
<body>
<header class="main-header">메일 읽기</header>
	<article id="mail_view" class="mail_box">
		<h3>제목 : ${emsVO.s_subject}</h3>
		<p>발송 Email : ${emsVO.from_email}</p>
		<p>받는 Email : ${emsVO.to_email}</p>
		<p>작성 일자 : ${emsVO.s_date}</p>
		<p>작성 시각 : ${emsVO.s_time}</p>
		<p>내용 : ${emsVO.s_content}</p>
		<p>첨부 파일 <img src="${pageContext.request.contextPath}/files/${emsVO.s_file1}">
		<img src="${pageContext.request.contextPath}/files/${emsVO.s_file2}">
		
		<div>
			<button type="button" id="mail_update">편집</button>
			<button type="button" id="mail_delete">삭제</button>
			
		</div>
	</article>
</body>
</html>