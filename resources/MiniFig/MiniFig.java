import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Point;
import java.awt.Polygon;
import java.awt.Color;

/**
 * A starting point for creating a new graphical program
 * @author Luke Hindman
 */
@SuppressWarnings("serial")
public class MiniFig
{
	/* Define the initial height and width of the MiniFig */
	private final int DESIGN_HEIGHT = 450;
	private final int DESIGN_WIDTH = 300;
	
	/* General attributes for the MiniFig as a whole */
	private Graphics canvas;  //Graphics context on which to draw the MiniFig
	private int mid,top; //X,Y coordinates for the anchor point of the MiniFig
	private double scaleFactor; //Scaler used to updated MiniFig dimensions
	
	/* Color attributes for the MiniFig */
	private Color headColor, eyeColor, torsoColor, beltColor, legColor, footColor, armColor, handColor, handHoleColor, outlineColor;

	/* Attributes for MiniFig Head */
	private int knobWidth, knobHeight, knobCurve;
	private Point knobAnchor;
	private int faceWidth,faceHeight,faceCurve;
	private int eyeSpacing, eyeDiameter, eyeDistFromTopOfFace;
	private int mouthOvalDiameter, mouthDistFromTopOfFace;
	private Point faceAnchor;
	private int neckWidth, neckHeight;
	private Point neckAnchor;
	
	/* Attributes for MiniFig Torso */
	private int torsoShoulderWidth, torsoWaistWidth, torsoHeight;
	private Point rightShoulder, leftShoulder, leftWaist, rightWaist;
	
	/* Attributes for MiniFig Belt */
	private int beltWidth,beltHeight;
	private Point beltAnchor;
	
	/* Attributes for MiniFig Legs */
	private int ankleWidth, legSpacing, legLength;
	private int footWidth, footHeight;
	private int legDividerWidth, legDividerHeight;
	private Point rightHip, rightInseam, rightInnerAnkle, rightOuterAnkle;
	private Point leftHip, leftInseam, leftInnerAnkle, leftOuterAnkle;
	private Point legDividerAnchor;
	
	/* Attributes for MiniFig Arms */
	private int armUpperWidth, armUpperHeight, armCuffWidth;
	private Point rightArmAnchor, rightArmSleeve, rightArmElbow, rightArmCuffOuter, rightArmCuffInner, rightArmPit;
	private Point leftArmAnchor, leftArmSleeve, leftArmElbow, leftArmCuffOuter, leftArmCuffInner, leftArmPit;
	
	/* Attributes for MiniFig Hands */
	private Point rightWristCuffOuter, rightWristCuffInner, rightWristHandOuter, rightWristHandInner;
	private Point leftWristCuffOuter, leftWristCuffInner, leftWristHandOuter, leftWristHandInner;
	private int handDiameter, handHoleDiameter;
	private Point leftHandAnchor, rightHandAnchor;
	
	
	/**
	 * Constructor for a new MiniFig with a fixed size
	 * @param canvas Graphics canvas on which to draw the MiniFig
	 * @param midX X component of the MiniFig anchor point, located at the top, center of the MiniFig
	 * @param topY Y component of the MiniFig anchor point, located at the top, center of the MiniFig
	 */
	public MiniFig(Graphics canvas, int midX, int topY)
	{
		this(canvas,1.0,midX,topY);
	}
	
	
	/**
	 * @param canvas Graphics canvas on which to draw the MiniFig
	 * @param scaleFactor Decimal scaler to resize MiniFig
	 * @param midX X component of the MiniFig anchor point, located at the top, center of the MiniFig
	 * @param topY Y component of the MiniFig anchor point, located at the top, center of the MiniFig
	 */
	public MiniFig(Graphics canvas, double scaleFactor, int midX, int topY)
	{
		this.canvas = canvas;
		this.scaleFactor = scaleFactor;
		this.mid = midX;
		this.top = topY;
		
		initializeColors();
		initializeHead();
		initializeTorso();
		initializeBelt();
		initializeLegs();
		initializeArms();
		initializeHands();
	}
	
	/**
	 * Constructor for a new MiniFig with a fixed size
	 * @param canvas Graphics canvas on which to draw the MiniFig
	 * @param anchor The MiniFig anchor point is located at the top, center of the MiniFig
	 */
	public MiniFig(Graphics canvas, Point anchor)
	{
		this(canvas,anchor.x,anchor.y);
	}
	
