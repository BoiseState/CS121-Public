import java.util.Scanner;

/**
 * Demonstrate expressions using chars.
 * 
 * @author mvail
 */
public class CharacterMathAndComparison {

	public static void main(String[] args) {
		Scanner kbd = new Scanner(System.in);
		String input;
		char upperLetter;
		char lowerLetter;
		int position;
		final int ALPHA_OFFSET = 'a' - 'A';
		
		System.out.print("Enter a single capital letter: ");
		input = kbd.nextLine();
		upperLetter = input.charAt(0);
		position = (upperLetter - 'A') + 1;
		System.out.println("\'" + upperLetter + "\'" +
							" is letter " + position + 
							" in the alphabet.");
		
		System.out.print("Enter a lower-case letter: ");
		input = kbd.nextLine();
		lowerLetter = input.charAt(0);
		//long way
		if (lowerLetter - ALPHA_OFFSET == upperLetter) {
			System.out.println("\'" + upperLetter + "\'" + 
								" and " +
								"\'" + lowerLetter + "\'" +
								" are the same letter.");
		} else {
			System.out.println("\'" + upperLetter + "\'" + 
								" and " +
								"\'" + lowerLetter + "\'" +
								" are not the same letter.");
		}
		
		//less duplication
		System.out.print("\'" + upperLetter + "\'" + " and " +
						"\'" + lowerLetter + "\'" +
						" are ");
		if (lowerLetter - ALPHA_OFFSET != upperLetter) {
			System.out.print("not ");
		}
		System.out.println("the same letter");

		//using ternary conditional statement
		System.out.println("\'" + upperLetter + "\'" + " and " +
				"\'" + lowerLetter + "\'" + " are " +
				(lowerLetter - ALPHA_OFFSET != upperLetter ? "not " : "") +
				"the same letter.");
	
		System.out.print("Enter a number between 1 and 26: ");
		input = kbd.nextLine();
		position = Integer.parseInt(input);
		System.out.println("Letter " + position + " is " +
							(char)('A' + position-1) + ".");
		
		kbd.close();
	}
}
