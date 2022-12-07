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
	<br> Ürün Özdeşliği: ${product.productId}
	<br> Ürün Adı: ${product.productName}
	<br> Satış Fiyatı: ${product.salesPrice}
	<br>

	<br>
	<a href="<c:url value="/product/list"></c:url>">Ürün Listesi</a>
</body>
</html>