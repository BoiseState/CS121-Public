package frogger;

import java.applet.AudioClip;
import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.net.URL;
import java.util.Random;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.ButtonGroup;
import javax.swing.JApplet;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import javax.swing.Timer;
import javax.swing.border.TitledBorder;

/**
 * Main container for TrafficFrogger game, sets up and coordinates the game
 *
 * @author mvail
 */
@SuppressWarnings("serial")
public class FroggerPanel extends JPanel implements ActionListener, KeyListener, MouseListener {
	private final int DEFAULT_NUM_LANES = 3;
	private final int DEFAULT_VEHICLES_PER_LANE = 1;
	private final Dimension MAX_TEXT_FIELD_DIMENSION = new Dimension(300, 10);
	private final Dimension PREFERRED_GAME_PANEL_DIMENSION = new Dimension(600, 400);
	private final int MAX_VEHICLES_PER_LANE = 3;
	private final String START_BUTTON_TEXT = "Start";
	private final String PAUSE_BUTTON_TEXT = "Pause";
	
	private final int DEFAULT_TIMER_DELAY = 100; //10 frames per second to start
	private final double TIMER_SPEEDUP_RATE = 0.9; //each new level has 10% faster timer
	private final int MIN_VEHICLES_PER_LANE = 1;
	private final int MIN_LANES = 1;
	private final int MOVEMENT_INCREMENTS = 100;
	private final String SCREAM_FILE_NAME = "wilhelm.wav";
	private final int SCORE_FACTOR = 10;
	private final int BONUS_FACTOR = 2000;

	private Random rand;
	private Timer gameTimer;
	private int score;
	private int scoreBonus;
	private boolean collision;
	private FroggerVehicle[] vehicle;
	private FroggerAvatar avatar;
	private int laneHeight;
	private URL screamURL;
	private AudioClip screamAudioClip;
	private boolean soundEnabled;

	
	private JPanel configPanel;
	private JTextField numLanesText;
	private JButton newGameButton, startStopButton;
	private JCheckBox toggleGoreBox;
	private JRadioButton[] vehiclesPerLaneRadioButton;
	private boolean gameOn;
	
	private FroggerDisplayPanel displayPanel;
	private int numLanes = DEFAULT_NUM_LANES;
	private int vehiclesPerLane = DEFAULT_VEHICLES_PER_LANE;
	
	private JPanel avatarControlsPanel;
	private JButton moveUpButton, moveDownButton, moveLeftButton, moveRightButton;
	
