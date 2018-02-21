/**
 * Represent a card as a suit and rank within the suit.
 * @author amit
 *
 */
public class Card
{
	private Suit suit;
	private Rank rank;

	/**
	 * Construct a card with given suit and rank.
	 * @param suit
	 * @param rank
	 */
	public Card(Suit suit, Rank rank)
	{
		this.suit = suit;
		this.rank = rank;
	}

	/**
	 * Build a card using an index in the range 0..51 using standard
	 * card ordering: Clubs, Diamonds, Hearts, Spades
	 * and Ace, 2, 3, 10, Jack, Queen, King.
	 * @param index
	 */
	public Card(int index) {
		suit = Suit.values()[index/Rank.values().length];
		rank = Rank.values()[index%Rank.values().length];
	}

	/**
	 * @return the suit
	 */
	public Suit getSuit()
	{
		return suit;
	}

	/**
	 * @return the rank
	 */
	public Rank getRank()
	{
		return rank;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString()
	{
		return  String.format("%18s", rank + " of " + suit);
	}
}
