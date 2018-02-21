import java.awt.*;
import java.awt.event.*;
import java.util.Random;
import javax.swing.*;

/**
 * Draw user-specified number of circles on a panel, with the 
 * largest circle red and all others blue.
 * This class is the program driver, the JFrame, and the 
 * ActionListener, all rolled into one. It serves as the 
 * "Controller" in this program's Model-View-Controller design.
 * @author mvail
 */
@SuppressWarnings("serial")
public class CircleMaker extends JFrame implements ActionListener
{
	private static final int DEFAULT_NUM_CIRCLES = 3;
	private JPanel mainPanel;
	private JPanel controlPanel;
	private CircleMakerDrawPanel drawPanel;
	private JTextField numCirclesText;
	private JButton drawButton;
	private JButton clearButton;
	
	private Random rand = new Random(); //maintained just for convenience

	/**
	 * extended JFrame constructor
	 */
	public CircleMaker()
	{
		setTitle("Circle Maker");
		
		mainPanel = new JPanel(new BorderLayout());
		setupControlPanel();
		
		drawPanel = new CircleMakerDrawPanel();
		drawPanel.setPreferredSize(new Dimension(400, 400));
		
		mainPanel.add(controlPanel, BorderLayout.WEST);
		mainPanel.add(drawPanel, BorderLayout.CENTER);
		getContentPane().add(mainPanel);
	}
	
	/**
	 *  Setup the control panel.
	 */
	private void setupControlPanel() 
	{
		controlPanel = new JPanel();
		controlPanel.setLayout(new BoxLayout(controlPanel, BoxLayout.Y_AXIS));
		
		numCirclesText = new JTextField(5);
		numCirclesText.setBorder(BorderFactory.createTitledBorder("Circles"));
		numCirclesText.setText(Integer.toString(DEFAULT_NUM_CIRCLES));
		numCirclesText.addActionListener(this);
		numCirclesText.setFont(new Font("Helvitica", Font.BOLD, 18));
		
		drawButton = new JButton("Draw");
		drawButton.addActionListener(this);
		
		clearButton = new JButton("Clear");
		clearButton.addActionListener(this);
		
		controlPanel.add(Box.createVerticalGlue());
		numCirclesText.setMaximumSize(new Dimension(200, 20));
		
		controlPanel.add(numCirclesText);
		controlPanel.add(drawButton);
		controlPanel.add(clearButton);
		controlPanel.add(Box.createVerticalGlue());		
	}

	/**
	 * ActionListener method to coordinate text box (or button) input and the draw panel 
	 */
	@Override
	public void actionPerformed(ActionEvent e) {
		int numCircles = 0;
		if (e.getSource() == drawButton || e.getSource() == numCirclesText) {
			numCircles = Integer.parseInt(numCirclesText.getText());
		} else if (e.getSource() == clearButton) {
			numCircles = 0;
		}
		drawPanel.paintCircles(makeCircles(numCircles));
	}
	
	/**
	 * Generates a new array of numCircles Circles.
	 */
	private Circle[] makeCircles(int numCircles) {
		Circle[] circles = new Circle[numCircles];
		int panelWidth = drawPanel.getWidth();
		int panelHeight = drawPanel.getHeight();
		int minDim = Math.min(panelWidth, panelHeight);
		int minDiameter = minDim / 20;
		int diameterRange = minDim*3/4 - minDiameter;
		
		//generate circle diameters and coordinates
		for (int i = 0; i < numCircles; i++)
		{
			int diameter = rand.nextInt(diameterRange) + minDiameter;
			int xAnchor = rand.nextInt(panelWidth - diameter); //keep circles completely in-bounds
			int yAnchor = rand.nextInt(panelHeight - diameter);
			circles[i] = new Circle(xAnchor, yAnchor, diameter);
		}
		return circles;
	}

	/**
	 * Creates an instance of this class and sets the size and
	 * visibility of its JFrame.
	 * @param args 
	 */
	public static void main(String args[])
	{
		final CircleMaker f = new CircleMaker();
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		//f.setSize(550, 450);
		f.pack();
		f.setLocationRelativeTo(null); //center the frame on the screen
		f.setVisible(true);
	}
}
