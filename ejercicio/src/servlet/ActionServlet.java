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

@WebServlet("/actionServlet")
public class ActionServlet extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String url = "";
		//Miro a ver qué botón he pulsado y en función de eso redirijo a un sitio u otro
		switch (request.getParameter("action")) {
		case "searchPerson":
			url = "searchBox.jsp";
			request.setAttribute("type", "person");
			break;
		case "listPerson":
			url = "listServlet";
			request.setAttribute("type", "person");
			break;
		case "searchCompany":
			url = "searchBox.jsp";
			request.setAttribute("type", "company");
			break;
		case "listCompany":
			url = "listServlet";
			request.setAttribute("type", "company");
			break;
		}

		RequestDispatcher rd = request.getRequestDispatcher(url);
		rd.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		doGet(request, response);

	}

}
