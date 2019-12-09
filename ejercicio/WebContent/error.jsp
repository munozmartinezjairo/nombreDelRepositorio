<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
</head>
<body>
<!-- Página con el mensaje de error si nos logeamos mal -->
	<c:out value="Credenciales incorrectas" />
	<jsp:include page="index.jsp"/>
</body>
</html>