	/**
	 * Constructor for a new MiniFig with a fixed size
	 * @param canvas Graphics canvas on which to draw the MiniFig
	 * @param anchor The MiniFig anchor point is located at the top, center of the MiniFig
	 */
	public MiniFig(Graphics canvas, double scaleFactor, Point anchor)
	{
		this(canvas,scaleFactor,anchor.x,anchor.y);
	}
	
	/**
	 * Helper method to set initial component colors
	 */
	private void initializeColors() {
		/* Define colors for each of the MiniFig components */
		headColor = new Color(255,227,48);
		eyeColor = Color.BLACK;
		torsoColor = new Color(7,60,145);
		beltColor = new Color (104,3,33);
		legColor = Color.BLACK;
		footColor = Color.DARK_GRAY;
		armColor = new Color (14, 250, 20);
		handColor = new Color(255,227,48);
		handHoleColor = new Color(255,255,255,200);
		outlineColor = Color.BLACK;
		
	}
	
	/**
	 * Helper method to initialize anchor points and dimensions for head
	 */
	private void initializeHead() {
		
		// Calculate scaled knob dimensions
		knobWidth = (int) (40 * scaleFactor);
		knobHeight = (int) (16 * scaleFactor);
		knobCurve = Math.min(5, (int) (5 * scaleFactor));
		
		// Define (x,y) coordinates for knob anchor point and store to Point object 
		knobAnchor = new Point(mid - knobWidth / 2, top );

		// Calculate scaled face dimensions
		faceWidth = (int) (84 * scaleFactor);
		faceHeight = (int) (75 * scaleFactor);
		faceCurve = Math.min(28, (int) (28 * scaleFactor));
		eyeSpacing = (int) (30 * scaleFactor);
		eyeDiameter = (int) (10 * scaleFactor);
		eyeDistFromTopOfFace = (int) (28 * scaleFactor); 
		mouthOvalDiameter = (int) (40 * scaleFactor);
		mouthDistFromTopOfFace = (int) (18 * scaleFactor);
		
		// Define (x,y) coordinates for face anchor point and store to Point object 
		faceAnchor = new Point (mid - faceWidth / 2,top + knobHeight );
		

		// Calculate scaled neck dimensions
		neckWidth = (int) (54 * scaleFactor);
		neckHeight = (int) (10 * scaleFactor);
		
		// Define (x,y) coordinates for neck anchor point and store to Point object 
		neckAnchor = new Point (mid - neckWidth / 2, faceAnchor.y + faceHeight);
		
		
	}
	
	/**
	 * Helper method to initialize anchor points and dimensions for torso
	 */
	private void initializeTorso() {
		// Calculate scaled torso dimensions
		torsoShoulderWidth = (int) (90 * scaleFactor);
		torsoWaistWidth = (int) (130 * scaleFactor);
		torsoHeight = (int) (114 * scaleFactor);
		
		// Calculate the Y axis position for shoulders and waist
		int torsoShoulderYOffset = neckAnchor.y + neckHeight;
		int torsoWaistYOffset = neckAnchor.y + neckHeight + torsoHeight;
		
		// Use the scaled dimensions to calculate x,y Points for torso
		rightShoulder = new Point(mid - torsoShoulderWidth / 2, torsoShoulderYOffset);
		leftShoulder = new Point(mid + torsoShoulderWidth / 2, torsoShoulderYOffset);
		leftWaist = new Point(mid + torsoWaistWidth / 2, torsoWaistYOffset);
		rightWaist = new Point(mid - torsoWaistWidth / 2, torsoWaistYOffset);
	}
	
	/**
	 * Helper method to initialize anchor points and dimensions for belt
	 */
	private void initializeBelt() {
		// Calculate scaled belt dimensions
		beltWidth = (int) (120 * scaleFactor);
		beltHeight = (int) (20 * scaleFactor);
		
		// Define (x,y) coordinates for belt anchor point and store to Point object
		beltAnchor = new Point(mid - beltWidth/2, leftWaist.y);
	}
	
