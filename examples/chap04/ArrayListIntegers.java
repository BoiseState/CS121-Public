
import java.util.Scanner;
import java.util.ArrayList;

/**
 * Demonstrates the use of an ArrayList object with Integer wrapper objects.
 * 
 * @author CS 121 Instructors
 * 
 */
public class ArrayListIntegers 
{
	/**
	 * Prompts the user to enter integers and adds them to an Array List.
	 * Then removes the even integers.
	 * 
	 * @param args
	 */
	public static void main(String [] args)
	{
		Scanner scan = new Scanner(System.in);
		int intValue;
		ArrayList<Integer> myIntList = new ArrayList<Integer>();
		
		/* Store integer values to array list */
		do
		{
			System.out.print("Enter a positive integer (0 to quit): ");
			intValue = scan.nextInt();
			
			if(intValue > 0)
			{
				myIntList.add(intValue);
			}
			else if(intValue < 0) 
			{
				System.out.println("Invalid input: Your integer must be positive!");
			}
			
		} while(intValue != 0);
		
		/* Make sure the list is nonempty */
		if(myIntList.size() > 0)
		{
			/* Print array list contents */
			System.out.println("Your initial array list size is " + myIntList.size() + " and contains: ");
			for(int i = 0; i < myIntList.size(); i++)
			{
				System.out.printf("\t[%d] %d\n", i, myIntList.get(i));
			}
			
			/* Now remove the even numbers */
			System.out.println("Removing even numbers!");
			for(int i = myIntList.size() - 1; i >= 0; i--)
			{
				if(myIntList.get(i) % 2 == 0)
				{
					myIntList.remove(i);
				}
			}
			
			/* Print array list contents */
			System.out.println("Now your array list size is " + myIntList.size() + " and contains: ");
			for(int i = 0; i < myIntList.size(); i++)
			{
				System.out.printf("\t[%d] %d\n", i, myIntList.get(i));
			}
		}
		else
		{
			System.out.println("Your array list is empty! Nothing to do!");
		}
		
		scan.close();
	}
}
