package frogger;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import javax.swing.JPanel;
import java.util.Random;

/** Main game display panel for TrafficFrogger, also responsible for moving
 * vehicles and avatar and detecting collisions and level-ending conditions.
 *
 * @author mvail
 */
@SuppressWarnings("serial")
public class FroggerDisplayPanel extends JPanel {
	private final Color darkGreen = new Color(0,127,0);
	private final String GAME_OVER = "GAME OVER";
	
	private Random rand;
	
	private int score;
	private final String SCORE = "Score: ";
	private int scoreBonus;
	private final String BONUS = "Bonus: ";
	
	private int numLanes;
	
	private boolean collision = false;
	private boolean goreOn = true;
	
	private FroggerVehicle[] vehicle;
	private FroggerAvatar avatar;
		
	/**
	 * Constructor
	 * @param numLanes
	 * @param vehiclesPerLane
	 */
	public FroggerDisplayPanel(int numLanes, int vehiclesPerLane) {
		setBackground(darkGreen);
		
		//initialize instance variables
		rand = new Random();
	}//end constructor
	
	/**
	 * Update display with current game state
	 */
	public void refresh(int numLanes, FroggerAvatar avatar, FroggerVehicle[] vehicle, int score, int scoreBonus, boolean collision) {
		this.numLanes = numLanes;
		this.avatar = avatar;
		this.vehicle = vehicle;
		this.score = score;
		this.scoreBonus = scoreBonus;
		this.collision = collision;
		
		this.repaint();
	}
	
	/* Paint the current scene, scaled to the current frame size.
	 * 
	 * (non-Javadoc)
	 * @see javax.swing.JComponent#paintComponent(java.awt.Graphics)
	 */
	public void paintComponent(Graphics g0) {
		super.paintComponent(g0); //takes care of grass green background
		Graphics2D g = (Graphics2D) g0; //necessary for setting Stroke

		int width, height;
		int laneHeight;
		int roadHeight;
		
		//compensate for resizing
		width = getWidth();
		height = getHeight();
		laneHeight = height / (numLanes + 2);
		roadHeight = numLanes * laneHeight;
		int strokeWeight = laneHeight/50 + 1;
		BasicStroke stroke = new BasicStroke(strokeWeight);
		g.setStroke(stroke);
//		//System.out.println("Stroke: " + strokeWeight); //DEBUG
		Font scoreFont = new Font("Arial", Font.BOLD, laneHeight / 3);
		Font gameOverFont = new Font("Arial", Font.BOLD, (int)(laneHeight/1.5));
		
//		//grass background
//		g.setColor(darkGreen);
//		g.fillRect(0, 0, width, height);

		//tarmac and lane lines
		g.setColor(Color.black);
		g.fillRect(0, laneHeight, width, roadHeight); //pave the road all at once
		g.setColor(Color.yellow);
		for (int y = laneHeight; y <= laneHeight + roadHeight; y += laneHeight) {
			g.drawLine(0, y, width, y); //paint the lane lines
		}
		
		//avatar
		avatar.paint(g0, width, laneHeight);
		
		//vehicles
		for (int i = 0; i < vehicle.length; i++) {
			vehicle[i].paint(g, width, laneHeight);
		}
		
		//ambiance (in case of collision)
		if (collision && goreOn) {
			Color spot1 = new Color(127, 0, 0);
			Color spot2 = new Color(191, 0, 0);
			for (int i = 0; i < Math.max(width, height)/4; i++) {
				int spotDim = Math.min(width, height) / 20 + rand.nextInt(21) - 2;
				int x = rand.nextInt(width + spotDim) - spotDim / 2;
				int y = rand.nextInt(height + spotDim) - spotDim / 2;
				g.setColor(spot2);
				g.fillOval(x-1, y-2, spotDim+1, spotDim+1);
				g.setColor(spot1);
				g.fillOval(x, y, spotDim, spotDim+2);
			}
		}
		if (collision) {
			g.setFont(gameOverFont);
			int fontWidth = g.getFontMetrics().stringWidth(GAME_OVER);
			g.setColor(Color.black);
			g.drawString(GAME_OVER, (width - fontWidth)/2 + 2, (height + laneHeight/3)/2 + 2);
			g.setColor(Color.red);
			g.drawString(GAME_OVER, (width - fontWidth)/2, (height + laneHeight/3)/2);
		}
		
		//Score
		g.setFont(scoreFont);
		g.setColor(Color.black);
		g.drawString(SCORE + score, laneHeight/4 + 2, laneHeight/3 + 2);
		g.setColor(Color.red);
		String scoreString = SCORE + score;
		g.drawString(scoreString, laneHeight/4, laneHeight/3);
		String bonusString = BONUS + scoreBonus;
		int fontWidth = g.getFontMetrics().stringWidth(bonusString);
		g.setColor(Color.black);
		g.drawString(bonusString, width - fontWidth - laneHeight/4 + 2, laneHeight/3 + 2);
		g.setColor(Color.red);
		g.drawString(bonusString, width - fontWidth - laneHeight/4, laneHeight/3);
	}//end paint()

	/**
	 * Turn collision gore on or off
	 * @param showGore
	 */
	public void setGore(boolean showGore) {
		goreOn = showGore;
	}
}
