<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>Product Edit</title>
</head>
<body>

	<form:form method="post" modelAttribute="product">
	<form:errors/>
		<fieldset class="form-group">
			<form:label path="productId">Ürün Özdeşliği</form:label>
			<form:input path="productId" type="text" disabled="true"/>
			<form:errors path="productId"/>
			
		</fieldset >
		<fieldset class="form-group">
			<form:label path="productName">Ürün Adı</form:label>
			<form:input path="productName" type="text" />
			<form:errors path="productName"/>
		</fieldset >
		<fieldset class="form-group">
			<form:label path="salesPrice">Satış Fiyatı</form:label>
			<form:input path="salesPrice" type="text" />
			<form:errors path="salesPrice"/>
			
		</fieldset>
		<button type="submit" >Sakla</button>
	</form:form>
</body>
</html>