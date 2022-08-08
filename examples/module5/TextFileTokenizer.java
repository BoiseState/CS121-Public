import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.StringTokenizer;

/**
 * Reads in a text file line by line and tokenizes it into words, 
 * printing them out on one per line.
 * @author amit
 *
 */
public class TextFileTokenizer
{

	/**
	 * @param args
	 */
	public static void main(String[] args)
	{

		if (args.length == 0) {
			System.err.println("Usage: java TextFileTokenizer <filename>");
			System.exit(1);
		}

		try {
			Scanner scan = new Scanner(new File(args[0]));
			while (scan.hasNextLine()) {
				String inputLine = scan.nextLine();
				StringTokenizer tokenizer = new StringTokenizer(inputLine,
						" , .;:'\"&!?-_\n\t12345678910[]{}()@#$%^*/+-");
				while (tokenizer.hasMoreTokens()) {
					System.out.println(tokenizer.nextToken());
				}
			}
		} catch (FileNotFoundException e) {
			System.err.println(e);
		}

	}

}
