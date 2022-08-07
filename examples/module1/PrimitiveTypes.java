/**
 * PrimitiveTypes.java
 *
 * Demonstrates how to find minimum/maximum values for some primitive types and how to
 * use parse methods.
 *
 * @author amit
 * @author marissa
 */
public class PrimitiveTypes
{
	public static void main(String[] args)
	{
		System.out.println();
		System.out.println("byte " + "\t" + Byte.MIN_VALUE + "\t" + Byte.MAX_VALUE);
		System.out.println("short " + "\t" + Short.MIN_VALUE + "\t" + Short.MAX_VALUE);
		System.out.println("int " + "\t" + Integer.MIN_VALUE + "\t\t" +  Integer.MAX_VALUE);
		System.out.println("long " + "\t" + Long.MIN_VALUE + "\t" + Long.MAX_VALUE);
		System.out.println();

		System.out.println("long " + "\t" + Float.MIN_VALUE + "\t\t" + Float.MAX_VALUE);
		System.out.println("double " + "\t" + Double.MIN_VALUE + "\t" + Double.MAX_VALUE);
		System.out.println();

		String input = "10";
		int iValue = Integer.parseInt(input);
		System.out.println("Parsed int from string \"" + input + "\": " + iValue);

		input = "99.99";
		double dValue = Double.parseDouble(input);
		System.out.println("Parsed double from string \"" + input + "\": " + dValue);
	}
}
