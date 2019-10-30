import java.util.ArrayList;

/**
 * This is a driver class that creates a "litter of Critters"
 *  and then initiates rounds of cookie sharing until no adjacent
 *  neighbors differ by more than one cookie.
 *  
 * The driver class for a program contains the main() method - 
 * the starting point for the Java Runtime Environement (JRE).
 * Before a program can be run by the JRE, all classes must be
 * compiled - translated into "byte-code" that the JRE understands.
 * The compile command for this program would be:
 *     javac CritterLitter.java
 * The compiler is smart enough to follow all class references
 * inside CritterLitter.java and compile those classes as well and
 * so on. Once the compiler has translated .java source code files
 * into .class byte-code files, you can run the program by passing
 * the driver class name to the JRE with this command: 
 *     java CritterLitter
 * 
 * The method header of main() has a lot of parts, but you
 * must include all of the parts as shown.
 *  
 * @author mvail
 */
public class CritterLitter {

	/** @param args unused */
	public static void main(String[] args) {
		//constant to use in place of numeric literal 10
		final int NUM_CRITTERS = 10;
		
		//spawn a litter of NUM_CRITTERS Critters
		ArrayList<Critter> litter = new ArrayList<Critter>(NUM_CRITTERS);
		for (int i = 0; i < NUM_CRITTERS; i++) {
			litter.add(new Critter());
		}
		
		//what are we starting with?
		System.out.println("Initial Litter");
		for (int index = 0; index < litter.size(); index++) {
			System.out.println(index + ": " + litter.get(index));
		}
		
		//while there are adjacent Critters differing by
		// more than one cookie, keep sharing
		int numRounds = 0;
		boolean needyNeighbors = true;
		while (needyNeighbors) {
			needyNeighbors = false;
			//for every index in the ArrayList
			for (int index = 0; index < litter.size(); index++) { 
				Critter currentCritter = litter.get(index);
				if (index > 0) { //look left if there is a Critter to the left
					Critter leftCritter = litter.get(index-1);
					if (currentCritter.getNumCookies() - leftCritter.getNumCookies() > 1) {
						needyNeighbors = true;
						currentCritter.giveCookie(leftCritter);
					}
				}
				if (index < litter.size()-1) { //look right if there is a Critter to the right
					Critter rightCritter = litter.get(index+1);
					if (currentCritter.getNumCookies() - rightCritter.getNumCookies() > 1) {
						needyNeighbors = true;
						currentCritter.giveCookie(rightCritter);
					}
				}
			}
			if (needyNeighbors) {
				numRounds++;
				//what does the cookie distribution look like, now?
				System.out.println("After " + numRounds + (numRounds == 1 ? " round" : " rounds") + " of sharing:");
				for (int index = 0; index < litter.size(); index++) {
					System.out.println(index + ": " + litter.get(index));
				}			
			}
		}
		
		System.out.println("\nAll cookies shared after " + numRounds + " rounds of sharing!");
	}
}
