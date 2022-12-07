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
	<br> Çalışan Özdeşliği: ${employee.employeeId}
	<br> Çalışan Adı: ${employee.employeeName}
	<br> Aylık Maaşı: ${employee.monthlySalary}
	<br> Çalıştığı Departman: ${employee.departmentName}

	<br>
	<a href="<c:url value="/employee/list"></c:url>">Çalışanlar</a>
</body>
</html>