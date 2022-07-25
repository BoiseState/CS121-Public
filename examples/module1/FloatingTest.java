/**
 * Example that shows how floating point numbers cannot always be stored precisely.
 *
 * @author amit
 */
public class FloatingTest
{
	public static void main(String args[])
	{
		float n = 5322;
		double value1 = n / 3600;
		double value2 = (double) n / 3600;
		System.out.println(" x = " + value1 + "\n y = " + value2);
		System.out.println();

		double value = 2.0;
		value = Math.sqrt(value);
		System.out.println("sqrt(2) = " + value);
		value  = value * value;
		System.out.println("sqrt(2) * sqrt(2) = " + value);
		System.out.println();

		value = 1/3.0;
		System.out.println("1/3.0 = " + value);
		value = value * 3.0;
		System.out.println("1/3.0 * 3.0 = " + value);
		System.out.println();

		value =  1;
		value = value/3;
		value = value/3;
		System.out.println("1/3.0/3.0  = " + value);
		value =  value * 9 ;
		System.out.println("(1/3.0/3.0) * 9  = " + value);
		System.out.println();

		value = 1;
		value = value/3;
		value = value/3;
		value = value/3;
		value = value*Math.sqrt(3.0);
		value = value*Math.sqrt(3.0);
		System.out.println("value (1/(3*3*3) * sqrt(3) * sqrt(3) = " + value);
		value = value * 9;
		System.out.println("value * 9 (we expect it to be 1 but it isn't) = " + value);

		double x = 5.44;
		double y = 6.77;
		double z = y - x;

		System.out.println("x = " + x);
		System.out.println("y = " + y);
		System.out.println("z = y - x = " + z);
		System.out.println("z * 100 = " + (z * 100));
		System.out.println("(int) z = " + ((int) (z * 100)));
		System.out.println("Math.round(z) = " + (Math.round(z * 100)));
		System.out.println("re-z = " + ((Math.round(z * 100))/100.0));

	}
}
