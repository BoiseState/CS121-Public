import java.util.Random;

/**
 * Demonstrates the creation of pseudo-random numbers using the Random class.
 *
 * @author CS121 Instructors
 */
public class DiceRoll
{
	/**
	 * Generates a random dice roll
	 */
	public static void main(String[] args)
	{
		final int SIDES = 6;

		// Try it with a seed:  new Random(12345);
		Random generator = new Random();

		int roll1 = generator.nextInt(SIDES)+1;
		int roll2 = generator.nextInt(SIDES)+1;

		System.out.println("Roll 1: " + roll1);
		System.out.println("Roll 2: " + roll2);
	}
}
