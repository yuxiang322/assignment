/**
 * @title CT167 Assignment 2.
 * @author Ng Yu Xiang.
 * @date 27/07/2021.
 * @purpose Sub class CourseWork Student.
 */

public class CourseWorkStudent extends Student {
	/**
	 * Assignment 1 marks.
	 */
	private int assignment_1;
	/**
	 * Assignment 2 marks.
	 */
	private int assignment_2;
	/**
	 * practical marks.
	 */
	private int practical;
	/**
	 * Exam marks.
	 */
	private int exam;
	/**
	 * Coursework student number from coursework.csv.
	 */
	private long cStudentNumber;
	
	/**
	 * Constructor for courseworkstudent.
	 * <p>
	 * @param cStudentNumber long cStudentNumber.
	 * @param assignment_1 int assignment_1.
	 * @param assignment_2 int assignment_2.
	 * @param practical int practical.
	 * @param exam int exam.
	 * @param overall double overall.
	 * @param grade string grade.
	 */
	public CourseWorkStudent(long cStudentNumber, int assignment_1, int assignment_2, int practical, int exam, double overall, String grade) {
		this.cStudentNumber = cStudentNumber;
		this.assignment_1 = assignment_1;
		this.assignment_2 = assignment_2;
		this.practical = practical;
		this.exam = exam;
		this.overall = 0;
		this.grade = null;
	}
	/**
	 * Method that overrides super class and get the student number for CourseWorkStudent object.
	 * <p>
	 * @return cStudentNumber.
	 */
	public long getStudentNumber() {
		return cStudentNumber;
	}
	/**
	 * Method to get the assignment 1 marks.
	 * <p>
	 * @return assignment_1.
	 */
	public int getAssignment_1() {
		return assignment_1;
	}
	/**
	 * Method to get assignment_2 marks.
	 * <p>
	 * @return assignment_2.
	 */
	public int getAssignment_2() {
		return assignment_2;
	}
	/**
	 * Method to get practical marks.
	 * <p>
	 * @return practical.
	 */
	public int getPractical() {
		return practical;
	}
	/**
	 * Method to get exam marks.
	 * <p>
	 * @return exam.
	 */
	public int getExam() {
		return exam;
	}
	
	/**
	 * Method that overrides super class and display information of CourseWorkStudent object.
	 */
	public void display() {
		System.out.println("Coursework Student Number: " + getStudentNumber());
		System.out.println("Assignment 1 marks: " + getAssignment_1());
		System.out.println("Assignment 2 marks: " + getAssignment_2());
		System.out.println("Practical marks: " + getPractical());
		System.out.println("Exam marks: " + getExam());
		System.out.println("Overall marks: " + getOverall());
		System.out.println("Final Grade: " + getGrade() + "\n");
	}
	
	/**
	 * Method that overrides super class and calculate overall marks for CourseWorkStudent object.
	 * <p>
	 * Get the assignment 1 and 2, practical, exam marks from the object and apply some simple calculation
	 * return the Overall mark of the CourseWorkStudent object.
	 * <p>
	 * @return overallMarks which is a double type.
	 */
	public double calculateOverall() {
		double overallMarks;
		double assignment_1;
		double assignment_2;
		double practical;
		double exam;
		
		assignment_1 = getAssignment_1() * 0.25;
		assignment_2 = getAssignment_2() * 0.25;
		practical =  getPractical();
		exam = getExam() * 0.3;
		
		overallMarks = assignment_1 + assignment_2 + practical + exam; 
		
		return overallMarks;
	}
	
}
