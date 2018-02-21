import java.util.GregorianCalendar;
import java.util.Date;
import java.text.SimpleDateFormat;

/**
 * Demonstrate the use of GregorianCalendar and Date classes.
 * @author amit
 */
public class DateExample
{
	public static void main(String[] args)
	{
		// This formatter allows us to display dates in a short format. The
		// default is a longer format.
		SimpleDateFormat shortDisplay = new SimpleDateFormat( "MM/dd/yyyy");

		GregorianCalendar now = new GregorianCalendar();
		System.out.println("Today: " + now); //prints the entire calendar object!
		Date today = now.getTime();

		System.out.println();
		System.out.println("Today: " + today);
		System.out.println(shortDisplay.format(today));
		System.out.println("Today (in seconds since 1900): " + today.getTime()/1000);

		/* The GregorianCalendar constructor uses (year, month, day). Note that the month starts
		 * from 0 and goes to 11.  So the birthday below is 1st Dec, 1990.
		 */
		GregorianCalendar then = new GregorianCalendar(1990, 11, 1);
		Date birthday = then.getTime();

		System.out.println();
		System.out.println("Birthday: " + birthday);
		System.out.println(shortDisplay.format(birthday));
		System.out.println("Birthday (in seconds since 1900): " + birthday.getTime()/1000);

		long seconds = today.getTime()/1000  - birthday.getTime()/1000;
		System.out.println();
		System.out.println("Been alive for " + seconds + " seconds");
		System.out.println("Been alive for " + (double) seconds/3600 + " hours");
		System.out.println("Been alive for " + (double) seconds/(24 * 3600) + " days");
		System.out.println("Been alive for " + (double) seconds/(24 * 3600 * 365) + " years");
		System.out.println();
	}
}
