/**
 * Demonstrates the use of primitive data types,arithmetic
 * expressions, and promotion
 *
 * @author Java Foundations, CS121 Instructors
 */
public class TempConverter
{
	/**
	 * Computes the Fahrenheit equivalent of a specific Celsius
	 * value using the formula F =(9/5)C + 32.
	 */
	public static void main(String[] args)
	{
		// Declare and instantiate constants
		final int BASE = 32;
		final double CONVERSION_FACTOR = 9.0 / 5.0;

		//Declare variables (celsiusTemp is also instantiated)
		double fahrenheitTemp;
		int celsiusTemp = 24;  // value to convert

		// Notice the types of each variable: BASE is an int. CONVERSION_FACTOR
		// is a double. celsiusTemp is an int. fahrenheitTemp is a double. BASE is promoted 
		// to a double during the evaluation of the expression. 
		fahrenheitTemp = celsiusTemp * CONVERSION_FACTOR + BASE;

		System.out.println("Celsius Temperature: " + celsiusTemp);
		System.out.println("Fahrenheit Equivalent: " + fahrenheitTemp);
	}
}
