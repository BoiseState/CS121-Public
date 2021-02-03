import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.*;

/**
 * Draws a snowman to demonstrate drawing methods and use of color.
 * @author Java Foundations, converted to GUI by mvail
 */
@SuppressWarnings("serial")
public class Snowman extends JPanel
{
   	/**
   	 * @param page object on which drawing takes place
   	 */
   	public void paintComponent(Graphics page)
	{
		int mid = 300;
		final int TOP = 100;
		final Color GROUND_COLOR = new Color(127, 0, 64);
		
		mid = mid  - 20;
		
		int pageWidth = getWidth();
		int pageHeight = getHeight();

		page.setColor(Color.CYAN);
		page.fillRect(0, 0, pageWidth, pageHeight);

		page.setColor(GROUND_COLOR);
		page.fillRect(0, 350, 600, 100);  // ground

		page.setColor(Color.yellow);
		page.fillOval(pageWidth - 80, -80, 160, 160); // sun

		page.setColor(Color.white);
		page.fillOval(mid - 40, TOP, 80, 80);      // head
		page.fillOval(mid - 70, TOP + 70, 140, 100);   // upper torso
		page.fillOval(mid - 100, TOP + 160, 200, 120);  // lower torso

		page.setColor(Color.black);
		page.fillOval(mid - 20, TOP + 20, 10, 10);   // left eye
		page.fillOval(mid + 10, TOP + 20, 10, 10);    // right eye

		page.drawArc(mid - 20, TOP + 40, 40, 20, 190, 160);   // smile

		page.drawLine(mid - 50, TOP + 120, mid - 100, TOP + 80);  // left arm
		page.drawLine(mid + 50, TOP + 120, mid + 110, TOP + 120);  // right arm

		page.drawLine(mid - 40, TOP + 10, mid + 40, TOP + 10);  // brim of hat
		page.fillRect(mid - 30, TOP - 40, 60, 50);        // top of hat
		
		page.drawString("Tauros", 20, 20);
   	}


	/**
	 * Constructor(panel initialization)
	 */
	public Snowman()
	{
		setPreferredSize(new Dimension(600, 400));
	}


	/**
	 * Starting point for Snowman application.
	 * @param args unused
	 */
	public static void main(String[] args)
	{
		JFrame frame = new JFrame("Snowman");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().add(new Snowman());
		frame.pack();
		frame.setVisible(true);
	}
}
