/**
 * Demonstrates the use of nested for loops.
 *
 * @author Java Foundations
 */
public class Stars
{
	/**
	 * Prints a triangle shape using asterisk (star) characters.
	 * @param args
	 */
	public static void main (String[] args)
	{
		final int MAX_ROWS = 10;

		for(int row = MAX_ROWS; row > 0; row--)
		{
			for(int star = 0; star < row; star++)
			{
				System.out.print ("*");
			}
			System.out.println();
		}
	}
}
