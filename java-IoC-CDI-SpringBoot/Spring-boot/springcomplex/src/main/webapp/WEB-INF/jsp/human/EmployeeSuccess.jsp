<%@ page language="java" contentType="text/html; charset=ISO-8859-9"
	pageEncoding="ISO-8859-9"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-9">
<title>Employee Success</title>
</head>
<body>
	${message}
	<br>
	<br> �al��an �zde�li�i: ${employee.employeeId}
	<br> �al��an Ad�: ${employee.employeeName}
	<br> Ayl�k Maa��: ${employee.monthlySalary}
	<br> �al��t��� Departman: ${employee.departmentName}

	<br>
	<a href="<c:url value="/employee/list"></c:url>">�al��anlar</a>
</body>
</html>