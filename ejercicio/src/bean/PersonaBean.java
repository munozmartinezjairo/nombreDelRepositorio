package bean;

public class PersonaBean {
	private String name;
	private String phoneNumber;
	
	public PersonaBean() {
		
	}
	
	public PersonaBean(String name, String phoneNumber) {
		this.name = name;
		this.phoneNumber = phoneNumber;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}
	
	public String toString() {
		return "Contact " + name + " with phone number " + phoneNumber;
	}
	
}
