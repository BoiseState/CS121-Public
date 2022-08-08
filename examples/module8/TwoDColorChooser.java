import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

/**
 * Demonstrate 2D array of GUI components. (This could all be done using a
 * 1D array. See MiniColorChooserV1.java and MiniColorChooserV2.java).
 * 
 * Get color from the clicked button, itself.
 * 
 * @author CS121 Instructors
 */
@SuppressWarnings("serial")
public class TwoDColorChooser extends JPanel 
{
	private final Color[][] COLORS = { { Color.RED, Color.GREEN, Color.BLUE }, 
									   { Color.YELLOW, Color.CYAN, Color.MAGENTA },
									   { Color.WHITE, Color.BLACK, Color.GRAY },
									   { Color.PINK, Color.ORANGE, Color.LIGHT_GRAY} };
	
	private JButton[][] colorButtons;
	private JPanel displayPanel;
	
	/**
	 * main panel constructor
	 */
	private TwoDColorChooser() 
	{
		//sub-panel for grid of color choices
		JPanel gridPanel = new JPanel();
		gridPanel.setLayout(new GridLayout(COLORS.length, COLORS[0].length));
		gridPanel.setPreferredSize(new Dimension(300, 300));
		
		//sub-panel to display chosen color
		displayPanel = new JPanel();
		displayPanel.setPreferredSize(new Dimension(300,300));
		
		//instantiate a ColorButtonListener. all buttons should share the same instance.
		ColorButtonListener listener = new ColorButtonListener();
		
		//buttons
		colorButtons = new JButton[COLORS.length][COLORS[0].length];
		for (int i = 0; i < colorButtons.length; i++) {
			for(int j = 0; j < colorButtons[0].length; j++) {
				colorButtons[i][j] = new JButton();
				colorButtons[i][j].setBackground(COLORS[i][j]);
				colorButtons[i][j].addActionListener(listener);
				gridPanel.add(colorButtons[i][j]);
			}
		}
		
		//add sub-panels to this panel
		this.add(gridPanel);
		this.add(displayPanel);
	}

	private class ColorButtonListener implements ActionListener
	{
		@Override
		public void actionPerformed(ActionEvent e)
		{
			// have to cast generic Object reference from e.getSource()
			// to a JButton reference in order to use button method
			// getBackground()
			JButton source = (JButton)(e.getSource());
			
			//set display panel to the color of the button that was clicked
			displayPanel.setBackground(source.getBackground());
		}
	}

	/**
	 * Initialize the GUI and make it visible
	 * @param args unused
	 */
	public static void main(String[] args)
	{
		JFrame frame = new JFrame("Mini-ColorChooser");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		frame.getContentPane().add(new TwoDColorChooser());
		
		frame.pack();
		frame.setVisible(true);
	}
}