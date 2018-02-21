import java.util.Date;
import java.util.Scanner;
import java.text.DateFormat;
import java.text.ParseException;

/**
 * Demonstrates how to read a date from the keyboard and create the
 * corresponding Date object.
 * 
 * @author amit, teresa
 */
public class DateInputExample
{
	/**
	 * Read a date from a scanner and create a corresponding Date object.
	 * 
	 * @param scanner
	 *            A scanner to read the date from.
	 * @param df
	 *            A DateFormat object to parse the input date string.
	 */
	private static Date readDate(Scanner scanner, DateFormat df)
			throws ParseException
	{
		System.out.println();
		System.out.print("Enter a date in mm/dd/yy format:");
		String input = scanner.nextLine();
		System.out.println("You entered \"" + input + "\"");
		Date d = df.parse(input);
		return d;
	}

	/**
	 * Read some dates from the keyboard and use a DataFormat object to create
	 * and print Date objects.
	 * 
	 * @param args
	 */
	public static void main(String[] args) throws ParseException
	{
		DateFormat shortFormat = DateFormat.getDateInstance(DateFormat.SHORT);
		/*
		 * DateFormat mediumFormat =
		 * DateFormat.getDateInstance(DateFormat.MEDIUM);
		 */
		DateFormat longFormat = DateFormat.getDateInstance(DateFormat.LONG);

		System.out.println();
		System.out.println("Program DateInputExample starting... ");
		System.out.println();
		Scanner scanner = new Scanner(System.in);

		Date d = readDate(scanner, shortFormat);
		System.out.println(shortFormat.format(d));
		System.out.println(longFormat.format(d));

		d = readDate(scanner, shortFormat);
		System.out.println(shortFormat.format(d));
		System.out.println(longFormat.format(d));

		System.out.println();
		System.out.println("Program DateInputExample terminating...");
		System.out.println();
	}
}
