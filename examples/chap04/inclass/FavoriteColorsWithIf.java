package inclass;
import java.util.Scanner;

public class FavoriteColorsWithIf
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
		String upperInput = input.toUpperCase();
		
		if(upperInput.equals("BLUE")) {
			countBlue++;
		} else if(upperInput.equals("GREEN")) {
			countGreen++;
		} else if(upperInput.equals("PURPLE")) {
			countPurple++;
		} else if(upperInput.equals("ORANGE")) {
			countOrange++;
		} else {
			System.out.println("Not in my top 5!");
		}

		System.out.println();
		System.out.println("Count blue: " + countBlue);
		System.out.println("Count green: " + countGreen);
		System.out.println("Count purple: " + countPurple);
		System.out.println("Count orange: " + countOrange);

		scan.close();
	}
}
