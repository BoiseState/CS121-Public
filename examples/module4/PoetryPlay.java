import java.util.Scanner;


/**
 * Demonstrate if statements with String equals method.
 * @author amit
 *
 */
public class PoetryPlay {

	/**
	 * @param args
	 */
	public static void main(String[] args)
	{
		Scanner keyboard = new Scanner(System.in);
		System.out.print("Choose poem version (original|modded): ");
		String choice = keyboard.nextLine();
		keyboard.close();
		
		if (choice.equals("original")) 
		{
			System.out.println("\nYou'd have to do math to divide a");
			System.out.println("    smile by a tear, times fear, equals");
			System.out.println("    mere truth, that simply dwells in the air");
			System.out.println("\t --Saul Williams\n");
		} 
		else if (choice.equals("modded")) 
		{
			System.out.println();
			System.out.println("\nYou'd have to do math to divide a");
			System.out.println("    oval by a line, times rectangle, equals");
			System.out.println("    mere drawing, that simply slides on the screen");
			System.out.println("\t --modded version\n");
		} 
		else 
		{
			System.out.println("\nTry again and enter a valid choice!\n");
		}
	}
}
