package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import bean.CompanyBean;
import bean.PersonaBean;
import utils.ConnectionUtils;

public class SearchDAO {
	//Este tampoco tiene mucha chicha, como el de listar
	public PersonaBean getPerson(String searched) {
		try {
			ConnectionUtils connectionUtils = new ConnectionUtils();
			Connection connection = connectionUtils.openConnection();
			PreparedStatement ps = connection.prepareStatement("select phone_number from person where name = ?");
			ps.setString(1, searched);
			ResultSet rs = ps.executeQuery();
			PersonaBean person = null;
			if (rs.next()) {
				person = new PersonaBean(searched, rs.getString("phone_number"));
			}
			return person;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	public CompanyBean getCompany(String searched) {
		try {
			ConnectionUtils connectionUtils = new ConnectionUtils();
			Connection connection = connectionUtils.openConnection();
			PreparedStatement ps = connection.prepareStatement("select cif from company where company_name = ?");
			ps.setString(1, searched);
			ResultSet rs = ps.executeQuery();
			
			CompanyBean company = null;
			if (rs.next()) {
				company = new CompanyBean(searched, rs.getString("cif"));
			}
			return company;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
}
