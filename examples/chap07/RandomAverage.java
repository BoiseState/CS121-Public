import java.util.*;

/**
 * Generate and store random numbers in an array and then compute their average.
 * 
 * @author Amit Jain
 */

public class RandomAverage
{
	private static final int MAX = 1000;

	/**
	 * Compute the average of integers in an array.
	 * 
	 * @param values
	 *            An array of integer values.
	 * @return The average
	 */
	public static double average(int[] values)
	{
		double average = 0.0;
		double sum = 0.0;
		int n = values.length;

		for (int i = 0; i < n; i++) {
			sum = sum + values[i];
		}
		average = sum / n;
		return average;
	}

	/**
	 * Read in n from command line, create a random array of n integers in the
	 * range [0..MAX], and then print their average.
	 * 
	 * @param args
	 *            The command line arguments
	 */
	public static void main(String[] args)
	{
		if (args.length == 0) {
			System.err.println("Usage: java Average <int>");
			System.exit(1);
		}

		int n = Integer.parseInt(args[0]);
		int[] array = new int[n];

		Random generator = new Random();
		for (int i = 0; i < array.length; i++) {
			array[i] = generator.nextInt(MAX);
		}

		System.out.printf("Average of %d random numbers in the range 0..1000 was %6.2f\n",
						n, average(array));
	}

}
