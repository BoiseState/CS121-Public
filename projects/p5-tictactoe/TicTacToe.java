import java.awt.Point;

/**
 * Interface defining the TicTacToe game model.
 * 
 * @author mvail
 */
public interface TicTacToe {
	public static enum Player {X, O, OPEN};
	public static enum Winner {X, O, TIE, IN_PROGRESS};
	
	/**
	 * Reset the game. It is the player's turn.
	 */
	public void newGame();
	
	/**
	 * Return true if either player X or O has achieved
	 * 3-in-a-row, whether vertically, horizontally, or diagonally,
	 * or if all positions have been claimed without a winner.
	 * 
	 * @return true if the game is over, else false
	 */
	public boolean gameOver();
	
	/**
	 * Return the Winner (X, O, or TIE) if the game is over, or
	 * IN_PROGRESS if the game is not over.
	 * 
	 * @return the winner of a completed game or IN_PROGRESS
	 */
	public Winner winner();
	
	/**
	 * Get the current game board with each position marked as
	 * belonging to X, O, or OPEN.
	 * Preserve encapsulation by returning a copy of the original data.
	 * 
	 * @return array showing the current game board
	 */
	public Player[][] getGameGrid();
	
	/**
	 * Get the sequence of moves, where even indexes correspond to the
	 * first player's moves and odd indexes correspond to the second
	 * player's moves.
	 * NOTE: Move rows are stored in the first coordinate, x, and move
	 * columns are stored in the second coordinate, y.
	 * Preserve encapsulation by returning a copy of the original data.
	 * 
	 * @return array showing the sequence of claimed positions
	 */
	public Point[] getMoves();
	
	/**
	 * If the move is invalid for any reason, return false.
	 * Cannot claim any position when the game is over or the
	 * position has already been claimed.
	 * If the chosen row, column position is not already claimed
	 * and the game is not already over, claim it for the player.
	 * 
	 * @param player either Player.X or Player.O
	 * @param row value from 0 to 2
	 * @param col value from 0 to 2
	 * @return true if the choice was a valid move, else false
	 */
	public boolean choose(Player player, int row, int col);
}
