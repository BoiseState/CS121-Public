import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

/**
 * Demonstrates replacing a GUI panel in a running program.
 * NOTE: Whenever possible, an existing component should be reconfigured,
 * not replaced. However, there are times when a component cannot simply
 * be reconfigured, so this is one way to replace components in a running
 * program.
 * 
 * @author mvail
 */
@SuppressWarnings("serial")
public class PanelReplacer extends JPanel implements ActionListener {
	private JPanel gridPanel;
	private JLabel[][] label;
	private int gridDim;
	private JTextField gridDimText;
	private final int DEFAULT_GRID_DIM = 3;
	private final int LABEL_DIM = 120;
	
	/**
	 * main panel constructor
	 */
	private PanelReplacer() {
		gridDim = DEFAULT_GRID_DIM;
		
		//control panel
		JButton updateButton = new JButton("Update Grid");
		updateButton.addActionListener(this);
		gridDimText = new JTextField(5);
		gridDimText.setText(Integer.toString(gridDim));
		gridDimText.setBorder(BorderFactory.createTitledBorder("Grid Dim"));
		gridDimText.addActionListener(this);
		JPanel controlPanel = new JPanel();
		controlPanel.add(gridDimText);
		controlPanel.add(updateButton);
		
		//grid panel
		configureGridPanel();
		gridPanel.setPreferredSize(new Dimension(gridDim*LABEL_DIM, gridDim*LABEL_DIM));
		
		//this (primary) panel
		this.setLayout(new BorderLayout());
		this.add(controlPanel, BorderLayout.SOUTH);
		this.add(gridPanel, BorderLayout.CENTER);
	}
	
	/**
	 * method to replace gridPanel with a new grid panel, if configuration
	 * input is valid
	 */
	private void configureGridPanel() {
		int oldGridDim = gridDim; //store in case invalid value in gridDimText
		try {
			gridDim = Integer.parseInt(gridDimText.getText().trim());
			if (gridDim < 1) { //invalid dimension
				//reset gridDim and text field to previous values
				gridDim = oldGridDim;
				gridDimText.setText(Integer.toString(gridDim));
			} else { //valid input, so configure a new gridPanel
				if (gridPanel != null) { //if we have a previous gridPanel
					this.remove(gridPanel);
				}
				gridPanel = new JPanel();
				gridPanel.setLayout(new GridLayout(gridDim, gridDim));
				//populate gridPanel with labels
				label = new JLabel[gridDim][gridDim];
				for (int row = 0; row < label.length; row++) {
					for (int col = 0; col < label[row].length; col++) {
						label[row][col] = new JLabel(String.format("%d,%d", row, col));
						label[row][col].setBorder(BorderFactory.createEtchedBorder());
						label[row][col].setHorizontalAlignment(SwingConstants.CENTER);
						gridPanel.add(label[row][col]);
					}
				}
				//add new gridPanel to primary panel
				this.add(gridPanel, BorderLayout.CENTER);
				this.revalidate(); //causes panel to refresh itself with new contents
			}
		} catch (NumberFormatException nfe) { //invalid input in text field
			//reset gridDim and text field to previous values
			gridDim = oldGridDim;
			gridDimText.setText(Integer.toString(gridDim));
		}
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		configureGridPanel();
	}

	/**
	 * @param args unused
	 */
	public static void main(String[] args) {
		JFrame frame = new JFrame("Panel Replacer");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().add(new PanelReplacer());
		frame.pack();
		frame.setVisible(true);
	}
}