	/**
	 * Helper method to initialize anchor points and dimensions for legs
	 */
	private void initializeLegs() {

		// Calculate scaled leg dimensions
		ankleWidth = (int) (60 * scaleFactor);
		legSpacing = (int) (10 * scaleFactor);
		legLength = (int) (94 * scaleFactor);
		footHeight = (int) (28 * scaleFactor);
		footWidth = ankleWidth;
		legDividerWidth = (int) (12 * scaleFactor);
		legDividerHeight = (int) (54 * scaleFactor);
		
		// Calculate the Y axis positions for upper and lower leg
		int upperLegYOffset = beltAnchor.y + beltHeight;
		int lowerLegYOffset = upperLegYOffset + legLength;
		
		// Use the scaled dimensions to calculate x,y Points for right leg
		rightHip = new Point(mid - beltWidth/2, upperLegYOffset);
		rightInseam = new Point(mid - (legSpacing / 2), upperLegYOffset);
		rightInnerAnkle = new Point(mid - (legSpacing / 2), lowerLegYOffset);
		rightOuterAnkle = new Point(mid - (legSpacing / 2 + ankleWidth),lowerLegYOffset);
		
		// Use the scaled dimensions to calculate x,y Points for left leg
		leftHip = new Point(mid + beltWidth/2, upperLegYOffset);
		leftInseam = new Point(mid + (legSpacing / 2), upperLegYOffset);
		leftInnerAnkle = new Point(mid + (legSpacing / 2), lowerLegYOffset);
		leftOuterAnkle= new Point(mid + (legSpacing / 2 + ankleWidth),lowerLegYOffset);
		
		// Use the scaled dimensions to calculate anchor point for leg divider
		legDividerAnchor = new Point(mid - legDividerWidth / 2, beltAnchor.y + beltHeight);
	}
	
	/**
	 * Helper method to initialize anchor points and dimensions for arms
	 */
	private void initializeArms() {

		// Calculate scaled arm dimensions
		armUpperWidth = (int) (31 * scaleFactor);
		armUpperHeight = (int) (20 * scaleFactor); 
		armCuffWidth = (int) (35 * scaleFactor);
		
		// Calculate the Y axis positions for left and right arms
		int armShoulderYOffset = leftShoulder.y + (int) (8 * scaleFactor);
		int armElbowYOffset = armShoulderYOffset + (int) (58 * scaleFactor);
		int armUpperCuffYOffset = armElbowYOffset + (int) (34 * scaleFactor);
		int armLowerCuffYOffset = armElbowYOffset + (int) (38 * scaleFactor);
		
		// Use the scaled dimensions to calculate x,y Points for right arm
		rightArmAnchor = new Point(mid - (torsoShoulderWidth / 2 + armUpperWidth ), armShoulderYOffset);
		rightArmSleeve = new Point(rightArmAnchor.x - (int) (2 * scaleFactor), rightArmAnchor.y + armUpperHeight - (int) (2 * scaleFactor));
		rightArmElbow = new Point(rightArmAnchor.x - (int) (18 * scaleFactor), armElbowYOffset);
		rightArmCuffOuter = new Point(rightArmAnchor.x - (int) (24 * scaleFactor), armUpperCuffYOffset);
		rightArmCuffInner = new Point(rightArmCuffOuter.x + armCuffWidth, armLowerCuffYOffset);
		rightArmPit = new Point(rightArmAnchor.x + armUpperWidth , rightArmAnchor.y);
		
		// Use the scaled dimensions to calculate x,y Points for left arm
		leftArmAnchor = new Point(mid + (torsoShoulderWidth / 2 - armUpperWidth), armShoulderYOffset);
		leftArmSleeve = new Point(leftArmAnchor.x  + armUpperWidth * 2 + (int) (2 * scaleFactor), leftArmAnchor.y + armUpperHeight - (int) (2 * scaleFactor) );
		leftArmElbow = new Point(leftArmAnchor.x + armUpperWidth*2 + (int) (18 * scaleFactor), armElbowYOffset);
		leftArmCuffOuter = new Point(leftArmAnchor.x + armUpperWidth*2 + (int) (24 * scaleFactor), armUpperCuffYOffset);
		leftArmCuffInner = new Point(leftArmAnchor.x + armUpperWidth + (int) (20 * scaleFactor), armLowerCuffYOffset);
		leftArmPit = new Point(leftArmAnchor.x + armUpperWidth, leftArmAnchor.y);
	}
	
