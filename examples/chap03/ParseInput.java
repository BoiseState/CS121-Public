import java.util.Scanner;
/**
 * Demonstrates how to parse integer and double from String.
 * @author CS121 Instructors
 */
public class ParseInput
{
	public static void main(String[] args)
	{
		Scanner kbd = new Scanner(System.in);

		int count;
		String item;
		double cost;

		/* Read in an integer */
		System.out.print("How many? ");
		count = kbd.nextInt();
								// String input = kbd.nextLine();
								// count = Integer.parseInt(line);
		
		/* Read in a String */
		System.out.println("What is it?");
		item = kbd.nextLine(); // UH-OH! Why doesn't it wait for me? :(

		/* Read in a double */
		System.out.print("How much (#.##)? ");
		cost = kbd.nextDouble();
								// String input = kbd.nextLine();
								// cost = Double.parseDouble(line);

		/* Print results */
		System.out.println("Count: " + count);
		System.out.println("Item: " + item);
		System.out.println("Cost: " + cost);
			
		kbd.close();
	}

}
