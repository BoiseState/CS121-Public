import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

/**
 * Demonstrate 1D array of GUI components.
 * Get color from the clicked button, itself.
 * 
 * @author mvail
 */
@SuppressWarnings("serial")
public class MiniColorChooserV1 extends JPanel implements ActionListener 
{
	private final int GRID_DIM = 3;
	private JButton[] colorButton;
	private JPanel displayPanel;
	
	/**
	 * main panel constructor
	 */
	private MiniColorChooserV1() 
	{
		//sub-panel for grid of color choices
		JPanel gridPanel = new JPanel();
		gridPanel.setLayout(new GridLayout(GRID_DIM, GRID_DIM));
		gridPanel.setPreferredSize(new Dimension(300,300));
		
		//sub-panel to display chosen color
		displayPanel = new JPanel();
		displayPanel.setPreferredSize(new Dimension(300,300));
		
		//colors 
		Color[] color = {Color.red, Color.green, Color.blue, 
				 new Color(255, 255, 0), new Color(0, 255, 255), new Color(255, 0, 255),
				 Color.white, Color.black, Color.gray};
		
		//buttons
		colorButton = new JButton[GRID_DIM*GRID_DIM];
		for (int i = 0; i < colorButton.length; i++) {
			colorButton[i] = new JButton();
			colorButton[i].setBackground(color[i]);
			colorButton[i].addActionListener(this);
			gridPanel.add(colorButton[i]);
		}
		
		//add sub-panels to this panel
		this.add(gridPanel);
		this.add(displayPanel);
	}

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

	/**
	 * Initialize the GUI and make it visible
	 * @param args unused
	 */
	public static void main(String[] args)
	{
		JFrame frame = new JFrame("Mini-ColorChooser");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		frame.getContentPane().add(new MiniColorChooserV1());
		
		frame.pack();
		frame.setVisible(true);
	}
}