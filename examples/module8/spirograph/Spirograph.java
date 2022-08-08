package spirograph;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

/**
 * Simulates a "spirograph" toy with an anchor circle and a moving
 * drawing circle with a pen at a specified distance from the drawing
 * circle's center that rotates as the drawing circle rotates.
 * A simulation is even better than a physical spirograph, because
 * it is not necessary for the inner moving circle to fit within the
 * anchor circle and it is not necessary for the pen to be within
 * the drawing circle's boundaries.
 * 
 * @author mvail
 */
@SuppressWarnings("serial")
public class Spirograph extends JFrame implements ActionListener
{
	private final int DEFAULT_DISPLAY_DIM = 400;
	private final int DEFAULT_DELAY = 50;
	private final double ANGLE_INCREMENT = Math.PI/60;
	private final String START_TEXT = "Start";
	private final String STOP_TEXT = "Stop";
	private final int DRAWING_POINTS = 1;
	
	private JPanel mainPanel;
	private JPanel controlPanel;
	private SpirographDrawPanel drawPanel;
	private JButton timerButton;
	private JButton clearButton;
	private JTextField radius1Text;
	private JCheckBox radius1ShowCheck;
	private JTextField radius2Text;
	private JCheckBox radius2ShowCheck;
	private JTextField[] drawingRadiusText;
	private JCheckBox[] drawingShowCheck;
	private int[] drawingRadius;
//	private JTextField radius3Text;
//	private JCheckBox radius3ShowCheck;
	private int radius1; //less than or equal to half min display width or height 
	private int radius2; //less than radius1
//	private int radius3; //less than or equal to radius2
	private Circle circle1; //outer circle
	private DrawingCircle circle2; //middle circle
	private Timer timer;

	public Spirograph()
	{
		timer = new Timer(DEFAULT_DELAY, this);
		
		int midDim = DEFAULT_DISPLAY_DIM / 2;
		radius1 = DEFAULT_DISPLAY_DIM / 2;
		radius2 = radius1 * 3 / 5;
//		radius3 = radius2 / 2;

		circle1 = new Circle(midDim, midDim, radius1);
		circle2 = new DrawingCircle(midDim + radius2, midDim, radius2, radius1 - radius2, radius2/2);//fix
		
		this.setTitle("Spirograph");
		
		mainPanel = new JPanel();
		mainPanel.setLayout(new BorderLayout());

		controlPanel = new JPanel();
		controlPanel.setLayout(new BoxLayout(controlPanel, BoxLayout.Y_AXIS));
		
		radius1Text = new JTextField(5);
		radius1Text.setText(Integer.toString(radius1));
		radius1Text.addActionListener(this);
		//radius1Text.setMaximumSize(new Dimension(150, 50));
		radius1Text.setToolTipText("Radius");
		radius1ShowCheck = new JCheckBox("show", true);
		radius1ShowCheck.addActionListener(this);
		JPanel r1 = new JPanel();
		r1.setBorder(BorderFactory.createTitledBorder("Anchor Circle"));
		r1.setMaximumSize(new Dimension(250,75));
		r1.add(radius1Text);
		r1.add(radius1ShowCheck);
		
		radius2Text = new JTextField(5);
		radius2Text.setText(Integer.toString(radius2));
		radius2Text.addActionListener(this);
		//radius2Text.setMaximumSize(new Dimension(150, 50));
		radius2Text.setToolTipText("Radius");
		radius2ShowCheck = new JCheckBox("show", true);
		radius2ShowCheck.addActionListener(this);
		JPanel r2 = new JPanel();
		r2.setBorder(BorderFactory.createTitledBorder("Drawing Circle"));
		r2.setMaximumSize(new Dimension(250,75));
		r2.add(radius2Text);
		r2.add(radius2ShowCheck);

		JPanel r3 = new JPanel();
		r3.setBorder(BorderFactory.createTitledBorder("Drawing Radii"));
		r3.setMaximumSize(new Dimension(250,75*DRAWING_POINTS));
		drawingRadius = new int[DRAWING_POINTS];
		drawingRadiusText = new JTextField[DRAWING_POINTS];
		drawingShowCheck = new JCheckBox[DRAWING_POINTS];
		for(int i = 0; i < DRAWING_POINTS; i++) {
			drawingRadius[i] = radius2 / 2;
			drawingRadiusText[i] = new JTextField(5);
			drawingRadiusText[i].setText(Integer.toString(drawingRadius[i]));
			drawingRadiusText[i].addActionListener(this);
			drawingShowCheck[i] = new JCheckBox("show", true);
			r3.add(drawingRadiusText[i]);
			r3.add(drawingShowCheck[i]);
		}

//		radius3Text = new JTextField(5);
//		//radius3Text.setMaximumSize(new Dimension(150, 50));
//		radius3Text.setText(Integer.toString(radius3));
//		radius3Text.addActionListener(this);
//		radius3Text.setToolTipText("Radius");
//		radius3ShowCheck = new JCheckBox("show", true);
//		r3.add(radius3Text);
//		r3.add(radius3ShowCheck);
		
		timerButton = new JButton(START_TEXT);
		timerButton.addActionListener(this);
		clearButton = new JButton("Clear");
		clearButton.addActionListener(this);
		controlPanel.add(Box.createVerticalGlue());
		controlPanel.add(r1);
		controlPanel.add(r2);
		controlPanel.add(r3);
		controlPanel.add(Box.createRigidArea(new Dimension(0,10)));
		controlPanel.add(timerButton);
		controlPanel.add(clearButton);
		controlPanel.add(Box.createRigidArea(new Dimension(0,10)));
		controlPanel.add(Box.createVerticalGlue());
		
		drawPanel = new SpirographDrawPanel();
		drawPanel.setPreferredSize(new Dimension(DEFAULT_DISPLAY_DIM, DEFAULT_DISPLAY_DIM));
		Circle[] circles = {circle1, circle2};
		drawPanel.drawCircles(circles);
		
		mainPanel.add(controlPanel, BorderLayout.WEST);
		mainPanel.add(drawPanel, BorderLayout.CENTER);
		getContentPane().add(mainPanel);
	}
	
