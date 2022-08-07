import java.text.NumberFormat;
import java.util.Locale;

/**
 * Shows basic usage of NumberFormat.
 * @author CS121 Instructors
 */
public class BasicNumberFormat
{
	public static void main(String[] args)
	{
		NumberFormat currencyFmt = NumberFormat.getCurrencyInstance();
		double amount = 1150.45;
		System.out.println("Amount: " + currencyFmt.format(amount));

		NumberFormat percentFmt = NumberFormat.getPercentInstance();
		double percent = .8845;
		System.out.println("Percent: " + percentFmt.format(percent));

		/* currencyFmt = NumberFormat.getCurrencyInstance(Locale.UK); */
		/* System.out.println("Amount: " + currencyFmt.format(amount)); */
	}
}
