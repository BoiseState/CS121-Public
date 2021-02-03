import java.util.Scanner;
import java.text.DecimalFormat;

/**
 * Demonstrates the formatting of decimal values using the DecimalFormat class.
 *
 * @author Java Foundations, amit
 */
public class CircleStatsDecimalFormat
{
	/**
	 * Calculates the area and circumference of a circle given its
	 * radius.
	 */
	public static void main(String[] args)
	{
		int radius;
		double area, circumference;

		Scanner scan = new Scanner(System.in);

		System.out.print("Enter the circle's radius: ");
		radius = scan.nextInt();

		area = Math.PI * Math.pow(radius, 2);
		circumference = 2 * Math.PI * radius;

		// Round the output to three decimal places
		DecimalFormat fmt = new DecimalFormat("0.00");

		System.out.println("The circle's area: " + fmt.format(area));
		System.out.println("The circle's circumference: " + fmt.format(circumference));

		scan.close();
	}
}
