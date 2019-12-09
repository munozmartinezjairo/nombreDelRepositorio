<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%><%@ taglib prefix="c"
	uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<!-- Este es el cuadro de búsqueda -->
<form action="searchServlet">
<c:out value="Buscar"/><input type="text" name="searched">
<!-- le metemos un parámetro oculto que nos indica si estamos buscando persona o empresa -->
<input type="hidden" name="type" value="${requestScope.type }"/>
<input type="submit" name="button" value="Search">
</form>
</body>
</html>