import java.util.Random;
/**
 * Uses the Random class to "roll" 2 dice.
 *
 * @author CS121 Instructors
 */
public class RollTheDice
{
	public static void main(String[] args)
	{
		Random generator = new Random(1234);

		int roll1 = generator.nextInt(6) + 1;
		int roll2 = generator.nextInt(6) + 1;

		System.out.println("Roll1: " + roll1);
		System.out.println("Roll2: " + roll2);
	}

}
