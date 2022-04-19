import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

/**
 * Demonstrate 2D arrays of GUI components
 * Determine clicked button indexes and look up color in parallel array.
 * 
 * @author mvail
 */
@SuppressWarnings("serial")
public class MiniColorChooserV3 extends JPanel implements ActionListener {
	private final int GRID_DIM = 3;
	private JButton[][] colorButton;
	private Color[][] color;
	private JPanel displayPanel;
	
	/**
	 * main panel constructor
	 */
	private MiniColorChooserV3() {
		//sub-panel for grid of color choices
		JPanel gridPanel = new JPanel();
		gridPanel.setLayout(new GridLayout(GRID_DIM, GRID_DIM));
		gridPanel.setPreferredSize(new Dimension(120,120));;
		//sub-panel to display chosen color
		displayPanel = new JPanel();
		displayPanel.setPreferredSize(new Dimension(120,120));
		//colors 
		Color[][] c = {{Color.red, Color.green, Color.blue}, 
				 {new Color(255, 255, 0), new Color(0, 255, 255), new Color(255, 0, 255)},
				 {Color.white, Color.black, Color.gray}};
		color = c; //necessary to use initializer list in constructor
					//while also storing array as instance data
		//buttons
		colorButton = new JButton[GRID_DIM][GRID_DIM];
		for (int row = 0; row < colorButton.length; row++) {
			for (int col = 0; col < colorButton[row].length; col++) {
				colorButton[row][col] = new JButton();
				colorButton[row][col].setBackground(color[row][col]);
				colorButton[row][col].addActionListener(this);
				gridPanel.add(colorButton[row][col]);
			}
		}
		//add sub-panels to this panel
		this.add(gridPanel);
		this.add(displayPanel);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		//find the row and col of the clicked button and set the
		//display panel color to the corresponding color in the
		//color array
		for (int row = 0; row < colorButton.length; row++) {
			for (int col = 0; col < colorButton[row].length; col++) {
				if (e.getSource() == colorButton[row][col]) {
					displayPanel.setBackground(color[row][col]);
				}
			}
		}
		//NOTE: This is an unnecessarily inefficient way to find the
		//button color. A loop like this only makes sense if you need
		//to know the row and column of the button. In this case, we
		//used the row and column values to index into the color array.
		//The functionality of the loop above, however, can be 
		//accomplished in two statements:
		//JButton button = (JButton)(e.getSource());
		//displayPanel.setBackground(button.getBackground());
	}

	/**
	 * Initialize the GUI and make it visible
	 * @param args unused
	 */
	public static void main(String[] args) {
		JFrame frame = new JFrame("Mini-ColorChooser");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		frame.getContentPane().add(new MiniColorChooserV3());
		
		frame.pack();
		frame.setVisible(true);
	}
}
