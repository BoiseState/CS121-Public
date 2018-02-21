import java.util.Scanner;

/**
 * Driver class to demonstrate AmazonAddress and AmazonAccount classes.
 * @author CS121 Instructors
 */
public class AmazonAccountManager
{
	public static void main(String[] args)
	{
		Scanner kbd = new Scanner(System.in);

		// First, create an AmazonAccount.
		AmazonAccount account = new AmazonAccount("snoopydog", "iL0v3tr3atz!");

		// Create a address when all values are known ahead of time.
		AmazonAddress snoopyAddress = new AmazonAddress("Snoopy", "123 Doghouse",
				"The top of the house", "Peanutville", "D.C.", 20500, "USA");
		snoopyAddress.setIsDefault(true);

		// Add the new address to the account. (just like you would from the
		// Amazon "Add New Address" page.
		account.addAddress(snoopyAddress);

		// Update account (add snoopy's email address.)
		account.setEmail("snoopy@peanuts.org");

		// Print account information (uses overridden toString)
		System.out.println(account);

		// Create a new address with no previously known values.
		AmazonAddress userAddress = readAddress(kbd);

		// Add this new address to snoopy's account.
		account.addAddress(userAddress);

		System.out.println(account);
	}

	private static AmazonAddress readAddress(Scanner scan)
	{
		AmazonAddress address = new AmazonAddress();
		String input;

		System.out.print("Full name: ");
		input = scan.nextLine().trim();
		address.setName(input);

		System.out.print("Address line 1: ");
		input = scan.nextLine().trim();
		address.setLine1(input);

		System.out.print("Address line 2: ");
		input = scan.nextLine().trim();
		address.setLine2(input);

		System.out.print("City: ");
		input = scan.nextLine().trim();
		address.setCity(input);

		System.out.print("State/Province/Region: ");
		input = scan.nextLine().trim();
		address.setState(input);

		System.out.print("ZIP: ");
		input = scan.nextLine().trim();
		address.setZip(Integer.parseInt(input));

		System.out.print("Country: ");
		input = scan.nextLine().trim();
		address.setCountry(input);

		System.out.print("Weekend Delivery (y/n): ");
		input = scan.nextLine().trim();
		if(input.toLowerCase().charAt(0) == 'y') {
			address.setDeliverOnWeekends(true);
		} else {
			address.setDeliverOnWeekends(false);
		}

		System.out.print("Security access code: ");
		input = scan.nextLine().trim();
		address.setAccessCode(input);

		return address;
	}
}
