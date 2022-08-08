package spirograph;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Point;


/**
 * A circle
 * 
 * @author mvail
 */
public class Circle {
	protected Point center;
	protected int radius;
	private boolean display;
	
	/**
	 * Constructor
	 * 
	 * @param xCenter x coordinate of circle center 
	 * @param yCenter y coordinate of circle center
	 * @param radius
	 */
	public Circle(int xCenter, int yCenter, int radius) {
		this.center = new Point(xCenter, yCenter);
		this.radius = radius;
		this.display = true;
	}
	
	/*
	 * Default Constructor
	 */
	public Circle() {
		this.center = new Point();
		this.radius = 0;
		this.display = true;
	}
	
	/**
	 * @return Point at circle center
	 */
	public Point getCenterPoint() {
		return new Point(center);
	}
	
	/**
	 * @param newCenter now Point for circle's center
	 */
	public void setCenterPoint(Point newCenter) {
		this.center = new Point(newCenter);
	}
	
	/**
	 * @return circle radius
	 */
	public int getRadius() {
		return radius;
	}
	
	/**
	 * @param newRadius new radius of circle 
	 */
	public void setRadius(int newRadius) {
		radius = newRadius;
	}
	
	/**
	 * @return Point at upper left of circle's bounding rectangle
	 */
	public Point getUpperLeftPoint() {
		return new Point(center.x - radius, center.y - radius);
	}
	
	/**
	 * @return circle diameter
	 */
	public int getDiameter() {
		return radius*2;
	}
	
	/**
	 * @return circle circumference
	 */
	public double getCircumference() {
		return 2*Math.PI*radius;
	}
	
	/**
	 * @param arcLength
	 * @return radian angle given an arc length
	 */
	public double getAngleFromArc(double arcLength) {
		return arcLength / radius;
	}
	
	/**
	 * @param angle radian angle for arc
	 * @return length of arc
	 */
	public double getArcLengthFromAngle(double angle) {
		return angle*radius;
	}
	
	/**
	 * @param g Graphics on which to draw this circle
	 */
	public void draw(Graphics g) {
		if (display) {
			g.setColor(Color.DARK_GRAY);
			Point p = getUpperLeftPoint();
			g.drawOval(p.x, p.y, 2*radius, 2*radius);
		}
	}
	
	/**
	 * do not draw circle when draw() is called
	 */
	public void hide() {
		display = false;
	}
	
	/**
	 * draw circle when draw() is called
	 */
	public void show() {
		display = true;
	}
}
