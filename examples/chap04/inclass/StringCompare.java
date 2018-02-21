package inclass;

/**
 * Demonstrates == equality operator vs equals.
 * 
 * @author CS121 Instructors
 */
public class StringCompare
{
	public static void main(String[] args)
	{
		String thingOne = "hello";
		String thingTwo = "hello"; // Java will actually only declare the string literal one in memory.
		String thingThree = new String("hello");
		
		// Compares thingOne and thingTwo references
		if(thingOne == thingTwo)
		{ 
			System.out.println(thingOne + " == " + thingTwo);
		}
		else
		{
			System.out.println(thingOne + " != " + thingTwo);
		}
		
		
		// Compares thingOne and thingThree references
		if(thingOne == thingThree)
		{
			System.out.println(thingOne + " == " + thingThree);
		}
		else
		{
			System.out.println(thingOne + " != " + thingThree);
		}
		
		// Compares thingOne and thingThree for equality
		if(thingOne.equals(thingThree))
		{
			System.out.println(thingOne + " equals " + thingThree);
		}
		else
		{
			System.out.println(thingOne + " does not equal " + thingThree);
		}
		
		// Compares thingOne and thingThree for equality
		if(thingOne.compareTo(thingTwo) < 0)
		{
			System.out.println(thingOne + " comes first.");
		}
		else if(thingOne.compareTo(thingTwo) > 0)
		{
			System.out.println(thingTwo + " comes first.");
		}
		else
		{
			System.out.println("They are equal.");
		}
	}
}
