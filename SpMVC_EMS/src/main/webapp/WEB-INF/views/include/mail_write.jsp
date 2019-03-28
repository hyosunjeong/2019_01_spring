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
	.in-box{
		margin: 5px;
		width:80%;
		text-align: top;
		vertical-align: middle;
		
	}
	
	.main-box{
		text-align: center;
	
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
	$("#mail_list").click(function(){
		location.replace("<c:url value='/' />")
	})
})

</script>

<body>
<header class="main-header">메일보내기</header>

<section>
<form action="<c:url value='/mail'/>" method="POST" class="main-box">

	<input type="hidden" name="s_date" value="${MAIL.s_date }"><br/>
	<input type="hidden" name="s_time" value="${MAIL.s_time }"><br/>
	
	<label for="from_email">보내는Email</label>
		<input type="email" id="from_email" class="in-box" name="from_email" ><br/>
	<label for="to_email">받는Email</label>
		<input type="email" id="to_email" class="in-box" name="to_email"><br/>
	<label for="s_subject">메일제목</label>
		<input type="text" id="s_subject" class="in-box" name="s_subject"><br/>
	<label for="s_content">메일내용</label>
		<textarea rows="5" id="s_content" class="in-box" name="s_content"></textarea><br/>
	<label for="s_file1">첨부파일1</label>
		<input type="file" id="s_file1" class="in-box" name="s_file1"><br/>
	<label for="s_file2">첨부파일2</label>
		<input type="file" id="s_file2" class="in-box" name="s_file2">	
	<hr/>
	<button type="submit">메일보내기</button>
	<button type="reset">취소</button>
	<button type="button" id="mail_list">목록보기</button>
</form>			
</section>

</body>
</html>