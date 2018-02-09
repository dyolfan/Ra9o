package jtm.activity14;

// This class is used as a definition for persistent objects
// Do not change this class

public class Student {

	private String firstName;
	private int id;
	private String lastName;

	public Student(int id, String firstName, String lastName) {

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

}
