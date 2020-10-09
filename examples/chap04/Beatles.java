import java.util.ArrayList;

/**
 * Demonstrates the use of an ArrayList object.
 * 
 * @author Lewis, Loftus, amit
 * 
 */
public class Beatles
{
	/**
	 * Stores and modifies a list of band members.
	 * @param args
	 */
	public static void main(String[] args)
	{
		ArrayList<String> band = new ArrayList<String>();

		band.add("Paul");
		band.add("Pete");
		band.add("John");
		band.add("George");
		
		System.out.println("Size of the band: " + band.size());
		
		//Iterate over the band members using a for loop. 
		for (int index = 0; index < band.size(); index++) {
			System.out.print(band.get(index) + " ");
		}
		System.out.println("\n");
		
		//Iterate over the band members using a for-each loop
		//Note that the for-each loop is simpler than a normal for loop
		for (String member: band) {
				System.out.print(member + " ");
		}
		System.out.println("\n");

		//Searching for a member and removing it. 
		int location = band.indexOf("Pete");
		band.remove(location);
		
		System.out.println(" After removing Pete");
		//Iterate over the band members
		for (String member: band) {
			System.out.print(member + " ");
		}	
		System.out.println("\n");

		System.out.println(" After adding Ringo");
		band.add(2, "Ringo");

		//Iterate over the band members
		for (String member: band) {
			System.out.print(member + " ");
		}	
		System.out.println("\n");
		
		// Print the second band member. Note that the index starts from 0.
		System.out.println("At index 1: " + band.get(1));
	}
}
