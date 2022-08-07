/**
 * Employee.java creates an Employee object used by EmployeeDriver.java
 * 
 * @author sfrost
 *
 */
public class Employee {
	// Instance Variables - These define the attributes of the object
	// Remember to make instance variables private - this enforces Encapsulation
	private String name;
	private double hoursPerWeek;
	private double wage;
	private double weeklyPay;
	
	// Overloaded constructors
	public Employee(){
		// This creates a new employee with default values for the attributes
		this.name = "";
		this.hoursPerWeek = 0;
		this.wage = 0;
		this.weeklyPay = this.hoursPerWeek * this.wage;
	}

	public Employee(String name) {
		// This constructor creates a new employee with a given name
		this.name = name;
		this.hoursPerWeek = 0;
		this.wage = 0;
		this.weeklyPay = this.hoursPerWeek * this.wage;
	}
	
	public Employee(String name, double wage, double hoursPerWeek) {
		this.name = name;
		this.hoursPerWeek = hoursPerWeek;
		this.wage = wage;
		this.weeklyPay = this.hoursPerWeek * this.wage;
		
	}
	
	// Methods
	// Define getters and setters for each attribute
	
	// Getters
	public String getName() {
		return this.name;
	}
	
	public double getHoursPerWeek() {
		return this.hoursPerWeek;
	}
	
	public double getWage() {
		return this.wage;
	}

	public double getWeeklyPay() {
		return this.weeklyPay;
	}

	// Setters
	public void setName(String name) {
		this.name = name;
	}

	public void setHoursPerWeek(double hoursPerWeek) {
		this.hoursPerWeek = hoursPerWeek;
		// need to recalculate weeklyPay as well
		this.weeklyPay = this.hoursPerWeek * this.wage;
	}

	public void setWage(double wage) {
		this.wage = wage;
		// need to recalculate weeklyPay
		this.weeklyPay = this.hoursPerWeek * this.wage;		
	}

	// NOTICE there is no setter for weeklyPay because this value
	// should be determined by the other values. 
	
	//the toString function allows you to print the status of the
	// object in a meaningful way.
	public String toString() {
		String toReturn;
		toReturn = "Name: " + this.name 
				+ "\n  Wage: " + this.wage 
				+ "\n  HoursPerWeek: " + this.hoursPerWeek 
				+ "\n  WeeklyPay: " + this.weeklyPay
				+ "\n";
		
		return toReturn;
	}
	
	/* TO TRY:
	 * 	Can you improve the toString function by adding appropriate
	 * formatting for the wage and weekly pay?
	 * 
	 *  What other attributes would be useful for the employee object?
	 *  Could you add a Bonus attribute that would be added to the 
	 * weekly pay?
	 */
}
