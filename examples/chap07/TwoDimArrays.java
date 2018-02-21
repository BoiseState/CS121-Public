

/**
 * Examples of square and rectangular two-dimensional arrays.
 * @author amit
 *
 */
public class TwoDimArrays
{		

	/**
	 * Prints a two-dimensional array row by row.
	 * @param arr a two-dimensional array
	 */
	public static void printArray (int arr[][])
	{
		for (int i = 0; i < arr.length; i++)
		{
			for (int j = 0; j < arr[i].length; j++)
				System.out.printf("%4d ", arr[i][j]);
			System.out.println();
		}
		System.out.println();
	}

	/**
	 * Create a square two-dimensional array
	 * @param numRows the dimension of the two-dimensional array
	 */
	public static void createAndShowSquareArray(int numRows)
	{
		int [][] array = new int [numRows][numRows];

		for (int i = 0; i < numRows; i++)
			for (int j = 0; j < numRows; j++)
				array[i][j] = i * numRows + j;

		printArray(array);
	}

	/**
	 * Create and print a rectangular array
	 * @param numRows number of rows
	 * @param numCols number of columns
	 */
	public static void createAndShowRectangularArray(int numRows, int numCols)
	{
		int [][] array = new int [numRows][numCols];

		for (int i = 0; i < numRows; i++)
			for (int j = 0; j < numCols; j++)
				array[i][j] = i * numCols + j;

		printArray(array);
	}
	
	/**
	 * @param args Pass in number of rows and columns
	 */
	public static void main(String [] args)
	{
		if (args.length != 2)
		{
			System.err.println("Usage: java TwoDimArrays <#rows> <#columns>");
			System.exit(1);
		}
		int n = Integer.parseInt(args[0]);
		int m = Integer.parseInt(args[1]);

		createAndShowSquareArray(n);

		createAndShowRectangularArray(n, m);
	}
}
