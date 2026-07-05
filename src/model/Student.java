package model;

public class Student {

	private int id;
	private String name;
	private String email;
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getProgram() {
		return program;
	}

	public void setProgram(String program) {
		this.program = program;
	}

	private int age;
	private String program;
	
	public Student(String name, String email, int age, String program) {
		this.name = name;
		this.email = email;
		this.age = age;
		this.program = program;
	}
	
	public Student(int id, String name, String email, int age, String program) {
		this.id = id;
		this.name = name;
		this.email = email;
		this.age = age;
		this.program = program;
		
	}

}
