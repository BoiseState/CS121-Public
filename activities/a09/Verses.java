import java.util.Scanner;

/**
 * Lesson 9: Activity - Data Comparisons and Switch Statements
 * 
 * @author CS121 Instructors
 * @author <you>
 */
public class Verses
{
	public static void main(String[] args)
	{
		Scanner scan = new Scanner(System.in);
		
		System.out.print("Which day is it (1 - 12)? ");
		int day = scan.nextInt();
		
		// TODO: Use a switch statement to set the appropriate suffix for the day
		String daySuffix = "st";
		
		System.out.println("On the " + day + daySuffix + " day of Christmas my true love gave to me");
	
		// TODO: Use a switch statement to control which lines get printed depending on the day
		System.out.println("Twelve drummers drumming,");
		System.out.println("Eleven pipers piping,");
		System.out.println("Ten lords a leaping,");
		System.out.println("Nine ladies dancing,");
		System.out.println("Eight maids a milking,");
		System.out.println("Seven swans a swimming,");
		System.out.println("Six geese a laying,");
		System.out.println("Five golden rings,");
		System.out.println("Four calling birds,");
		System.out.println("Three french hens,");
		System.out.println("Two turtle doves, and");
		System.out.println("A partridge in a pear tree.");
		
		scan.close();
	}
}
