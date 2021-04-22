/**
 * Lessons 21: Activity
 * 
 * @author CS121 Instructors
 * @version Fall 2018
 */
public class Card implements Comparable<Card>
{
	private Suit suit;
	private Rank rank;

	/**
	 * Creates a new Card with the given Suit and Rank.
	 *
	 * @param suit Card's suit.
	 * @param rank Card's rank.
	 */
	public Card(Suit suit, Rank rank)
	{
		this.suit = suit;
		this.rank = rank;
	}

	/**
	 * Returns the suit of this card.
	 * @return the suit.
	 */
	public Suit getSuit()
	{
		return suit;
	}

	/**
	 * Returns the rank of this card.
	 * @return the rank.
	 */
	public Rank getRank()
	{
		return rank;
	}
	
	/**
	 * Returns the value of this card.
	 * @return the value.
	 */
	public int getValue()
	{
		return rank.getFaceValue();
	}

	/**
	 * Return relative rank of this Card as compared to other Card.
	 *
	 * @param other Card to compare to this Card for relative rank
	 * @return -1 if this Card is less than other Card, +1 if this Card is
	 *         greater than other Card, 0 if Card values are equal
	 */
	@Override
	public int compareTo(Card other)
	{
		if (this.getValue() < other.getValue()) {
			return -1;
		} else if (this.getValue() > other.getValue()) {
			return 1;
		}
		return 0;
	}
	
	@Override
	public String toString()
	{
		return rank + " of " + suit;
	}
}
