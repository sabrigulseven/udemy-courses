<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>account Edit</title>
</head>
<body>
	${message} <br>
	<form:form method="post" modelAttribute="account">
	<form:errors/>
	<form:hidden path="accountId"/>
		<fieldset class="form-group">
			<form:label path="accountId">Hesap Özdeşliği</form:label>
			<form:input path="accountId" type="text" disabled="true"/>
			<form:errors path="accountId"/>
			
		</fieldset >
		<fieldset class="form-group">
			<form:label path="accountName">Hesap Adı</form:label>
			<form:input path="accountName" type="text" />
			<form:errors path="accountName"/>
		</fieldset >
		<fieldset class="form-group">
			<form:label path="totalBalance">Toplam Bakiye</form:label>
			<form:input path="totalBalance" type="text" />
			<form:errors path="totalBalance"/>
			
		</fieldset>
		<button type="submit" >Sakla</button>
	</form:form>
</body>
</html>