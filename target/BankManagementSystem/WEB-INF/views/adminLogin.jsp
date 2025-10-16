<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h2>Hello Admin</h2>
	<form action="${pageContext.request.contextPath}/admin/AdminLogin" method="post">
		Username: <input type="text" name="username" id="username"><br><br>
		Password: <input type="text" name="password" id="password"><br><br>
		<input type="submit" value="Submit">
	</form>
</body>
</html>