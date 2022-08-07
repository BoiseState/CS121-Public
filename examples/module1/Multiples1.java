/** 
* Multiples1.java 
* Demonstrates basics introduced in Module 1: strings, print, println, escape sequences,
* 	concatenation, variables, constants, argument in method call, literals
* @author sfrost  
* @version Summer 2022
* 
* This is an example of a javadoc comment
*/

public class Multiples1 {
	/* Above is the class header
	 * 		"public" is the visibility modifier 
	 *  	"class" tells what kind of thing this is (a class)
	 *  	"multiples" is the name of the class.  It MUST be the same as the file name
	 *
	 * This is an example of a multi-line comment or block comment (NOT a javadoc comment)
	 */
	
	// This is a single line in-line comment.
	
	
	// Here is the main method header
	public static void main(String[] args) {
		/* You will understand each component in this method header by the end of the
		 * semester.  For now, know that every "driver" class will have a main method 
		 * with this method header.
		 */

		// declare and initialize constants
		// Remember constant names should be all caps
		// The values used to intialize these constants are literals
		final String GREETING = "Welcome to this example!";
		final int MULT = 10; 
		
		// declares and initializes variable of type int
		// remember variables are named using camelCase
		int sum = 0;
		int sumTwo = 0; //sumTwo is not used in this program.  Notice the warning message
		
		// declares but does not initialize a variable of type int
		int start;
		
		//prints GREETING to the display
		System.out.println(GREETING);

		// Note in the above command that println is a method located in the System.out
		// package.  The println method takes a parameter which it will output to the 
		// console and add a new line character.  The parameter in the above line is the 
		// string GREETING.
		
		//prints the first three multiples of 10
		// METHOD 1: hardcoded
		System.out.println("10 20 30");
		
		// METHOD 2: all on one line
		System.out.println(MULT + " " + MULT*2 + " " + MULT*3);
		
		// METHOD 3: using variables
		// declaring 3 variables of type int, no initialization
		int mult1, mult2, mult3;
		
		// initialize variables
		mult1 = MULT;
		mult2 = MULT*2;
		mult3 = MULT*3;
		System.out.print(mult1 + " ");
		System.out.print(mult2 + " ");
		System.out.print(mult3 + "\n");
		
		// METHOD 4: more variables
		// Notice the + in the print statement below is concatenation
		final String SPACER = " ";
		System.out.print(mult1 + SPACER + mult2 + SPACER + mult3 + "\n");
		
		// METHOD 5: running total
		// Here, the + is being used for addition
		sum = sum + MULT;  // the answer to sum + MULT (0 + 10) gets stored back in sum; 
		System.out.print(sum);
		
		sum = sum + MULT; // now the new value of sum is used so 10 + 10 gets stored back in sum
		System.out.print(" " + sum);
		
		sum = sum + MULT; // and now 20 + 10 gets stored back in sum
		System.out.print(" " + sum);
		
		System.out.print("\n");
		
		
		// Print a goodbye message
		// Combination of print and println statements
		System.out.println("Thank you for visiting this example!");
		System.out.print("Remember to ask questions early and often ");
		// concatenation used to help code readability
		System.out.println("- if you have a question, chances are several other "
				+ "people have the same question. ");
		System.out.println("Take one for the team and ask!"); 
		System.out.println("Happy coding!");

		/* THINGS TO TRY: 
		 *  - Change the greeting to something more your style
		 *  - Change the goodbye message (try using as many different escape sequences as you can!)
		 * 	- Separate each multiple with a tab ("\t") instead of a space
		 *  - Print the first three multiples of 2 instead of 10. 
		 *  - Print the first 5 multiples
		 *  - Print the multiples on separate lines instead of the same line 
		 *  
		 *  - Try changing the class name in the class header
		 *  - Try removing a semicolon and see what the error is when you try to run the program
		 *  - Try this on lines with different types of statements 
		 *  - Try removing a bracket, parenthesis, or quotation mark

		 *  NOTICE:
		 *  	- Which methods are easiest to modify?
		 *  	- Which methods do you find easier to read?
		 *  	- Is this the same method you would find easiest to implement?
		 */

		
	}	
}