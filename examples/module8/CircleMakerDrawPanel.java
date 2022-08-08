import java.awt.*;

import javax.swing.*;

/**
 * JPanel where Circles are painted. Colors the largest
 * Circle red and all others blue.
 * This class is the "View" in the CircleMaker program's
 * Model-View-Controller design.
 * @author mvail
 */
@SuppressWarnings("serial")
public class CircleMakerDrawPanel extends JPanel
{
	private static final Color DEFAULT_FILL_COLOR = Color.blue;
	private static final Color BIGGEST_FILL_COLOR = Color.red;
	
	private Circle[] circles = new Circle[0];
	
	/**
	 * Extended JPanel paint() to generate and draw circles
	 */
	public void paintComponent(Graphics g)
	{	
		Graphics2D canvas = (Graphics2D) g;
		setBackground(Color.black);
		super.paintComponent(canvas);
		
		int biggest = findBiggestCircle();
		drawCircles(canvas, biggest);
	}
	

	/**
	 * Draw the circles in blue, with the biggest one in red.
	 * @param canvas the graphics object to draw on
	 * @param biggest index of the bggest circle
	 */
	private void drawCircles(Graphics2D canvas, int biggest) 
	{
		final int STROKE_WIDTH = 2;
		canvas.setStroke(new BasicStroke(STROKE_WIDTH));
		
		for (int i = 0; i < circles.length; i++)
		{
			if (i == biggest) {
				canvas.setColor(BIGGEST_FILL_COLOR);
			} else {
				canvas.setColor(DEFAULT_FILL_COLOR);
			}
			//canvas.fillOval(circles[i].getXAnchor(), circles[i].getYAnchor(), 
			//		          circles[i].getDiameter(), circles[i].getDiameter());
			//canvas.setColor(DEFAULT_OUTLINE_COLOR);
			canvas.drawOval(circles[i].getXAnchor(), circles[i].getYAnchor(), 
					        circles[i].getDiameter(), circles[i].getDiameter());
		}			
	}


	/**
	 * Find the index of the biggest circle by diameter
	 * @return the index of the biggest circle
	 */
	private int findBiggestCircle() 
	{
		int biggest = 0;
		for (int i = 1; i < circles.length; i++) {
			if (circles[i].getDiameter() > circles[biggest].getDiameter()) {
				biggest = i;
			}
		}
		return biggest;
	}



	/**
	 * Update numCircles and call repaint()
	 * @param circles array of Circles to paint
	 */
	public void paintCircles(Circle[] circles)
	{
		this.circles = circles;
		repaint();
	}
}
