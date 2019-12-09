<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%><%@ taglib prefix="c"
	uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
<body>
	<c:if test="${empty sessionScope.user}">
		<jsp:forward page="index.jsp" />
	</c:if>
	<!-- Muestra el resultado de la búsqueda -->
	<c:out value="${requestScope.result}"/>
	<form action="invalidateSessionServlet">
		<input type="submit" value="Log out" />
	</form>
</body>
</html>