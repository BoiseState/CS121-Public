/**
 * Demonstrates the use of nested for loops.
 *
 * @author CS121 Instructors
 */
public class Numbers
{
	/**
	 * Prints a triangle shape using numbers.
	 * @param args
	 */
	public static void main (String[] args)
	{
		final int ROWS = 10;
		final int COLS = 10;

		// for every row
		for(int row = 0; row < ROWS; row++)
		{
			// for every column in the current row (from 0 to row #)
			for(int col = 0; col <= row; col++)
			{
				System.out.print(col + " "); // print current column #
			}
			System.out.println();
		}

		System.out.println();

		// for every row
		for(int row = 0; row < ROWS; row++)
		{
			// for every column in the current row from (0 to maxcol# - row)
			for(int col = 0; col < COLS - row; col++)
			{
				System.out.print(col + " "); // print current column #
			}
			System.out.println();
		}
	}
}
