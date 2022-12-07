<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>Employee Edit</title>
</head>
<body>

	<form:form method="post" modelAttribute="employee">
	<form:errors/>
	<form:hidden path="employeeId"/>
		<fieldset class="form-group">
			<form:label path="employeeId">Çalışan Özdeşliği</form:label>
			<form:input path="employeeId" type="text" disabled="true"/>
			<form:errors path="employeeId"/>
			
		</fieldset >
		<fieldset class="form-group">
			<form:label path="employeeName">Çalışan Adı</form:label>
			<form:input path="employeeName" type="text" />
			<form:errors path="employeeName"/>
		</fieldset >
		<fieldset class="form-group">
			<form:label path="monthlySalary">Aylık Maaşı</form:label>
			<form:input path="monthlySalary" type="text" />
			<form:errors path="monthlySalary"/>
			
		</fieldset>
		<button type="submit" >Sakla</button>
	</form:form>
</body>
</html>