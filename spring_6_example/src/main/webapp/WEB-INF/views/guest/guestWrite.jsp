<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<script type="text/javascript">
	function goList() {
		location.href="${pageContext.request.contextPath}/guest/guestList";
	}
</script>
</head>
<body>
	<h2>방명록작성하기</h2>
	<form action="write" method="post">
		<table>
			<tr>
				<th>제목</th><td><input type="text" name="title"></td>
			</tr>
			<tr>
				<th>작성자</th><td><input type="text" name="id"></td>
			</tr>
			<tr>
				<th colspan="2">내용</th>
			</tr>
			<tr><td colspan="2"><textarea rows="" cols="" name="contents"></textarea></td></tr>
		</table>
		<input type="submit" value="글작성">
	</form>
		<button onclick="goList()">목록</button>
</body>
</html>