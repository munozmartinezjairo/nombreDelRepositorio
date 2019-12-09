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

@WebServlet("/invalidateSessionServlet")
public class InvalidateSessionServlet extends HttpServlet {
	private static final String GO_TO = "index.jsp";

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		//Este servlet simplemente cierra la sesión y devuelve al index
		HttpSession session = request.getSession(true);
		
		session.invalidate();
		
		RequestDispatcher rd = request.getRequestDispatcher(GO_TO);
		rd.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		doGet(request, response);

	}

}
