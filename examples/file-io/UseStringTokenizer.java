import java.util.Scanner;
import java.util.StringTokenizer;

/**
 * Demonstrates how to use the StringTokenizer.
 */
public class UseStringTokenizer {

	/**
	 * @param args
	 */
	public static void main(String[] args)
	{
		String text = "Twinkle, twinkle, little star,\n" +
			"How I wonder what you are!\n" +
			"Up above the world so high,\n" +
			"Like a diamond in the sky!";

		System.out.println("---------- StringTokenizer default ----------");
		tokenizeDefault(text);
		System.out.println("---------- StringTokenizer with delimiter string ----------");
		tokenizeWithDelims( text, " \t\n!,.");
		System.out.println("------------------------------\n");
	}

	/**
	 * Breaks the given text into tokens using the default StringTokenizer delimeters.
	 * The default delimiter set is " \t\n\r\f": the space character, the tab character,
	 * the newline character, the carriage-return character, and the form-feed character.
	 * Delimiter characters themselves will not be treated as tokens.
	 * @param the string to tokenize.
	 */
	public static void tokenizeDefault(String text)
	{
		StringTokenizer tokenizer = new StringTokenizer(text);

		int count = tokenizer.countTokens();
		System.out.println( "The string has " + count + " tokens");

		String token;
		while (tokenizer.hasMoreTokens()) {
			token = tokenizer.nextToken();
			System.out.println("\t" + token);
		}
	}

	/**
	 * Breaks the given text into tokens using the given delimeters.
	 * Delimiter characters themselves will not be treated as tokens.
	 * @param the string to tokenize.
	 */
	public static void tokenizeWithDelims(String text, String delimiters)
	{
		StringTokenizer tokenizer = new StringTokenizer(text, delimiters);

		int count = tokenizer.countTokens();
		System.out.println( "The string has " + count + " tokens");

		String token;
		while (tokenizer.hasMoreTokens()) {
			token = tokenizer.nextToken();
			System.out.println("\t" + token);
		}
	}

}