	/**
	 * Set up TrafficFrogger game components layout and act as the listener
	 * for action and item events. 
	 */
	public FroggerPanel() {
		/* ***************
		 * DISPLAY LAYOUT
		 * ***************/
		
		//avatarControlsPanel setup
		avatarControlsPanel = new JPanel();
		avatarControlsPanel.setLayout(new GridLayout(3,3));
		moveUpButton = new JButton("Up");
		moveUpButton.addActionListener(this);
		moveDownButton = new JButton("Down");
		moveDownButton.addActionListener(this);
		moveLeftButton = new JButton("Left");
		moveLeftButton.addActionListener(this);
		moveRightButton = new JButton("Right");
		moveRightButton.addActionListener(this);
		avatarControlsPanel.add(new JLabel());
		avatarControlsPanel.add(moveUpButton);
		avatarControlsPanel.add(new JLabel());
		avatarControlsPanel.add(moveLeftButton);
		avatarControlsPanel.add(new JLabel());
		avatarControlsPanel.add(moveRightButton);
		avatarControlsPanel.add(new JLabel());
		avatarControlsPanel.add(moveDownButton);
		avatarControlsPanel.add(new JLabel());
		JPanel controlsPanelWrap = new JPanel();
		controlsPanelWrap.add(avatarControlsPanel);
		
		//configPanel setup
		configPanel = new JPanel();
		configPanel.setLayout(new BoxLayout(configPanel, BoxLayout.Y_AXIS));
		numLanesText = new JTextField();
		numLanesText.addActionListener(this);
		numLanesText.setBorder(new TitledBorder("Lanes"));
		numLanesText.setMaximumSize(MAX_TEXT_FIELD_DIMENSION);
		numLanesText.setText(Integer.toString(DEFAULT_NUM_LANES));
		JPanel numVehiclesPanel = new JPanel();
		numVehiclesPanel.setBorder(new TitledBorder("Per Lane"));
		numVehiclesPanel.setLayout(new BoxLayout(numVehiclesPanel, BoxLayout.Y_AXIS));
		ButtonGroup vehiclesPerLaneButtonGroup = new ButtonGroup();
		vehiclesPerLaneRadioButton = new JRadioButton[MAX_VEHICLES_PER_LANE];
		for (int i = 0; i < MAX_VEHICLES_PER_LANE; i++) {
			vehiclesPerLaneRadioButton[i] = new JRadioButton(i + 1 + " vehicles");
			vehiclesPerLaneButtonGroup.add(vehiclesPerLaneRadioButton[i]);
			numVehiclesPanel.add(vehiclesPerLaneRadioButton[i]);
			vehiclesPerLaneRadioButton[i].addActionListener(this);
		}
		vehiclesPerLaneRadioButton[0].setSelected(true);
		toggleGoreBox = new JCheckBox("Show Gore", true);
		toggleGoreBox.addActionListener(this);
		newGameButton = new JButton("New Game");
		newGameButton.addActionListener(this);
		gameOn = false;
		startStopButton = new JButton(START_BUTTON_TEXT);
		startStopButton.addActionListener(this);
		configPanel.add(Box.createVerticalGlue());
		configPanel.add(numLanesText);
		configPanel.add(numVehiclesPanel);
		configPanel.add(newGameButton);
		configPanel.add(Box.createVerticalGlue());
		configPanel.add(startStopButton);
		configPanel.add(Box.createVerticalGlue());
		configPanel.add(toggleGoreBox);
		configPanel.add(Box.createVerticalGlue());
		
		//displayPanel setup
		displayPanel = new FroggerDisplayPanel(numLanes, vehiclesPerLane);
		displayPanel.setPreferredSize(PREFERRED_GAME_PANEL_DIMENSION);
		displayPanel.setMinimumSize(PREFERRED_GAME_PANEL_DIMENSION);
//		gamePanel.addActionListener(this); //to receive game-over notifications
		
		//main panel setup
		this.setLayout(new BorderLayout());
		this.add(controlsPanelWrap, BorderLayout.SOUTH);
		this.add(configPanel, BorderLayout.WEST);
		this.add(displayPanel, BorderLayout.CENTER);
		
		//initial button enabled/disabled
		newGameButton.setEnabled(true);
		startStopButton.setEnabled(true);
		moveUpButton.setEnabled(false);
		moveDownButton.setEnabled(false);
		moveLeftButton.setEnabled(false);
		moveRightButton.setEnabled(false);

		/* ***********
		 * GAME SETUP
		 * ***********/
		
		//initialize game variables
		rand = new Random();
		gameTimer = new Timer(DEFAULT_TIMER_DELAY, this);
		score = 0;
		scoreBonus = numLanes * vehiclesPerLane * BONUS_FACTOR / gameTimer.getDelay();
		collision = false;
		displayPanel.setGore(true);
		try {
			screamURL = new URL("file", "localhost", SCREAM_FILE_NAME);
			screamAudioClip = JApplet.newAudioClip(screamURL);
			soundEnabled = true;
		} catch (Exception e) {
			System.err.println("Failed to load " + SCREAM_FILE_NAME);
			e.printStackTrace();
			soundEnabled = false;
		}
		
		//register self as KeyListener
		this.addKeyListener(this);
//        this.addFocusListener(this);
        this.addMouseListener(this);
        
        //set numLanes and vehiclesPerLane and generate vehicles and avatar
		this.reconfigure(numLanes, vehiclesPerLane);
	}
	
	/**
	 * Like a "re-Constructor" for the TrafficFroggerGamePanel
	 * @param numLanes
	 * @param vehiclesPerLane
	 */
	public void reconfigure(int numLanes, int vehiclesPerLane) {
		gameTimer.stop();
		gameTimer.setDelay(DEFAULT_TIMER_DELAY);
		this.numLanes = Math.max(numLanes, MIN_LANES);
		this.vehiclesPerLane = Math.max(vehiclesPerLane, MIN_VEHICLES_PER_LANE);
		
		//create vehicles
		vehicle = new FroggerVehicle[this.numLanes * this.vehiclesPerLane];
		for (int lane = 0; lane < this.numLanes; lane++) {
			int baseX = rand.nextInt(MOVEMENT_INCREMENTS);
			for (int v = 0; v < this.vehiclesPerLane; v++) {
				int thisX = (int)(baseX + v*(double)MOVEMENT_INCREMENTS / this.vehiclesPerLane) % MOVEMENT_INCREMENTS;
				//System.out.println("lane: " + lane + ", vehicle: " + v + ", thisX: " + thisX);//DEBUG
				vehicle[lane*this.vehiclesPerLane + v] = new FroggerVehicle(thisX, lane + 1);
			}
		}
		
		//create avatar
		avatar = new FroggerAvatar(this.numLanes);
		
		//refresh the view
		score = 0;
		scoreBonus = numLanes * vehiclesPerLane * BONUS_FACTOR / gameTimer.getDelay();
		collision = false;
		displayPanel.refresh(numLanes, avatar, vehicle, score, scoreBonus, collision);//this.repaint();
	}

