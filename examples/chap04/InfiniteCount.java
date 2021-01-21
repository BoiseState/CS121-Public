/**
 * Decrements a counter forever.
 * @author amit
 *
 */
public class InfiniteCount
{

	/**
	 * @param args
	 */
	public static void main(String[] args)
	{
		int count = 1;
		while (true) {
			if (count % 10000 == 0) System.out.println(count);
			count++;
		}
		//System.out.println(count);
	}

}
