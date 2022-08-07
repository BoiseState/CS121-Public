
public class EmployeeDriver {
	public static void main(String[] args) {
		//Create a new employee using each constructor
		//first, second, and third are instances of the class Employee
		// The new keyword is used to declare a new instance
		// Using the constructors and/or setters to give each attribute a value
		// Instantiates the instances.

		Employee first = new Employee();
		Employee second = new Employee("Paul Bunyan");
		Employee third = new Employee("Peter Piper", 14.50, 35);
		
		//In order to call the methods defined in the Employee class, we use
		// the dot operator.  That means the name of the instance followed by a "."
		// followed by the name of the method.
		//e.g. to call the toString method for the instance first it would be
		//     first.toString(); 
		// this method returns a String.  We could store it in a new variable as follows
		String firstToString = first.toString();
		System.out.print(firsttoString);

		//Or we can use the String returned by the toString method directly as an 
		// argument for a different method. In this case, it is used as the argument for the 	
		// print() method.
		System.out.print(second.toString());
		System.out.print(third.toString());
		
		first.setName("Little Red Riding Hood");
		first.setWage(10.25);
		first.setHoursPerWeek(15);
		
		second.setWage(22.75);
		second.setHoursPerWeek(50);
		
		third.setWage(16.00);
		
		System.out.println("**********");
		System.out.print(first.toString());
		System.out.print(second.toString());
		System.out.print(third.toString());
				

		// Reference Variables
		// This assignment makes a copy of the address where second is stored 
		// paul and second now both point to the same object.  "paul" is an alias
		// for second.  
		Employee paul = second; 

		//changing a value using "paul" changes the object itself
		System.out.println("Changing the object using an alias:");
		paul.setWage(250.00);
		System.out.println(second.toString);

		//Primitive Variables 
		// This assignment makes a copy of the value in sampleWage and stores it in newWage.
		// Changing the value of newWage does not change sampleWage;
		double sampleWage = 5.00;
		double newWage = sampleWage;

		newWage = sampleWage * 2;
		System.out.println("sampleWage = " + sampleWage + ", newWage = " + newWage);


	}
	
}