	/**
	 * Helper method to initialize anchor points and dimensions for hands
	 */
	private void initializeHands() {
		int wristLength = (int) (15 * scaleFactor);
		// Calculate width of cuff using Pythagorean Theorem */
		double cuffWidth = Math.sqrt( Math.pow(Math.abs(rightArmCuffOuter.x - rightArmCuffInner.x),2) +
				Math.pow(Math.abs(rightArmCuffOuter.y - rightArmCuffInner.y),2));
		
		// Right Wrist
		double rightCuffSlope = ((double) rightArmCuffOuter.y - rightArmCuffInner.y) / (rightArmCuffOuter.x - rightArmCuffInner.x);
		double rightCuffAngle = Math.atan(rightCuffSlope);

		// Distance from outer cuff edge to outer wrist edge (1/5 cuffWidth)
		double rightWristDist1 = cuffWidth / 5.0;
		// Distance from outer cuff edge to inner wrist edge (4/5 cuffWidth)
		double rightWristDist2 = 4 * cuffWidth / 5.0; 

		// Use trig functions to calculate x,y components of Points required to draw wrist perpendicular to cuff on arm
		rightWristCuffOuter = new Point();
		rightWristCuffOuter.x = (int) (rightArmCuffOuter.x - (rightWristDist1 * (rightArmCuffOuter.x - rightArmCuffInner.x)) / cuffWidth);
		rightWristCuffOuter.y = (int) (rightArmCuffOuter.y - (rightWristDist1 * (rightArmCuffOuter.y - rightArmCuffInner.y)) / cuffWidth);
		
		rightWristCuffInner = new Point();
		rightWristCuffInner.x = (int) (rightArmCuffOuter.x - (rightWristDist2 * (rightArmCuffOuter.x - rightArmCuffInner.x)) / cuffWidth);
		rightWristCuffInner.y = (int) (rightArmCuffOuter.y - (rightWristDist2 * (rightArmCuffOuter.y - rightArmCuffInner.y)) / cuffWidth);
		
		rightWristHandOuter = new Point();
		rightWristHandOuter.x = (int)(rightWristCuffOuter.x + wristLength * Math.cos(rightCuffAngle + Math.PI/2.0));
		rightWristHandOuter.y = (int)(rightWristCuffOuter.y + wristLength * Math.sin(rightCuffAngle + Math.PI/2.0));
		
		rightWristHandInner = new Point();
		rightWristHandInner.x = (int)(rightWristCuffInner.x + wristLength * Math.cos(rightCuffAngle + Math.PI/2.0));
		rightWristHandInner.y = (int)(rightWristCuffInner.y + wristLength * Math.sin(rightCuffAngle + Math.PI/2.0));
		
		// Left Wrist
		double leftCuffSlope = ((double)leftArmCuffOuter.y - leftArmCuffInner.y) / (leftArmCuffOuter.x - leftArmCuffInner.x);
		double leftCuffAngle = Math.atan(leftCuffSlope);

		/* Distance from outer cuff edge to outer wrist edge (1/5 cuffWidth) */
		double leftWristDist1 = cuffWidth / 5.0;
		/* Distance from outer cuff edge to inner wrist edge (4/5 cuffWidth) */
		double leftWristDist2 = 4 * cuffWidth / 5.0; 
	
		// Use trig functions to calculate x,y components of Points required to draw wrist perpendicular to cuff on arm
		leftWristCuffOuter = new Point();
		leftWristCuffOuter.x = (int) (leftArmCuffOuter.x - (leftWristDist1 * (leftArmCuffOuter.x - leftArmCuffInner.x)) / cuffWidth);
		leftWristCuffOuter.y = (int) (leftArmCuffOuter.y - (leftWristDist1 * (leftArmCuffOuter.y - leftArmCuffInner.y)) / cuffWidth);
		
		leftWristCuffInner = new Point();
		leftWristCuffInner.x = (int) (leftArmCuffOuter.x - (leftWristDist2 * (leftArmCuffOuter.x - leftArmCuffInner.x)) / cuffWidth);
		leftWristCuffInner.y = (int) (leftArmCuffOuter.y - (leftWristDist2 * (leftArmCuffOuter.y - leftArmCuffInner.y)) / cuffWidth);
		
		leftWristHandOuter = new Point();
		leftWristHandOuter.x = (int)(leftWristCuffOuter.x + wristLength * Math.cos(leftCuffAngle + Math.PI / 2.0  )) + 1;
		leftWristHandOuter.y = (int)(leftWristCuffOuter.y + wristLength * Math.sin(leftCuffAngle + Math.PI / 2.0 ));
		
		leftWristHandInner = new Point();
		leftWristHandInner.x = (int)(leftWristCuffInner.x + wristLength * Math.cos(leftCuffAngle + Math.PI / 2.0 )) + 1;
		leftWristHandInner.y = (int)(leftWristCuffInner.y + wristLength * Math.sin(leftCuffAngle + Math.PI / 2.0 ));
		
		// Calculate scaled hand dimensions and position offsets		
		handDiameter = (int) (45 * scaleFactor);
		handHoleDiameter = (int) (30 * scaleFactor);
		int leftHandXShift = (int) (-30 * scaleFactor);
		int leftHandYShift = (int) (-1 * scaleFactor);
		int rightHandXShift = (int) (-16 * scaleFactor);
		int rightHandYShift = (int) (-1 * scaleFactor);
		
		leftHandAnchor = new Point (leftWristHandOuter.x + leftHandXShift,leftWristHandOuter.y + leftHandYShift );
		rightHandAnchor = new Point (rightWristHandOuter.x  +rightHandXShift,rightWristHandOuter.y + rightHandYShift );
		
	}

