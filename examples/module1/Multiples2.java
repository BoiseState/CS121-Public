import java.util.Scanner;

/**
 * Multiples2.java
 * Example of Module 1 concepts with user input
 * 
 * @author sfrost
 * @version Summer 2022
 */
public class Multiples2 {
	
	// main method
	public static void main (String[] args) {
		// Declare and instantiate a new scanner to get input from the keyboard
		Scanner scnr = new Scanner(System.in);
		
		// Give the user a prompt to tell them what to enter
		System.out.print("Please enter your name: ");
		
		/*
		 *  Get their answer and use it
		 *  - Declare a variable of type String (the box that can hold a String value)
		 *  - Store the input value in that variable
		 *  - Print out a nice greeting using the value
		*/

		// This declares and instantiates using the scanner input all in one line.
		String name = scnr.next(); 
		
		// Use the input to say hi
		System.out.println("Hello " + name + "!");
		
		//Get another kind of input
		System.out.print("Please enter a number: ");
		
		// declares the variable and then instantiates it in the next line
		int num;
		num = scnr.nextInt();
		
		// Now use num to do something
		System.out.println("You entered " + num);
		System.out.println("The first three multiples of " + num + " are: " + (num*1) 
				+ " " + (num*2) + " " + (num*3));

		
		// reuse the variable num to store a new value from the user
		System.out.print("Please enter another number: ");
		num = scnr.nextInt();
		
		// You could copy and paste the code above, but here is an example of a different approach
		System.out.print("You entered " + num + "\n");
		int num1, num2, num3; // declare 3 related variables on one line.  
		// Instantiate the variables
		num1 = num;
		num2 = num*2;
		num3 = num*3;
		// declare and instantiate a string variable building up the string with concatenation
		String toPrint = num1 + " " + num2 + " " + num3;
		
		System.out.print("The first three multiples of " + num + " are: " + toPrint + "\n");
		
		// One more example
		System.out.print("Please enter a number: ");
		num = scnr.nextInt();
		toPrint = num + " " + (num+num) + " " + (num+num+num);
		System.out.print("The first three multiples of " + num + " are: " + toPrint + "\n");
		
		
		
		// Print a nice goodbye message
		System.out.println("Bye " + name + "!");
		
		
		/* THINGS TO TRY:
		 * 	- What happens if you enter a number for the name?
		 * 	- What happens if you input something other than an integer when you run the program? 
		 * 	- Take out the parenthesis in line 65 where toPrint gets a new value.  What happens?
		 */
	}
	
	
}
