import java.util.Random;

/**
 * Die.java
 *
 * Represents one n-sided die (singular of dice) with faces showing values
 * between 1 and n.
 *
 * @author Java Foundations
 * @author CS121 Instructors (modified a few things from the book)
 */
/**
 * @author amit
 *
 */
public class Die {
	private final int DEFAULT_FACES = 6; // default number of sides
	
	private int faceValue; // current value showing on the die
	private int numSides;
	
	private Random rand = new Random();

	/**
	 * Constructor: Sets the initial face value of this die.
	 */
	public Die() {
		numSides = DEFAULT_FACES;
		faceValue = 1;
	}

	/**
	 * Constructor: Sets the number of sides and initial face value.
	 * 
	 * @param numSides
	 */
	public Die(int numSides) {
		this.numSides = numSides;
		faceValue = 1;
	}

	/**
	 * Computes a new face value for this die and returns the result.
	 * 
	 * @return The new face value.
	 */
	public int roll() {
		// faceValue = (int)(Math.random() * numSides) + 1;
		
		faceValue = rand.nextInt(numSides) + 1;
		return faceValue;
	}

	
	/**
	 * Face value mutator. The face value is not modified if the specified value is
	 * not valid.
	 * 
	 * @param value
	 */
	public void setFaceValue(int value) {
		if (value > 0 && value <= numSides) {
			faceValue = value;
		} 
		else {
			throw new IllegalArgumentException("value must be between 1 and " + numSides);
		}
	}

	/**
	 * Face value accessor.
	 * 
	 * @return The current face value.
	 */
	public int getFaceValue() {
		return faceValue;
	}

	/**
	 * Returns a string representation of this die.
	 */
	public String toString() {
		String result = "Die [numberOfSides = " + numSides + ", faceValue = " + faceValue + "]";
		return result;
	}
}
