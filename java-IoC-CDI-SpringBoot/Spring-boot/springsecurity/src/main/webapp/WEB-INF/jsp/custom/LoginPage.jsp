<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>Home Page</title>
</head>
<body>
	<h1>Login Page</h1>
	İleti : ${message}
	<form name="login" action="/login" method="POST">
		<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}" /> 
		Kullanıcı : <input type="text" name="username" value=""/> <br /> 
		Parola :    <input type="password" name="password"/> <br /> 
		<input type="submit" value="Gir"/>
	</form>
</body>
</html>