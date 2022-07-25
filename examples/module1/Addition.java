/**
 *  Demonstrates the difference between the addition and string
 *  concatenation operators.
 *
 *  @author: Java Foundations, amit
 */
public class Addition
{
   	/**
	 * Concatenates and adds two numbers and prints the results.
   	 */
   	public static void main(String[] args)
   	{
		System.out.println("1 through 5 concatenated: " + 1 + 2 + 3 + 4 + 5);

		System.out.println("1 through 5 added: 1 + 2 + ... + 5 =  " + (1 + 2 + 3 + 4 + 5));
   	}
}
