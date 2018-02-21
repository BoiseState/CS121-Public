import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.*;

/**
 * Draws a snowman to demonstrate drawing methods and use of color.
 * @author Java Foundations, converted to GUI by mvail
 */
@SuppressWarnings("serial")
public class SnowmanBigger extends JPanel
{
	/**
	 * @param page object on which drawing takes place
	 */
	public void paintComponent(Graphics page)
	{
		final int MID = 600;
		final int TOP = 200;

		page.setColor(Color.CYAN);
		page.fillRect(0, 0, getWidth(), getHeight());

		Color groundColor = new Color(127, 0, 64);

		page.setColor(groundColor);
		page.fillRect(0, 700, 1200, 200);  // ground

		page.setColor(Color.yellow);
		page.fillOval(-190, -190, 320, 320); // sun

		page.setColor(Color.white);
		page.fillOval(MID - 80, TOP, 160, 160);      // head
		page.fillOval(MID - 140, TOP + 140, 280, 200);   // upper torso
		page.fillOval(MID - 200, TOP + 320, 400, 240);  // lower torso

		page.setColor(Color.black);
		page.fillOval(MID - 40, TOP + 40, 20, 20);   // left eye
		page.fillOval(MID + 20, TOP + 40, 20, 20);    // right eye

		page.drawArc(MID - 40, TOP + 80, 80, 40, 190, 160);   // smile

		page.drawLine(MID - 100, TOP + 240, MID - 200, TOP + 160);  // left arm
		page.drawLine(MID + 100, TOP + 240, MID + 220, TOP + 240);  // right arm

		page.drawLine(MID - 80, TOP + 20, MID + 80, TOP + 20);  // brim of hat
		page.fillRect(MID - 60, TOP - 80, 120, 100);        // top of hat

		/* drawGridLines(page, 20); */
	}

	/**
	 * Draws grid lines for demo purposes.
	 * @param pixels number of pixes between each line.
	 */
	public void drawGridLines(Graphics page, int pixels)
	{
		Color gridColor = new Color(200, 200, 200, 200);
		page.setColor(gridColor);
		for(int i = 0; i < (getWidth()/pixels); i++) {
			page.drawLine(i*pixels, 0, i*pixels, getHeight());
		}
		for(int i = 0; i < (getHeight()/pixels); i++) {
			page.drawLine(0, i*pixels, getWidth(), i*pixels);
		}
	}

	/**
	 * Constructor(panel initialization)
	 */
	public SnowmanBigger()
	{
		setPreferredSize(new Dimension(1200, 800));
	}


	/**
	 * Starting point for SnowmanBigger application.
	 * @param args unused
	 */
	public static void main(String[] args)
	{
		JFrame frame = new JFrame("SnowmanBigger");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().add(new SnowmanBigger());
		frame.pack();
		frame.setVisible(true);
	}
}
