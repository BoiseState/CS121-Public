import javax.swing.JFrame;
import javax.swing.JPanel;

import java.awt.Dimension;
import java.awt.Font;
import java.awt.FontMetrics;
import java.awt.Graphics;
import java.awt.Point;
import java.awt.Color;

/**
 * Draw a blueprint for a MiniFig, showing the points that 
 *  are accessible via public MiniFig methods.
 * @author CS121 instructors
 */
@SuppressWarnings("serial")
public class MiniFigBlueprintDriver extends JPanel
{
	public final int INITIAL_WIDTH = 850;
	public final int INITIAL_HEIGHT = 600;
	public enum Position {UpperLeft, LowerLeft, UpperRight, LowerRight};
	
	/**
	 * Draws the picture in the panel. This is where all of your
	 * code will go.
	 * @param page Our graphics canvas.
	 */
	public void paintComponent (Graphics page)
	{
		
		/* This is the anchor point for the MiniFig (x,y) -> (mid,top) */
		int mid = getWidth() / 2;
		int top = 100;
		
		/* Create a new MiniFig object */
		MiniFig bob = new MiniFig(page,mid,top);
		
		
		/* Create a new Color object and update the MiniFig's color */
		Color blueprintBlue = new Color (28, 100, 157);
		page.setColor(blueprintBlue);
		page.fillRect(0, 0, getWidth(), getHeight());
		
		bob.setHeadColor(blueprintBlue);
		bob.setTorsoColor(blueprintBlue);
		bob.setBeltColor(blueprintBlue);
		bob.setArmColor(blueprintBlue);
		bob.setLegColor(blueprintBlue);
		bob.setHandColor(blueprintBlue);
		bob.setHandHoleColor(blueprintBlue);
		bob.setFootColor(blueprintBlue);
		bob.setEyeColor(Color.WHITE);
		bob.setOutlineColor(Color.WHITE);
		

		/* Draw the MiniFig */
		bob.draw();
		
		
		/* Mark the points on MiniFig that are available via accessor methods */
		int pointDiameter = 8;
		page.setColor(Color.WHITE);
		
		Point topMidPoint = bob.getTopMidPoint();
		page.fillOval(topMidPoint.x - pointDiameter / 2, topMidPoint.y - pointDiameter / 2, pointDiameter, pointDiameter);
		placeText(page,topMidPoint.x,topMidPoint.y,"getTopMidPoint()",Position.UpperRight);
		
		Point capPoint = bob.getCapPoint();
		page.fillOval(capPoint.x - pointDiameter / 2, capPoint.y - pointDiameter / 2, pointDiameter, pointDiameter);
		placeText(page,capPoint.x,capPoint.y,"getCapPoint()",Position.UpperLeft);
		
		Point rightShoulderPoint = bob.getRightShoulderPoint();
		page.fillOval(rightShoulderPoint.x - pointDiameter / 2, rightShoulderPoint.y - pointDiameter / 2, pointDiameter, pointDiameter);
		placeText(page,rightShoulderPoint.x,rightShoulderPoint.y,"getRightShoulderPoint()",Position.UpperLeft);
		
		Point leftShoulderPoint = bob.getLeftShoulderPoint();
		page.fillOval(leftShoulderPoint.x - pointDiameter / 2, leftShoulderPoint.y - pointDiameter / 2, pointDiameter, pointDiameter);
		placeText(page,leftShoulderPoint.x,leftShoulderPoint.y,"getLeftShoulderPoint()",Position.LowerRight);
		
		Point rightHandCenterPoint = bob.getRightHandCenterPoint();
		page.fillOval(rightHandCenterPoint.x - pointDiameter / 2, rightHandCenterPoint.y - pointDiameter / 2, pointDiameter, pointDiameter);
		placeText(page,rightHandCenterPoint.x,rightHandCenterPoint.y,"getRightHandCenterPoint()",Position.UpperLeft);
		
		Point leftHandCenterPoint = bob.getLeftHandCenterPoint();
		page.fillOval(leftHandCenterPoint.x - pointDiameter / 2, leftHandCenterPoint.y - pointDiameter / 2, pointDiameter, pointDiameter);
		placeText(page,leftHandCenterPoint.x,leftHandCenterPoint.y,"getLeftHandCenterPoint()",Position.LowerRight);
		
		Point baseMidPoint = bob.getBaseMidPoint();
		page.fillOval(baseMidPoint.x - pointDiameter / 2, baseMidPoint.y - pointDiameter / 2, pointDiameter, pointDiameter);
		placeText(page,baseMidPoint.x,baseMidPoint.y,"getBaseMidPoint()",Position.LowerRight);
		
		/* Draw a the vertical and horizontal rulers for MiniFig height and width */
		placeVerticalRuler(page,topMidPoint.x + 300, topMidPoint.y + bob.getHeight()/2, bob.getHeight(),"getHeight()", Position.UpperRight);
		placeVerticalRuler(page,capPoint.x + bob.getFaceWidth()/2 +50, capPoint.y + bob.getFaceHeight()/2, bob.getFaceHeight(),"getFaceHeight()",Position.UpperRight);
		placeHorizontalRuler(page,baseMidPoint.x, baseMidPoint.y + 50, bob.getWidth(),"getWidth()", Position.LowerRight);
		placeHorizontalRuler(page,topMidPoint.x, topMidPoint.y - 50, bob.getFaceWidth(),"getFaceWidth()", Position.UpperRight);
	
	}

