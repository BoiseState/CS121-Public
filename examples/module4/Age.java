import java.util.Scanner;
/**
 * Demonstrates the use of an if statement.
 *
 * @author Java Foundations, marissa
 */
public class Age
{
	/**
	 * Reads the user's age and prints comments accordingly.
	 * @param args
	 */
	public static void main (String[] args)
	{
		final int MINOR = 21;

		Scanner scan = new Scanner(System.in);

		System.out.print("Enter your age: ");
		int age = scan.nextInt();

		scan.close(); // Close the scanner because we are done reading input.

		System.out.print("You are " + age + ". ");

		if(age < MINOR) {
			System.out.println("Youth is a wonderful thing. Enjoy.");
		}
		// Always printed because outside of conditional statement.
		System.out.println("It doesn't matter how old you are.");
	}
}