	/**
	 * Draws the MiniFig on the canvas
	 */
	public void draw()
	{	
		/* 
		 * Component: Head
		 */
		// Draw the knob component on the canvas
		int knobHeightPadded = knobHeight + 2; // extend knob below head to hide curved border
		canvas.setColor(headColor);
		canvas.fillRoundRect(knobAnchor.x,knobAnchor.y,knobWidth,knobHeightPadded,knobCurve,knobCurve); //head knob
		canvas.setColor(outlineColor);
		canvas.drawRoundRect(knobAnchor.x,knobAnchor.y,knobWidth,knobHeightPadded,knobCurve,knobCurve); //head knob

		// Calculate eye positions based upon scaled dimensions and anchor point
		int leftEyeXOffset = mid - (eyeSpacing / 2 + eyeDiameter / 2);
		int rightEyeXOffset = mid + (eyeSpacing / 2 - eyeDiameter / 2);
		int EyeYOffset = faceAnchor.y + eyeDistFromTopOfFace;
		int mouthXOffset = mid - mouthOvalDiameter / 2;
		int mouthYOffset = faceAnchor.y + mouthDistFromTopOfFace;
		
		// Draw the face components on the canvas
		canvas.setColor(headColor);
		canvas.fillRoundRect(faceAnchor.x,faceAnchor.y,faceWidth,faceHeight,faceCurve,faceCurve); //head
		canvas.setColor(outlineColor);
		canvas.drawRoundRect(faceAnchor.x,faceAnchor.y,faceWidth,faceHeight,faceCurve,faceCurve); //head
		canvas.setColor(eyeColor);
		canvas.fillOval(leftEyeXOffset, EyeYOffset, eyeDiameter, eyeDiameter); // right eye
		canvas.fillOval(rightEyeXOffset, EyeYOffset, eyeDiameter, eyeDiameter); // left eye
		canvas.setColor(outlineColor);
		canvas.drawArc(mouthXOffset,mouthYOffset,mouthOvalDiameter,mouthOvalDiameter,225,90); // mouth
		
		// Draw the neck component on the canvas
		canvas.setColor(headColor);
		canvas.fillRect(neckAnchor.x,neckAnchor.y,neckWidth,neckHeight);
		canvas.setColor(outlineColor);
		canvas.drawRect(neckAnchor.x,neckAnchor.y,neckWidth,neckHeight);
		
		/*
		 * Component: Belt
		 */
		// Draw the belt component on the canvas
		canvas.setColor(beltColor);
		canvas.fillRect(beltAnchor.x,beltAnchor.y, beltWidth, beltHeight); // belt
		canvas.setColor(outlineColor);
		canvas.drawRect(beltAnchor.x,beltAnchor.y, beltWidth, beltHeight); // belt

		/* 
		 * Component: Legs
		 */
		// Create a new Polygon object for the right leg using the above Points
		Polygon rightLeg = new Polygon();
		rightLeg.addPoint(rightHip.x, rightHip.y);
		rightLeg.addPoint(rightInseam.x, rightInseam.y);
		rightLeg.addPoint(rightInnerAnkle.x, rightInnerAnkle.y);
		rightLeg.addPoint(rightOuterAnkle.x, rightOuterAnkle.y);
		
		// Draw the right leg components on the canvas
		canvas.setColor(legColor);	
		canvas.fillPolygon(rightLeg);  //right leg
		canvas.setColor(outlineColor);
		canvas.drawPolygon(rightLeg);  //right leg
		canvas.setColor(footColor);
		canvas.fillRect(rightOuterAnkle.x, rightOuterAnkle.y, footWidth, footHeight); // right foot
		canvas.setColor(outlineColor);
		canvas.drawRect(rightOuterAnkle.x, rightOuterAnkle.y, footWidth, footHeight); // right foot

		// Create a new Polygon object for the left leg using the above Points
		Polygon leftLeg = new Polygon();
		leftLeg.addPoint(leftHip.x, leftHip.y);
		leftLeg.addPoint(leftInseam.x, leftInseam.y);
		leftLeg.addPoint(leftInnerAnkle.x, leftInnerAnkle.y);
		leftLeg.addPoint(leftOuterAnkle.x, leftOuterAnkle.y);
		
		// Draw the left leg components on the canvas
		canvas.setColor(legColor);	
		canvas.fillPolygon(leftLeg);  //left leg
		canvas.setColor(outlineColor);
		canvas.drawPolygon(leftLeg);  //left leg
		canvas.setColor(footColor);
		canvas.fillRect(leftInnerAnkle.x, leftInnerAnkle.y, footWidth, footHeight); // left foot
		canvas.setColor(outlineColor);
		canvas.drawRect(leftInnerAnkle.x, leftInnerAnkle.y, footWidth, footHeight); // left foot

		// Draw the leg divider components on the canvas
		canvas.setColor(footColor);
		canvas.fillRect(legDividerAnchor.x, legDividerAnchor.y, legDividerWidth, legDividerHeight);
		canvas.setColor(outlineColor);
		canvas.drawRect(legDividerAnchor.x, legDividerAnchor.y, legDividerWidth, legDividerHeight);
		
		/* 
		 * Component: Arms
		 */
		// Create a new Polygon object for the right arm using the above Points
		Polygon rightArm = new Polygon();
		rightArm.addPoint(rightArmSleeve.x, rightArmSleeve.y);
		rightArm.addPoint(rightArmElbow.x , rightArmElbow.y);
		rightArm.addPoint(rightArmCuffOuter.x, rightArmCuffOuter.y);
		rightArm.addPoint(rightArmCuffInner.x, rightArmCuffInner.y);
		rightArm.addPoint(rightArmPit.x, rightArmPit.y);
		
		// Draw the right arm components on the canvas
		canvas.setColor(armColor);
		canvas.fillPolygon(rightArm);
		canvas.setColor(outlineColor);
		canvas.drawPolygon(rightArm);
		canvas.setColor(armColor);
		canvas.fillArc(rightArmAnchor.x, rightArmAnchor.y, armUpperWidth * 2, armUpperHeight * 2,90,90);
		canvas.setColor(outlineColor);
		canvas.drawArc(rightArmAnchor.x, rightArmAnchor.y, armUpperWidth * 2, armUpperHeight * 2,90,80);
		
		// Create a new Polygon object for the left arm using the above Points
		Polygon leftArm = new Polygon();
		leftArm.addPoint(leftArmSleeve.x, leftArmSleeve.y);
		leftArm.addPoint(leftArmElbow.x, leftArmElbow.y);
		leftArm.addPoint(leftArmCuffOuter.x, leftArmCuffOuter.y);
		leftArm.addPoint(leftArmCuffInner.x, leftArmCuffInner.y);
		leftArm.addPoint(leftArmPit.x,leftArmPit.y );
		
		// Draw the right arm components on the canvas
		canvas.setColor(armColor);
		canvas.fillPolygon(leftArm);
		canvas.setColor(outlineColor);
		canvas.drawPolygon(leftArm);
		canvas.setColor(armColor);
		canvas.fillArc(leftArmAnchor.x, leftArmAnchor.y, armUpperWidth * 2, armUpperHeight * 2,90,-90);
		canvas.setColor(outlineColor);
		canvas.drawArc(leftArmAnchor.x, leftArmAnchor.y, armUpperWidth * 2, armUpperHeight * 2,90,-80);

		/* 
		 * Component: Torso 
		 */
		// Create a new Polygon object for the torso using the above Points
		Polygon torso = new Polygon();
		torso.addPoint(rightShoulder.x, rightShoulder.y ); //right shoulder point
		torso.addPoint(leftShoulder.x, leftShoulder.y); //left shoulder point
		torso.addPoint(leftWaist.x, leftWaist.y ); //left waist point
		torso.addPoint(rightWaist.x, rightWaist.y ); //right waist point
		
		// Draw the torso polygon over the top of the arms to make sure the shoulders look correct
		canvas.setColor(torsoColor);
		canvas.fillPolygon(torso);
		canvas.setColor(outlineColor);
		canvas.drawPolygon(torso);
			
		/* 
		 * Components: Wrists
		 */

		
		// Create a new Polygon object for the right wrist using the above Points
		Polygon rightWrist = new Polygon();
		rightWrist.addPoint(rightWristCuffOuter.x, rightWristCuffOuter.y);
		rightWrist.addPoint(rightWristCuffInner.x, rightWristCuffInner.y);
		rightWrist.addPoint(rightWristHandInner.x, rightWristHandInner.y);
		rightWrist.addPoint(rightWristHandOuter.x, rightWristHandOuter.y);
		
		// Draw the right wrist components on the canvas
		canvas.setColor(handColor);
		canvas.fillPolygon(rightWrist);
		canvas.setColor(outlineColor);
		canvas.drawPolygon(rightWrist);

		// Create a new Polygon object for the left wrist using the above Points
		Polygon leftWrist = new Polygon();
		leftWrist.addPoint(leftWristCuffOuter.x, leftWristCuffOuter.y);
		leftWrist.addPoint(leftWristCuffInner.x, leftWristCuffInner.y);
		leftWrist.addPoint(leftWristHandInner.x, leftWristHandInner.y);
		leftWrist.addPoint(leftWristHandOuter.x, leftWristHandOuter.y);
		
		// Draw the left wrist components on the canvas
		canvas.setColor(handColor);
		canvas.fillPolygon(leftWrist);
		canvas.setColor(outlineColor);
		canvas.drawPolygon(leftWrist);
		
		/* 
		 * Component:  Hands
		 */
		// Draw the left hand components on the canvas
		canvas.setColor(handColor);
		canvas.fillArc(leftHandAnchor.x, leftHandAnchor.y , handDiameter, handDiameter,-45,290);
		canvas.fillOval(leftHandAnchor.x + ((handDiameter - handHoleDiameter) / 2), leftHandAnchor.y + ((handDiameter - handHoleDiameter) / 2), handHoleDiameter, handHoleDiameter);
		canvas.setColor(outlineColor);
		canvas.drawArc(leftHandAnchor.x, leftHandAnchor.y, handDiameter, handDiameter,-45,290);
		canvas.setColor(handHoleColor);
		canvas.fillOval(leftHandAnchor.x + ((handDiameter - handHoleDiameter) / 2), leftHandAnchor.y + ((handDiameter - handHoleDiameter) / 2), handHoleDiameter, handHoleDiameter);
		canvas.setColor(outlineColor);
		canvas.drawArc(leftHandAnchor.x + ((handDiameter - handHoleDiameter) / 2), leftHandAnchor.y + ((handDiameter - handHoleDiameter) / 2), handHoleDiameter, handHoleDiameter,-45,290);
		
		// Draw the right hand components on the canvas
		canvas.setColor(handColor);
		canvas.fillArc(rightHandAnchor.x, rightHandAnchor.y, handDiameter, handDiameter,-60,290);
		canvas.fillOval(rightHandAnchor.x  + ((handDiameter - handHoleDiameter) / 2), rightHandAnchor.y + ((handDiameter - handHoleDiameter) / 2), handHoleDiameter, handHoleDiameter);
		canvas.setColor(outlineColor);
		canvas.drawArc(rightHandAnchor.x, rightHandAnchor.y, handDiameter, handDiameter,-60,290);
		
		canvas.setColor(handHoleColor);
		canvas.fillOval(rightHandAnchor.x  + ((handDiameter - handHoleDiameter) / 2), rightHandAnchor.y + ((handDiameter - handHoleDiameter) / 2), handHoleDiameter, handHoleDiameter);
		canvas.setColor(outlineColor);
		canvas.drawArc(rightHandAnchor.x + ((handDiameter - handHoleDiameter) / 2), rightHandAnchor.y + ((handDiameter - handHoleDiameter) / 2), handHoleDiameter, handHoleDiameter,-60,290);

	}
	
