/**
 * Demonstrates how and when to use overloaded methods.
 * 
 * @author marissa
 *
 */
public class MethodOverloader
{	
	private String fanciness;
	
	/**
	 * Creates a new MethodOverloader object.
	 */
	public MethodOverloader()
	{
		this.fanciness = "**~~";
	}
	
	/**
	 * Creates a new MethodOverloader object. (Overloaded constructor)
	 * @param fanciness The string used when printing fancily
	 */
	public MethodOverloader(String fanciness)
	{
		this.fanciness = fanciness;
	}
	
	//---------------------------------------------------
	// Clunky versions.                              
	//---------------------------------------------------
	/**
	 * Prints a fancy integer.
	 * @param i
	 */
	public void fancyPrintInt(int i)
	{
		System.out.println(fanciness + i + new StringBuilder(fanciness).reverse().toString());
	}
	
	/**
	 * Prints a fancy string.
	 * @param s
	 */
	public void fancyPrintString(String s)
	{
		System.out.println(fanciness + s + new StringBuilder(fanciness).reverse().toString());
	}
	
	/**
	 * Prints a fancy double.
	 * @param d
	 */
	public void fancyPrintDouble(double d)
	{
		System.out.println(fanciness + d + new StringBuilder(fanciness).reverse().toString());
	}
	
	/**
	 * Prints a fancy double and int.
	 * @param d
	 * @param i
	 */
	public void fancyPrintDoubleAndInt(double d, int i)
	{
		System.out.println(fanciness + d + " " + i  + new StringBuilder(fanciness).reverse().toString());
	}
	
	//----------------------------------------------------------------
	// Overloaded versions. When we are tired of typing the parameter
	//  types as part of our method names because we don't have to.
	//----------------------------------------------------------------
	/**
	 * Prints a fancy int.
	 * @param i
	 */
	public void fancyPrint(int i)
	{
		System.out.println(fanciness + i + new StringBuilder(fanciness).reverse().toString());
	}
	
	/**
	 * Prints a fancy String.
	 * @param s
	 */
	public void fancyPrint(String s)
	{
		System.out.println(fanciness + s + new StringBuilder(fanciness).reverse().toString());
	}
	
	/**
	 * Prints a fancy double.
	 * @param d
	 */
	public void fancyPrint(double d)
	{
		System.out.println(fanciness + d + new StringBuilder(fanciness).reverse().toString());
	}
	
	/**
	 * Prints a fancy double and int.
	 * @param d
	 * @param i
	 */
	public void fancyPrint(double d, int i)
	{
		System.out.println(fanciness + d + " " + i  + new StringBuilder(fanciness).reverse().toString());
	}
	
	//-------------------------------------------------------------------
	// Another example of overloading. When we want to do the same thing,
	// but with an optional argument
	//-------------------------------------------------------------------
	/**
	 * Prints a fancy string.
	 * @param s the strin to print.
	 * @param caps true if it should be all caps, false otherwise.
	 */
	public void fancyPrint(String s, boolean caps)
	{
		if(caps) {
			s = s.toUpperCase();
		}
		// reuse the method we already wrote.
		fancyPrint(s);
	}
	
	
	//-------------------------------------------------------------------
	// Another example of overloading. When we want to do the same thing,
	// but with an more arguments.
	//-------------------------------------------------------------------
	/**
	 * Sums two ints and returns result.
	 * @param i
	 * @param j
	 * @return
	 */
	public int sum(int i, int j)
	{
		return i + j;
	}
	
	/**
	 * Sums three ints and returns the result.
	 * @param i
	 * @param j
	 * @param k
	 * @return
	 */
	public int sum(int i, int j, int k)
	{
		return i + j+ k;
	}
	
	/**
	 * Demonstrates usage.
	 * @param args
	 */
	public static void main(String[] args)
	{
		MethodOverloader prettyFancy = new MethodOverloader();
		
		// using "clunky" methods
		prettyFancy.fancyPrintInt(10);
		prettyFancy.fancyPrintString("I'm so fancy");
		prettyFancy.fancyPrintDouble(10.0);
		prettyFancy.fancyPrintDoubleAndInt(10.0, 50);
		
		// using overloaded method
		prettyFancy.fancyPrint(10);
		prettyFancy.fancyPrint("I'm so fancy");
		prettyFancy.fancyPrint(10.0);
		prettyFancy.fancyPrint(10.0, 50);
		
		// using overloaded constructor to change "fanciness"
		MethodOverloader fancier = new MethodOverloader("**.~~*.~");
		fancier.fancyPrint(10);
		fancier.fancyPrint("I'm so fancy");
		fancier.fancyPrint(10.0);
		fancier.fancyPrint(10.0, 50);
		
		fancier.fancyPrint("I'm so fancy", true); // all upper-case
		
	}
}
