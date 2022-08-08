

import java.util.ArrayList;
import java.util.Scanner;

/**
 * Collects numbers in an ArrayList in a while loop until user quits.
 * Uses indexed and for-each loops to access ArrayList elements.
 * Converts between primitive doubles and wrapper class Double references
 * via "auto-boxing" and "auto-unboxing".
 * 
 * @author mvail
 */
public class ArrayListInputDemo {

	/** @param args unused */
	public static void main(String[] args) {
		//This ArrayList is configured to hold references
		// of type Double - the wrapper class for the 
		// primitive double data type.
		//We need to use a wrapper class because Java
		// collections can only hold object references,
		// not primitive values.
		//Java will automatically convert back and forth
		// between a primitive type and its wrapper type
		// via processes called "auto-boxing" and
		// "auto-unboxing", so you don't need to do anything
		// to make this work.
		ArrayList<Double> list = new ArrayList<Double>();
		
		//continue to prompt the user for numbers until
		// they enter a "Q" or "q" to quit
		Scanner kbd = new Scanner(System.in);
		String input = "";		
		while (!input.toUpperCase().equals("Q")) { //while not "Q"
			System.out.print("Enter a number (or 'Q' to quit): ");
			
			if (kbd.hasNextDouble()) { //if it's a number
				list.add(kbd.nextDouble()); //add to list
			} else { //check for "q" or "Q"
				input = kbd.next();
				if (!input.toUpperCase().equals("Q")) {
					System.out.println("Invalid input.");
				}
			}
		}		
		kbd.close();
		
		//display all numbers in the list, using indexes
		// to access each value
		System.out.println("Numbers in the list:");
		for (int index = 0; index < list.size(); index++) {
			System.out.println(list.get(index));
		}
		
		//calculate the sum, using a for-each loop to
		// access each value in turn
		System.out.println("Sum of the numbers in the list:");
		double sum = 0;
		for (Double d : list) {
			sum += d;
		}
		System.out.println(sum);
	}

}
