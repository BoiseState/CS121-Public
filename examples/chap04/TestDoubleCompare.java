
/**
 * Demonstrate how to effectively compare two double values. 
 * @author amit
 *
 */
public class TestDoubleCompare
{
	public static void main(String[] args)
	{		
		double x = Math.sqrt(2);
		double xSquared = x * x;
		if (xSquared == 2) {
			System.out.println("sqrt(2) * sqrt(2) == 2");
		} else {
			System.out.println("sqrt(2) * sqrt(2) != 2  :-(");
		}
			
		final double TOLERANCE = 1E10-15;
		if (Math.abs(xSquared - 2) < TOLERANCE) {
			System.out.println("sqrt(2) * sqrt(2) == 2");
		} else {
			System.out.println("sqrt(2) * sqrt(2) != 2  :-(");
		}
		

	}

}
