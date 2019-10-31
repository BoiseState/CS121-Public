import java.util.Scanner;

public class FavoriteColors
{
	public static void main(String[] args)
	{
		int countBlue = 0, countGreen = 0;
		int countPurple = 0, countOrange = 0;

		Scanner scan = new Scanner(System.in);

		// Read in a color from the user.
		System.out.print("Please enter a color:");
		String input = scan.nextLine().trim();

		System.out.println("You chose: " + input);

		// Now, convert input to a value of the enum.
		switch (input.toUpperCase()) // convert to upper case so we can handle lower case input
		{
			case "TEAL":
			case "BLUE":
				countBlue++;
				break;
			case "GREEN":
				countGreen++;
				break;
			case "PURPLE":
				countPurple++;
				break;
			case "ORANGE":
			case "RUST":
				countOrange++;
				break;
			default:
				System.out.println("Not in my top 5!");
				break;
		}

		System.out.println();
		System.out.println("Count blue: " + countBlue);
		System.out.println("Count green: " + countGreen);
		System.out.println("Count purple: " + countPurple);
		System.out.println("Count orange: " + countOrange);

		scan.close();
	}
}
