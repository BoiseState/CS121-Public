import java.awt.Point;

/**
 * Defines the methods that a snake should implement.
 * 
 * @author JERRYFAILS
 */
public interface SnakeInterface 
{

    public static enum Direction {Up, Down, Left, Right};
	
	public static final int DEFAULT_START_TAIL_LENGTH = 3;
	
	/**
	 * Returns (a copy of) the position of the current head of the snake.
	 * @return The point location where the head of the snake is.
	 */
	public Point getHead();
	
	/**
	 * Returns the location of the previous end of the snake.
	 * @return The location of the previous end of the snake.
	 */
	public Point getPreviousEnd();
	
	/**
	 * Returns an array with the current snake locations. The head should be the first point in the array, and the last point should be the end of the tail.
	 * @return An array with the current snake locations.
	 */
	public Point[] getSnake();
	
	/**
	 * The number of locations the snake has visited
	 * @return the number of locations the snake has visited
	 */
	public int getNumLocationsVisited();

	/**
	 * Moves the snake after changing the specified direction.
	 * @param direction The direction to change to
	 */
	public void changeDirection(Direction direction);

	/**
	 * Moves the snake one more spot based on the current direction.
	 * @return Returns the location of the new head position.
	 */
	public Point move();
	
	/**
	 * Moves the snake after changing the specified direction.
	 * @param direction The direction to change to
	 */
	public Point move(Direction direction);	
	
	
	/**
	 * Indicates whether a collision occurred or not.
	 * @return Whether the snake collided with itself.
	 */
	public boolean collisionOccurred();
	
    /**
     * Returns whether the game is over (a collision occurred or the current snake head is out of the bounds of the grid).
     * @param width  the width of the snake game
     * @param height the height of the snake game
     * @return Whether the game is over
     */
	public boolean isGameOver(int width, int height);
	
	/**
	 * Increases the length of the snake.
	 */
	public void increaseLength();
	
	
	/**
     * A string representing all the points in the current snake.
     * @return a string representation of where the snake is.
     */
    public String toString();
}
