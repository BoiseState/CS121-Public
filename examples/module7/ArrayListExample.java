
import java.util.ArrayList;
import java.util.Random;

/**
 * @author amit
 */
public class ArrayListExample
{
	private String[] words;
	private Random generator = new Random();
	private final int MAX_LENGTH = 20;

	public ArrayListExample(int n)
	{
		words = new String[n];
		for (int i=0; i<n; i++)
		{
			int length = generator.nextInt(MAX_LENGTH);
			String next = "";
			for (int j = 0; j<length; j++)
				next = next + "a";
			words[i] = next;
		}
	}

	public String[] findByLength(int n)
	{
		ArrayList<String> temp = new ArrayList<String>();
		for (int i=0; i<words.length; i++)
		{
			if (words[i].length() == n)
			{
				temp.add(words[i]);
			}
		}
		String[] result = new String[temp.size()];
		temp.toArray(result);
		return result;
	}


	public static void main(String[] args)
	{
		if (args.length == 0)
		{
			System.err.println("Usage: java ArrayListExample <word length>");
			System.exit(1);
		}
		int n = Integer.parseInt(args[0]);
		ArrayListExample ex1 = new ArrayListExample(100); // set initial size to 100

		String[] results = ex1.findByLength(n);

		System.out.println();
		System.out.println("There were " + results.length 
							+ " words with length " + n + " : ");
		System.out.println();
		for(int i=0; i<results.length; i++)
			System.out.println(results[i]);
		System.out.println();
	}


}
