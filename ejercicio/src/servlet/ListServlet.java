package servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.ListDAO;

@WebServlet("/listServlet")
public class ListServlet extends HttpServlet {

	private static final String GO_TO = "list.jsp"; 
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		//Instancio listDAO
		ListDAO listDAO = new ListDAO();
		//Declaro una lista
		List list;
		//Y la inicializo en función de lo que quiero buscar
		if (request.getAttribute("type").equals("person")) {
			list = listDAO.getPersonList();
		} else {
			list = listDAO.getCompanyList();
		}
		//La meto en request y nos vamos al jsp que la enseña
		request.setAttribute("list", list);
		RequestDispatcher rd = request.getRequestDispatcher(GO_TO);
		rd.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		doGet(request, response);

	}

}
