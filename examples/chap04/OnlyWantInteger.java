import java.util.Scanner;

/**
 * Demonstrates an input validation loop that only accepts an int as input.
 * 
 * @author mvail
 */
public class OnlyWantInteger {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		boolean gotAnInteger = false;
		int theInt = 0;
		
		do {
			System.out.println("Please enter an integer:");
			
			if (scan.hasNextInt()) {
				//ensure newlines aren't stacking up in the Scanner by using nextLine()
				theInt = Integer.parseInt(scan.nextLine());
				gotAnInteger = true;
			} else {
				System.out.println("Um... no.");	
				//remove the offending token from the Scanner
				String garbage = scan.nextLine(); 
				System.out.println("\"" + garbage + "\" is not an integer. Try again.");
			}
			
		} while (gotAnInteger == false);
		
		System.out.println("Good job. You entered integer " + theInt + ".");
		
		scan.close();
	}

}
