import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.*;

/**
 * Draws a pig to demonstrate drawing methods and use of color.
 * @author marissa
 */
@SuppressWarnings("serial")
public class Pig extends JPanel
{
	/**
	 * @param page object on which drawing takes place
	 */
	public void paintComponent(Graphics page)
	{
		int width = getWidth();
		int height = getHeight();

		int xOffset = 200;
		int yOffset = height/3;

		final Color GROUND_COLOR = new Color(120, 63, 4);
		final Color PIG_COLOR = new Color(252, 229, 205);
		final Color EYE_COLOR = new Color(182, 215, 168);

		// ground
		page.setColor(GROUND_COLOR);
		page.fillRect(0, 280, width, height - 280);

		// pig
		page.setColor(PIG_COLOR);
		page.fillOval(xOffset + 60, 80, 220, 160); // body
		page.setColor(Color.black);
		page.drawOval(xOffset + 60, 80, 220, 160); // body outline

		page.setColor(PIG_COLOR);
		page.fillRect(xOffset + 100, 220, 40, 60);  // leg 1
		page.setColor(Color.black);
		page.drawRect(xOffset + 100, 220, 40, 60);  // leg 1 outline

		page.setColor(PIG_COLOR);
		page.fillRect(xOffset + 200, 220, 40, 60); // leg 2
		page.setColor(Color.black);
		page.drawRect(xOffset + 200, 220, 40, 60); // leg 2 outline

		page.setColor(PIG_COLOR);
		page.fillRect(xOffset + 300, 80, 40, 40); // snout
		page.setColor(Color.black);
		page.drawRect(xOffset + 300, 80, 40, 40); // snout outline

		page.setColor(PIG_COLOR);
		page.fillOval(xOffset + 220, 40, 100, 120); // head
		page.setColor(Color.black);
		page.drawOval(xOffset + 220, 40, 100, 120); // head outline

		page.setColor(PIG_COLOR);
		page.fillOval(xOffset + 240, 40, 40, 80); // ear
		page.setColor(Color.black);
		page.drawOval(xOffset + 240, 40, 40, 80); // ear outline

		page.setColor(EYE_COLOR);
		page.fillOval(xOffset + 280, 60, 20, 20);

		page.setColor(Color.black);
		page.drawLine(xOffset + 20, 240, xOffset + 60, 160);  // tail
		page.drawArc(xOffset + 280, 80, 80, 80, 200, 35);   // smile

		page.drawString("Oink, oink!", xOffset + 340, 140);
	}


	/**
	 * Constructor(panel initialization)
	 */
	public Pig()
	{
		setPreferredSize(new Dimension(600, 400));
	}


	/**
	 * Starting point for Pig application.
	 * @param args unused
	 */
	public static void main(String[] args)
	{
		JFrame frame = new JFrame("Pig");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().add(new Pig());
		frame.pack();
		frame.setVisible(true);
	}
}
