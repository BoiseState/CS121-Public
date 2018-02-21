package inclass;

/**
 * Demonstrates how to use a for-loop to print multiples.
 * 
 * @author CS121 Instructors
 */
public class MultiplesOfThree
{
	public static void main(String[] args)
	{
		// Version 1: Look at every number.
		for(int i = 3; i <= 300; i++) {
			if(i % 3 == 0) {
				System.out.println(i);
			}
		}
		
		// Version 2: Skip over irrelevant numbers. 
		for(int i = 3; i <= 300; i += 3) {
			System.out.println(i);
		}

		// Version 3: Go backwards.
		for(int i = 300; i <= 3; i = i - 3) {
			System.out.println(i);
		}
	}

}
