<%@ page language="java" contentType="text/html; charset=ISO-8859-9"
	pageEncoding="ISO-8859-9"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-9">
<title>Employee List</title>
</head>
<body>
	${message}
	<br>
	<br>
	<form:form modelAttribute="employees" method= "post">
     <form:label path= "departmentId">Bölüm</form:label>
     <form:select path= "departmentId">
         <form:option value= "0">
                 --Tümü--
             </form:option>
         <c:forEach items= "${departments.departmentDetailList}"
             var= "department">
             <form:option value= "${department. departmentId}">
                      ${department. departmentName}
                 </form:option>
         </c:forEach>
    </form:select>
    <form:button type= "filter" >Süz</form:button>
	</form:form>	
	<table border="1">
		<c:forEach var="employee" items="${employees.employeeDetailList}">
			<tr>
				<td>${employee.employeeId}</td>
				<td>${employee.employeeName}</td>
				<td>${employee.monthlySalary}</td>
				<td>${employee.departmentId}</td>
				<td>${employee.departmentName}</td>
				<td><a href="<c:url value="/employee/edit/${employee.employeeId}"></c:url>">Güncelle</a></td>
				<td><a href="<c:url value="/employee/delete/${employee.employeeId}"></c:url>">Sil</a></td>
			</tr>
		</c:forEach>
	</table>
	<br>
	<a href="<c:url value="/employee/edit"></c:url>">Ekle</a>
</body>
</html>