	/**
	 * Draw a vertical ruler on the blueprint
	 * @param g Graphics canvas to draw on
	 * @param midx X component of midpoint of ruler
	 * @param midy Y component of midpoint of the ruler
	 * @param length length of the ruler 
	 * @param msg Text label for the ruler
	 * @param textPosition Orientation of the text label
	 */
	private void placeVerticalRuler(Graphics g, int midx, int midy, int length, String msg, Position textPosition ) {
		
		Point p1 = new Point(midx,midy);
		Point p2 = new Point(midx,midy - length / 2);
		Point p3 = new Point(midx,midy + length / 2);
		
		Color savedColor = g.getColor();
		g.setColor(Color.black);
		g.drawLine(p2.x,p2.y, p3.x, p3.y);
		g.drawLine(p2.x-4,p2.y, p2.x+4, p2.y);
		g.drawLine(p3.x-4,p3.y, p3.x+4, p3.y);
		g.setColor(savedColor);
		placeText(g,p1.x,p1.y,msg,textPosition);	
	}
	/**
	 * Draw a horizontal ruler on the blueprint
	 * @param g Graphics canvas to draw on
	 * @param midx X component of midpoint of ruler
	 * @param midy Y component of midpoint of the ruler
	 * @param length length of the ruler 
	 * @param msg Text label for the ruler
	 * @param textPosition Orientation of the text label
	 */
	private void placeHorizontalRuler(Graphics g, int midx, int midy, int length, String msg, Position textPosition ) {
		
		Point p1 = new Point(midx,midy);
		Point p2 = new Point(midx - length / 2, midy);
		Point p3 = new Point(midx + length / 2, midy);
		
		Color savedColor = g.getColor();
		g.setColor(Color.black);
		g.drawLine(p2.x,p2.y, p3.x, p3.y);
		g.drawLine(p2.x,p2.y-4, p2.x, p2.y+4);
		g.drawLine(p3.x,p3.y-4, p3.x, p3.y+4);
		g.setColor(savedColor);
		placeText(g,p1.x,p1.y,msg,textPosition);	
	}
	
	/**
	 * Draw a text table on the canvas
	 * @param g Graphics canvas
	 * @param x X component of the point to anchor the label to
	 * @param y Y component of the point to anchor the label to
	 * @param msg Contents of label
	 * @param textPosition Orientation of the label
	 */
	private void placeText(Graphics g, int x, int y, String msg, Position textPosition) {
		g.setFont(new Font("Monospaced", Font.BOLD, 12));

		FontMetrics metrics = g.getFontMetrics();
		int msgWidth = metrics.stringWidth(msg);
		int msgHeight = metrics.getHeight();
		
		Point p1 = new Point(x,y);
		Point p2 = new Point();
		Point p3 = new Point();
		Point p4 = new Point();
		
		if (textPosition == Position.UpperRight) {
			p2.x = p1.x+15;
			p2.y = p1.y-msgHeight;
			p3.x = p2.x+15;
			p3.y = p2.y;
			p4.x = p3.x;
			p4.y = p3.y;
		} else if (textPosition == Position.LowerRight) {
			p2.x = p1.x+15;
			p2.y = p1.y+msgHeight;
			p3.x = p2.x+15;
			p3.y = p2.y;
			p4.x = p3.x;
			p4.y = p3.y;
		} else if (textPosition == Position.UpperLeft) {
			p2.x = p1.x-15;
			p2.y = p1.y-msgHeight;
			p3.x = p2.x-15;
			p3.y = p2.y;
			p4.x = p3.x - msgWidth ;
			p4.y = p3.y;
		} else if (textPosition == Position.LowerLeft) {
			p2.x = p1.x-15;
			p2.y = p1.y+msgHeight;
			p3.x = p2.x-15;
			p3.y = p2.y;
			p4.x = p3.x - msgWidth ;
			p4.y = p3.y;
		} 

		
		Color savedColor = g.getColor();
		g.setColor(Color.black);
		g.drawLine(p1.x,p1.y, p2.x, p2.y);
		g.drawLine(p2.x,p2.y, p3.x, p3.y);
		g.drawString(msg, p4.x, p4.y);
		
		g.setColor(savedColor);
	}


	/**
	 * Constructor (panel initialization)
	 */
	public MiniFigBlueprintDriver()
	{
		this.setBackground(Color.white);
		this.setPreferredSize(new Dimension(INITIAL_WIDTH, INITIAL_HEIGHT));
	}


	/**
	 * Sets up a JFrame and the MiniFigDriver panel.
	 * @param args unused
	 */
	public static void main(String[] args)
	{
		JFrame frame = new JFrame("MiniFigDriver");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().add(new MiniFigBlueprintDriver());
		frame.pack();
		frame.setVisible(true);
	}
}