	/** 
	 * Advance all visual elements and then repaint the scene.
	 * Will eventually need to include collision detection and level completion
	 * or failure notification for TrafficFroggerPanel.
	 */
	private void stepGame() {
		//step all vehicles
		for (int i = 0; i < vehicle.length; i++) {
			vehicle[i].step();
		}
		
		//check for level completion
		if (avatar.getLane() == 0) {
			//pause timer
			gameTimer.stop();
			//award points
			score += (numLanes * vehiclesPerLane * SCORE_FACTOR) + (BONUS_FACTOR / gameTimer.getDelay());
			score += scoreBonus;
			//make sure avatar appears to have moved
			displayPanel.refresh(numLanes, avatar, vehicle, score, scoreBonus, collision);//repaint();
			//notify player of level completion
			JOptionPane.showMessageDialog(this, "Level Complete!\nNow do it again, but faster.");
			//speed up the timer
			gameTimer.setDelay((int)(gameTimer.getDelay() * TIMER_SPEEDUP_RATE));
			scoreBonus = numLanes * vehiclesPerLane * BONUS_FACTOR / gameTimer.getDelay();
			//shuffle the vehicles
			for (int lane = 0; lane < this.numLanes; lane++) {
				int baseX = rand.nextInt(MOVEMENT_INCREMENTS);
				for (int v = 0; v < this.vehiclesPerLane; v++) {
					int thisX = (int)(baseX + v*(double)MOVEMENT_INCREMENTS / this.vehiclesPerLane) % MOVEMENT_INCREMENTS;
					//System.out.println("lane: " + lane + ", vehicle: " + v + ", thisX: " + thisX);//DEBUG
					vehicle[lane*this.vehiclesPerLane + v].setX(thisX);
				}
			}
			//reset the avatar
			avatar.reset();
			//restart the timer
			gameTimer.start();
		}
		
		//check for collision
		int roadWidth = displayPanel.getWidth();
		laneHeight = getLaneHeight();
		for (int i = 0; i < vehicle.length; i++) {
			if (vehicle[i].getLane() == avatar.getLane()
				&&
				((avatar.getMinX(roadWidth, laneHeight) < vehicle[i].getMaxX(roadWidth, laneHeight)
				  && avatar.getMinX(roadWidth, laneHeight) > vehicle[i].getMinX(roadWidth, laneHeight))
				 ||
				 (avatar.getMaxX(roadWidth, laneHeight) < vehicle[i].getMaxX(roadWidth, laneHeight)
				  && avatar.getMaxX(roadWidth, laneHeight) > vehicle[i].getMinX(roadWidth, laneHeight)))) {
				//there was a collision
				gameTimer.stop();
				if (soundEnabled) {
					screamAudioClip.play();
				}
				scoreBonus = 0;
				collision = true;
				gameOver();
			}
		}
		
		//reduce bonus score
		scoreBonus = Math.max(scoreBonus - 1, 0);
		
		//update display
		displayPanel.refresh(numLanes, avatar, vehicle, score, scoreBonus, collision);//repaint();
	}
	
	/* Update variables that depend on current displayPanel dimensions
	 * 
	 * (non-Javadoc)
	 * @see javax.swing.JComponent#paintComponent(java.awt.Graphics)
	 */
	public void paintComponent(Graphics g) {
		laneHeight = getLaneHeight();
	}
	
	/**
	 * @return calculated height for each lane
	 */
	private int getLaneHeight() {
		return displayPanel.getHeight() / (numLanes + 2);
	}

	/**
	 * Start the game Timer
	 */
	public void startGame() {
		this.requestFocus();
		gameTimer.start();
	}
	
	/**
	 * Stop the game Timer
	 */
	public void stopGame() {
		gameTimer.stop();
	}
	
	/**
	 * Move avatar up
	 */
	public void moveUp() {
		if (gameTimer.isRunning()) {
			avatar.moveUp();
		}
	}
	
	/**
	 * Move avatar down
	 */
	public void moveDown() {
		if (gameTimer.isRunning()) {
			avatar.moveDown();
		}		
	}
	
