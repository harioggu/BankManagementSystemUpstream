<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h2>Enter your OTP here</h2>
	<form action="${pageContext.request.contextPath}/customer/CustomerOtpValidate" method="post">
		Enter your otp: <input type="text" name="otp" id="otp">
		<input type="submit" value="Submit">
	</form>
</body>
</html>