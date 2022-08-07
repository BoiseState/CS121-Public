import java.text.DecimalFormat;
import java.math.RoundingMode;

/**
 * Shows basic usage of DecimalFormat.
 * @author CS121 Instructors
 */
public class BasicDecimalFormat
{
	public static void main(String[] args)
	{
		DecimalFormat fmt = new DecimalFormat("0.###");
		double amount = 110.3424;
		System.out.println("Amount: " + fmt.format(amount));

		double percent = .8845;
		System.out.println("Percent: " + fmt.format(percent));

		fmt.setRoundingMode(RoundingMode.CEILING);
		System.out.println("Amount: " + fmt.format(amount));
	}
}
