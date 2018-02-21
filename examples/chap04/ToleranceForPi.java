
/**
 * Demonstrate using tolerances for comparing floating point numbers.
 * 
 * @author mvail
 */
public class ToleranceForPi {

	public static void main(String[] args) {
		final double TOLERANCE15 = 1E-15;	//0.000000000000001
		final double TOLERANCE5 = 1E-5;		//0.00001
		final double TOLERANCE2 = 1E-2;		//0.01
		
		final double DECENT_PI = 3.14159;
		final double BAD_PI = 3.14;
		final double AWFUL_PI = 3;
		
		double bestDifference = Math.abs(Math.PI - Math.PI);
		double decentDifference = Math.abs(Math.PI - DECENT_PI);
		double badDifference = Math.abs(Math.PI - BAD_PI);
		double awfulDifference = Math.abs(Math.PI - AWFUL_PI);

		if (bestDifference < TOLERANCE15) {
			System.out.println(Math.PI + " is great Pi!");
		} else if (bestDifference < TOLERANCE5) {
			System.out.println(Math.PI + " is decent Pi.");
		} else if (bestDifference < TOLERANCE2) {
			System.out.println(Math.PI + " resembles Pi.");
		} else {
			System.out.println(Math.PI + " is awful Pi.");
		}

		if (decentDifference < TOLERANCE15) {
			System.out.println(DECENT_PI + " is great Pi!");
		} else if (decentDifference < TOLERANCE5) {
			System.out.println(DECENT_PI + " is decent Pi.");
		} else if (decentDifference < TOLERANCE2) {
			System.out.println(DECENT_PI + " resembles Pi.");
		} else {
			System.out.println(DECENT_PI + " is awful Pi.");
		}
		
		if (badDifference < TOLERANCE15) {
			System.out.println(BAD_PI + " is great Pi!");
		} else if (badDifference < TOLERANCE5) {
			System.out.println(BAD_PI + " is decent Pi.");
		} else if (badDifference < TOLERANCE2) {
			System.out.println(BAD_PI + " resembles Pi.");
		} else {
			System.out.println(BAD_PI + " is awful Pi.");
		}

		if (awfulDifference < TOLERANCE15) {
			System.out.println(AWFUL_PI + " is great Pi!");
		} else if (awfulDifference < TOLERANCE5) {
			System.out.println(AWFUL_PI + " is decent Pi.");
		} else if (awfulDifference < TOLERANCE2) {
			System.out.println(AWFUL_PI + " resembles Pi.");
		} else {
			System.out.println(AWFUL_PI + " is awful Pi.");
		}
	}

}
