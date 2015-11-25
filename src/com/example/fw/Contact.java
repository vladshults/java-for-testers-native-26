package com.example.fw;

public class Contact {

	public String firstname;
	public String lastname;
	
	public Contact (String firstname, String lastname) {
		this.firstname = firstname;
		this.lastname = lastname;
		}
	
	public Contact() {
	}

	public String getFirstname() {
		return firstname;
	}

	public String getLastname() {
		return lastname;
	}

	public Contact setFirstName(String firstname) {
		this.firstname = firstname;
		return this;
	}
	
	public Contact setLastName(String lastname) {
		this.lastname = lastname;
		return this;
	}

}
