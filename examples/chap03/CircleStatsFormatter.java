import java.util.Scanner;
import java.util.Formatter;
/**
 * Demonstrates the formatting of decimal values using various formatters.
 *
 * @author Java Foundations, amit
 */
public class CircleStatsFormatter
{
   	/**
	 * Calculates the area and circumference of a circle given its radius.
	 */
   	public static void main(String[] args)
   	{
		Scanner scan = new Scanner(System.in);

		System.out.print("Enter the circle's radius: ");
		int radius = scan.nextInt();

		double area = Math.PI * Math.pow(radius, 2);
		double circumference = 2 * Math.PI * radius;

		// Round the output to three decimal places
		Formatter fmt = new Formatter(System.out);

		System.out.println("The circle's area: " + area);
		System.out.println("The circle's circumference: " + circumference);

		System.out.println( "\nUsing printf\n");
		System.out.printf( "The circle's area:          %7.3f\n", area);
		System.out.printf( "The circle's circumference: %7.3f\n", circumference);

		System.out.println( "\nUsing Formatter object\n");
		fmt.format( "The circle's area:          %7.3f\n", area);
		fmt.format( "The circle's circumference: %7.3f\n", circumference);

		System.out.println("\nUsing String.format\n");
		String areaString = String.format("The circle's area:          %7.2f", area);
		String circumferenceString = String.format("The circle's circumference: %7.2f", circumference);
		System.out.println(areaString);
		System.out.println(circumferenceString);

		System.out.println("\nUsing one format string for two variables\n");
		String complete = String.format("The circle's area: %7.4f\nThe circle's circumference: %7.3f",
										area, circumference);
		System.out.println(complete);

		fmt.close();
		scan.close();
   	}
}
