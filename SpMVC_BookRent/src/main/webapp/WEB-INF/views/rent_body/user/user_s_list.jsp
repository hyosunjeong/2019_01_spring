<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<script>
$(function(){
	$(".u_select").on("click",function(){
		let seq = $(this).attr("data-seq")
		let name = $(this).text()
		
		$("#user_name").val(name)
		$("#rent_user_seq").text(seq)
	})
})
</script>
<style>
	.u_select{
		cursor: pointer;
	}
</style>
<table>
	<tr>
		<th>회원명</th>
		<th>연락처</th>
	</tr>
	<c:choose>
		<c:when test="${empty USERS}">
			<tr><td colspan=2>회원정보 없음</td></tr>
		</c:when>
	<c:otherwise>
		<c:forEach var="user" items="${USERS}">
			<tr>
				<td class="u_select" data-seq="${user.user_seq}">${user.user_name}</td>
				<td>{user.user_phone}</td>
			</tr>
		</c:forEach>		
			
	</c:otherwise>
	</c:choose>	
</table>