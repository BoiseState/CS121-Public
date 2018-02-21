/**
 * Demonstrates enum for directions.
 * @author marissa
 */
public class Navigator
{
	public enum Direction { NORTH, SOUTH, EAST, WEST }

	private int x, y;
	private Direction currentHeading;

	/**
	 * Creates a new instance at point 0, 0 heading due east.
	 */
	public Navigator()
	{
		x = 0;
		y = 0;
		currentHeading = Direction.EAST;
	}

	/**
	 * Moves the given distance.
	 * NOTE: This is a VERY basic demonstration. No bounds checking.
	 * or parameter validation.*
	 * @param distance the distance to move
	 */
	public void move(int distance)
	{
		switch(currentHeading) {
			case NORTH:
				System.out.println("Up we go!");
				y -= distance;
				break;
			case EAST:
				System.out.println("To the east we go.");
				x += distance;
				break;
			case SOUTH:
				System.out.println("It's all down from here.");
				y += distance;
				break;
			case WEST:
				System.out.println("To the west we go.");
				x -= distance;
				break;
			default:
				System.out.println("Are we lost?");
		}
	}

	/**
	 * Updates the current direction.
	 * @param direction the direction to turn.
	 */
	public void turn(Direction direction) {
		this.currentHeading = direction;
	}

	/**
	 * @param args (unused)
	 */
	public static void main(String[] args)
	{
		Navigator navigator = new Navigator();

		navigator.turn(Direction.SOUTH);
		navigator.move(5);

		navigator.turn(Direction.EAST);
		navigator.move(10);
	}

}
