package servlet;

import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.UserDAO;
import bean.UserBean;

@WebServlet("/loginServlet")
public class LoginServlet extends HttpServlet {
	// Constantes para no tener que usar strings metidos a cañón
	private static final String CORRECT_LOGIN = "welcome.jsp";
	private static final String INCORRECT_LOGIN = "error.jsp";

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// Instando la clase DAO
		UserDAO userDAO = new UserDAO();
		// Creo o recupero la sesión
		HttpSession session = request.getSession(true);
		// Saco los datos de la request
		String userName = request.getParameter("userName");
		String pass = request.getParameter("pass");
		// y los uso para velidar el login
		UserBean user = userDAO.checkLogin(userName, pass);
		//Asumo que el login es incorrecto
		String url = INCORRECT_LOGIN;
		//Pero si es correcto, meto el usuario en sesión y cambio la url
		if (user != null) {
			session.setAttribute("user", user);
			url = CORRECT_LOGIN;
		}
		//Y me voy a la url que corresponda
		RequestDispatcher rd = request.getRequestDispatcher(url);
		rd.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		doGet(request, response);

	}

}
