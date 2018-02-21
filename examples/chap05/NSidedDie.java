/**
  	Represents one n-sided die with faces showing values between 1 and n, 
  	where n is specified when the die is constructed.

  	@author amit
*/

public class NSidedDie
{
	private final int DEFAULT_FACES = 6;  // maximum face value
	private int numberOfSides; //number of faces on the die
	private int faceValue;  // current value showing on the die

	/**
	  Constructor: Sets the initial face value.
	*/
	public NSidedDie()
	{
	   numberOfSides = DEFAULT_FACES;
	   faceValue = 1;
	}

	/**
	  Constructor: Sets the number of sides and initial face value.
	*/
	public NSidedDie(int numberOfSides)
	{
	   this.numberOfSides = numberOfSides;
	   faceValue = 1;
	}

	/**
	  Rolls the die and returns the result.
	*/
	public int roll()
	{
	   faceValue = (int)(Math.random() * numberOfSides) + 1;

	   return faceValue;
	}

	/**
	  Number of sides value accessor.
	*/
	public int getNumberOfFaces() 
	{ 
		return numberOfSides; 
	}

	/**
		 Face value mutator.
	*/
	public void setFaceValue (int value) 
	{ 
		faceValue = value; 
	}

	/**
	  Face value accessor.
	*/
	public int getFaceValue() 
	{ 
		return faceValue; 
	}

	/**
	  Returns a string representation of this die.
	*/
	public String toString()
	{
	   String result = "NSidedDie [numberOfSides = " + numberOfSides + ", faceValue = " + faceValue + "]";

	   return result;
	}
}
