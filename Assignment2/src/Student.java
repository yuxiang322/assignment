/**
 * @title CT167 Assignment 2.
 * @author Ng Yu Xiang.
 * @date 27/07/2021.
 * @purpose Superclass and for creating Student objects.
 */


public class Student {
	/**
	 * Student type, Research or coursework.
	 */
	private String type;
	/**
	 * Title of student, Mr or Mrs or miss.
	 */
	private String titleOfStudent;
	/**
	 * First name of student.
	 */
	private String firstName;
	/**
	 * last name of student.
	 */
	private String lastName;
	/**
	 * Student Number.
	 */
	private long studentNumber;
	/**
	 * Date of Birth.
	 */
	private String dateOfBirth;
	/**
	 * Overall marks of student.
	 */
	protected double overall;
	/**
	 * Grade of student.
	 */
	protected String grade;

	/**
	 * Default constructor.
	 */
	public Student() {
		
	}
	
	/**
	 * Student class constructor.
	 * <p>
	 * @param type String type.
	 * @param titleOfStudent String titleOfStudent.
	 * @param firstName String firstName.
	 * @param lastName String lastName.
	 * @param studentNumber long studentNumber.
	 * @param dateOfBirth String dateOfBirth.
	 */
	public Student(String type, String titleOfStudent, String firstName, String lastName, long studentNumber, String dateOfBirth) {
		this.type = type;
		this.titleOfStudent = titleOfStudent;
		this.firstName = firstName;
		this.lastName = lastName;
		this.studentNumber = studentNumber;
		this.dateOfBirth = dateOfBirth;
	}
	
	/**
	 * Method to get the Type from student object.
	 * <p>
	 * @return type.
	 */
	//getters
	public String getType() {
		return type;
	}
	/**
	 * Method to get the title from student object.
	 * <p>
	 * @return titleOfStudent.
	 */
	public String getTitleOfStudent() {
		return titleOfStudent;
	}
	/**
	 * Method to get the first name from student object.
	 * <p>
	 * @return firstName.
	 */
	public String getFirstName() {
		return firstName;
	}
	/**
	 * Method to get last name from student object.
	 * <p>
	 * @return lastName.
	 */
	public String getLastName() {
		return lastName;
	}
	/**
	 * Method to get student number from student object.
	 * <p>
	 * @return studentNumber.
	 */
	public long getStudentNumber() {
		return studentNumber;
	}
	/**
	 * Method to get date of birth from student object.
	 * <p>
	 * @return dateofBirth.
	 */
	public String getDateOfBirth() {
		return dateOfBirth;
	}
	/**
	 * Method to get overall marks from student object.
	 * <p>
	 * @return overall.
	 */
	public double getOverall() {
		return overall;
	}
	/**
	 * Method to get grade from student object.
	 * <p>
	 * @return grade.
	 */
	public String getGrade() {
		return grade;
	}
	
	//setters
	/**
	 * Method to set the overall marks for the student object in ResearchStudent or CourseworkStudent.
	 * <p>
	 * @param overall double overall. 
	 */
	public void setOverall (double overall) {
		this.overall = overall;
	}
	/**
	 * Method to set the grade for the student object in ResearchStudent or CourseworkStudent.
	 * <p>
	 * @param grade String grade.
	 */
	public void setGrade(String grade) {
		this.grade = grade;
	}
	
	//displaying
	/**
	 * Method for displaying the information of the student object.
	 */
	public void display() {
		System.out.println("Type: " + type);
		System.out.println("Title: " + titleOfStudent);
		System.out.println("First Name: " + firstName);
		System.out.println("Last Name: " + lastName);
		System.out.println("Student ID: " + studentNumber);
		System.out.println("Date Of Birth: " + dateOfBirth + "\n");
	}
	
	/**
	 * Method to check if the students object is equal or not base on the Student Number.
	 * <p>
	 * Take in an argument of long type to compare whether the student number of the current object
	 * is equals to the student object number.
	 * <p>
	 * @param id long ID.
	 * @return isEqual true if student object student number is equals to the argument id.
	 */
	//compare two students. equal method
	public boolean isEquals (long id) {
		Boolean isEqual = false;
		
		if(this.getStudentNumber() == id) {
			isEqual = true;
		}
		return isEqual;
	}
	
	/**
	 * Dummy for ResearchStudent and CourseWorkStudent class for overriding.
	 * <p>
	 * @return 0.
	 */
	public double calculateOverall() {
		return 0;
	}
	
	/**
	 * Method that will take in double overall argument, and return a Grade base on the overall marks.
	 * <p>
	 * When this method take in the argument, it will go through a few if else statement
	 * where it will then return the grade base on the marks.
	 * <p>
	 * @param overall double overall.
	 * @return grade which is a string type, consist of HD,D,C,P,N.
	 */
	public String gradingMark(double overall) {
		String grade = null;
		
		if(overall >= 80) {
			grade = "HD";
		}
		else if(overall >= 70 && overall < 80) {
			grade = "D";
		}
		else if(overall >= 60 && overall < 70) {
			grade = "C";
		}
		else if(overall >= 50 && overall < 60) {
			grade = "P";
		}
		else if(overall < 50) {
			grade = "N";
		}
		
		return grade;
	}

}
