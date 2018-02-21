
/**
 * Shows how to write a method that can swap two array references.
 * @author amit
 *
 */
public class ArraySwap {

	private class Array {
		private int[] array;
	}
	
	public void swap(Array a1, Array a2) {
		int[] tmp = a1.array; a1.array = a2.array; a2.array = tmp; 
	}	
	/**
	 * @param args
	 */
	public static void main(String[] args) {

		ArraySwap test = new ArraySwap();
		Array a1 = test.new Array();
		Array a2 = test.new Array();
		
		a1.array = new int[10];	
		for (int i = 0; i < a1.array.length; i++)
			a1.array[i] = 1;
		
		a2.array = new int[20];
		for (int i = 0; i < a2.array.length; i++)
			a2.array[i] = 2;
		
		System.out.println("Before swap: a1.array.length = " + a1.array.length);
		System.out.println("Before swap: a2.array.length = " + a2.array.length);
		
		test.swap(a1, a2);
		
		System.out.println("After swap: a1.array.length = " + a1.array.length);
		System.out.println("After swap: a2.array.length = " + a2.array.length);
	}
}
