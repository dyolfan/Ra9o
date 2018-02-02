package jtm.activity14;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

// TODO Implement Student manager class, similarly to TeacherManager class in activity13.

public class StudentManager {
	protected Connection conn;

	public StudentManager() {
		// TODO Initialize connection similarly to TeacherManager() in
		// activity13

	}

	/**
	 * Returns a Student instance represented by the specified ID.
	 * 
	 * @param id
	 *            the ID of student
	 * @return a Student object
	 * @throws SQLException
	 */
	public Student findStudent(int id) throws SQLException {
		// TODO implement findStudent(int id) method similarly to
		// findTeacher(int id) method in activity13
		return null;

	}

	/**
	 * Returns a list of Student object that contain the specified first name
	 * and last name. This will return an empty List of no match is found.
	 * 
	 * @param firstName
	 *            the first name of student.
	 * @param lastName
	 *            the last name of student.
	 * @return a list of Student object.
	 */
	public List<Student> findStudent(String firstName, String lastName) throws Exception {

		List<Student> results = new ArrayList<Student>();
		// TODO implement findStudent(String firstName, String lastName) method
		// similarly to findTeacher(String firstName, String lastName) method in
		// activity13
		return null;

	}

	/**
	 * This method will attempt to insert an new student (first name and last
	 * name) into the repository.
	 * 
	 * @param firstName
	 *            the first name of student
	 * @param lastName
	 *            the last name of student
	 * @return true if insert, else false.
	 * @throws SQLException
	 */

	public boolean insertStudent(String firstName, String lastName) throws SQLException {
		// TODO implement this method similarly to activity13
		return false;
	}

	/**
	 * This method will attempt to insert an student's (id, first name and last
	 * name) into the repository.
	 * 
	 * @param id
	 *            the ID of student
	 * @param firstName
	 *            the first name of student
	 * @param lastName
	 *            the last name of student
	 * @return true if insert, else false.
	 * @throws SQLException
	 */
	public boolean insertStudentAll(int id, String firstName, String lastName) throws SQLException {
		// TODO implement this method similarly to activity13
		return false;
	}

	/**
	 * Updates an existing Student in the repository with the values represented
	 * by the Student object.
	 * 
	 * @param student
	 *            a Student object, which contain information for updating.
	 * @return true if row was updated.
	 * @throws SQLException
	 */
	public boolean updateStudent(Student student) throws SQLException {
		// TODO implement this method similarly to activity13
		return false;

	}

	/**
	 * Delete an existing Student in the repository with the values represented
	 * by the ID.
	 * 
	 * @param id
	 *            the ID of student.
	 * @return true if row was deleted.
	 * @throws SQLException
	 */

	public boolean deleteStudent(int id) throws SQLException {
		// TODO implement this method similarly to activity13
		return false;
	}

}
