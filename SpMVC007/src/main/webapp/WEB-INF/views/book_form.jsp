<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta name="viewprot" content="width=divice-width, initial-scale=1">
<meta charset="UTF-8">
<title>Insert title here</title>

<style>
	
	#book_field{
		width:500px;
		margin: 10px auto;    /* 10px는 top부분*/
	}
	
	legend{
		font-size: 12pt;
		font-weight: bold;
		color : #3e65ff;
	}
	
	label{
/* width가 작동이 되려면 반드시 display가 block로 되어야한다.*/
		width:120px;
		display: block;
		float : left; /* 왼쪽 정렬 한다.*/
		text-align: right;
		font-weight: bold;
		font-size: 10pt;
		padding : 8px;	
	}
	
	input{
		margin : 3px;
		padding : 8px;
		border : 1px solid #ccc;
	}

	#btn-box{
		border : 1px solid lightgray;
		width : 103px;
		margin : 5px auto;
	}
	#btn-box button{
		width : 100px;
		margin : 3px;
	}	
	
	/* button을 label로 바꿔줬기 때문에 #but-box와 #btn-box button 은 무력화된다. */
	
	
	#btn-ok{
		width :100px;
		margin : 3px;
		padding : 5px;
	
	}


</style>

</head>
<body>
	<form action="book" method="POST">
		<!--  legend는 fieldset이 없으면 사용할 수 없다. 항상 따라다님 -->
		<fieldset id = "book_field">
		<legend>도서정보입력</legend>
		<label for="b_title">도서명</label>
		<input id="b_title" name="b_title"><br />
		
		<label for="b_comp">출판사명</label>
		<input id="b_comp" name = "b_comp"><br />
		
		<label for="b_auth">저자명</label>
		<input id="b_auth" name = "b_auth"><br />
		
		<label for="b_price">가격</label>
		<input id="b_price" name = "b_price"><br />

		<label for="btn-ok"></label>
		<button id="btn-ok">확인</button>
		</fieldset>

	</form>
</body>
</html>