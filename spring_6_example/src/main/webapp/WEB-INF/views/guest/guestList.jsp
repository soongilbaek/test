<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<style type="text/css">
	th,td{
		text-align: center;
	}
</style>
<script type="text/javascript">
	function goHome() {
		location.href="${pageContext.request.contextPath}/";
	}
	function goWrite() {
		location.href="${pageContext.request.contextPath}/guest/guestWrite";
	}
	if('${msg}'!=""){
		alert('${msg}');		
	}
</script>
</head>
<body>
	<button onclick="goHome()">홈으로</button><button onclick="goWrite()">글쓰기</button>
	<table>
		<tr>
			<th>NUMBER</th><th>WRITER</th><th>TITLE</th><th>COUNT</th><th>DATE</th>
		</tr>
		<c:forEach items="${guestList}" var="guest">
		<tr>
			<td>${guest.num}</td>
			<td>${guest.id}</td>
			<td>${guest.title}</td>
			<td>${guest.count}</td>
			<td>${guest.reg_date}</td>
		</tr>
		</c:forEach>
	</table>
</body>
</html>