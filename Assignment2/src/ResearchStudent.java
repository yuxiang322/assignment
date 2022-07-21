/**
 * @title CT167 Assignment 2.
 * @author Ng Yu Xiang.
 * @date 27/07/2021.
 * @purpose Sub class Research Student.
 */

public class ResearchStudent extends Student {
	
	/**
	 * Research student number from research.csv.
	 */
	private long rStudentNumber;
	/**
	 * Oral marks.
	 */
	private int oral;
	/**
	 * thesis marks.
	 */
	private int thesis;
	
	
	/**
	 * Constructor for ResearchStudent Class.
	 * <p>
	 * @param rStudentNumber long rStudentNumber.
	 * @param oral int oral.
	 * @param thesis int thesis.
	 * @param overall double overall.
	 * @param grade string grade.
	 */
	public ResearchStudent(long rStudentNumber, int oral, int thesis, double overall, String grade) {
		this.rStudentNumber = rStudentNumber;
		this.oral = oral;
		this.thesis = thesis;
		this.overall = 0;
		this.grade = null;
	}
	
	/**
	 * Method that override the getStudentNumber method in the super class. 
	 * <p>
	 * @return rStudentNumber.
	 */
	public long getStudentNumber() {
		return rStudentNumber;
	}
	/**
	 * Method to get Oral from the ResearchStudent object.
	 * <p>
	 * @return oral.
	 */
	public int getOral() {
		return oral;
	}
	/**
	 * Method to get thesis from the ResearchStudent object.
	 * <p>
	 * @return thesis.
	 */
	public int getThesis() {
		return thesis;
	}

	
	/**
	 * Method that overrides super class and display the information of the ResearchStudent object.
	 */
	public void display() {

		System.out.println("Research student Number: " + getStudentNumber());
		System.out.println("Oral marks: " + getOral());
		System.out.println("Thesis: " + getThesis());
		System.out.println("Overall marks: " + getOverall());
		System.out.println("Final Grade: " + getGrade() + "\n");
	}
	
	/**
	 * Method that overrides super class where it will calculate the overall marks.
	 * <p>
	 * Get the oral and thesis marks from the object and apply some simple calculation
	 * return the Overall mark of the Research object.
	 * <p>
	 * @return overallMark which is a double type.
	 */
	public double calculateOverall() {
		double overallMark;
		double oralMark;
		double thesisMark;
	
		oralMark = this.getOral();
		
		thesisMark = this.getThesis() * 0.8; 
		
		overallMark = oralMark + thesisMark;
		
		
		return overallMark;
	}
	   
}
