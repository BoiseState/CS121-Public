package frogger;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Polygon;

/**
 * Represents a movable vehicle for the TrafficFrogger game
 *
 * @author mvail
 */
public class FroggerVehicle {
	public final int STEP_SIZE = 1; //number of subdivisions to move in each step
	public final int MAX_RELATIVE_STEPS = 100; //subdivisions for crossing width of the frame
	private final Color darkGray = new Color(63,63,63);
	
	private int lane; //this is which lane the vehicle is in (beginning with 1)
	private int relativeX; //current x position out of STEPS_BEFORE_WRAP	
	private int bigStartSpokeAngle = 0, smallStartSpokeAngle = 0;
	
	/**
	 * Constructor
	 * @param startingX relative to STEPS_BEFORE_WRAP
	 * @param lane
	 */
	public FroggerVehicle(int startingX, int lane) {
		this.relativeX = startingX % MAX_RELATIVE_STEPS;
		this.lane = lane;
	}

	/**
	 * Advance (and wrap) the relativeX anchor point
	 */
	public void step() {
		relativeX = (relativeX + STEP_SIZE) % MAX_RELATIVE_STEPS;
	}
	
	/**
	 * Move vehicle's relativeX anchor point to newX
	 * @param newX
	 */
	public void setX(int newX) {
		relativeX = newX % MAX_RELATIVE_STEPS;
	}
	
	/**
	 * @return lane
	 */
	public int getLane() {
		return lane;
	}
	
	/**
	 * Calculate leftmost x coordinate
	 * @param roadWidth
	 * @param laneHeight
	 * @return leftmost x coordinate
	 */
	public int getMinX(int roadWidth, int laneHeight) {
		double scaleX; //scale factor for calculating actualX
		int actualX; //scaled leftmost x position
		scaleX = (double)(roadWidth + 2*laneHeight) / MAX_RELATIVE_STEPS;
		actualX = (int)(scaleX * relativeX) - 2*laneHeight;
		return actualX;
	}
	
	/**
	 * Calculate rightmost x coordinate
	 * @param roadWidth
	 * @param laneHeight
	 * @return rightmost x coordinate
	 */
	public int getMaxX(int roadWidth, int laneHeight) {
		double scaleX; //scale factor for calculating actualX
		int actualX; //scaled leftmost x position
		int maxX; //calculated rightmost x position
		scaleX = (double)(roadWidth + 2*laneHeight) / MAX_RELATIVE_STEPS;
		actualX = (int)(scaleX * relativeX) - 2*laneHeight;
		
		//From paint():
		//maxX = actualX + cabDim + 2*tankDim + cabDim/3
		//tankDim = cabDim - (cabDim / 3)
		//maxX = actualX + cabDim + (4/3)cabDim + (1/3)cabDim
		//maxX = actualX + (8/3)cabDim
		//cabDim = laneHeight/2
		//maxX = actualX + (8/6)laneHeight
		
		maxX = actualX + (int)(4.0*laneHeight/3.0);
		return maxX;
	}
	
