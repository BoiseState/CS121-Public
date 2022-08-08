import java.util.Scanner;

/**
 * Programming Project PP 5.11.
 */
public class CountFlips
{
	public static void main(String[] args)
	{
		Scanner scanner = new Scanner(System.in);
		System.out.print("Enter number of coin flips: ");
		int count = scanner.nextInt();
		scanner.close();

		int headCount = 0;
		int tailCount = 0;
		Coin coin = new Coin();

		for (int i = 0; i < count; i++) {
			coin.flip();
			if (coin.isHeads())
				headCount++;
			else
				tailCount++;
		}

		System.out.printf("Results of the experiment: %8d heads   %8d tails\n",
				headCount, tailCount);

		int diff = Math.abs(headCount * 2 - count);
		System.out.printf("Off by %2.8f%%\n", diff / (double) count * 100);
	}
}
