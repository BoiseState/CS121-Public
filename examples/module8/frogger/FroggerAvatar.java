package frogger;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;

/**
 * Represents the movable avatar for the TrafficFrogger game
 *
 * @author mvail
 */
public class FroggerAvatar {
	public final int STEP_SIZE = 5; //number of subdivisions to move in each step
	public final int MAX_RELATIVE_STEPS = 100; //subdivisions for crossing width of the frame

	private int avatarRelativeX; //current horizontal position out of STEPS_BEFORE_WRAP
	private int avatarLane; //current avatar lane - goal is to reach lane 0
	private int maxLane; //bottom-most lane where avatar begins
	
	/** Constructor sets up avatar centered below traffic lanes
	 * @param numTrafficLanes number of road lanes
	 */
	public FroggerAvatar(int numTrafficLanes) {
		maxLane = numTrafficLanes + 1;
		reset();
	}
	
	/**
	 * Center avatar at bottom of panel
	 */
	public void reset() {
		avatarLane = maxLane;
		avatarRelativeX = MAX_RELATIVE_STEPS / 2;
	}

	/**
	 * Move avatar up by 1 lane
	 */
	public void moveUp() {
		avatarLane = Math.max(avatarLane - 1, 0); //need to prevent running off top
//		System.out.println("avatar lane: " + avatarLane);//DEBUG
	}
	
	/**
	 * Move avatar down by 1 lane
	 */
	public void moveDown() {
		avatarLane = Math.min(avatarLane + 1, maxLane); //need to prevent running off bottom
//		System.out.println("avatar lane: " + avatarLane);//DEBUG
	}
	
	/**
	 * Move avatar left by one STEP_SIZE
	 */
	public void moveLeft() {
		avatarRelativeX = Math.max(avatarRelativeX - STEP_SIZE, 0);
//		System.out.println("avatar relative X (out of " + MAX_RELATIVE_STEPS + "): " + avatarRelativeX);//DEBUG
	}
	
	/**
	 * Move avatar right by one STEP_SIZE
	 */
	public void moveRight() {
		avatarRelativeX = Math.min(avatarRelativeX + STEP_SIZE, MAX_RELATIVE_STEPS);
//		System.out.println("avatar relative X (out of " + MAX_RELATIVE_STEPS + "): " + avatarRelativeX);//DEBUG
	}
	
	/**
	 * @return avatar's current lane
	 */
	public int getLane() {
		return avatarLane;
	}
	
	/**
	 * Calculate leftmost x coordinate
	 * @param roadWidth
	 * @param laneHeight
	 * @return leftmost x coordinate
	 */
	public int getMinX (int roadWidth, int laneHeight) {
		int avatarWidth = laneHeight/3;
		int avatarX = (int)((double)avatarRelativeX/MAX_RELATIVE_STEPS * roadWidth);
		return avatarX - avatarWidth/2; //from paint()
	}
	
	/**
	 * Calculate rightmost x coordinate
	 * @param roadWidth
	 * @param laneHeight
	 * @return rightmost x coordinate
	 */
	public int getMaxX (int roadWidth, int laneHeight) {
		int avatarWidth = laneHeight/3;
		int avatarX = (int)((double)avatarRelativeX/MAX_RELATIVE_STEPS * roadWidth);
		return avatarX + avatarWidth/2; //from paint()
	}
	
	/**
	 * Redraw the avatar at its current position
	 * @param g0
	 * @param roadWidth
	 * @param laneHeight
	 */
	public void paint(Graphics g0, int roadWidth, int laneHeight) {
		Graphics2D g = (Graphics2D) g0; //necessary for setting Stroke

		BasicStroke thinStroke = new BasicStroke(1);
		BasicStroke mediumStroke = new BasicStroke((laneHeight / 400) + 1);
		BasicStroke thickStroke = new BasicStroke((laneHeight / 200) + 1);

		g.setStroke(mediumStroke);
		g.setColor(Color.white);
		int avatarWidth = laneHeight/3;
		int avatarHeight = laneHeight/2;
		int avatarX = (int)((double)avatarRelativeX/MAX_RELATIVE_STEPS * roadWidth);
		int avatarY = (avatarLane * laneHeight) + (laneHeight / 4);
		//head
		g.fillOval(avatarX - avatarWidth/4, avatarY, avatarWidth/2, avatarWidth/2);
		//body
		g.drawLine(avatarX, avatarY + avatarWidth/2, avatarX, avatarY + 2*avatarHeight/3);
		//arms
		g.drawLine(avatarX, avatarY + 1 + avatarWidth/2, avatarX - avatarWidth/2, avatarY + 2*avatarWidth/3);
		g.drawLine(avatarX, avatarY + 1 + avatarWidth/2, avatarX + avatarWidth/2, avatarY + 2*avatarWidth/3);
		//legs
		g.drawLine(avatarX, avatarY + 2*avatarHeight/3, avatarX - avatarWidth/4, avatarY + avatarHeight);
		g.drawLine(avatarX, avatarY + 2*avatarHeight/3, avatarX + avatarWidth/4, avatarY + avatarHeight);
	}
}
