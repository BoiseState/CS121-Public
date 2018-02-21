/**
 * This demonstrates overflow on an int.
 * @author amit
 */
public class TestInt
{
	public static void main(String[] args)
	{
		int i = 0;

		final int INCREMENT = 1000;
		for(;;) {
			i += INCREMENT;
			System.out.print(i);
			System.out.print("\r");
			if(i < 0) {
				System.out.println("i has wrapped around!" + i);
				break;
			}
		}

		for(;;) {
			i += INCREMENT;
			System.out.print(i);
			System.out.print("\r");
			if(i > 0) {
				System.out.println("i is back to positive!" + i);
				break;
			}
		}
	}
}
