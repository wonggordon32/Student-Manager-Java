package model;

import java.util.ArrayList;
import java.util.Scanner;
import dao.StudentDAO;


public class Main {

	public static void main(String[] args) {
	
	Scanner input = new Scanner(System.in);
	StudentDAO dao = new StudentDAO();
	
	while (true) {
	System.out.println("\n");
	System.out.println("==========Student Manger==========");
	System.out.println("1. Add Student");
	System.out.println("2. View All Students");
	System.out.println("3. Update Student");
	System.out.println("4. Delete Student");
	System.out.println("5. Search Student by ID");
	System.out.println("6. Exit");
	System.out.println("==================================");
	System.out.print("choice: ");
	
	int choice = input.nextInt();
	
	switch (choice) {
	
	case 1 :
		System.out.println("Adding student...");
		
		input.nextLine();
		
		System.out.println("Enter name");
		
		String name = input.nextLine();
		
		System.out.println("Enter email");
		
		String email = input.nextLine();
		
		System.out.println("Enter age");
		
		int age = input.nextInt();
	    
		input.nextLine();
		
		System.out.println("Enter program");
		
		String program = input.nextLine();
		
		Student student = new Student(
				name,
				email,
				age,
				program
				);
		
		dao.addStudent(student);
		
		
		
		
		break;
		
	case 2 :
		System.out.println("\n");
		System.out.println("Viewing students...");
		System.out.println("\n");
		
		ArrayList<Student> students = dao.getAllStudents();

		System.out.println("ID | Name | Email | Age | Program");
	    System.out.println("-----------------------------------");
		 
			for (Student s : students) {
			    
				
				System.out.println(
						s.getId() + " | "+
						s.getName() + " | " + 
				        s.getEmail() + " | " + 
						s.getAge() + " | " + 
				        s.getProgram()
						);	
						
			}
		
		break;
		
	case 3 :
		System.out.println("Updaing student...");
		
		System.out.println("Enter student ID: ");
		
		int id = input.nextInt();
		
		input.nextLine();
		
		System.out.println("Enter new name: ");
		
		String newName = input.nextLine();
		
		System.out.println("Enter new email: ");
		
		String newEmail = input.nextLine();
		
		System.out.println("Enter new age: ");
		
		int newAge = input.nextInt();
		
		input.nextLine();
		
		System.out.println("Enter new program: ");
		
		String newProgram = input.nextLine();
		
		Student updatedStudent = new Student(
				id,
				newName,
				newEmail,
				newAge,
				newProgram
				);
		
		dao.updateStudent(updatedStudent);
		
	
		break;
		
	case 4 : 
		System.out.println("Deleting student...");
		
		System.out.print("Enter student ID: ");
		
		int deleteId = input.nextInt();
		
		Student deleteStudent = new Student(
				
				deleteId,
				"",
				"",
				0,
				""
				);
		
		dao.deleteStudent(deleteStudent);
		
		
		break;
		
	case 5:
	
	    System.out.println("Enter student Id: ");
	
	    int searchId = input.nextInt();
	    
	    Student foundStudent = dao.getStudentById(searchId);
	    
	    if (foundStudent != null) {
	    	System.out.println(
	    			foundStudent.getId() + " | " +
	    	        foundStudent.getName() + " | " +
	    			foundStudent.getEmail() + " | " + 
	    			foundStudent.getAge() + " | " +
	    			foundStudent.getProgram() 
	    			);
	    	
	    }
	 else {
		
		System.out.println("Student not found. ");
		
	}
	    break;
	    
		
	case 6 :
		System.out.println("Goodbye!");
		input.close();
		return;
		
	default: 
		System.out.println("Invalid choice!");
		
		
		
		
	}
	
	
	}

	

	
	}
}



