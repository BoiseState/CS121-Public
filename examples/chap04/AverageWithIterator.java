import java.text.DecimalFormat;
import java.util.Scanner;

/**
 * Demonstrates the use of the Scanner as an iterator.
 * @author Java Foundations
 * @author CS121 Instructors
 */
public class AverageWithIterator
{
	/**
	* Computes the average of a set of values entered by the user.
	* The running sum is printed as the numbers are entered.
	* @param args
	*/
	public static void main (String[] args)
	{
		int sum = 0, value, count = 0;
		double average;

		Scanner scan = new Scanner(System.in);

		System.out.print("Enter the integers you want to average " +
							"(anything else to quit): ");
		while(scan.hasNextInt())
		{
			count++;
			sum += scan.nextInt();
			System.out.println("The sum so far is " + sum);
		}

		scan.close();

		System.out.println();

		if(count == 0)
		{
			System.out.println ("No values were entered.");
		}
		else
		{
			average = (double) sum / count;

			DecimalFormat fmt = new DecimalFormat("0.###");
			System.out.println("The average is " + fmt.format(average));
		}
	}
}
