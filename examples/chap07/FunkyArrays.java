/**
 * Example of non-rectangular shaped two-dimensional arrays in Java.
 * 
 * @author amit
 */

public class FunkyArrays
{

	/**
	 * Prints a two-dim array to the console
	 * @param arr
	 */
	public static void printArray(int arr[][])
	{
		for (int i = 0; i < arr.length; i++) {
			for (int j = 0; j < arr[i].length; j++)
				System.out.print(arr[i][j]);
			System.out.println();
		}
		System.out.println();
	}

	/**
	 * Create and print a triangle shaped array.
	 * @param n
	 */
	public static void createAndShowTriangleArray(int n)
	{
		// create a triangle array
		int[][] triangleArray = new int[n][];
		for (int i = 0; i < triangleArray.length; i++) {
			triangleArray[i] = new int[i + 1];
		}

		// initialize it to all 1's
//		for (int i = 0; i < n; i++)
//			for (int j = 0; j <= i; j++)
//				triangleArray[i][j] = 1;

		for (int i=0; i < triangleArray.length; i++) 
			for (int j=0; j < triangleArray[i].length; j++) 
				triangleArray[i][j] = 1; 

		printArray(triangleArray);
	}

	/**
	 * Create and print a pyramid shaped array.
	 * @param n
	 */
	public static void createAndShowPyramidArray(int n)
	{
		// create a pyramid shaped array
		int[][] pyramidArray = new int[n][];
		for (int i = 0; i < n / 2; i++) {
			pyramidArray[i] = new int[i + 1];
		}
		for (int i = n / 2; i < n; i++) {
			pyramidArray[i] = new int[n - i];
		}

		// initialize it to all 1's
		for (int i = 0; i < pyramidArray.length; i++)
			for (int j = 0; j < pyramidArray[i].length; j++)
				pyramidArray[i][j] = 1;

		printArray(pyramidArray);
	}

	/**
	 * Create and print a randomly shaped array
	 * @param n
	 */
	public static void createAndShowRaggedArray(int n)
	{
		// create a radically shaped array
		int[][] radArray = new int[n][];
		for (int i = 0; i < n; i++) {
			radArray[i] = new int[(int) (Math.random() * n) + 1];
		}

		// initialize it to all 1's
		for (int i = 0; i < radArray.length; i++)
			for (int j = 0; j < radArray[i].length; j++)
				radArray[i][j] = 1;

		printArray(radArray);

	}

	/**
	 * Demonstrate how to create non-rectangular shaped two-dim arrays.
	 * @param args
	 */
	public static void main(String[] args)
	{
		if (args.length != 1) {
			System.err.println("Usage: java FunkyArrays <n>");
			System.exit(1);
		}
		int n = Integer.parseInt(args[0]);

		createAndShowTriangleArray(n);

		createAndShowPyramidArray(n);

		createAndShowRaggedArray(n);
	}
}
