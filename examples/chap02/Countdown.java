/**
 * Demonstrates the difference between print and println.
 * @author Java Foundations, amit
 */
public class Countdown
{
	/**
   	 *  Prints two lines of output representing a rocket countdown.
   	 */
   	public static void main(String[] args)
   	{
		System.out.print("Three... ");
		System.out.print("Two... ");
		System.out.print("One... ");
		System.out.print("Zero... ");

		System.out.println("Liftoff!"); // appears on first output line

		System.out.println("To infinity and beyond!");
	  	System.out.println("C");
	  	System.out.println(" r");
	  	System.out.println("  a");
	  	System.out.println("   s");
	  	System.out.println("    h...");
	  	/* The following line has the same effect at the five lines above */
		/*System.out.println ("C\n r\n  a\n   s\n    h...");*/
   	}
}
