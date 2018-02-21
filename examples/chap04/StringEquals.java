/**
 * Demonstrate equals versus == for objects.
 * 
 * @author amit
 */
public class StringEquals
{
	public static void main(String[] args)
	{
		String s1 = "hello";
		String s2 = new String("hello");

		if (s1 == s2)
			System.out.println("Using ==  hello is hello");
		else
			System.out.println("Using ==  hello is not hello!");

		if (s1.equals(s2))
			System.out.println("Using equals  hello is hello");
		else
			System.out.println("Using equals  hello is not hello!");
		
		if(s1.compareTo(s2) == 0)
		{
			System.out.println(s1 + " equals " + s2);
		}
		else if(s1.compareTo(s2) < 0)
		{
			System.out.println(s1 + " less than " + s2);
		}
		else if(s1.compareTo(s2) > 0)
		{
			System.out.println(s1 + " greater than " + s2);
		}
		
	}
}
