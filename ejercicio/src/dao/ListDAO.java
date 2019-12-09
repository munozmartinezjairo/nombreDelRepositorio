package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import bean.CompanyBean;
import bean.PersonaBean;
import bean.UserBean;
import utils.ConnectionUtils;

public class ListDAO {
	//Estos no tienen mucha chicha. Uno saca todas las personas y otro saca todas las empresas.
	//Esto para una aplicación más grande, en vez de hacer un dao de busqueda y otro de lista, habría sido
	//mejor hacer uno de Persona y otro de Empresa, para solo tener un dao para cada uno. Aquí da un poco
	//igual porque al ser dos clases diferentes con sólo dos métodos cada una, tenemos el mismo número de clases
	public List<PersonaBean> getPersonList() {
		try {
			ConnectionUtils connectionUtils = new ConnectionUtils();
			Connection connection = connectionUtils.openConnection();
			Statement s = connection.createStatement();
			ResultSet rs = s.executeQuery("select * from person");
			List<PersonaBean> list = new ArrayList<PersonaBean>();
			while (rs.next()) {
				PersonaBean person = new PersonaBean(rs.getString("name"), rs.getString("phone_number"));
				list.add(person);
			}
			return list;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	public List<CompanyBean> getCompanyList() {
		try {
			ConnectionUtils connectionUtils = new ConnectionUtils();
			Connection connection = connectionUtils.openConnection();
			Statement s = connection.createStatement();
			ResultSet rs = s.executeQuery("select * from company");
			List<CompanyBean> list = new ArrayList<CompanyBean>();
			while (rs.next()) {
				CompanyBean company = new CompanyBean(rs.getString("company_name"), rs.getString("cif"));
				list.add(company);
			}
			return list;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
}
