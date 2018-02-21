import java.util.Scanner;

/**
 * Demonstrates the use of a do loop by reversing a number. Here
 * is an example of how the algorithm works.
 * 
 * number: 234
 * 
 * lastDigit = 234 % 10      = 4
 * reverse   =  (0 * 10) + 4 = 4
 * number    = 234 / 10      = 23
 * 
 * lastDigit = 23 % 10       = 3
 * reverse   = (4 * 10) + 3  = 43
 * number    = 23 / 10       = 2
 * 
 * lastDigit =   2 % 10      = 2
 * reverse   = (43 * 10) + 2 = 432
 * number    =   2 / 10      = 0 (stop)
 * 
 * (Can also watch values using Eclipse debugger)
 * 
 * @author Java Foundations
 */
public class ReverseNumber
{
	/**
	 * Reverses the digits of an integer mathematically.
	 * 
	 * @param args
	 */
	public static void main(String[] args)
	{
		int number, lastDigit, reverse = 0;

		Scanner scan = new Scanner(System.in);

		System.out.print("Enter a positive integer: ");
		number = scan.nextInt();

		do {
			lastDigit = number % 10;
			reverse = (reverse * 10) + lastDigit;
			number = number / 10;
		} while (number > 0);

		System.out.println("That number reversed is " + reverse);

		scan.close();
	}
}
