<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<table>
		<tr>
			<th>NUMBER</th><th>TITLE</th><th>DATE</th>
		</tr>
		<c:forEach items="${boardList}" var="board">
		<tr>
			<td>${board.num}</td>
			<td>${board.title}</td>
			<td>${board.reg_date}</td>
		</tr>
		</c:forEach>
	</table>
</body>
</html>