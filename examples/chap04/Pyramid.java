/**
 * Demonstrates the use of nested for loops.
 * @author Lewis/Loftus/amit
 *
 */
public class Pyramid
{
	/**
	 * Prints a pyramid shape using asterisk (star) characters.
	 * @param args
	 */
	public static void main(String[] args)
	{
		final int MAX_ROWS = 10;

		for (int row = 1; row <= MAX_ROWS; row++) {

			for (int space = 1; space <= MAX_ROWS - row; space++)
				System.out.print(" ");

			for (int star = 1; star <= 2 * row; star++)
				System.out.print("*");

			System.out.println();
		}
	}
}
