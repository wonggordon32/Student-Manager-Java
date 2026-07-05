package database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseConnection {
	
	
	
	private static final String URL =
			"jdbc:mysql://localhost:3306/student_manager";
	
	public static Connection getConnection() {

	    Connection connection = null;

	    try {
	        Class.forName("com.mysql.cj.jdbc.Driver");

	        connection = DriverManager.getConnection(
	                URL,
	                "student_app",
	                "Student123!"
	        );

	        //System.out.println("Connected!");

	    } catch (SQLException | ClassNotFoundException e) {
	        e.printStackTrace();
	    }

	    return connection;
	}
}