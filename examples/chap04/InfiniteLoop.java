import java.util.Random;

/**
 * Demonstrate an ostensibly useful infinite loop. 
 * Simulates a crying baby :-)
 * 
 * @author amit
*/
public class InfiniteLoop
{
	
	public static void main (String[] args) throws InterruptedException 
	{
		final int MAX = 80;
		final int THRESHOLD = 60;
		Random generator = new Random();

		//for (int j = 0; j < 1000; j++) {
		while (true) {
			int count = generator.nextInt(MAX) + 1;
			if (count > THRESHOLD) {
				//System.out.println(count);
				Thread.sleep(1000); //milliseconds
			}

			System.out.print("bw");
			int i = 0;
			while (i < count) {
				System.out.print("a");
				i++;
			}
			System.out.print("h...");
			System.out.println();
		}
	}
}
