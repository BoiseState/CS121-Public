import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Polygon;
import java.awt.Color;

/**
 * Illustrates various methods for drawing geometric shapes from the Graphics class.
 * @author amit
 */
@SuppressWarnings("serial")
public class Shapes extends JPanel
{
	public void paintComponent(Graphics page)
	{
		page.setColor(Color.blue);
		page.drawOval(10, 10, 100, 100);
		page.drawRect(25, 25, 75, 125);
		page.drawLine(0, 0, 200, 200);
		page.drawArc(50, 50, 200, 200, 315, 45);
		
		Polygon p = new Polygon();
		//points get connected in the order we add them!
		p.addPoint(50, 200);
		p.addPoint(150, 200);
		p.addPoint(180, 300);
		p.addPoint(20, 300);
		
		page.drawPolygon(p);

		page.setColor(Color.red);
		page.drawString("The Shapes Application", 200, 400);
		page.drawString("Out of clutter, find simplicity.", 130, 70);
		page.drawString("-- Albert Einstein", 130, 100);

		page.setColor(Color.orange);
		page.fillOval(110, 110, 50, 50);
		page.fillRect(225, 225, 75, 125);
		page.fillArc(200, 200, 250, 250, 315, 45);
		
		p = new Polygon();
		//points get connected in the order we add them!
		p.addPoint(350, 200);
		p.addPoint(450, 200);
		p.addPoint(480, 300);
		p.addPoint(320, 300);
		page.fillPolygon(p);
		
	}

	/**
	 * Constructor: panel initialization
	 */
	public Shapes()
	{
		setBackground(Color.white);
		setPreferredSize(new Dimension(500, 500));
	}


	/**
	 * Starting point for Shapes application.
	 * @param args unused
	 */
	public static void main(String[] args)
	{
		JFrame frame = new JFrame("Shapes");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().add(new Shapes());
		frame.pack();
		frame.setVisible(true);
	}
}