	/**
	 * get current values from radius inputs and update circles
	 */
	private void updateCircles() {
		int prevR1 = radius1;
		try {
			radius1 = Integer.parseInt(radius1Text.getText());
			Point p = drawPanel.getMidPoint();
			circle1.setCenterPoint(new Point(p.x, p.y));
			circle1.setRadius(radius1);
		} catch (NumberFormatException nfe) {
			radius1 = prevR1;
			radius1Text.setText(Integer.toString(radius1));
		}
		int prevR2 = radius2;
		try {
			radius2 = Integer.parseInt(radius2Text.getText());
			Point p = circle1.getCenterPoint();
			circle2.setCenterPoint(new Point(p.x + radius2, p.y));
			circle2.setRadius(radius2);
			circle2.setDistanceFromAnchor(radius1 - radius2);
		} catch (NumberFormatException nfe) {
			radius2 = prevR2;
			radius2Text.setText(Integer.toString(radius2));
		}
		for (int i = 0; i < DRAWING_POINTS; i++) {
			int prevRad = drawingRadius[i];
			try {
				drawingRadius[i] = Integer.parseInt(drawingRadiusText[i].getText());
				circle2.setPenRadius(drawingRadius[i]);
			} catch (NumberFormatException nfe) {
				drawingRadius[i] = prevRad;
				drawingRadiusText[i].setText(Integer.toString(drawingRadius[i]));
			}
		}
	}
	
	/* (non-Javadoc)
	 * @see java.awt.event.ActionListener#actionPerformed(java.awt.event.ActionEvent)
	 */
	@Override
	public void actionPerformed(ActionEvent e) {
		Circle[] circles = {circle1, circle2};
		if (e.getSource() == timer) {
			circle2.rotate(circle1.getCenterPoint(), ANGLE_INCREMENT);
		}
		else if (e.getSource() == timerButton) {
			if (timer.isRunning()) {
				timer.stop();
				timerButton.setText(START_TEXT);
			} else {
				updateCircles();
				timer.start();
				timerButton.setText(STOP_TEXT);
			}
		}
		else if (e.getSource() == clearButton) {
			circle2.clearPenPoints();
		}
		else {
			if (radius1ShowCheck.isSelected()) {
				circle1.show();
			} else {
				circle1.hide();
			}
			if (radius2ShowCheck.isSelected()) {
				circle2.show();
			} else {
				circle2.hide();
			}
			updateCircles();
		}
		drawPanel.drawCircles(circles);
	}

	/**
	 * Creates an instance of this class and sets the size and
	 * visibility of its JFrame. An anonymous class is used to create an
	 * instance of the WindowListener class, which handles the window close
	 * events for the application.
	 */
	public static void main(String args[])
	{
		final Spirograph f = new Spirograph();
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		//f.setSize(550, 450);
		f.pack();
		f.setLocationRelativeTo(null); //center
		f.setVisible(true);
	}
}
