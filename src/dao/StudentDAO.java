package dao;

import java.util.ArrayList;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import database.DatabaseConnection;
import model.Student;

public class StudentDAO {
	
	public void addStudent(Student student) {
	
		
		Connection connection = DatabaseConnection.getConnection();
		
		String sql = 
				"INSERT INTO students (name, email, age, program) VALUES (?, ?, ?, ?) ";
		
		try {
			
			PreparedStatement statement = connection.prepareStatement(sql);
			
			statement.setString(1, student.getName());
			statement.setString(2, student.getEmail());
			statement.setInt(3, student.getAge());
			statement.setString(4, student.getProgram());
			
			statement.executeUpdate();
			
			System.out.println("Student added successfully!");
			
			
			
		
		} catch (SQLException e) {
			e.printStackTrace();
			
		}
		
		
	}
	
	public ArrayList<Student> getAllStudents() {
		
		ArrayList<Student> students = new ArrayList<>();
		
		
		
		
		Connection connection = DatabaseConnection.getConnection();
		
		String sql = "SELECT * FROM students";
		
		
		try {
			
			PreparedStatement statement = connection.prepareStatement(sql);
			ResultSet result = statement.executeQuery();
			
			while (result.next()) {
				
				int id = result.getInt("id");
				String name = result.getString("name");
				String email = result.getString("email");
				int age = result.getInt("age");
				String program = result.getString("program");
				
				Student student = new Student(
						id,
						name,
						email,
						age,
						program
						);
				
				students.add(student);
				
				
			}
			
			
		} catch( SQLException e) {
			e.printStackTrace();
			
		}
		return students;
		
		
	}
	
	public void updateStudent(Student student) {
		
		Connection connection = DatabaseConnection.getConnection();
		
		String sql = 
				"UPDATE students SET name = ?, email = ?, age = ?, program = ? WHERE id = ?";
		
		try {
			PreparedStatement statement = connection.prepareStatement(sql);
			
			statement.setString(1, student.getName());
			statement.setString(2, student.getEmail());
			statement.setInt(3, student.getAge());
			statement.setString(4, student.getProgram());
			statement.setInt(5, student.getId());
			
			statement.executeUpdate();
			
			System.out.println("Student updated successfully!");
			
		} catch (SQLException e) {
			e.printStackTrace();
			
		}
	}
	
	public void deleteStudent(Student student) {
		
		Connection connection = DatabaseConnection.getConnection();
		
		String sql = "DELETE FROM students WHERE id = ?";
		
		try {
			PreparedStatement statement = connection.prepareStatement(sql);
			
			statement.setInt(1, student.getId());
			
			statement.executeUpdate();
			
			System.out.println("Student deleted successfully!");
			
		} catch (SQLException e) {
			e.printStackTrace();
			
			
		}
	}
	
	public Student getStudentById(int id) {
		
		Connection connection = DatabaseConnection.getConnection();
		
		String sql = "SELECT * FROM students WHERE id = ?";
				
				try {
					
					PreparedStatement statement = connection.prepareStatement(sql);
							
					statement.setInt(1, id);
					
					ResultSet result = statement.executeQuery();
					
					if(result.next()) {
						
						int studentId = result.getInt("id");
						String name = result.getString("name");
						String email = result.getString("email");
						int age = result.getInt("age");
						String program = result.getString("program");
						
						Student student = new Student(
								studentId,
								name,
								email,
								age,
								program
				);
						
						return student;
					
					}
					
				}catch (SQLException e) {
					e.printStackTrace();
					
				}
				
				return null;
				
	}

}
