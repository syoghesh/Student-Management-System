package studentmanagementsystem;

import java.util.Scanner;

public class Student {

	public String firstName;
	public String lastName;
	public int gradeYear;
	public String studentId;
	public String courses = "";
	public double tuitionBalance = 0;
	public static double costOfCourse = 200;
	public static int id = 1000;

// Constructor: prompts user to enter student's name and year
	public Student() 
	{
		Scanner sc = new Scanner(System.in);
		System.out.print("Enter student's first name: ");
		this.firstName = sc.nextLine();

		System.out.print("Enter student's last name: ");
		this.lastName = sc.nextLine();

		System.out.print("	1 - Beginner\n	2 - Intermediate\n	3 - Advanced\n	4 - Expert\nEnter student's level: ");
		try 
		{
			this.gradeYear = sc.nextInt();
			setStudentId();
			this.enroll();
		 } 
		catch (Exception e) 
		{
			System.out.println("Invalid Entry");
		}
	}

// Generate an ID: grade level+id
	public void setStudentId() 
	{
		id = id + 1;
		this.studentId = gradeYear + "" + id;
	}

// Enroll in courses
	public void enroll() 
	{
		do {
			System.out.print("Enter course name to enroll(Q to quit): ");
			Scanner sc = new Scanner(System.in);
			String course = sc.nextLine();
			if (!course.equals("Q")) {
				courses = courses + course + ", ";
				tuitionBalance = tuitionBalance + costOfCourse;
			} else {
				break;
			}
		} while (true);
		this.payTuition();
	}

// View Balance
	public void viewBalance() 
	{
		System.out.println("Your balance is: Rs" + tuitionBalance);
	}

// Pay Tuition
     public void payTuition() 
     {
		this.viewBalance();
		System.out.print("Enter the amount you want to pay : Rs");
		Scanner in = new Scanner(System.in);
		double payment = in.nextDouble();
		tuitionBalance = payment - tuitionBalance;
		System.out.println("Thank you for your payment of Rs" + payment);
		this.viewBalance();
	 }

// Show summary
	public String toString() 
	{
		return "Summary [Name=" + firstName + " " + lastName + "; Grade Level=" + gradeYear + "; Student Id="
				+ studentId + "; Courses Enrolled= {" + courses + "}; Pending Balance=" + tuitionBalance + "]";
	}

}
