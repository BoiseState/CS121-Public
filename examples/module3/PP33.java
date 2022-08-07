import java.util.Random;
import java.text.DecimalFormat;

/**
 * Write an application that creates and prints a random phone number
 * of the form XXX-XXX-XXXX. Include the dashes in the output.
 *
 * Do not let the first three digits contain an 8 or 9.
 * Make sure that the second set of three digits is not greater than 742.
 *
 * @author amit
 */
public class PP33
{
	/**
	 * Generates random numbers in various ranges.
	 */
	public static void main(String[] args)
	{
		Random generator = new Random();
		int area1 = generator.nextInt(8);
		int area2 = generator.nextInt(8);
		int area3 = generator.nextInt(8);
		int areaCode = area1 * 100 + area2 * 10 + area3;

		int second = generator.nextInt(743);
		int third = generator.nextInt(10000);

		System.out.println(areaCode + "-" + second + "-" + third);

		// Print in xxx-xxx-xxxx format using DecimalFormat
		DecimalFormat formatter3wide = new DecimalFormat("000");
		DecimalFormat formatter4wide = new DecimalFormat("0000");
		System.out.println(formatter3wide.format(areaCode) + "-"
				+ formatter3wide.format(second) + "-"
				+ formatter4wide.format(third));

		// Print in xxx-xxx-xxxx format using printf
		System.out.printf("%1d%1d%1d-%03d-%04d\n", area1, area2, area3, second, third);
		System.out.printf("%03d-%03d-%04d\n", areaCode, second, third);
	}
}
