/**
 * Lesson 9: Activity
 * 
 * @author CS121 Instructors
 * @version Fall 2018
 */
public class DoubleComparison
{
	public static void main(String[] args)
	{
		final double TOLERANCE = 0.0000000000000001;
		double result = 1.0 - 0.9;
		double expected = 0.1;
		
		if(result == expected)
		{
			System.out.println("They are equal!");
		}
		else
		{
			System.out.println("They are not equal.");
		}
	}
}
