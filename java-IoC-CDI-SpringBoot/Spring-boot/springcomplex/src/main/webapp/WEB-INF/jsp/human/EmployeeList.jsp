<%@ page language="java" contentType="text/html; charset=ISO-8859-9"
	pageEncoding="ISO-8859-9"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-9">
<title>Insert title here</title>
</head>
<body>
	${message}
	<br>
	<br>
	<table border="1">
		<c:forEach var="product" items="${products}">
			<tr>
				<td>${product.productId}</td>
				<td>${product.productName}</td>
				<td>${product.salesPrice}</td>
				<td><a href="<c:url value="/product/edit/${product.productId}"></c:url>">Güncelle</a></td>
				<td><a href="<c:url value="/product/delete/${product.productId}"></c:url>">Sil</a></td>
			</tr>
		</c:forEach>
	</table>
	<br>
	<a href="<c:url value="/product/edit"></c:url>">Ekle</a>
</body>
</html>