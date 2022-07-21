import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * @title CT167 Assignment 2.
 * @author Ng Yu Xiang.
 * @date 27/07/2021.
 * @purpose Client class, for getting information from file and calculate the marks and sorting of the arraylist. Finally to get the details into an output .CSV file.
 */
public class Client {
	/**
	 * Scanner used to accept inputs from user keyboard.
	 */
	private Scanner sc = new Scanner(System.in);
	/**
	 * Student arraylist that will be used to store the information.
	 */
	private ArrayList<Student> studentArray = new ArrayList<Student>();
	/**
	 * this will be use to determine whether option 10 will be allowed to output or not.
	 */
	private Boolean swap = true;
	/**
	 * Determine the type of student the user chose.
	 */
	private String whichType; 


	/**
	 * client class where information from .CSV files will be loaded into the ArrayList.
	 * <p>
	 * Get input from user when program start running using promptForType method.
	 * User to choose between C/R for research or coursework students.
	 * Will prompt user again if invalid input.
	 * <p>
	 * Once chosen it will take in the respective information from the .CSV file.
	 * and upload those information into the arraylist.
	 */
	private Client() {		
		promptForType();
		
		File inputFile = new File("students.csv");
		//try catch if file does not exist
		if(whichType.equalsIgnoreCase("C")) {
			try 	{
				//scan in the inputFile
				Scanner inputStream = new Scanner(inputFile);
			
				//while the file contains next line we do...
				while(inputStream.hasNextLine()) {
				
					String line = inputStream.nextLine();
				
					if(line.startsWith("coursework")) {
						String[] splits = line.split(",");
						String type  = splits[0];
						String title = splits[1];
						String first = splits[2];
						String last = splits[3];
						long sNumber = Long.parseLong(splits[4]);
						//int sNumber = Integer.parseInt(splits[4]);
						int day = Integer.parseInt(splits[5]);
						int month = Integer.parseInt(splits[6]);
						int year = Integer.parseInt(splits[7]);		
				
						studentArray.add(new Student(type, title, first, last, sNumber,inputDateOfBirth(day,month,year)));
					}
				}
				inputStream.close();
			
			} catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				System.out.println("File not found");
			}
		}
		else if(whichType.equalsIgnoreCase("R")) {
			try 	{
				//scan in the inputFile
				Scanner inputStream = new Scanner(inputFile);
			
				//while the file contains next line we do...
				while(inputStream.hasNextLine()) {
				
					String line = inputStream.nextLine();
				
					if(line.startsWith("research")) {
						String[] splits = line.split(",");
						String type  = splits[0];
						String title = splits[1];
						String first = splits[2];
						String last = splits[3];
						long sNumber = Long.parseLong(splits[4]);
						//int sNumber = Integer.parseInt(splits[4]);
						int day = Integer.parseInt(splits[5]);
						int month = Integer.parseInt(splits[6]);
						int year = Integer.parseInt(splits[7]);		
				
						studentArray.add(new Student(type, title, first, last, sNumber,inputDateOfBirth(day,month,year)));
					}
				}
				inputStream.close();
			
			} catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				System.out.println("File not found");
			}
		}

	}
	
	/**
	 * Method for prompting user for inputs.
	 * <p>
	 * Prompt user for R/C .
	 * once user input, the variable whichType is assigned to the user input R/C
	 * loop will end.
	 * <p>
	 * if invalid input is detected method will prompt user for input again.
	 */
	private void promptForType() {
		
		Boolean invalid = true;
		
		while(invalid) {
			
			System.out.println("Choose the Type of student(R/C):");
			whichType = sc.nextLine();
			
			if(whichType.equalsIgnoreCase("R")) {
				invalid = false;
			}
			else if(whichType.equalsIgnoreCase("C")) {
				invalid = false;
			}
			else {
				System.out.println("Invalid input. Re-enter: ");
			}
		}
		
	}
	
	/**
	 * Method to get date of birth in the format dd/mm/yyyy.
	 * <p>
	 * Get the integer input arguments, get the format in string.
	 * return the Date of Birth string .
	 * <p>
	 * @param day int day.
	 * @param month int month.
	 * @param year int year.
	 * @return dob which is a string type. "20/01/2001".
	 */
	//method to get dateOfBirth into a string format while accepting 3 integers
	private String inputDateOfBirth(int day, int month, int year) {
		
		String dob;
		dob = day + "/" + month + "/" + year;
		return dob;
	} 
	
	/**
	 * method for inputing research student marks information into the arraylist.
	 * <p>
	 * Using scanner to scan the .CSV file.
	 * Skip the first line which is the header.
	 * Using a spit by "," get the information
	 * and using the constructor to add a new ResearchStudent object into ArrayList.
	 * <p>
	 * new object will be created .
	 * All information from Research.CSV will be added into arraylist.
	 */
	private void researchTxt() {		
		int count = 0;
		File inputFile = new File("research.csv");
		//try catch if file does not exist
		try {
			//scan in the inputFile
			Scanner inputStream = new Scanner(inputFile);
			//while the file contains next line we do...
			
			while(inputStream.hasNextLine()) {
				
				if(count == 0) {
					inputStream.nextLine();
					count++;
				}
				else {
					String line = inputStream.nextLine();
					String[] splits = line.split(",");
					long RSNumber = Long.parseLong(splits[0]);
					int oral = Integer.parseInt(splits[1]);
					int thesis = Integer.parseInt(splits[2]);		
				
					studentArray.add(new ResearchStudent(RSNumber, oral, thesis, 0, null));
				}
			}
			inputStream.close();
			
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("File not found");
		}
	}
	
	
	/**
	 * method to input coursework student marks information into the arraylist.
	 * <p>
	 * Using scanner to scan the .CSV file.
	 * Skip the first line which is the header.
	 * Using a spit by "," get the information
	 * and using the constructor to add a new CourseWorkStudent object into ArrayList.
	 * <p>
	 * new object will be created.
	 * All information from coursework.CSV will be added into arraylist.
	 */
	private void courseworkTxt() {		
		int count = 0;
		File inputFile = new File("coursework.csv");
		//try catch if file does not exist
		try {
			//scan in the inputFile
			Scanner inputStream = new Scanner(inputFile);
			//while the file contains next line we do...
			while(inputStream.hasNextLine()) {
				
				if(count == 0) {
					inputStream.nextLine();
					count++;
				}
				else {
					String line = inputStream.nextLine();
					String[] splits = line.split(",");
					long cSNumber = Long.parseLong(splits[0]);
					int assignment_1 = Integer.parseInt(splits[1]);
					int assignment_2 = Integer.parseInt(splits[2]);
					int practical = Integer.parseInt(splits[3]);
					int exam = Integer.parseInt(splits[4]);
				
					studentArray.add(new CourseWorkStudent(cSNumber, assignment_1, assignment_2, practical, exam, 0 ,null));
				}
			}
			inputStream.close();
			
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("File not found");
		  }
	}
	
	
	/**
	 * Method to display the menu at main.
	 */
	private void menu() {
		System.out.println("1. Quit (exit the program)");
		System.out.println("2. Add (to the ArrayList) all the marks information for Research or Coursework student.");
		System.out.println("3. Give the Student number(ID) of the student's details(information and marks) to be removed from the arraylist.");
		System.out.println("4. Output from the ArrayList the details all students currently held in the ArrayList");
		System.out.println("5. Compute and output the overall mark and grade for coursework or research students");
		System.out.println("6. Determine and display how many coursework or research students obtained an overall mark equal to or above the average overall mark and how many obtained an overall mark below the average overall mark.");
		System.out.println("7. Given a coursework or research student number (ID), view all details of the student with that number.");
		System.out.println("8. Given a coursework or research student’s name (both surname and given name) view all details of that student.");
		System.out.println("9. Sort the ArrayList of the student objects into ascending order of the students’ numbers (IDs), and output the sorted array");
		System.out.println("10. Output the sorted ArrayList from (9) to a CSV file.\n");
	}
	
	/**
	 * Method to prompt user for their choices.
	 * <p>
	 * Prompt user for numbers 1 to 10.
	 * <p>
	 * if input if valid from user break from the loop.
	 * if not invalid, we will run the menu again and reprompt the user.
	 * <p>
	 * @return choice.
	 */
	private int prompt() {
		int choice;
		//loop for the prompt
		while(true) {
			//prompt user for input
			System.out.println("Enter your choice. (1-10)");
			choice = sc.nextInt();
			sc.nextLine();
			//if invalid input, menu method will be printed out and user will be prompt again
			if(choice > 10 || choice < 1) {
				System.out.println("Invalid input. Re-enter: ");
				menu();
			}
			//if inputs are valid loop will break
			else {
				break;
			}
		}//end of while
		return choice;
	}
	
	
	
	
	
	/** 
	 * Method for option 1. to exit program.
	 */
	private void first() {
		System.out.println("Program exited.");
		//Quit program.
		System.exit(0);
	}
	
	/**
	 * Method for option 2. to add in student marks information.
	 * <p>
	 * By validating the whichType where we get from the start of the program
	 * if whichType is R. Method researchTxt() will be called, which will add marks information on Research student
	 * if C Method courseworkTxt() will be called, which will add marks information on Coursework student.
	 * <p>
	 * once the information is added, it will then compute the overall marks and grade the students accordingly.
	 * and set the overall and grade for the respective students.
	 */
	private void second() {
		if(whichType.equalsIgnoreCase("R")) {
			researchTxt();
			
		}
		else if(whichType.equalsIgnoreCase("C")) {
			courseworkTxt();
		}
		
		for(int i = 0; i < studentArray.size(); i++) {
			if(studentArray.get(i) != null) {
				double overall = studentArray.get(i).calculateOverall();
				String grade = studentArray.get(i).gradingMark(overall);
				studentArray.get(i).setOverall(overall);
				studentArray.get(i).setGrade(grade);
			}
		}
		//say if we sort with option 9 first.. user then add in option 2... which will become unsorted.. so we need to make swap = true once this option 2 is called
		swap = true;
		System.out.println("Overall marks and Grades have been calculated for respective students.\n");
	}
	
	/**
	 * Method for option 3. where it will remove student details based on student number.
	 * <p>
	 * User will be prompted for studentnumber.
	 * if Student number exists, method will print out the student Name and Student number for confirmation
	 * and prompt user for Y/N.
	 * <p>
	 * Once user Select Y.. student details related to the student number will be removed from the Arraylist.
	 * if N is selected, then nothing will change, user will be brought to the menu selection.
	 */
	private void third() {
		
		long userInput;
		Boolean exists = false;
		int indexTracker = -1;
		int indexTracker2 = -1; 
		String confirmation = null;
		Boolean choice = false;
		
		System.out.println("Please enter the Student's student number to be removed: ");
		userInput = sc.nextLong();
		
		for(int i = 0; i < studentArray.size(); i++) {
			if(!(studentArray.get(i) instanceof ResearchStudent) && !(studentArray.get(i) instanceof CourseWorkStudent)) {
				if(studentArray.get(i).isEquals(userInput)) {
					exists = true;
					indexTracker = i;
				}
			}
			//new
			if(studentArray.get(i) instanceof ResearchStudent) {
				if(studentArray.get(i).isEquals(userInput)) {
					exists = true;
					indexTracker2 = i;
				}
			}
			//new
			if(studentArray.get(i) instanceof CourseWorkStudent) {
				if(studentArray.get(i).isEquals(userInput)) {
					exists = true;
					indexTracker2 = i;
				}
			}
		}
		
		do {
			if(exists && indexTracker != -1) {
				System.out.println("Please confirm the details of the student to be removed below.");
				System.out.println("Name: " + studentArray.get(indexTracker).getFirstName() + " " + studentArray.get(indexTracker).getLastName() + "   StudentID: " + studentArray.get(indexTracker).getStudentNumber());
				System.out.println("Enter Y to remove, N to exit.");
				confirmation = sc.next();
				
				if(confirmation.equalsIgnoreCase("Y")) {
					studentArray.remove(indexTracker);
					for(int i = 0; i < studentArray.size(); i++) {				
						
						if(studentArray.get(i) instanceof ResearchStudent) {
							if(studentArray.get(i).isEquals(userInput)) {
								studentArray.remove(studentArray.get(i));
							}
						}
						
						if(studentArray.get(i) instanceof CourseWorkStudent) {
							if(studentArray.get(i).isEquals(userInput)) {
								studentArray.remove(studentArray.get(i));
							}
						}
						
					}
					
					System.out.println("Student has been removed.\n");
					choice = false;
				}
				else if(confirmation.equalsIgnoreCase("N")) {
					System.out.println("Student not removed.\n");
					choice = false;
				}
				else{
					System.out.println("Invalid input. Re-enter.\n");
					choice = true;
				}
			}
			// added to check if student exists and remove them
			else if(exists && indexTracker2 != -1) {
				System.out.println("Please confirm the details of the student to be removed below.");
				System.out.println("Student ID: " + studentArray.get(indexTracker2).getStudentNumber());
				System.out.println("Enter Y to remove, N to exit.");
				confirmation = sc.next();
				
				if(confirmation.equalsIgnoreCase("Y")) {
					for(int i = 0; i < studentArray.size(); i++) {				
						
						if(studentArray.get(i) instanceof ResearchStudent) {
							if(studentArray.get(i).isEquals(userInput)) {
								studentArray.remove(studentArray.get(i));
							}
						}
						
						if(studentArray.get(i) instanceof CourseWorkStudent) {
							if(studentArray.get(i).isEquals(userInput)) {
								studentArray.remove(studentArray.get(i));
							}
						}
						
					}
						
					System.out.println("Student has been removed.\n");
					choice = false;
				}
				
				else if(confirmation.equalsIgnoreCase("N")) {
					System.out.println("Student not removed.\n");
					choice = false;
				}
				else{
					System.out.println("Invalid input. Re-enter.\n");
					choice = true;
				}
			}
			
			else {
				System.out.println("Student does not exist in the arraylist.\n");
				choice = false;
			}
		}while(choice);
		
	}
	
	/**
	 * Method for option 4. where we display all the object in the ArrayList.
	 */
	private void fourth() {
		
		for(int i = 0; i < studentArray.size(); i++) {
			
			studentArray.get(i).display();
		}
	}
	
	/**
	 * Method for option 5. where we print out the students overall marks and grading.
	 * <p>
	 * method will check for whether the object is instanceof research or coursework student.
	 * <p>
	 * get the student number, overall marks and grade using methods from respective class.
	 * In the case where no marks information have been uploaded prior.
	 * User will be asked to refer to menu selection option 2. 
	 */
	private void fifth() {
		int checker = 0;
		
		for(int i = 0; i < studentArray.size(); i++) {
			if(studentArray.get(i) instanceof ResearchStudent) {
				//double overall = ((ResearchStudent) studentArray.get(i)).calculateOverall();
				//String grade = studentArray.get(i).gradingMark(overall);
				System.out.println("StudentID: " + studentArray.get(i).getStudentNumber() + " Overall marks: " + studentArray.get(i).getOverall() + "   Grade: " + studentArray.get(i).getGrade());
				checker = 1;
			}
			
			if(studentArray.get(i) instanceof CourseWorkStudent) {
				//double overall = ((CourseWorkStudent) studentArray.get(i)).calculateOverall();
				//String grade = studentArray.get(i).gradingMark(overall);
				System.out.println("StudentID: " + studentArray.get(i).getStudentNumber() + " Overall marks: " + studentArray.get(i).getOverall() + "   Grade: " + studentArray.get(i).getGrade());
				checker = 1;
			}
		}
		if(checker == 0) {
			System.out.println("No information for the marks of Students! Refer to option 2.");
		}
		System.out.println("\n");
	}
	
	/**
	 * Method for option 6. where we will display how many students scored above average and how many scored below.
	 * <p>
	 * The method will first go through the arraylist to get the total number of research students or coursework student
	 * while totaling up the total marks.
	 * it will then calculate the overall average.
	 * <p>
	 * Make use of another counter, to check how many student from respective types
	 * scored above or below the overall average.
	 * Finally print out the information for the user.
	 */
	private void sixth() {
		double rAvgOverall = 0;
		double cAvgOverall = 0;
		double rTotal = 0;
		double cTotal = 0;
		int rCounter = 0;
		int cCounter = 0;
		int rCounterAbv = 0;
		int rCounterBelow = 0;
		int cCounterAbv = 0;
		int cCounterBelow = 0;
		
		//counting total
		for(int i = 0; i < studentArray.size(); i++) {
			if(studentArray.get(i) instanceof ResearchStudent) {
				rTotal += studentArray.get(i).getOverall();
				rCounter++;
			}
			if(studentArray.get(i) instanceof CourseWorkStudent) {
				cTotal += studentArray.get(i).getOverall();
				cCounter++;
			}
		}
		//get average for Research
		rAvgOverall = rTotal / rCounter;
		
		//get average for Coursework
		cAvgOverall = cTotal / cCounter;
		
		//Counting how many students got above or below.
		for(int i = 0; i < studentArray.size(); i++) {
			if(studentArray.get(i) instanceof ResearchStudent) {
				if(studentArray.get(i).getOverall() >= rAvgOverall) {
					rCounterAbv++;
				}
				else if(studentArray.get(i).getOverall() < rAvgOverall) {
					rCounterBelow++;
				}
			}
			if(studentArray.get(i) instanceof CourseWorkStudent) {
				if(studentArray.get(i).getOverall() >= cAvgOverall) {
					cCounterAbv++;
				}
				else if(studentArray.get(i).getOverall() < cAvgOverall) {
					cCounterBelow++;
				}
			}
		}
		
		if(rCounter != 0) {
			System.out.println(rCounterAbv + "  Research Students scored above the average overall score. " + rCounterBelow + "  scored below the average overall score.\n");
		}
		
		if(cCounter != 0) {
			System.out.println(cCounterAbv + "  Coursework Students scored above the average overall score. " + cCounterBelow + "  scored below the average overall score.\n");
		}
		
		if(rCounter == 0 && cCounter == 0) {
			System.out.println("No information for the marks of Students! Refer to option 2.\n");
		}
		
	}
	
	/**
	 * Method for option 7. where we display all details of the student number.
	 * <p>
	 * if student details of the student number provided by user
	 * we will display the details.
	 * <p>
	 * if does not exist we will output to user, student number not found in arraylist.
	 */
	private void seventh() {
		
		long idInput;
		int tracker = 0;
		
		System.out.println("Enter the Student's student number(ID) for their information.");
		idInput = sc.nextLong();
		
		for(int i = 0; i < studentArray.size(); i++) {
			
			if(studentArray.get(i).getStudentNumber() == idInput) {
				studentArray.get(i).display();
				tracker = 1;
			}
		}
		if(tracker == 0) {
			System.out.println("Student(ID) " + idInput + " is not found in the arraylist.\n");
		}
		
	}
	
	/**
	 * Method for option 8. where we display all details of the student name.
	 * <p>
	 * User will be prompt to enter the Student Name.
	 * <p>
	 * if student exist with the name given by user
	 * We will display the student object.
	 * We then go into the ResearchStudent and coursework object
	 * to compare the student number of the student name the user provide
	 * and display the details too.
	 * <p>
	 * if does not exist, will print a message for user stating student name not found.
	 */
	private void eighth() {
		String fName;
		String lName;
		int tracker = 0;
		
		System.out.println("Enter the Student's First name:");
		fName = sc.next();
		System.out.println("Enter the Student's Last name:");
		lName = sc.next();
		
		for(int i = 0; i < studentArray.size(); i++) {
			if(studentArray.get(i).getFirstName() != null && studentArray.get(i).getLastName() != null) {
				if(studentArray.get(i).getFirstName().equalsIgnoreCase(fName) && studentArray.get(i).getLastName().equalsIgnoreCase(lName)) {
					studentArray.get(i).display();
					tracker = 1;
					
					if(whichType.equalsIgnoreCase("R")) {
						for(int x = 0; x < studentArray.size(); x++) {
							if(studentArray.get(x) instanceof ResearchStudent) {
								if(studentArray.get(i).isEquals(studentArray.get(x).getStudentNumber())) {
									studentArray.get(x).display();
								}
							}
						}
					}
					else if(whichType.equalsIgnoreCase("C")) {
						for(int x = 0; x < studentArray.size(); x++) {
							if(studentArray.get(x) instanceof CourseWorkStudent) {
								if(studentArray.get(i).isEquals(studentArray.get(x).getStudentNumber())) {
									studentArray.get(x).display();
								}
							}
						}
					}
				}
			}
		}

		if(tracker == 0) {
			System.out.println("Student " + fName + " " + lName + " is not found in the arraylist.\n");
		}
		
	}
	
	/**
	 * Method for option 9. where we sort the arraylist.
	 * <p>
	 * Arraylist will be sorted using bubble sort algorithm.
	 * Reason for using bubble sort algorithm is that the getStudentNumber make use of polymorphism
	 * So when we use the bubble sort, when getting the student number
	 * java will return the respective student number base on what the instance of the student object
	 * from there we can compare between those student numbers as all of them are type long.
	 * Also we only need to compare two elements which is the student number a long type and sort them by ascending.
	 * In addition, it is simple and fast based on the size of the data which we will be using for this assignment, which is not that large.
	 * <p>
	 * once arraylist if sorted, swap = false
	 * which then the output of the arraylist to a .CSV file will be allowed
	 * from option 10.
	 */
	private void ninth() {
		swap = true;
		while(swap) {
			swap = false;
			
			for(int i = 1; i < studentArray.size(); i++) {
				Student first = studentArray.get(i - 1);
				Student second = studentArray.get(i);
					
				if(first.getStudentNumber() > second.getStudentNumber()) {
					studentArray.set(i - 1, second);
					studentArray.set(i, first);
					swap = true;
				}		
			}
		}	
	}
	
	/**
	 * Method for option 10. to output the arraylist to .CSV file.
	 * <p>
	 * only after running option 9. where swap = false if sorted
	 * swap = true is not sorted.
	 * <p>
	 * if not sorted user will be prompt to refer to option 9 for sorting
	 * if sorted arraylist will be output to assignment2.CSV file.
	 */
	private void tenth() {
		if(swap) {
			System.out.println("Sorry ArrayList is not sorted. Unable to output to .CSV\nPlease sort ArrayList using option 9 before proceeding to option 10.\n");
		}
		else if(swap == false) {
			File outputFile = new File("assignment2.csv");
			
			PrintWriter outputStream = null;
			try {
			
				FileOutputStream fos = new FileOutputStream(outputFile, true);
				outputStream = new PrintWriter(fos);
			
				for(int i = 0; i < studentArray.size(); i++) {
					
					if(studentArray.get(i) instanceof ResearchStudent) {
						outputStream.write("Student_ID: " + studentArray.get(i).getStudentNumber() + "," + "Oral: " + ((ResearchStudent) studentArray.get(i)).getOral() + "," + "Thesis: " + ((ResearchStudent) studentArray.get(i)).getThesis() + "," + "Overall: " + studentArray.get(i).getOverall() + "," + "Grade: " + studentArray.get(i).getGrade() + "\n");
					}	
					else if(studentArray.get(i) instanceof CourseWorkStudent) {
						outputStream.write("Student_ID: " + studentArray.get(i).getStudentNumber() + "," + "Assignment1: " + ((CourseWorkStudent) studentArray.get(i)).getAssignment_1() + "," + "Assignment2: " + ((CourseWorkStudent) studentArray.get(i)).getAssignment_2() + "," + "Practical: " + ((CourseWorkStudent) studentArray.get(i)).getPractical() + "," + "Exam: " + ((CourseWorkStudent) studentArray.get(i)).getExam() + "," + "Overall: " + studentArray.get(i).getOverall() + "," + "Grade: " + studentArray.get(i).getGrade() + "\n");
					}
					else{
						outputStream.write("Type: " + studentArray.get(i).getType() + "," + "Title: " + studentArray.get(i).getTitleOfStudent() + "," + "First_name: " + studentArray.get(i).getFirstName() + "," + "Last_name: " + studentArray.get(i).getLastName() + "," + "Student_ID: " + studentArray.get(i).getStudentNumber() + "," + "Date of Birth: " + studentArray.get(i).getDateOfBirth() + "\n");
					}
				}
				outputStream.close();
			} catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				System.out.println("File not found.");
			}
			System.out.println("ArrayList outputted to .CSV File 'Assignment2'.\n");
		}
	}

	
	/**
	 * Method to print out my student info.
	 */
	private void StudentInfo() {
		System.out.println("\nStudent Name: Ng Yu Xiang");
		System.out.println("Student No. : 34331261");
		System.out.println("Tutor Name: Mr Aaron");
		System.out.println("Mode of enrolment: PT");
		System.out.println("Tutorial attendance day: Monday | time: 1830\n");
	}
	
	
	
	/**
	 * Main
	 * @param args args
	 */
	public static void main(String[] args) {
		
		int inputs;
		Client clients = new Client();		
		clients.StudentInfo();
		
		do {
			
			clients.menu();
			inputs = clients.prompt();
			
			switch(inputs) {
				case 1:
					clients.first();
					break;
				case 2:
					clients.second();	
					break;
				case 3:
					clients.third();
					break;
				case 4:
					clients.fourth();
					break;
				case 5:
					clients.fifth();
					break;
				case 6:
					clients.sixth();
					break;
				case 7:
					clients.seventh();
					break;
				case 8:
					clients.eighth();
					break;
				case 9:
					clients.ninth();
					clients.fourth();
					System.out.println("ArrayList<Student> studentArray has been sorted. Please proceed with option 10 to print out the arraylist.\n");
					break;
				case 10:
					clients.tenth();
					break;
			}
		}while(inputs != 1);
		
	}
	
	
	
	//@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@ TEST CHECK @@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@
	
	
	/*public static void main(String[] args) {
		
		Client testclient = new Client();
		
		
		//Test 001
		//testclient.promptForType();
		//End of test 001
		
		//test 003
		//testclient.fourth();
		//End of test 003
		
		//test 004
		//change the FILE NAME in the researchTxt() method. AT line 180
		//testclient.researchTxt();
		//End of test 004
		
		//test 005
		//testclient.researchTxt();
		//testclient.fourth();
		//End of test 005
		
		//test 006
		//change the FILE NAME in the courseworkTxt() method. AT line 226
		//testclient.courseworkTxt();
		//End of test 006
		
		//test 007
		//testclient.courseworkTxt();
		//testclient.fourth();
		//End of test 007
		
		//test 008
		//populate arraylist
		//testclient.researchTxt();
		//testclient.third();
		//End of test 008
		
		//test 009
		//input R, populate arraylist
		//testclient.researchTxt();
		//testclient.third();
		//End of test 009
		
		//test 010
		//input R, populate arraylist
		//testclient.researchTxt();
		//testclient.third();
		//End of test 010
		
		//test 011
		//input R, populate arraylist
		//testclient.researchTxt();
		//testclient.fourth();
		//testclient.third();
		//testclient.fourth();
		//End of test 011
		
		//test 012
		//input R, populate arraylist
		//testclient.researchTxt();
		//testclient.third();
		//End of test 012
		
		//test 013
		//testclient.fifth();
		//End of test 013
		
		//test 014
		//testclient.second();
		//testclient.fifth();
		//End of test 014
		
		//test 015
		//testclient.sixth();
		//End of test 015
		
		
		//test 016
		//testclient.second();
		//testclient.sixth();
		//End of test 016
		
		
		//test 017
		//testclient.seventh();
		//End of test 017
		
		//test 018
		//testclient.second();
		//testclient.seventh();
		//End of test 018
		
		//test 019
		//testclient.eighth();
		//End of test 019
		
		//test 020
		//testclient.second();
		//testclient.eighth();
		//End of test 020
		
		//test 021
		//testclient.second();
		//testclient.fourth();
		//testclient.ninth();
		//testclient.fourth();
		//End of test 021
		
		//test 022
		//testclient.tenth();
		//End of test 022
		
	}*/
	
}





































