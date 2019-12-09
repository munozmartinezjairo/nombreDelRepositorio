<%@ page language="java" contentType="text/html; UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<!-- Los estilos se los copié a Gely, por eso es la única página que tiene. Gracias, Gely! :) 
A parte de eso poco msiterio, es el login, sin más -->
<body bgcolor="aquamarine">
	<div align="center">
		<h1 style="color: DodgerBlue;">LOGIN</h1>
		<br /> <br />
		<form action="loginServlet" method="post">
			<div align="center">
				Usuario: <input type="text" name="userName" /><br /> <br />
				Password: <input type="password" name="pass" /><br /> <br /> <input
					type="submit" name="boton" value="Iniciar Sesión" />
			</div>
		</form>
	</div>
</body>
</html>