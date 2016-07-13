<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Registration</title>
</head>
<body>
	<h1>JAX-RS @FormQuery Testing</h1>

	<form action="${pageContext.request.contextPath}/webapi/user/add" method="post">
		<p>
			Username : <input type="text" name="username" />
		</p>
		<p>
			Email Id : <input type="text" name="emailid" />
		</p>
		<p>
			Password : <input type="password" name="password" />
		</p>
		<input type="submit" value="Register" />
	</form>
</body>
</html>