<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h2>Reset Password</h2>
<form action="${pageContext.request.contextPath}/customer/resettingpassword" method="post">
	Old password: <input type="password" name="oldpassword" id="oldpassword"><br>
	New password: <input type="password" name="newpassword" id="newpassword"><br>
	Confirm password: <input type="text" name="confirmpassword" id="confirmpassword"><br>
	<input type="submit" value="Submit">
</form>
</body>
</html>