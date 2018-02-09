package jtm.extra04;

public class Student {
	private String firstName;
	private int ID;
	private String lastName;
	private int phoneNumber;

	public Student() {
	};

	public Student(int ID, String firstName, String lastName, int phoneNumber) {
		// TODO #1 Create new student, assign him ID, first name, last name and
		// phone number from passed values
		this.ID = ID;
		this.firstName = firstName;
		this.lastName = lastName;
		this.phoneNumber = phoneNumber;
	}

	public String getFirstName() {
		return firstName;
	}

	public int getID() {
		return ID;
	}

	public String getLastName() {
		return lastName;
	}

	public int getPhoneNumber() {
		return phoneNumber;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public void setID(int iD) {
		ID = iD;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public void setPhoneNumber(int phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

}
