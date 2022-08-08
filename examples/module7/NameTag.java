

/**
 * 
 * Demonstrates the use of command line arguments.
 * @author Lewis/Loftus/amit
 *
 */
public class NameTag
{
	private static final int ERROR_EXIT = 1;
	/**
	 * Prints a simple name tag using a greeting and a name that is 
	 * specified by the user.
	 * @param args
	 */
	public static void main(String[] args)
	{

		if (args.length != 2) {
			// Note that we use System.err instead of System.out for
			// printing error messages.
			System.err.println("Usage: java NameTag <greeting> <name>");
			System.exit(ERROR_EXIT); //terminate the program with an error status
		}

		System.out.println();
		System.out.println("     " + args[0]);
		System.out.println("My name is " + args[1]);
	}
}
