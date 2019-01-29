<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
/*
	core tag lib를 import하고 /controller/book_list.jsp로 redirect하는 코드 작성

	순수하게 redirect만 수행할 때는 HTML과 관련된 코드가 없어도 된다. 	
*/

%>

<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<c:redirect url="/controller/book_list.jsp"></c:redirect>
