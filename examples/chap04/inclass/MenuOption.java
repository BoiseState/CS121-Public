package inclass;

import java.util.Scanner;

/**
 * Demonstrates how to use a switch-statement and a while loop with a sentinel
 * value for a basic interactive menu.
 * 
 * @author CS121 Instructors
 */
public class MenuOption
{
	public static void main(String[] args)
	{
		final String QUIT = "q";
		
		Scanner kbd = new Scanner(System.in);
		
		String input = ""; // starting condition

		while(!input.equals(QUIT)) // ending condition
		{
			System.out.println("==========================");
			System.out.println("(j) Tell a joke");
			System.out.println("(a) Print art");
			System.out.println("(m) Mathematical equation");
			System.out.println("(q) Quit") ;
			System.out.println("==========================");
			System.out.print("What do you want me to do? ");
			
			input = kbd.nextLine().toLowerCase();
			
			switch(input)
			{
			case "j":
				System.out.println("Time flies like an arrow; fruit flies like a banana.");
				break;
			case "a":
				System.out.println("**~~~*.oOo.*~~~**");
				break;
			case "m":
				System.out.println("e = mc\u00B2");
				break;
			case "q":
				System.out.println("Goodbye.");
				break;
			default:
				System.out.println("Invalid option");
				break;
			}
		}
		System.out.println("Exiting.");
		
		kbd.close();
	}

}
