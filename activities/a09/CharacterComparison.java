/**
 * Lesson 9: Activity
 * 
 * @author CS121 Instructors
 * @version Fall 2018
 */
public class CharacterComparison
{
	public static void main(String[] args)
	{
		String word = "purple";
		char firstLetter = word.charAt(0);
		int asciiValue =  (int)firstLetter;
		
		System.out.println("The ascii value of " + firstLetter + " is " + asciiValue);
		
		if(firstLetter >= 'a' && firstLetter <= 'z')
		{
			System.out.println("It is a lower case letter");
		}
		else if(firstLetter >= 'A' && firstLetter <= 'Z')
		{
			System.out.println("It is an upper case letter");
		}
		else
		{
			System.out.println("It is a number");
		}
	}
}