	/**
	 * Paint the vehicle on the given Graphics context.
	 * @param g0 context on which vehicle should paint itself
	 * @param anchorY provides starting coordinate from which vehicle's relative y coordinates are calculated
	 * @param roadWidth allows calculation of scaleX and actualX from current relativeX
	 * @param laneHeight provides a scale dimension from which to calculate vehicle dimensions
	 */
	public void paint(Graphics g0, int roadWidth, int laneHeight) {
		//SOMEHOW NEED TO ENFORCE THAT A VEHICLE CANNOT BE MORE THAN 2X laneHeight LONG
		
		Graphics2D g = (Graphics2D) g0; //necessary for setting Stroke

		BasicStroke thinStroke = new BasicStroke(1);
		BasicStroke mediumStroke = new BasicStroke((laneHeight / 400) + 1);
		BasicStroke thickStroke = new BasicStroke((laneHeight / 200) + 1);
		
		double scaleX; //scale factor for calculating actualX
		int actualX; //scaled x position
		int anchorY; //calculated based on lane and laneHeight
		
		int cabDim, cabX;
		int windowDim, windowX, windowY;
		int tankDim, tankX, tankY;
		int stackDim, stackX, stackY;
		int bigWheelDim, bigWheel1X, bigWheel2X, bigWheelY;
		int smallWheelDim, smallWheel1X, smallWheel2X, smallWheelY;
		int bigHubDim, bigHub1X, bigHub2X, bigHubY;
		int smallHubDim, smallHub1X, smallHub2X, smallHubY;
		int cowDim, cowLeftX, cowRightX, cowTopY, cowBottomY;
		Polygon cowGuard;

		scaleX = (double)(roadWidth + 2*laneHeight) / MAX_RELATIVE_STEPS;
		actualX = (int)(scaleX * relativeX) - 2*laneHeight;
		anchorY = lane * laneHeight;
		
		//cab
		g.setColor(Color.blue);
		cabDim = laneHeight/2;
		cabX = actualX;
		g.fillRect(cabX, anchorY, cabDim, cabDim);
		//window
		g.setColor(Color.black);
		windowDim = cabDim / 3;
		windowX = cabX + windowDim;
		windowY = anchorY + (windowDim / 2);
		g.fillRect(windowX, windowY, windowDim, windowDim);
		//tank
		g.setColor(Color.blue);
		tankX = cabX + cabDim;
		tankY = anchorY + (cabDim / 3);
		tankDim = cabDim - (cabDim / 3);
		g.fillRect(tankX, tankY, 2*tankDim, tankDim);
		//smokestack
		g.setColor(Color.blue);
		stackDim = tankY - anchorY;
		stackX = tankX + 2*tankDim - stackDim;
		stackY = anchorY;
		g.fillRect(stackX, stackY, stackDim, stackDim);
		//big wheels
		g.setColor(Color.black);
		bigWheelDim = 2 * cabDim / 3;
		bigStartSpokeAngle = (int)(bigStartSpokeAngle - (360*STEP_SIZE*scaleX/(Math.PI*bigWheelDim))) % 360;
//		bigStartSpokeAngle = (int)(bigStartSpokeAngle - (STEP_SIZE*scaleX)) % 360;
//		bigStartSpokeAngle = (int)(bigStartSpokeAngle - STEP_SIZE) % 360;
		bigWheel1X = cabX;
		bigWheel2X = bigWheel1X + bigWheelDim;
		bigWheelY = anchorY + cabDim - (cabDim / 3);
		g.fillOval(bigWheel1X, bigWheelY, bigWheelDim, bigWheelDim);
		g.fillOval(bigWheel2X, bigWheelY, bigWheelDim, bigWheelDim);
		//big wheels spokes
		g.setColor(darkGray);
		g.setStroke(thickStroke);
		g.fillArc(bigWheel1X + 2, bigWheelY + 2, bigWheelDim - 4, bigWheelDim - 4, bigStartSpokeAngle, 90);
		g.fillArc(bigWheel1X + 2, bigWheelY + 2, bigWheelDim - 4, bigWheelDim - 4, bigStartSpokeAngle + 180, 90);
		g.fillArc(bigWheel2X + 2, bigWheelY + 2, bigWheelDim - 4, bigWheelDim - 4, bigStartSpokeAngle, 90);
		g.fillArc(bigWheel2X + 2, bigWheelY + 2, bigWheelDim - 4, bigWheelDim - 4, bigStartSpokeAngle + 180, 90);
		//big wheels hubs
		g.setColor(Color.black);
		bigHubDim = (bigWheelDim / 3);
		bigHub1X = bigWheel1X + (bigWheelDim / 2) - (bigHubDim / 2);
		bigHub2X = bigHub1X + bigWheelDim;
		bigHubY = bigWheelY + (bigWheelDim / 2) - (bigHubDim / 2); 
		g.fillOval(bigHub1X, bigHubY, bigHubDim, bigHubDim);
		g.fillOval(bigHub2X, bigHubY, bigHubDim, bigHubDim);
		//big wheels outline
		g.setColor(darkGray);
		g.setStroke(thickStroke);
		g.drawOval(bigWheel1X + 2, bigWheelY + 2, bigWheelDim - 4, bigWheelDim - 4);
		g.drawOval(bigWheel2X + 2, bigWheelY + 2, bigWheelDim - 4, bigWheelDim - 4);
		//small wheels
		g.setColor(Color.black);
		smallWheelDim = stackDim;
		smallStartSpokeAngle = (int)(smallStartSpokeAngle - (360*STEP_SIZE*scaleX/(Math.PI*smallWheelDim))) % 360;
//		smallStartSpokeAngle = (int)(smallStartSpokeAngle - 2*(STEP_SIZE*scaleX)) % 360;
//		smallStartSpokeAngle = (int)(smallStartSpokeAngle - 2*STEP_SIZE) % 360;
		smallWheel1X = stackX - stackDim;
		smallWheel2X = stackX;
		smallWheelY = anchorY + cabDim;
		g.fillOval(smallWheel1X, smallWheelY, smallWheelDim, smallWheelDim);
		g.fillOval(smallWheel2X, smallWheelY, smallWheelDim, smallWheelDim);
		//small wheels spokes
		g.setColor(darkGray);
		g.setStroke(thickStroke);
		g.fillArc(smallWheel1X + 2, smallWheelY + 2, smallWheelDim - 4, smallWheelDim - 4, smallStartSpokeAngle, 90);
		g.fillArc(smallWheel1X + 2, smallWheelY + 2, smallWheelDim - 4, smallWheelDim - 4, smallStartSpokeAngle + 180, 90);
		g.fillArc(smallWheel2X + 2, smallWheelY + 2, smallWheelDim - 4, smallWheelDim - 4, smallStartSpokeAngle, 90);
		g.fillArc(smallWheel2X + 2, smallWheelY + 2, smallWheelDim - 4, smallWheelDim - 4, smallStartSpokeAngle + 180, 90);
		//small wheels hubs
		g.setColor(Color.black);
		smallHubDim = (smallWheelDim / 3);
		smallHub1X = smallWheel1X + (smallWheelDim / 2) - (smallHubDim / 2);
		smallHub2X = smallHub1X + smallWheelDim;
		smallHubY = smallWheelY + (smallWheelDim / 2) - (smallHubDim / 2); 
		g.fillOval(smallHub1X, smallHubY, smallHubDim, smallHubDim);
		g.fillOval(smallHub2X, smallHubY, smallHubDim, smallHubDim);
		//small wheels outline
		g.setColor(darkGray);
		g.setStroke(thickStroke);
		g.drawOval(smallWheel1X + 2, smallWheelY + 2, smallWheelDim - 4, smallWheelDim - 4);
		g.drawOval(smallWheel2X + 2, smallWheelY + 2, smallWheelDim - 4, smallWheelDim - 4);
		//cattle guard
		g.setColor(Color.blue);
		g.setStroke(thinStroke);
		cowLeftX = tankX + 2* tankDim;
		cowRightX = cowLeftX + stackDim;
		cowBottomY = tankY + tankDim;
		cowTopY = cowBottomY - stackDim;
		cowGuard = new Polygon();
		cowGuard.addPoint(cowLeftX, cowTopY);
		cowGuard.addPoint(cowRightX, cowBottomY);
		cowGuard.addPoint(cowLeftX, cowBottomY);
		g.fillPolygon(cowGuard);
		cowDim = (cowRightX - cowLeftX) / 3;
		g.setColor(Color.black);
		g.setStroke(mediumStroke);
		g.drawLine(cowLeftX, cowTopY + cowDim, cowRightX - cowDim, cowBottomY);
		g.drawLine(cowLeftX, cowTopY + 2*cowDim, cowRightX - 2*cowDim, cowBottomY);
		g.setColor(Color.blue);
		g.drawPolygon(cowGuard);
	}
}
