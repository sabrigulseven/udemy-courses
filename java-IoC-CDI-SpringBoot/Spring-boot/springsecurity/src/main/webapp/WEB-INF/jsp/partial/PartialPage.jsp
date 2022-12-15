<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ taglib prefix="security" uri="http://www.springframework.org/security/tags"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>Welcome Page</title>
</head>
<body>
<h1>Partial Page</h1>
	High Security
<security:authorize access="hasRole('ADMIN')">
<h2>Yönetici Erişebilir</h2>
</security:authorize>

<security:authorize access="hasRole('USER')">
<h2>Kullanıcı Erişebilir</h2>
</security:authorize>
</body>
</html>