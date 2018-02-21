package inclass;

public class CharacterMath
{
	public static void main(String[] args)
	{
		char letter = 'n'; // how can we read this from the console?
		int offset = letter - 'a';
		
		System.out.println(letter + " is at position " + offset + " in the alphabet");
		
		/* now show the reverse */
		offset = 15;
		letter = (char) ('a' + offset);
		System.out.println("The letter at position " + offset + " is " + letter);
		
		// How can we validate that it is a letter before we use it?
		// How can we convert a letter to upper/lower case before checking?

	}
}
