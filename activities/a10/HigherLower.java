import java.util.Random;
import java.util.Scanner;

/**
 * Lesson 10: Activity - while Loops and Iterators 
 * 
 * @author Java Foundations
 * @author CS121 Instructors
 * @version Fall 2018
 */
public class HigherLower
{
	public static void main(String[] args)
	{
		final int MAX = 10;
		int answer;
		int guess;
		
		Scanner scan = new Scanner(System.in);
		Random random = new Random();
		
		answer = random.nextInt(MAX) + 1;
		
		System.out.print("I'm thinking of a number between 1 and " + MAX + ". ");
		System.out.print("Guess what it is: ");
		
//		guess = scan.nextInt(); //Warning! Using nextInt() will screw up your ability
					//to read anything other than ints later on!
		guess = Integer.parseInt(scan.nextLine());	//THIS is how you should read
								//a line of input when an int
								//is expected and you still want
								//to be able to read something
								//else later.
		
		if(guess == answer)
		{
			System.out.println("You got it! Good guessing!");
		}
		else
		{
			System.out.println("That is not correct, sorry.");
			System.out.println("The number was " + answer + ".");
		}
		
		System.out.println("Game over. Goodbye!");
		
		scan.close();
	}
}
