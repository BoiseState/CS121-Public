import java.util.Scanner;

/**
 * Demonstrates while loop with a switch statement.
 * 
 * @author CS121 Instructors
 */
public class SwitchOptions
{
	public static void main(String[] args)
	{
		final char SENTINAL = 'Q';
		
		Scanner scan = new Scanner(System.in);
		
		int aCount = 0;
		int bCount = 0;
		int cCount = 0;
		int otherCount = 0;
		char option = 0;

		while(option != SENTINAL)
		{
			System.out.println("Enter an option (A, B, or C) (or Q to quit): ");
			
			// Read the first character of the input that they enter.
			option = scan.nextLine().trim().charAt(0);
	
			switch(option)
			{
			case 'A':
				aCount++;
				System.out.println("A Count: " + aCount);
				break;
			case 'B':
				bCount++;
				System.out.println("B Count: " + bCount);
				break;
			case 'C':
				cCount++;
				System.out.println("C Count: " + cCount);
				break;
			case 'Q':
				System.out.println("Goodbye!");
				break;
			default:
				otherCount++;
				System.out.println("Invalid option: " + otherCount);
				break;
			}
		}
		scan.close();
	}
}
