/**
 * StringComparisons.java demonstrates how different string comparisons work
 * 
 * @author sfrost
 *
 */
public class StringComparisons {
	public static void main(String[] args) {
		String string1 = "Broncos";
		String string2 = "broncos";
		String string3 = string2;

		int result1, result2;
		boolean result3, result4, result5, result6, result7;
		
		result1 = string1.compareTo(string2);
		result2 = string1.compareToIgnoreCase(string2);
		result3 = string1.equals(string2);
		result4 = string1.equalsIgnoreCase(string2);
		result5 = string1==string2;
		result6 = string2==string3;
		
		System.out.println("string1 = " + string1 + ", string2 = " + string2
				+ ", string3 = " + string3);
		System.out.println("string1.compareTo(string2): " + result1);
		System.out.println("string1.compareToIgnoreCase(string2): " + result2);
		System.out.println("string1.equals(string2): " + result3);
		System.out.println("string1.equalsIgnoreCase(string2): " + result4);
		System.out.println("string1 == string2: " + result5);
		System.out.println("string2 == string3: " + result6);

		
		/*
		 * Notice that compareTo returns an int.  A negative number means the argument string
		 * comes AFTER the original string object (e.g. in this case string2 comes after string1)
		 * The equalsTo methods return a boolean value - true or false.  True means the strings have
		 * the same value.  False means the strings have different values.
		 * Result5 would return true only if the two values were aliases for the same object as in result6.
		 */
	}
	
}
