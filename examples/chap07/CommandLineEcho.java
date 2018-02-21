/**
  Demonstrates the use of command line arguments.
  @author Java Foundations, amit
*/

public class CommandLineEcho
{
	/**
	 * Prints all of the command line arguments provided by the user
	 * 
	 * @param args the command line arguments
	 */
	public static void main(String[] args)
	{
		for (String arg : args)
			System.out.println(arg);
	}
}
