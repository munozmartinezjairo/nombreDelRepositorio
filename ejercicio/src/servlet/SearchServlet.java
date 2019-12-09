package servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.SearchDAO;

@WebServlet("/searchServlet")
public class SearchServlet extends HttpServlet {
	//Declaro una constante para no tener luego que meter un string a ca��n
	private static final String GO_TO = "searchResult.jsp";

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		//Instance SearchDAO para poder lanzar una b�squeda contra la BBDD
		SearchDAO searchDAO = new SearchDAO();
		//Declaro un objeto gen�rico porque no s� si voy a buscar personas o empresas
		Object result;
		//Recupero la b�squeda de sesi�n
		String searched = request.getParameter("searched");
		//Chequeo si estoy buscando personas o empresas
		if (request.getParameter("type").equals("person")) {
			result = searchDAO.getPerson(searched);
		} else {
			result = searchDAO.getCompany(searched);
		}
		//Guardo el resultado en request y me voy a la p�gina de resultados
		request.setAttribute("result", result);
		RequestDispatcher rd = request.getRequestDispatcher(GO_TO);
		rd.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		doGet(request, response);

	}

}
