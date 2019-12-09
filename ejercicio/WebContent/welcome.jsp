<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title><c:out value="${sessionScope.user.userName }" /></title>
</head>
<body>
	<!-- Si no hay usuario en sesión, volvemos al login -->
	<c:if test="${empty sessionScope.user}">
		<jsp:forward page="index.jsp" />
	</c:if>
	<c:out
		value="Bienvenido ${sessionScope.user.userName}. ¿Qué quieres hacer?" />
	<br />

	<!-- Esto es una herramienta interesante. Si usamos links (href) en vez de botones, 
	podemos añadir parámetros a la request como hbicimos en los primeros ejemplos de jsp, 
	a cañón directamente en la url. Es buena forma de saber luego qué queremos hacer-->
	<!-- Me pasa un param diciendo que queremos buscar personas -->
	<a href="actionServlet?action=searchPerson">Buscar persona</a>
	<br />
	<!-- Me pasa un param diciendo que queremos listar personas -->
	<a href="actionServlet?action=listPerson">Ver lista de personas</a>
	<br />
	<!-- Me pasa un param diciendo que queremos buscar empresas -->
	<a href="actionServlet?action=searchCompany">Buscar empresa</a>
	<br />
	<!-- Me pasa un param diciendo que queremos listar empresas -->
	<a href="actionServlet?action=listCompany">Ver lista de empresas</a>
	<br />
	<!-- Este es el botón de cerrar sesión -->
	<form action="invalidateSessionServlet">
		<input type="submit" value="Log out" />
	</form>
</body>
</html>