	/**
	 * Move avatar left
	 */
	public void moveLeft() {
		if (gameTimer.isRunning()) {
			avatar.moveLeft();
		}		
	}
	
	/**
	 * Move avatar right
	 */
	public void moveRight() {
		if (gameTimer.isRunning()) {
			avatar.moveRight();
		}
	}
	
	/**
	 * Enable/disable controls after a collision
	 */
	private void gameOver() {
		startStopButton.setEnabled(false);
		newGameButton.setEnabled(true);
		moveUpButton.setEnabled(false);
		moveDownButton.setEnabled(false);
		moveLeftButton.setEnabled(false);
		moveRightButton.setEnabled(false);
		numLanesText.setEnabled(true);
		for (JRadioButton jrb : vehiclesPerLaneRadioButton) {
			jrb.setEnabled(true);
		}
		newGameButton.setEnabled(true);
	}

	///////////////////////
	// ActionEvent Handler
	///////////////////////
	@Override
	public void actionPerformed(ActionEvent arg0) {
		Object src = arg0.getSource();
		if (src == gameTimer) {
			stepGame();
		} else if (src == moveUpButton) {
			moveUp();
		} else if (src == moveDownButton) {
			moveDown();
		} else if (src == moveLeftButton) {
			moveLeft();
		} else if (src == moveRightButton) {
			moveRight();
		} else if (src == startStopButton) { //start/restart/pause game
			if (gameOn) { //pause game
				gameOn = false;
				startStopButton.setText(START_BUTTON_TEXT);
				newGameButton.setEnabled(true);
				moveUpButton.setEnabled(false);
				moveDownButton.setEnabled(false);
				moveLeftButton.setEnabled(false);
				moveRightButton.setEnabled(false);
				numLanesText.setEnabled(true);
				for (JRadioButton jrb : vehiclesPerLaneRadioButton) {
					jrb.setEnabled(true);
				}
				stopGame();
			} else if (collision == false) { //start/restart game
				gameOn = true;
				startStopButton.setText(PAUSE_BUTTON_TEXT);
				newGameButton.setEnabled(false);
				moveUpButton.setEnabled(true);
				moveDownButton.setEnabled(true);
				moveLeftButton.setEnabled(true);
				moveRightButton.setEnabled(true);
				numLanesText.setEnabled(false);
				for (JRadioButton jrb : vehiclesPerLaneRadioButton) {
					jrb.setEnabled(false);
				}
				startGame();				
			}
		} else if (src == toggleGoreBox) {
			displayPanel.setGore(toggleGoreBox.isSelected());
			displayPanel.repaint();
		} else { //if (src == newGameButton || src == lanesText || src == a radio button) { //configure a new game
			try {
				numLanes = Integer.parseInt(numLanesText.getText());
			} catch (NumberFormatException nfe) {
				numLanesText.setText(Integer.toString(numLanes));
			}
			for (int i = 0; i < vehiclesPerLaneRadioButton.length; i++) {
				if (vehiclesPerLaneRadioButton[i].isSelected()) {
					vehiclesPerLane = i + 1;
				}
			}
			reconfigure(numLanes, vehiclesPerLane);
			startStopButton.setText(START_BUTTON_TEXT);
			startStopButton.setEnabled(true);
		}
	}	
	
	////////////////////
	//KeyEvent Handlers
	////////////////////
	@Override
	public void keyPressed(KeyEvent arg0) {
		switch (arg0.getKeyCode())
		{
		case KeyEvent.VK_UP: case KeyEvent.VK_E:
			avatar.moveUp();
			break;
		case KeyEvent.VK_DOWN: case KeyEvent.VK_D:
			avatar.moveDown();
			break;
		case KeyEvent.VK_LEFT: case KeyEvent.VK_S:
			avatar.moveLeft();
			break;
		case KeyEvent.VK_RIGHT: case KeyEvent.VK_F:
			avatar.moveRight();
			break;
		}
	}
	//Unused KeyEvent handlers
	@Override
	public void keyReleased(KeyEvent arg0) {}
	@Override
	public void keyTyped(KeyEvent arg0) {}
	
	///////////////////////
	//Mouse Event Handlers
	///////////////////////
	@Override
	public void mouseClicked(MouseEvent arg0) {
		//try to give this panel the focus
		requestFocus();
	}
	
	//Unused MouseEvent handlers
	@Override
	public void mouseEntered(MouseEvent arg0) {}
	@Override
	public void mouseExited(MouseEvent arg0) {}
	@Override
	public void mousePressed(MouseEvent arg0) {}
	@Override
	public void mouseReleased(MouseEvent arg0) {}
}
