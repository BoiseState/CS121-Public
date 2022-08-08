import java.util.Scanner;

/**
 * Demonstrate the use of enum with switch statements.
 * @author amit
 *
 */
public class SwitchDays
{
	/**
	 * @param args
	 */
	public static void main(String[] args)
	{
		//display menu based on the enum Day
		System.out.print("Tell me about my day! \n");
		for (Day d : Day.values()) {
			System.out.print(d + "\n");
		}
		System.out.print("\nEnter choice: ");
		
		// get integer input from user
		Scanner keyboard = new Scanner(System.in);
		String menuChoice = keyboard.nextLine().trim();
		
		// convert integer input to an enum value
		// This doesn't handle an invalid choice!
		String choiceUpper = menuChoice.toUpperCase();
		Day day = Day.valueOf(choiceUpper); 
		
		//System.out.println("\nYou chose " + day + "\n");
		switch (day) {
		case SUNDAY:
			System.out.println("Sunday is a day for eating a Sundae");
			break;
		case MONDAY:
			System.out.println("Monday is a day of Mourning :-)");
			break;
		case TUESDAY:
			System.out.println("Tuesday is the day to dig a hole!");
			break;
		case WEDNESDAY:
			System.out.println("Wednesday is a day for a long lunch...");
			break;
		case THURSDAY:
			System.out.println("Thursday is a day to fill the hole with lots of dirt");
			break;
		case FRIDAY:
			System.out.println("Friday is a day to day dream...");
			break;
		case SATURDAY:
			System.out.println("Saturday is the day to party!");
			break;
		}
		
		keyboard.close();
	}
}
