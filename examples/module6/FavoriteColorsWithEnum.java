import java.util.Scanner;

public class FavoriteColorsWithEnum
{
	public enum MyColors {
		BLUE, GREEN, PURPLE, ORANGE, PINK
	};

	public static void main(String[] args)
	{
		int countBlue = 0, countGreen = 0;
		int countPurple = 0, countOrange = 0;

		Scanner scan = new Scanner(System.in);

		while (true) {

			// Print the menu of colors to the user.
			System.out.println("Here is a list of colors");
			System.out.println("------------------------");
			for (MyColors color : MyColors.values()) {
				System.out.println(color);
			}

			System.out.println("------------------------");

			// Read in their choice.
			System.out.print("Please choose a color:");
			String input = scan.nextLine();

			// Now, convert input to a value of the enum.
			MyColors color = null; // color is initially null (aka. nothing).
			switch (input.toUpperCase()) // convert to upper case so we can
											// handle lower case input
			{
			case "BLUE":
				color = MyColors.BLUE;
				break;
			case "GREEN":
				color = MyColors.GREEN;
				break;
			case "PURPLE":
				color = MyColors.PURPLE;
				break;
			case "ORANGE":
				color = MyColors.ORANGE;
				break;
			case "PINK":
				color = MyColors.PINK;
				break;
			default:
				System.out.println("Invalid entry.");
				break;
			}
			if (color != null) 
				System.out.println("You chose: " + color);

			// Assume we do some other processing in between.
			// ...
			// ...

			// Only switch if it is a valid enum value.
			if (color != null) {
				switch (color) {
				case BLUE:
					countBlue++;
					break;
				case GREEN:
					countGreen++;
					break;
				case PURPLE:
					countPurple++;
					break;
				case ORANGE:
					countOrange++;
					break;
				default:
					System.out.println("Not in my top four!");
					break;
				}
				System.out.println();
				System.out.println("Count blue: " + countBlue);
				System.out.println("Count green: " + countGreen);
				System.out.println("Count purple: " + countPurple);
				System.out.println("Count orange: " + countOrange);
			}
			// scan.close();
		}
	}
}
