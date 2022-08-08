
/**
 * Demonstrate how to effectively compare two double values. 
 * @author amit, elena
 *
 */
public class TestDoubleCompare
{
	public static void main(String[] args)
	{	
		//Example 1
		double val1 = (3 - 9) / 35.0;
		double val2 = 3 / 35.0 - 9 / 35.0;
		System.out.println("val1 " + val1 + "\tval2 " + val2);

		if (val1 == val2) {
			System.out.println("they are exactly the same!");
		} else {
			System.out.println("not the same");
		}
		
		 //a better way to compare floats
        double tolerance = 0.00001;
        //difference between val1 and val2 should be small
        double diff = val1 - val2;
        //1st compare val1 and val2, if negative it means val2 greater that val1,
        //subtract smaller from the larger
        double absDiff = val1 - val2 < 0 ? val2 - val1 : val1 - val2;

        if(absDiff < tolerance){
                //the same as the code below
        }
        if(Math.abs(diff) < tolerance){
                System.out.println("they are the same within " + tolerance);
        } else {
                System.out.println("they are different");
        }

        //Example 2
		double x = Math.sqrt(2);
		double xSquared = x * x;
		if (xSquared == 2) {
			System.out.println("sqrt(2) * sqrt(2) == 2");
		} else {
			System.out.println("sqrt(2) * sqrt(2) != 2  :-(");
		}
		System.out.println(xSquared);
			
		final double TOLERANCE = 1E10-15; 
		if (Math.abs(xSquared - 2) < TOLERANCE) {
			System.out.println("sqrt(2) * sqrt(2) == 2");
		} else {
			System.out.println("sqrt(2) * sqrt(2) != 2  :-(");
		}
		
		
		double x1 = 3.141590;
		double x2 = 3.141594;
		double area1 = x1 * 100 * 100;
		double area2 = x2 * 100 * 100;
		System.out.println("area1 = " + area1);
		System.out.println("area2 = " + area2);
		
		final double TOLERANCE_AREA = 0.1; // 1E10-1
		if (Math.abs(area1 - area2) < TOLERANCE_AREA)
				System.out.println("Essentially equal");

		
	}
}
