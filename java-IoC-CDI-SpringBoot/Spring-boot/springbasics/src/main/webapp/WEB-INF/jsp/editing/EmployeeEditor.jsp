<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>Insert title here</title>
</head>
<body>
	<form:form method="post" modelAttribute="employee">
		<fieldset class="form-group">
			<form:label path="employeeId">Çalışan Özdeşliği</form:label>
			<form:input path="employeeId" type="text" disabled="true"/>
		</fieldset >
		<fieldset class="form-group">
			<form:label path="employeeName">Çalışan Adı</form:label>
			<form:input path="employeeName" type="text" />
		</fieldset >
		<fieldset class="form-group">
			<form:label path="monthlySalary">Aylık Maaş</form:label>
			<form:input path="monthlySalary" type="text" />
		</fieldset>
		<button type="submit" >Sakla</button>
	</form:form>
</body>
</html>