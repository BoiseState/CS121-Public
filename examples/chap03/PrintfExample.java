/**
 *  Demonstrates the use of printf in System.out. Same formatting can be
 *  done with the String.format method or the java.util.Formatter class.
 *
 *  @author amit
 */
public class PrintfExample
{
	public static void main(String[] args)
	{
		int num1 = 1200;
		long num2 = 1234567890123L; //L as a suffix forces the number to be 64-bit long
		String label1 = "num1";
		String label2 = "num2";
		long BIG_VALUE = 0x0FFFFFFFFFFA1111L;
		float num3 = 8.15763f; //f as a suffix forces the constant to be 32-bit float
		double num4 = 3.3333398290922;
		String str1 = "goo goo gaa gaa";

		System.out.printf(" num1 = %d\n", num1);
		System.out.printf(" num1 num2\n %16d %16d\n", num1, num2);
		System.out.printf(" %16s %16s\n %16d %16d\n", label1, label2, num1, num2);
			// - left justifies (default is right justification)
		System.out.printf(" %-16s %-16s\n %16d %16d\n", label1, label2, num1, num2);

		System.out.printf(" num1 = %d (%X)\n", num1, num1);
		System.out.printf(" BIG_VALUE = %d (%X)\n", BIG_VALUE, BIG_VALUE);

		System.out.printf(" num3 = %f \n", num3);
		System.out.printf(" num3 (with 2 digits after decimal) = %.2f \n", num3);
		System.out.printf(" num3 (10 character wide field and with 2 digits after decimal) = %10.2f \n", num3);
		System.out.printf(" num4 = %10.2f \n", num4);
		System.out.printf(" num4 = %20.16f \n", num4);

		System.out.printf("\t \t %s \n", str1);
		// default is to right justify the string in a fixed width field
		System.out.printf("%20s \n", str1);
		// Use - to left justify the string in a fixed width field
		System.out.printf("%-20s \n", str1);

		// Run-time errors (Exceptions) can be thrown when the format string causes
		// an unsupported conversion. Uncomment the line below to try it out.
		System.out.printf(" num3 = %d \n", num3);
	}
}
