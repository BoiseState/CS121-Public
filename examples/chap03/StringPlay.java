/**
 * Demonstrates the use of the String class and its methods.
 *
 * @author Java Foundations
 */
public class StringPlay
{
	/**
	 * Prints a string and various manipulations of it.
	 */
	public static void main(String[] args)
	{
		String phrase = "Change is inevitable";
		String s1, s2, s3, s4;

		System.out.println("Original string: \"" + phrase + "\"");
		System.out.println("Length of string: " + phrase.length());

		s1 = phrase.concat(", except from vending machines.");
		s2 = s1.toUpperCase();
		s3 = s2.replace('E', 'X');
		s4 = s3.substring(3, 30);

		// Print each mutated string
		System.out.println("Mutation #1: " + s1);
		System.out.println("Mutation #2: " + s2);
		System.out.println("Mutation #3: " + s3);
		System.out.println("Mutation #4: " + s4);

		System.out.println("Mutated length: " + s4.length());
	}
}
