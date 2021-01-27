import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;

import javax.swing.JFrame;
import javax.swing.JPanel;

/**
 * Demonstrates changing line thickness for drawing with the Graphics2D class.
 * @author original unknown, converted to GUI by mvail
 */
@SuppressWarnings("serial")
public class Strokes extends JPanel
{
	/**
	 * Draw with different line thicknesses
	 * @param page object on which to paint
	 */
	public void paintComponent(Graphics page)
	{
		//clear panel (instead of calling fillRect...)
		super.paintComponent(page);

		//"cast" Graphics reference to Graphics2D to access setStroke() functionality
		Graphics2D g2d = (Graphics2D) page;

		//draw
		g2d.setColor(new Color(255, 0, 255));
		g2d.drawLine(25, 125, 125, 25);

		g2d.setColor(new Color(204, 0, 204));
		g2d.setStroke(new BasicStroke(4));
		g2d.drawLine(25, 225, 225, 25);

		g2d.setColor(new Color(153, 0, 153));
		g2d.setStroke(new BasicStroke(8, BasicStroke.CAP_ROUND, BasicStroke.JOIN_ROUND));
		g2d.drawLine(25, 325, 325, 25);

		g2d.setColor(new Color(102, 0, 102));
		g2d.setStroke(new BasicStroke(12, BasicStroke.CAP_BUTT, BasicStroke.JOIN_ROUND));
		g2d.drawLine(125, 325, 325, 125);

		g2d.setColor(new Color(51, 0, 51));
		g2d.setStroke(new BasicStroke(10));
		g2d.drawLine(225, 325, 325, 225);
	}


	/**
	 * Constructor (panel initialization)
	 */
	public Strokes()
	{
		setBackground(Color.black);
		setPreferredSize(new Dimension(400, 400));
	}


	/**
	 * Starting point for Strokes application.
	 * @param args unused
	 */
	public static void main(String[] args)
	{
		JFrame frame = new JFrame("Strokes");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().add(new Strokes());
		frame.pack();
		frame.setVisible(true);
	}

}
