import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JPanel;

/**
 * Main panel for LiteBrite activities.
 * Top-level organizer and coordinator between sub-panels/controls. 
 * 
 * @author mvail
 */
@SuppressWarnings("serial")
public class LiteBritePanel extends JPanel {
	private LiteBriteBoardPanel board;
	private final int BOARD_DIMENSION = 20;
	
	/**
	 * Initialize top-level panel with a LitePegButton (for testing) or 
	 * LiteBriteBoardPanel (final). Also adds a reset button to reset all
	 * pegs in the final LiteBriteBoardPanel.
	 */
	public LiteBritePanel() {
		/* 
		 * Phase 1: Enable the following to add a single LitePegButton to this 
		 * panel while developing and testing the LitePegButton class.
		 * Completely remove this comment and code once LitePegButton is working
		 * and you are ready to enable the Phase 2 code.
		 */
		LitePegButton testButton = new LitePegButton();
		this.add(testButton);
		
		/*
		 * Phase 2: Enable the following to add a subpanel containing a grid of
		 * LitePegButtons. This is the option that should be enabled in the
		 * final version of LiteBrite. Enable the call to board.reset() in
		 * ResetButtonListener at the same time you enable this option.
		 */
		//board = new LiteBriteBoardPanel(BOARD_DIMENSION, BOARD_DIMENSION);
		//this.add(board);
		
		JButton resetButton = new JButton("Reset");
		resetButton.setFont (new Font("Arial", Font.PLAIN, 24));
		resetButton.addActionListener(new ResetButtonListener());		
		this.add(resetButton);
	}
	
	/**
	 * Private listener class to respond to reset button clicks.
	 * Notifies LiteBriteBoardPanel to reset all pegs to black.
	 */
	private class ResetButtonListener implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			//board.reset();
		}
	}
}
