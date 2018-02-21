

/**
 * An example of passing an one-dimensional array as a parameter.
 * @author amit
 */
public class ArrayPassing
{

	/**
	 * Double each element of the passed array
	 * @param a
	 */
	private static void changeArray(int[] a)
	{
		for (int i = 0; i<a.length; i++)
			a[i] = 2*a[i];
	}

	/**
	 * @param args Not used
	 */
	public static void main(String[] args)
	{
		int[] X = new int[5];

		for (int i = 0; i<X.length; i++)
			X[i] = i+1;

		for (int i = 0; i<X.length; i++)
			System.out.print(X[i] + " ");
		System.out.println();

		changeArray(X);

		for (int i = 0; i<X.length; i++)
			System.out.print(X[i] + " ");
		System.out.println();
	}
}
