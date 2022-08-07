/**
 * Conversions.java demonstrates the effect of widening and 
 * narrowing conversions
 * @author sfrost
 *
 */
public class Conversions {
	public static void main(String[] args) {
		// Narrowing conversions store data in a smaller number of bits
		// Widening conversions store data in a larger number of bits
		
		// an int is smaller than a long

		int smallNumber;
		long bigNumber;

		
		//Widening conversions do not lose precision
		smallNumber = 5;
		bigNumber = smallNumber;
		System.out.println("smallNumber = " + smallNumber 
				+ ", bigNumber = " + bigNumber);
		
		//Narrowing conversions can lose precision
		bigNumber = 9223372036854L;
		smallNumber = (int)bigNumber; 
		System.out.println("smallNumber = " + smallNumber 
				+ ", bigNumber = " + bigNumber);

		//Be careful in your testing because it won't always cause an error!
		bigNumber = 5L; // this is a small number stored in a big space
		smallNumber = (int)bigNumber; // the int space is plenty big enough to store it
		System.out.println("smallNumber = " + smallNumber 
				+ ", bigNumber = " + bigNumber);
		
		//What happens when you try to store too big of a number in the given space?
		//The biggest int is 2147483647
		smallNumber = 2147483647;
		System.out.println("smallNumber = " + smallNumber 
				+ ", smallNumber + 1 = " + (smallNumber+1));
		
	}
	
	
	
}
