import java.util.Scanner;

/**
 * CookieSharing demonstrates primitive data types, the modulo operator, 
 * and casting. It gets a number of cookies from the user and determines 
 * how many each person gets
 * 
 * @author sfrost
 *
 */
public class CookieSharing {
	public static void main(String[] args) {
		
		// Note: These are all primitive data types
		final int NUM_FRIENDS = 4;
		int numCookies;
		double cookiesPerPersonFrac;
		int cookiesPerPersonWhole;
		int leftOverCookies;
		
		//Note: These are NOT primitive data types
		String friend1 = "Lucy";
		String friend2 = "Edmund";
		String friend3 = "Peter";
		String friend4 = "Susan";
		
		//Get the number of cookies from the user
		Scanner scnr = new Scanner(System.in);
		System.out.print("How many cookies are there to share? ");
		numCookies = scnr.nextInt();
		
		System.out.println(numCookies);
		
		// This calculation takes advantage of automatic conversion
		// An int divided by an int returns an int, truncating the decimal
		// portion of the division.  
		cookiesPerPersonWhole = numCookies/NUM_FRIENDS;
	
		// To allow splitting cookies into pieces you must cast one of the 
		// numbers involved in the division as a double
		cookiesPerPersonFrac = ((double)numCookies)/NUM_FRIENDS;
		
		// Now calculate and display how many cookies each friend gets
		System.out.println("Whole Cookies only :" + cookiesPerPersonWhole);
		leftOverCookies = numCookies-(cookiesPerPersonWhole*NUM_FRIENDS);
		System.out.println("    Cookies leftover: " + leftOverCookies);
		System.out.println("Splitting the cookies: " + cookiesPerPersonFrac);
		
		
	}
	
	
}
