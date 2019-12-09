package bean;

public class CompanyBean {
	private String companyName;
	private String cif;
	
	public CompanyBean() {
		
	}
	
	public CompanyBean(String companyName, String cif) {
		this.companyName = companyName;
		this.cif = cif;
	}

	public String getCompanyName() {
		return companyName;
	}

	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}

	public String getCif() {
		return cif;
	}

	public void setCif(String cif) {
		this.cif = cif;
	}
	
	public String toString() {
		return "Company " + companyName + " with CIF " + cif;
	}
}