	/**
	 * Change the color of the MiniFig head to the specified value. MiniFig
	 *   must be redrawn for the color change to take affect.
	 *   
	 * @param headColor the headColor to set
	 */
	public void setHeadColor(Color headColor) {
		this.headColor = headColor;
	}


	/**
	 * Change the color of the MiniFig torso to the specified value. MiniFig
	 *   must be redrawn for the color change to take affect.
	 *   
	 * @param torsoColor the torsoColor to set
	 */
	public void setTorsoColor(Color torsoColor) {
		this.torsoColor = torsoColor;
	}

	/**
	 * Change the color of the MiniFig belt to the specified value. MiniFig
	 *   must be redrawn for the color change to take affect.
	 *   
	 * @param beltColor the beltColor to set
	 */
	public void setBeltColor(Color beltColor) {
		this.beltColor = beltColor;
	}

	/**
	 * Change the color of the MiniFig legs to the specified value. MiniFig
	 *   must be redrawn for the color change to take affect.
	 *   
	 * @param legColor the legColor to set
	 */
	public void setLegColor(Color legColor) {
		this.legColor = legColor;
	}

	/**
	 * Change the color of the MiniFig feet to the specified value. MiniFig
	 *   must be redrawn for the color change to take affect.
	 *   
	 * @param footColor the footColor to set
	 */
	public void setFootColor(Color footColor) {
		this.footColor = footColor;
	}

