import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Color;

/**
 * Demonstrates basic drawing methods from Graphics class
 * @author mvail, amit
 */
@SuppressWarnings("serial")
public class BasicShapes extends JPanel
{
	public void paintComponent(Graphics page)
	{
		page.drawRect(50, 50, 40, 40);    // square
		page.drawRect(60, 80, 225, 30);   // rectangle
		page.drawOval(75, 65, 20, 20);    // circle
		page.drawLine(35, 60, 100, 120);  // line

		page.drawString("I read poetry to save time.", 110, 70);
		page.drawString("--Marilyn Monroe", 130, 100);
	}


	/**
	 * Constructor (panel initialization)
	 */
	public BasicShapes() {
		this.setBackground(Color.white);
		this.setPreferredSize(new Dimension(450,175));
	}


	/**
	 * sets up a JFrame and the BasicShapes panel
	 * @param args unused
	 */
	public static void main(String[] args) {
		JFrame frame = new JFrame("BasicShapes");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().add(new BasicShapes());
		frame.pack();
		frame.setVisible(true);
	}
}
