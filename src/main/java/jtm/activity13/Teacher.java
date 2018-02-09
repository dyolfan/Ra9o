package jtm.activity13;

public class Teacher {

	private String firstName;
	private int id;
	private String lastName;

	public Teacher(int id, String firstName, String lastName) {
		this.id = id;
		this.firstName = firstName;
		this.lastName = lastName;
	}

	public String getFirstName() {
		return firstName;
	}

	public int getID() {
		return id;
	}

	public String getLastName() {
		return lastName;
	}

	@Override
	public String toString() {
		return firstName + " " + lastName;
	}
}
