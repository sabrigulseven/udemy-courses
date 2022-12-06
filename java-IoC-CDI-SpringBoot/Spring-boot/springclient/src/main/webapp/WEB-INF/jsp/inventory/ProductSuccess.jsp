<%@ page language="java" contentType="text/html; charset=ISO-8859-9"
	pageEncoding="ISO-8859-9"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-9">
<title>Product Success</title>
</head>
<body>
	${message}
	<br>
	<br> �r�n �zde�li�i: ${product.productId}
	<br> �r�n Ad�: ${product.productName}
	<br> Sat�� Fiyat�: ${product.salesPrice}
	<br>

	<br>
	<a href="<c:url value="/product/list"></c:url>">�r�n Listesi</a>
</body>
</html>