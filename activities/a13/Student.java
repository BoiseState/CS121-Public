/**
 * Lesson 13: Activity - Gradebook
 *
 * @author CS121 Instructors
 * @version Fall 2018
 */
public class Student {
	private String firstName;
	private String lastName;
	private int id;
	private int grade;
	
	/**
	 * Create a new student object
	 * @param firstName First name of student
	 * @param lastName Last name of student
	 * @param id Student's id number
	 */
	public Student(String firstName, String lastName, int id) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.id = id;
		this.grade = -1;
	}

	/**
	 * @return the firstName
	 */
	public String getFirstName() {
		return firstName;
	}

	/**
	 * @param firstName the firstName to set
	 */
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	/**
	 * @return the lastName
	 */
	public String getLastName() {
		return lastName;
	}

	/**
	 * @param lastName the lastName to set
	 */
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	/**
	 * @return the id
	 */
	public int getId() {
		return id;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(int id) {
		this.id = id;
	}

	/**
	 * @return the grade
	 */
	public int getGrade() {
		return grade;
	}

	/**
	 * @param grade the grade to set
	 */
	public void setGrade(int grade) {
		this.grade = grade;
	}
	
	/**
	 * Get a letter grade that represents the student's current score
	 * @return String containing the letter grade representing the student's course grade
	 */
	public String getLetterGrade() {
		
		String letterGrade;
		
		if (this.grade >= 90) {
			letterGrade = "A";
		} else if (this.grade >= 80) {
			letterGrade = "B";
		} else if (this.grade >= 70) {
			letterGrade = "C";
		} else if (this.grade >= 60) {
			letterGrade = "D";
		} else if (this.grade >= 0) {
			letterGrade = "F";
		} else {
			letterGrade = "No grades have been entered for student";
		}
		
		return letterGrade;
		
	}
	
	@Override 
	public String toString() {
		String output = "";
		
		String letter = this.getLetterGrade();
		output += this.firstName + " " + this.lastName + " has " + ((letter.equals("A")||letter.equals("F"))?"an ":"a ") + letter + ".";
		
		return output;		
	}
	

}
