import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Color;

/**
 *
 * Programming Project F.7: Draws a pie chart with eight equal slices, all
 * colored differently.
 * @author amit, mvail
 *
 */
@SuppressWarnings("serial")
public class DrawPieChart extends JPanel
{
	public void paintComponent (Graphics page)
	{
		page.setColor(Color.blue);
		page.fillArc(0,0,100,100,0,45);

		page.setColor(Color.yellow);
		page.fillArc(0,0,100,100,45,45);

		page.setColor(Color.green);
		page.fillArc(0,0,100,100,90,45);

		page.setColor(Color.red);
		page.fillArc(0,0,100,100,135,45);

		page.setColor(Color.orange);
		page.fillArc(0,0,100,100,180,45);

		page.setColor(Color.lightGray);
		page.fillArc(0,0,100,100,225,45);

		page.setColor(Color.cyan);
		page.fillArc(0,0,100,100,270,45);

		page.setColor(Color.pink);
		page.fillArc(0,0,100,100,315,45);
	}


	/**
	 * Constructor (panel initialization)
	 */
	public DrawPieChart()
	{
		this.setBackground(Color.white);
		this.setPreferredSize(new Dimension(150,150));
	}


	/**
	 * sets up the JFrame and the panel
	 * @param args unused
	 */
	public static void main(String[] args)
	{
		JFrame frame = new JFrame("Pie Chart");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().add(new DrawPieChart());
		frame.pack();
		frame.setVisible(true);
	}
}
