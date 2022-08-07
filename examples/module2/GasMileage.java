import java.util.Scanner;

/**
 * Demonstrates the use of the Scanner class to read numeric data.
 *
 * @author Java Foundations, CS121 Instructors
 */
public class GasMileage
{
	/**
	 * Calculates fuel efficiency based on values entered by the user.
	 */
	public static void main(String[] args)
	{
		// data types, declaring multiple variables of same type on one line
		int miles;
		double gallons, mpg;

		Scanner scan = new Scanner(System.in);

		// Instantiate "miles" with the user input interpreted as an int
		System.out.print("Enter the number of miles: ");
		miles = scan.nextInt();

		// Instantiate "gallons" with user input interpreted as a double
		System.out.print("Enter the gallons of fuel used: ");
		gallons = scan.nextDouble();

		// Instantiate "mpg" as the result of the expression
		mpg = miles / gallons;

		System.out.println("Miles Per Gallon: " + mpg);

		scan.close();
	}
}
