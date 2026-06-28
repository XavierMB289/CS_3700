package main.xmb;

import java.util.Arrays;

public class XMB_m8a1 {

	public XMB_m8a1() {
		// Lists of data to use in Student Creation
		String[] courseStarts = new String[] { "CS", "MA", "ID", "EA", "SP", "OR", "TS" };
		String[] names = new String[] { "Steven", "Mary", "Joseph", "Mike", "Sully" };
		// Creating the 3 students and setting them to null
		Student[] students = new Student[3];
		Arrays.fill(students, null);
		// Actually creating the students
		for (int i = 0; i < students.length; i++) {
			// Variable set up
			String name = names[(int) Math.round(Math.random() * names.length)];
			int age = (int) (Math.random() * 100);
			String email = name + "_" + i + "@cheesy.edu.net.com.org";
			String phoneNum = "555-" + (int) (Math.random() * 10000);
			int stage = (int) (Math.random() * 10);
			String[] courses = new String[(int) (Math.random() * 6)];
			// Plug 'n chug
			for (int j = 0; j < courses.length; j++) {
				courses[j] = courseStarts[(int) (Math.random() * courseStarts.length)] + "_"
						+ (int) (Math.random() * 1000);
			}
			students[i] = new Student(name, new DateOfBirth(age), email, phoneNum, stage, courses);
			// Feel free to uncomment this \/
			// students[i].printMe();
		}
		//System.out.println(Student.getCount());
	}

	public static void main(String[] args) {
		new XMB_m8a1();
	}
}

class DateOfBirth{
	
	int age;
	
	public DateOfBirth(int age) {
		this.age = age;
	}
}

class Student {

	// Variable Declarations
	private final String name, email, phoneNum;
	private final int stage;
	private DateOfBirth age;
	private final String[] courses;
	
	//Static Counter
	static int counter;

	/**
	 * Student setup
	 */
	public Student(String name, DateOfBirth dob, String email, String phoneNum, int stage, String[] courses) {
		if (courses.length > 6)
			throw new IllegalArgumentException("No more than 6 courses allowed");
		this.name = name;
		this.age = dob;
		this.email = email;
		this.phoneNum = phoneNum;
		this.stage = stage;
		this.courses = courses;
		counter+=1;
	}

	/**
	 * Prints the student data in a readable format.
	 */
	public void printMe() {
		System.out.println("Student \"" + name + "\" Info:");
		System.out.println("Contact Info: " + email + " (" + phoneNum + ")");
		System.out.println("Age: " + age);
		System.out.println("Stage: " + stage);
		System.out.println("Courses:");
		for (String c : courses) {
			System.out.println(c);
		}
	}
	
	public static int getCount() {
		return counter;
	}
}