	/**
	 * Change the color of the MiniFig arms to the specified value. MiniFig
	 *   must be redrawn for the color change to take affect.
	 *   
	 * @param armColor the armColor to set
	 */
	public void setArmColor(Color armColor) {
		this.armColor = armColor;
	}

	/**
	 * Change the color of the MiniFig hands to the specified value. MiniFig
	 *   must be redrawn for the color change to take affect.
	 *   
	 * @param handColor the handColor to set
	 */
	public void setHandColor(Color handColor) {
		this.handColor = handColor;
	}

	/**
	 * Change the color of the center of the hands to the specified value. MiniFig
	 *   must be redrawn for the color change to take affect.
	 *   
	 * @param handHoleColor the handHoleColor to set
	 */
	public void setHandHoleColor(Color handHoleColor) {
		this.handHoleColor = handHoleColor;
	}
	
	/**
	 * Change the color of the MiniFig eyes to the specified value. MiniFig
	 *   must be redrawn for the color change to take affect.
	 *   
	 * @param eyeColor the eyeColor to set
	 */
	public void setEyeColor(Color eyeColor) {
		this.eyeColor = eyeColor;
	}
	
	/**
	 * Change the color of the MiniFig outline to the specified value. MiniFig
	 *   must be redrawn for the color change to take affect.
	 *   
	 * @param outlineColor the color for drawing the MiniFig outline
	 */
	public void setOutlineColor(Color outlineColor) {
		this.outlineColor = outlineColor;
	}

