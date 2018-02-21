package spirograph;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Point;
import java.text.DecimalFormat;
import java.util.ArrayList;


/**
 * A Circle with support for drawing in a Spirograph
 * @author mvail
 */
public class DrawingCircle extends Circle {
	private int distanceFromAnchor;
	private double angleFromAnchor;
	private int penRadius;
	private double penAngle;
	private ArrayList<Point> penPoints;
	
	/**
	 * default constructor
	 */
	public DrawingCircle() {
		super();
		distanceFromAnchor = 0;
		angleFromAnchor = 0; //not necessarily
		penRadius = 0;
		penAngle = 0;
		penPoints = new ArrayList<Point>();
	}

	/**
	 * constructor taking only basic Circle parameters
	 * @param xCenter x coordinate of circle's center point
	 * @param yCenter y coordinate of circle's center point
	 * @param radius circle's radius
	 */
	public DrawingCircle(int xCenter, int yCenter, int radius) {
		super(xCenter, yCenter, radius);
		this.distanceFromAnchor = 0;
		this.angleFromAnchor = 0; //not necessarily
		this.penRadius = 0;
		this.penAngle = 0;
		penPoints = new ArrayList<Point>();
	}

	/**
	 * constructor taking all DrawingCircle parameters
	 * @param xCenter x coordinate of circle's center point
	 * @param yCenter y coordinate of circle's center point
	 * @param radius circle's radius
	 * @param distanceFromAnchor distance of this circle's center to an anchor point
	 * @param penRadius distance of pen point from circle's center
	 */
	public DrawingCircle(int xCenter, int yCenter, int radius, 
			int distanceFromAnchor, int penRadius) {
		super(xCenter, yCenter, radius);
		this.distanceFromAnchor = distanceFromAnchor;
		this.angleFromAnchor = 0; //not necessarily
		this.penRadius = penRadius;
		this.penAngle = 0;
		penPoints = new ArrayList<Point>();
	}
	
	/**
	 * @param dist center point distance from an anchor point for rotation 
	 */
	public void setDistanceFromAnchor(int dist) {
		this.distanceFromAnchor = dist;
	}
	
	/**
	 * @param dist pen's distance from circle center point
	 */
	public void setPenRadius(int dist) {
		this.penRadius = dist;
	}

	/**
	 * Relocate circle's center Point by rotating around an anchor point
	 * and roll the circle (moving the pen)
	 * @param anchor Point around which to rotate the circle's center Point
	 * @param angle rotation angle in radians
	 */
	public void rotate(Point anchor, double angle) {
		//double startAngle = angleFromAnchor;
		angleFromAnchor = angleFromAnchor + angle;
		center.x = (int)(anchor.x + distanceFromAnchor*Math.cos(angleFromAnchor));
		center.y = (int)(anchor.y - distanceFromAnchor*Math.sin(angleFromAnchor));
		int rollingRadius = distanceFromAnchor + radius;
		double rollingArc = angle*rollingRadius;
		double penAngleDelta = getAngleFromArc(rollingArc);
		penAngle = (penAngle - penAngleDelta);
		
		DecimalFormat dfmt = new DecimalFormat("0.00");
		System.out.println("c1Circ: " + dfmt.format(2*Math.PI*rollingRadius)
				+ ", c2Circ: " + dfmt.format(2*Math.PI*radius)
				+ ", angle: " + dfmt.format(angle) 
				+ ", rollingRadius: " + dfmt.format(rollingRadius)
				+ ", distanceFromAnchor: " + dfmt.format(distanceFromAnchor)
				+ ", rollingArc: " + dfmt.format(rollingArc)
				+ ", penAngleDelta: " + dfmt.format(penAngleDelta)
				+ ", penAngle: " + dfmt.format(penAngle));
		
		penPoints.add(getPenPoint());
		
//		DecimalFormat dfmt = new DecimalFormat("0.00");
//		System.out.println("rotate[ startAngleFromAnchor: " + dfmt.format(startAngle) 
//				+ ", endAngleFromAnchor: " + dfmt.format(angleFromAnchor)
//				+ ", rollingRadius: " + dfmt.format(rollingRadius)
//				+ ", rollingArc: " + dfmt.format(rollingArc)
//				+ ", penAngleDelta: " + dfmt.format(penAngleDelta)
//				+ ", penAngle: " + dfmt.format(penAngle) + " ]");
	}

	/**
	 * @return Point of current pen location
	 */
	public Point getPenPoint() {
		return new Point((int)(center.x + penRadius*Math.cos(penAngle)), (int)(center.y - penRadius*Math.sin(penAngle)));
	}
	
	/* (non-Javadoc)
	 * @see Circle#draw(java.awt.Graphics)
	 */
	public void draw(Graphics g) {
		super.draw(g); //outline of this circle
		
//		Point p = getPenPoint();
//		g.drawOval(p.x, p.y, 2, 2);

		g.setColor(Color.yellow);
		for (Point p : penPoints) {
			g.drawOval(p.x - 1, p.y - 1, 2, 2);
		}
	}
	
	/**
	 * clear existing pen points
	 */
	public void clearPenPoints() {
		penPoints = new ArrayList<Point>();
	}
}
