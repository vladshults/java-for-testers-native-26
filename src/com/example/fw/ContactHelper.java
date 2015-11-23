package com.example.fw;


public class ContactHelper extends HelpersBase {

	public ContactHelper(ApplicationManager applicationManager) {
		super(applicationManager);
	}
	
	public void createContact(Contact contact) {
		initContactCreation();
		fillContactForm(contact);
		confirmContactCreation();
	}

	public void confirmContactCreation() {
		manager.getAutoItHelper()
		.click("Save")
		.winWaitAndActivate("AddressBook Portable", "", 5000);
	}

	public void fillContactForm(Contact contact) {
		manager.getAutoItHelper()
		.send("", contact.firstname)
		.send("", contact.lastname);
	}

	public void initContactCreation() {
		manager.getAutoItHelper()
		.winWaitAndActivate("AddressBook Portable", "", 5000)
		.click("Add").winWaitAndActivate("Add Contact", "", 5000);
	}

}
