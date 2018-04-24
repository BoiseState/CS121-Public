/**
 * Lesson 21: Activity - Deck of Cards
 * 
 * An interface for a deck of cards.
 * 
 * @author CS121 Instructors
 * @version Fall 2018
 */
public interface DeckOfCardsInterface
{
    /**
     * Shuffles the deck. After this method is called, each call to the
     * draw() method will return a random card.
     */
    public void shuffle();

    /**
     * Draws and returns the next undealt Card in the deck.
     *
     * Once a card has been drawn, it is no longer in the deck and can't be
     * drawn again. After 52 calls to draw() the deck will be empty and the
     * method will return null.
     *
     * @return The next Card from the deck, or <code>null</code> if the deck is empty.
     */
    public Card draw();

    /**
     * Returns the number of cards remaining in the deck.
     * @return the number of cards.
     */
    public int numCardsRemaining();

    /**
     * Returns the number of cards dealt.
     * @return the number of cards.
     */
    public int numCardsDealt();

    /**
     * Returns the collection of all cards that have been dealt so far.
     *
     * @return an array containing the dealt cards. The array will be empty
     * if no cards have been dealt.
     */
    public Card[] dealtCards();

    /**
     * Returns the collection of all cards still in the deck.
     *
     * @return an array containing the cards. The array will be empty if
     * no cards are left in the deck.
     */
    public Card[] remainingCards();

    @Override
    public String toString();
}