	/**
	 * Get the Point (x,y) representing the top of the face.
	 * 
	 * @return the capPoint
	 */
	public Point getCapPoint() {
		return new Point(this.mid, this.top + this.knobHeight);
	}
	
	/**
	 * Get the Point (x,y) representing the center of the left hand from the
	 *   MiniFig's perspective.
	 * 
	 * @return the center Point of left hand
	 */
	public Point getLeftHandCenterPoint() {
		return new Point(this.leftHandAnchor.x+this.handDiameter/2, this.leftHandAnchor.y + this.handDiameter/2);
	}
	
	/**
	 * Get the Point (x,y) representing the center of the right hand from the
	 *   MiniFig's perspective.
	 * 
	 * @return the center Point of right hand
	 */
	public Point getRightHandCenterPoint() {
		return new Point(this.rightHandAnchor.x+this.handDiameter/2, this.rightHandAnchor.y + this.handDiameter/2);
	}

	/**
	 * Get the Point (x,y) representing the right shoulder from the 
	 *    MiniFig's perspective.
	 *    
	 * @return the rightShoulder
	 */
	public Point getRightShoulderPoint() {
		return rightShoulder;
	}

	/**
	 * Get the Point (x,y) representing the left shoulder from the 
	 *    MiniFig's perspective.
	 *    
	 * @return the leftShoulder
	 */
	public Point getLeftShoulderPoint() {
		return leftShoulder;
	}
	
	/**
	 * Get the total height of the MiniFig, measured from the top of 
	 *    of the knob to the bottom of the feet.
	 *    
	 * @return the total height of MiniFig
	 */
	public int getHeight() {
		int totalHeight = this.leftInnerAnkle.y + this.footHeight - this.top;
		return totalHeight;
	}

	/**
	 * Get the total width of the MiniFig, measured from the outside 
	 *    edge of the right hand to the outside edge of the left hand.
	 * 
	 * @return the total width of MiniFig
	 */
	public int getWidth() {
		int totalWidth = this.leftHandAnchor.x + this.handDiameter - this.rightHandAnchor.x ;
		return totalWidth;
	}
	
	/**
	 * Get the Point (x,y) representing the top middle of the MiniFig. This
	 *   Point is actually the same as the anchor point that is specified
	 *   when the MiniFig is created.
	 * 
	 * @return a point along the middle axis of the MiniFig at the top
	 */
	public Point getTopMidPoint() {
		return new Point(this.mid,this.top);
	}
	
	/**
	 * Get the Point (x,y) representing the bottom middle of the MiniFig.
	 * 
	 * @return a point along the middle axis of the MiniFig at the base
	 */
	public Point getBaseMidPoint() {
		return new Point(this.mid,this.leftInnerAnkle.y + this.footHeight);
	}
	
	/**
	 * Get the height of the MiniFig's face.
	 * 
	 * @return the height of the MiniFig face
	 */
	public int getFaceHeight() {
		return this.faceHeight;
	}
	
	/**
	 * Get the width of the MiniFig's face.
	 * 
	 * @return the width of the MiniFig face
	 */
	public int getFaceWidth() {
		return this.faceWidth;
	}
	
	



}
