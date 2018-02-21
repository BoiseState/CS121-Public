import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.BorderFactory;
import javax.swing.JButton;
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
 * @author marissa
 */
@SuppressWarnings("serial")
public class GameBoardPanel extends JPanel
{
	private static final int DEFAULT_GRID_DIM = 3;
	private static final int LABEL_DIM = 120;
	
	private JPanel gridPanel;
	private JLabel[][] labels;
	
	private JTextField gridDimInput;
	
	private int gridDim;
	
	
	/**
	 * main panel constructor
	 */
	public GameBoardPanel()
	{
		this.setLayout(new BorderLayout());
		
		this.gridDim = DEFAULT_GRID_DIM;
		
		// Initialize shared listener for button and input text field.
		UpdateGridListener listener = new UpdateGridListener();
		
		
		// Create control panel (update button and input field)
		JPanel controlPanel = new JPanel();
		
		JButton updateButton = new JButton("Update Grid");
		updateButton.addActionListener(listener);
		
		gridDimInput = new JTextField(5);
		gridDimInput.setText(Integer.toString(gridDim));
		gridDimInput.setBorder(BorderFactory.createTitledBorder("Grid Dim"));
		gridDimInput.addActionListener(listener);
		
		controlPanel.add(gridDimInput);
		controlPanel.add(updateButton);
		
		// Creates and adds the grid panel to the NORTH
		configureGridPanel();
		
		// Add control to the main panel
		add(controlPanel, BorderLayout.SOUTH);
	}
	
	/**
	 * method to replace gridPanel with a new grid panel, if configuration
	 * input is valid
	 */
	private void configureGridPanel()
	{
		int oldGridDim = gridDim; //store in case invalid value in gridDimText
		
		try {
			gridDim = Integer.parseInt(gridDimInput.getText().trim());
			
			if (gridDim < 1) { // invalid input
				//reset gridDim and text field to previous values
				gridDim = oldGridDim;
				gridDimInput.setText(Integer.toString(gridDim));
			}
			else { //valid input, so configure a new gridPanel
				
				// ** IMPORTANT: If we already had a grid created, we must remove it before
				//               adding the new one. Otherwise, it will be under our new panel.
				if (gridPanel != null) {
					this.remove(gridPanel);
				}
				
				// re-create the entire grid panel.
				gridPanel = new JPanel();
				gridPanel.setLayout(new GridLayout(gridDim, gridDim));
				gridPanel.setPreferredSize(new Dimension(gridDim*LABEL_DIM, gridDim*LABEL_DIM));
				
				//populate gridPanel with labels
				labels = new JLabel[gridDim][gridDim];
				for (int row = 0; row < labels.length; row++) {
					for (int col = 0; col < labels[row].length; col++) {
						labels[row][col] = new JLabel(String.format("%d,%d", row, col));
						labels[row][col].setBorder(BorderFactory.createEtchedBorder());
						labels[row][col].setHorizontalAlignment(SwingConstants.CENTER);
						gridPanel.add(labels[row][col]);
					}
				}
				
				// ** IMPORTANT: must add the new panel to the main panel
				this.add(gridPanel, BorderLayout.CENTER);
				
				// ** IMPORTANT: forces panel to refresh itself with new contents
				this.revalidate();
			}
		} catch (NumberFormatException nfe) { //invalid input in text field
			//reset gridDim and text field to previous values
			gridDim = oldGridDim;
			gridDimInput.setText(Integer.toString(gridDim));
		}
	}
	
	/**
	 * Listens for New Game button click and replaces the existing panel with a 
	 * fresh game panel.
	 */
	private class UpdateGridListener implements ActionListener
	{
		@Override
		public void actionPerformed(ActionEvent e) {
			configureGridPanel();
		}
	}
}
