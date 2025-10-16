<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h2>Creating Customer Account</h2>
	 <form action="${pageContext.request.contextPath}/admin/CreateCustomer" method="post">

        Full Name: <input type="text" name="name" id="name" required><br><br>

        Date of Birth: <input type="date" name="dob" id="dob" required><br><br>

        Email: <input type="email" name="email" id="email" required><br><br>

        Mobile: <input type="text" name="mobile" id="mobile" pattern="[0-9]{10}" required><br><br>

        Address: <input type="text" name="address" id="address" required><br><br>

        Status: 
        <select name="status" id="status">
            <option value="ACTIVE">Active</option>
            <option value="INACTIVE">Inactive</option>
            <option value="BLOCKED">Blocked</option>
        </select><br><br>
		Account Type: 
		<select name="accountType" id="accountType">
            <option value="Savings">Savings</option>
            <option value="Current">Current</option>
        </select><br><br>
        <input type="submit" value="Create Customer">
    </form>
    <br><br>
    Do you want to logout? <a href="${pageContext.request.contextPath}/">click here</a>
</body>
</html>