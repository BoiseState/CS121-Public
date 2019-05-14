import java.util.Scanner;

/**
 * Lesson 9: Activity
 * 
 * @author CS121 Instructors
 * @version Fall 2018
 */
public class StringComparison
{
	public static void main(String[] args)
	{
		final String CODE_WORD = "peanut";
		
		// Compare constant to variable with the same value
		String myWord = "peanut";
		if(CODE_WORD == myWord)
		{
			System.out.println("Access granted!");
		}
		else
		{
			System.out.println("Access denied!");
		}
		
		// Now use scanner to read the same word from the user and compare
		Scanner scan = new Scanner(System.in);
		
		System.out.print("Enter the code word: ");
		String input = scan.nextLine();
		if(input == CODE_WORD)
		{
			System.out.println("Access granted!");
		}
		else
		{
			System.out.println("Access denied!");
		}
		scan.close();
	}
}
