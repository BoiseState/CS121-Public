import javax.swing.JFrame;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import javax.swing.JPanel;

/**
 * Demonstrates the use of 2-D arrays to represent a grid.
 *
 * @author CS121 Instructors
 *
 */
public class CheckerBoard extends JPanel
{
	private static final int MIN_DIM = 4;
	private int dimension;
	private Color[][] colors;

	/**
	 * Sets up the checker board panel.
	 */
	public CheckerBoard(int dimension)
	{
		this.dimension = dimension;
		this.colors = getBoardColors();

		setBackground(Color.lightGray);
		setPreferredSize(new Dimension(500, 500));
	}

	/* (non-Javadoc)
	 * @see javax.swing.JComponent#paintComponent(java.awt.Graphics)
	 */
	public void paintComponent(Graphics page)
	{
		super.paintComponent(page);

		int x = 0, y = 0;

		int width = getWidth();
		int height = getHeight();

		int boxWidth = width/colors.length; // assumes it is a square
		int boxHeight = height/colors.length;

		for (int row = 0; row < colors.length; row++)
		{
			for (int col = 0; col < colors[row].length; col++)
			{
				page.setColor(colors[row][col]);
				page.fillRect(x, y, boxWidth, boxHeight);
				x += boxWidth;
			}
			x = 0;
			y += boxHeight;
		}
	}

	public Color[][] getBoardColors()
	{
		Color[][] board = new Color[dimension][dimension];
		for (int row = 0; row < board.length; row++)
		{
			for (int col = 0; col < board[row].length; col++)
			{
				if(row % 2 == col % 2)
				{
					board[row][col] = Color.RED;
				}
				else
				{
					board[row][col] = Color.BLACK;
				}
			}
		}
		return board;
	}

	/**
	 * Creates the main frame of the program.
	 * @param args
	 */
	public static void main(String[] args)
	{
		if(args.length != 1)
		{
			System.out.println("Usage: CheckerBoard <dimension>");
			System.exit(1);
		}

		int dimension = 0;
		try
		{
			dimension = Integer.parseInt(args[0]);
			if(dimension < CheckerBoard.MIN_DIM)
			{
				System.out.println("Dimension must be larger than " + CheckerBoard.MIN_DIM);
				System.exit(1);
			}
		}
		catch (NumberFormatException e)
		{
			System.out.println("Invalid dimension: " + args[0]);
			System.exit(1);
		}

		JFrame frame = new JFrame("Board");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		CheckerBoard panel = new CheckerBoard(dimension);
		frame.getContentPane().add(panel);
		frame.pack();
		frame.setVisible(true);
	}
}
