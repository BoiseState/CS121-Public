import java.util.Random;

/**
 * Demonstrate creating arrays, populating them with some data,
 * and outputting the data.
 * 
 * @author mvail
 */
public class ArrayExample {

	/**
	 * @param args unused
	 */
	public static void main(String[] args) {
		final int ARRAY_SIZE = 10;
		Random rand = new Random();
		
		//create an array to hold ARRAY_SIZE ints
		//
		//an array is an object, so you must use the
		// 'new' keyword, but arrays break the usual
		// constructor pattern by specifying the size
		// parameter in square brackets rather than
		// in parentheses
		int[] anArray = new int[ARRAY_SIZE];

		//you can iterate through the contents of
		// an array in a for-each loop
		//
		//we haven't initialized any of the ints,
		// so they all have default values
		System.out.println("Displaying an un-initialized int[]:");
		for (int i : anArray) {
			System.out.println(i);
		}
		System.out.println();
		
		//you cannot initialize values with a
		// for-each loop - you must access the
		// array by index
		for (int i = 0; i < anArray.length; i++) {
			//generate a random int from 0..99
			// for each index position in the array
			anArray[i] = rand.nextInt(100);
		}
		
		//as before, we can use a for-each loop to
		// see the values in the array
		System.out.println("Displaying an int[] with a for-each loop:");
		for (int i : anArray) {
			System.out.println(i);
		}
		System.out.println();
		
		//or, we can use a for loop and get the
		// values by index
		System.out.println("Displaying an int[] with a for loop:");
		for (int i = 0; i < anArray.length; i++) {
			System.out.println(anArray[i]);
		}
		System.out.println();
		
		//arrays can also hold object references,
		// but you will get a null pointer exception
		// if you try to use an uninitialized
		// reference, just as with any individual
		// object reference
		//
		//also, as before, you must initialize
		// values by accessing the array by index
		String sourceString = "This is just a String for getting substrings.";
		String[] anotherArray = new String[ARRAY_SIZE];
		for (int i = 0; i < anotherArray.length; i++) {
			//we'll randomly generate indexes for getting substrings from
			// sourceString
			int startIndex = rand.nextInt(sourceString.length());
			int charsToInclude = rand.nextInt(sourceString.length() - startIndex);
			//anotherArray stores a reference to a String at each index position
			anotherArray[i] = sourceString.substring(startIndex, startIndex + charsToInclude);
		}
		
		//let's see what we put in our String[]
		System.out.println("Displaying a String[] with a for-each loop:");
		for (String s : anotherArray) {
			System.out.println(s);
		}
		System.out.println();
	}
}

