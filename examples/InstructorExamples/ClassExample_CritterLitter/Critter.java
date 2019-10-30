import java.util.Random;

/**
 * A Critter is a creature that is born knowing its own name and 
 * possessing some cookies that it likes to share.
 *  
 * This special kind of comment is a "Javadoc". There should be a good, 
 * descriptive Javadoc with appropriate tags before every class and method.
 * Typically, author tags, as seen in this Javadoc, are only included in 
 * class Javadocs, but they can be in method Javadocs if there's a 
 * compelling reason to specify who wrote a particular method. You can list 
 * multiple authors after one tag or have separate tags for every author.  
 *  
 * @author mvail
 */
public class Critter {
	//The variables below are "instance variables" - together they
	// make up the unique state, or identity, of a particular
	// object, or "instance", created from the Critter class.
	// Because they are declared outside of the Critter's methods,
	// instance variables have class scope - they can be used
	// anywhere inside the class. ONLY variables that make up the
	// identity of a Critter should be declared as instance
	// variables. All other variables should be declared within
	// methods and passed between methods as parameters/arguments
	// if necessary.
	//
	// Instance variables are marked "private" to enforce object
	// encapsulation. Private means that the variables will not be
	// directly accessible from outside an object. Anyone wanting
	// to interact with a Critter will have to use its public
	// methods.
	//
	// This kind of comment is a line comment - 
	// anything after double-slashes is ignored
	private String name;    //the name of the Critter
	private int numCookies; //this Critter's current number of cookies
	
	/**
	 * The Critter constructor is responsible for initializing
	 * a new Critter object's instance variables. No instance
	 * variables should be un-initialized by the end of the
	 * constructor. This constructor generates a random name
	 * and a random starting number of cookies.
	 */
	public Critter() {
		Random rand = new Random();
		//born with 1 to 10 cookies
		numCookies = rand.nextInt(10) + 1;
		//born with a random 6-character name
		name = "";
		name += (char)(rand.nextInt(26) + 'A');
		for (int i = 0; i < 5; i++) {
			name += (char)(rand.nextInt(26) + 'a');
		}
	}
	
	/**
	 * This accessor, or "getter" method returns the
	 *  Critter's name. This allows someone outside
	 *  the Critter to ask about the Critter's instance
	 *  variable value without violating encapsulation. 
	 * 
	 * Notice that this method Javadoc has a return tag,
	 * because the method is expected to return a value.
	 * 
	 * @return the Critter's name
	 */
	public String getName() {
		return name;
	}
	
	/**
	 * This accessor, or "getter" method returns the
	 * Critter's current number of cookies.
	 * 
	 * This allows someone outside the Critter to ask about
	 * its instance variable value without violating
	 * encapsulation.
	 * 
	 * @return the Critter's current number of cookies
	 */
	public int getNumCookies() {
		return numCookies;
	}
	
	/**
	 * This method takes one of this Critter's cookies and
	 * gives it to the otherCritter.
	 * 
	 * In this method, the Critter's numCookies instance
	 * variable is updated, but we control how the instance
	 * variable is changed (only one at a time, and only if
	 * this Critter has extra cookies) and make sure the
	 * otherCritter receives the cookie this Critter is
	 * sharing.
	 * 
	 * Notice that this Javadoc has a param tag, because
	 * the method requires a parameter referencing another
	 * Critter.
	 * 
	 * @param otherCritter reference to a Critter that will receive a cookie from this Critter
	 */
	public void giveCookie(Critter otherCritter) {
		if (numCookies > 1) {
			numCookies--;
			otherCritter.receiveCookie();
		}
	}
	
	/**
	 * This method adds one cookie to this Critter's
	 * number of cookies.
	 * 
	 * Notice that this Javadoc has no tags, because
	 * it expects no parameters and returns no value.
	 */
	public void receiveCookie() {
		numCookies++;
	}
	
	/*
	 * The @Override tag above the toString() method header, below,
	 * indicates that there is an inherited toString() method
	 * from a parent class that is being overridden (replaced)
	 * or that the class is providing a method body required by an 
	 * interface that the class is implementing. In this case, we
	 * are overriding a default toString() method that all classes
	 * inherit from a parent class called Object.
	 * 
	 * This comment is a regular block comment. The number of
	 * asterisks in the open delimiter (/** or /*) determines if the
	 * comment is a Javadoc or a regular block comment. This method
	 * does not need a Javadoc because it inherits the Javadoc from
	 * the original implementation of the method. The (non-Javadoc)
	 * information, below, indicates where to look for the
	 * inherited method and its documentation.
	 * 
	 * (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return String.format("Critter: %6s, Cookies: %2d", name, numCookies);
	}
}
