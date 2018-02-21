package inclass;

import java.util.Scanner;

/**
 * Demonstrates infinite loops. To kill the program, use CTRL-C (command line)
 * or click the red cancel button (Eclipse).
 * 
 * @author CS121 Instructors
 */
public class InfiniteLoop
{
	public static void main(String[] args)
	{
		// One with a sneaky bug. How can we fix it?
		int count = 0;
		
		while(count <= 50)
		{
			System.out.println("I'm still going...");
			count--;
		}
		
		// One that is meant to go on forever
		Scanner scan = new Scanner(System.in);
		String input = "";
		
		while(true)
		{
			System.out.println("This is the program that never ends.");
			System.out.println("Yes, it goes on and on my friends.");
			System.out.println("Some people started using it, not knowing what it does.");
			System.out.println("And they'll continue using it forever just because...");
			System.out.println("Continue (y/n)? ");
			input = scan.nextLine();
		}
	}
}
