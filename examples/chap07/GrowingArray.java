
import java.util.Scanner;

/**
 * Illustrates how to grow an array on the fly. Show the time taken when we grow
 * the array by 1 each time.
 *
 * time java GrowingArray < wordlist.txt 1
 *
 * Then see the improvement if we double the capacity each time we grow the array. The
 * command line argument of 0 doubles the size each time.
 *
 * time java GrowingArray < wordlist.txt 0
 * 
 * @author amit
 */

public class GrowingArray
{
	private String[] words;

	private int size; // size points to next free slot in words

	private int increment;

	/**
	 * Construct a Growing Array with an initial capacity.
	 * 
	 * @param initialCapacity
	 *            The initial capacity of the array.
	 * @param increment 
	 */
	public GrowingArray(int initialCapacity, int increment)
	{
		words = new String[initialCapacity];
		size = 0;
		this.increment = increment;
	}

	/**
	 * Increase capacity of internal array.
	 */
	private void growArray()
	{
		int extra = increment; 
		if (increment == 0) {
			extra = words.length;
		}
		String[] temp = new String[words.length + extra];
		for (int i = 0; i < words.length; i++) {
			temp[i] = words[i];
		}

		words = temp;
		System.out.println("Increased capacity to " + words.length);
	}

	/**
	 * Read in words (one per line) and store in array words, growing it as needed.
	 */
	public void readData()
	{
		Scanner input = new Scanner(System.in);

		while (input.hasNext()) {
			String line = input.nextLine();
				if (size == words.length) {
					growArray();
				}
				words[size] = line;
				size++;
		}
		input.close();
	}

	/**
	 * Print words array on console.
	 */
	public void printData()
	{
		for (int i = 0; i < size; i++) {
			System.out.println(words[i]);
		}
	}

	/**
	 * @param args
	 */
	public static void main(String[] args)
	{
		if (args.length != 1) {
			System.err.println("Usage: java GrowingArray <array increment>");
			System.exit(1);;
		}
		int increment = Integer.parseInt(args[0]);
		GrowingArray example = new GrowingArray(1, increment);
		example.readData();
		/* example.printData(); */
	}

}
