package jtm.activity13;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class TeacherManager {

	protected Connection conn;

	public TeacherManager() {
		// #1 When new TeacherManager is created, create connection to the
		// database server:
		// url = "jdbc:mysql://localhost/?autoReconnect=true&useSSL=false"
		// user = "root"
		// pass = "abcd1234"
		// Hints:
		// 1. Do not pass database name into url, because some statements
		// for tests need to be executed server-wise, not just database-wise.
		// 2. Set AutoCommit to false and use conn.commit() where necessary in
		// other methods
		
		conn = null;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			String user = "root";
			String pass = "abcd1234";
			conn = DriverManager.getConnection("jdbc:mysql://localhost/?autoReconnect=true&useSSL=false",
					user, pass);
		} catch (SQLException | ClassNotFoundException e) {
			e.printStackTrace();
		}
		
	}

	public void closeConnecion() {
		// Close connection if and reset it to release connection to the
		// database server
		try {
			conn.close();
			conn = null;
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	/**
	 * Delete an existing Teacher in the repository with the values represented
	 * by the ID.
	 * 
	 * @param id
	 *            the ID of teacher.
	 * @return true if row was deleted.
	 * @throws SQLException
	 */
	public boolean deleteTeacher(int id) throws SQLException {
		boolean status = false;
		java.sql.Statement stm = conn.createStatement();
		PreparedStatement prSt = conn.prepareStatement("delete from database_activity.Teacher where id=?");
		prSt.setInt(1, id);
		int rs = prSt.executeUpdate();
		if (rs > 0)
			return true;
		return false;
	}

	/**
	 * Returns a Teacher instance represented by the specified ID.
	 * 
	 * @param id
	 *            the ID of teacher
	 * @return a Teacher object
	 * @throws SQLException
	 */
	public Teacher findTeacher(int id) throws SQLException {
		//  #2 Write an sql statement that searches teacher by ID.
		// If teacher is not found return Teacher object with zero or null in
		// its fields!
		// Hint: Because default database is not set in connection,
		// use full notation for table "database_activity.Teacher"
		String name;
		String surname;
		
		java.sql.Statement stm = conn.createStatement();
				
		ResultSet rs = stm.executeQuery("SELECT * FROM database_activity.Teacher where id=" + id);
			
		if (rs.next()){
			name = rs.getString("firstname");
			surname = rs.getString("lastname");
		} else {
			id = 0;
			name = null;
			surname = null;
		}
		
		Teacher teacher = new Teacher(id, name, surname);
		return teacher;
	}

	/**
	 * Returns a list of Teacher object that contain the specified first name
	 * and last name. This will return an empty List of no match is found.
	 * 
	 * @param firstName
	 *            the first name of teacher.
	 * @param lastName
	 *            the last name of teacher.
	 * @return a list of Teacher object.
	 */
	public List<Teacher> findTeacher(String firstName, String lastName) throws Exception {
		List<Teacher> results = new ArrayList<Teacher>();
		// #3 Write an sql statement that searches teacher by first and
		// last name and returns results as ArrayList<Teacher>.
		// Note that search results of partial match
		// in form ...like '%value%'... should be returned
		// If nothing is found, return empty list!
		
		java.sql.Statement stm = conn.createStatement();
		
		ResultSet rs = stm.executeQuery("SELECT * FROM database_activity.Teacher where firstname like '%" + firstName + "%' AND lastName like '%" + lastName + "%'");
		
		while(rs.next()) {
			Teacher tch = new Teacher(rs.getInt("id"), rs.getString("firstname"), rs.getString("lastname"));
			results.add(tch);
		}
		return results;
	}

	/**
	 * This method will attempt to insert an new teacher (first name and last
	 * name) into the repository.
	 * 
	 * @param firstName
	 *            the first name of teacher
	 * @param lastName
	 *            the last name of teacher
	 * @return true if insert, else false.
	 * @throws SQLException
	 */

	public boolean insertTeacher(String firstName, String lastName) throws SQLException {
		// #4 Write an sql statement that inserts teacher in database.
		java.sql.Statement stm = conn.createStatement();
		
		int rs = stm.executeUpdate("INSERT INTO database_activity.Teacher(firstname, lastname) VALUES ('" + firstName + "', '" + lastName + "')");
		
		if (rs > 0)
			return true;
		return false;
	}

	/**
	 * This method will attempt to insert an teacher's (id, first name and last
	 * name) into the repository.
	 * 
	 * @param id
	 *            the ID of teacher
	 * @param firstName
	 *            the first name of teacher
	 * @param lastName
	 *            the last name of teacher
	 * @return true if insert, else false.
	 * @throws SQLException
	 */
	public boolean insertTeacherAll(int id, String firstName, String lastName) throws SQLException {
		// #5 Write an sql statement that inserts teacher in database.
		java.sql.Statement stm = conn.createStatement();

		
		PreparedStatement prSt = conn.prepareStatement("INSERT IGNORE INTO database_activity.Teacher VALUES (?, ?, ?)");
		prSt.setInt(1, id);
		prSt.setString(2, firstName);
		prSt.setString(3, lastName);
		int rs = prSt.executeUpdate();
		if (rs > 0)
			return true;
		return false;
	}

	/**
	 * Updates an existing Teacher in the repository with the values represented
	 * by the Teacher object.
	 * 
	 * @param teacher
	 *            a Teacher object, which contain information for updating.
	 * @return true if row was updated.
	 * @throws SQLException
	 */
	public boolean updateTeacher(Teacher teacher) throws SQLException {
		boolean status = false;
		// #6 Write an sql statement that updates teacher information.
		java.sql.Statement stm = conn.createStatement();
		PreparedStatement prSt = conn.prepareStatement("UPDATE database_activity.Teacher SET id=?, firstname=?, lastname=? WHERE id=?");
		prSt.setInt(1, teacher.getID());
		prSt.setString(2, teacher.getFirstName());
		prSt.setString(3, teacher.getLastName());
		prSt.setInt(4, teacher.getID());
		int rs = prSt.executeUpdate();
		if (rs > 0)
			return true;
		return false;
	}
}
