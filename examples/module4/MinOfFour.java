import java.util.Scanner;

/**
 *  Demonstrates uses of if-else statements and ? ternary if-else operator via the problem of 
 *  min of four integers. All of the methods to compute the min of four only do three comparisons each.
 *  
 *  @author amit
*/

public class MinOfFour {

	/**
	 * @param n1
	 * @param n2
	 * @param n3
	 * @param n4
	 * @return
	 */
	public static int minA(int n1, int n2, int n3, int n4) 
	{
		int min1, min2, min;

		if (n1 < n2) 
			min1 = n1;
		else 
			min1 = n2;

		if (n3 < n4) 
			min2 = n3;
		else 
			min2 = n4;

		if (min1 < min2) 
			min = min1;
		else 
			min = min2;

		return min;
	}

	/**
	 * @param n1
	 * @param n2
	 * @param n3
	 * @param n4
	 * @return
	 */
	public static int minB(int n1, int n2, int n3, int n4) 
	{
		int min1, min2, min;

		min1 = (n1 < n2) ? n1: n2;
		min2 = (n3 < n4) ? n3: n4;
		min = (min1 < min2) ? min1: min2;
		return min;
	}

	/**
	 * @param n1
	 * @param n2
	 * @param n3
	 * @param n4
	 * @return
	 */
	public static int minC(int n1, int n2, int n3, int n4) 
	{
		int min1, min2;
		min1 = (n1 < n2)? n1: n2;
		min2 = (n3 < n4) ? n3: n4;
		return (min1 < min2) ? min1: min2;
	}


	/**
	 * @param n1
	 * @param n2
	 * @param n3
	 * @param n4
	 * @return
	 */
	public static int minD(int n1, int n2, int n3, int n4) 
	{
		int min1, min2;
		return ((min1 = (n1 < n2)? n1: n2) <  (min2 = (n3 < n4) ? n3: n4)) ? min1: min2;
	}

	/**
	 * @param n1
	 * @param n2
	 * @param n3
	 * @param n4
	 * @return
	 */
	public static int minE(int n1, int n2, int n3, int n4)
	{
		int min;

		if (n1 < n2) 
			if (n3 < n4)
				if (n1 < n3)
					min = n1;
				else
					min = n3;
			else if (n1 < n4)
					min = n1;
				else
					min = n4;
		else if (n3 < n4)
				if (n2 < n3)
					min = n2;
				else 
					min = n3;
			else if (n2 < n4)
					min = n2;
				else
					min = n4;

		return min;
	}


	/**
	 * @param n1
	 * @param n2
	 * @param n3
	 * @param n4
	 * @return
	 */
	public static int minF(int n1, int n2, int n3, int n4)
	{
		if (n1 < n2) 
			if (n3 < n4)
				if (n1 < n3)
					return n1;
				else
					return n3;
			else if (n1 < n4)
					return n1;
				else
					return n4;
		else if (n3 < n4)
				if (n2 < n3)
					return n2;
				else 
					return n3;
			else if (n2 < n4)
					return n2;
				else
					return n4;
	}



	/**
	 * Read four input values, compute the min various ways and print results.
	 * @param args
	 */
	public static void main(String [] args)
	{
		Scanner input = new Scanner(System.in);

		System.out.print("Enter four integers: ");
		int num1 = input.nextInt();
		int num2 = input.nextInt();
		int num3 = input.nextInt();
		int num4 = input.nextInt();
		
		input.close();

		System.out.println("minA: " + MinOfFour.minA(num1, num2, num3, num4));
		System.out.println("minB: " + MinOfFour.minB(num1, num2, num3, num4));
		System.out.println("minC: " + MinOfFour.minC(num1, num2, num3, num4));
		System.out.println("minD: " + MinOfFour.minD(num1, num2, num3, num4));
		System.out.println("minE: " + MinOfFour.minE(num1, num2, num3, num4));
		System.out.println("minF: " + MinOfFour.minF(num1, num2, num3, num4));
		System.out.println("Math.min: " + Math.min(Math.min(num1, num2), Math.min(num3, num4)));
	}
}
