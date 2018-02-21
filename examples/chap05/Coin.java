import java.util.Random;

/**
 * Represents a coin with two sides that can be flipped. 
 * @author Lewis/Loftus/Amit
 */
public class Coin
{
	private final int HEADS = 0;
	private final int TAILS = 1;
	private Random rand = new Random();

	private int face;

	/**
	 * Sets up the coin by flipping it initially.
	 */
	public Coin()
	{
		flip();
	}

	/**
	 * Flips the coin by randomly choosing a face value.
	 */
	public void flip()
	{
		face = rand.nextInt(2); // 0 or 1 with equal probability
	}

	/**
	 * Returns true if the current face of the coin is heads.
	 */
	public boolean isHeads()
	{
		return (face == HEADS);
	}

	/**
	 * Returns the current face of the coin as a string.
	 */
	public String toString()
	{
		String faceName;

		if (face == HEADS)
			faceName = "Heads";
		else
			faceName = "Tails";

		return faceName;
	}
}
