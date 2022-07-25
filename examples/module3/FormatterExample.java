import java.util.Formatter;

/**
 * Demonstrates the use of Formatter class from java.util package.
 *
 * @author amit
 */
public class FormatterExample
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

	  	Formatter fmt = new Formatter (System.out);

		fmt.format(" num1 = %d\n", num1);
		fmt.format(" num1 num2\n %16d %16d\n", num1, num2);
		fmt.format(" %16s %16s\n %16d %16d\n", label1, label2, num1, num2);
			// - left justifies (default is right justification)
		fmt.format(" %-16s %-16s\n %16d %16d\n", label1, label2, num1, num2);

	  	fmt.format(" num1 = %d (%X)\n", num1, num1);
	  	fmt.format(" BIG_VALUE = %d (%X)\n", BIG_VALUE, BIG_VALUE);

	  	fmt.format(" num3 = %f \n", num3);
	  	fmt.format(" num3 (with 2 digits after decimal) = %.2f \n", num3);
	  	fmt.format(" num3 (10 character wide field and with 2 digits after decimal) = %10.2f \n", num3);
	  	fmt.format(" num4 = %10.2f \n", num4);
	  	fmt.format(" num4 = %20.16f \n", num4);

	  	fmt.format("\t \t %s \n", str1);
	  	// default is to right justify the string in a fixed width field
	  	fmt.format("%20s \n", str1);
	  	// Use - to left justify the string in a fixed width field
	  	fmt.format("%-20s \n", str1);

	  	fmt.close();
   	}
}
