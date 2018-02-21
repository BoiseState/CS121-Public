/**
 * Demonstrates how the order of operations and integer division
 * can affect the result of an expression.
 *
 * @author Anonymous
 */

public class Volume
{
	public static void main(String[] args)
	{
		final double PI = 3.14159;
		double radiusCubed = 1.0;
		double volume1 = 4 / 3 * PI * radiusCubed;
		double volume2 = PI * radiusCubed * 4 / 3;
		double volume3 = (4.0 / 3.0) * PI * radiusCubed;

		System.out.println();
		System.out.println("(Incorrect) volume1: " + volume1);
		System.out.println("-------------------------------");
		System.out.println("\t 4 / 3 = " + (4 / 3));
		System.out.println("\t 4 / 3 * PI = " + (4 / 3 * PI));
		System.out.println("\t 4 / 3 * PI * radiusCubed = " + (4 / 3 * PI * radiusCubed));

		System.out.println();
		System.out.println("(Correct) volume2: " + volume2);
		System.out.println("-------------------------------");
		System.out.println("\t PI * radiusCubed = " + (PI * radiusCubed));
		System.out.println("\t PI * radiusCubed * 4 = " + (PI * radiusCubed * 4));
		System.out.println("\t PI * radiusCubed * 4 / 3 = " + (PI * radiusCubed * 4 / 3));

		System.out.println();
		System.out.println("(Correct) volume3: " + volume3);
		System.out.println("-------------------------------");
		System.out.println("\t 4.0 / 3.0 = " + (4.0 / 3.0));
		System.out.println("\t 4.0 / 3.0 * PI = " + (4.0 / 3.0 * PI));
		System.out.println("\t 4.0 / 3.0 * PI * radiusCubed = " + (4.0 / 3.0 * PI * radiusCubed));

	}

}
