import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JPanel;

/**
 * Demonstrates using an array of JButtons.
 * 
 * @author CS121 Instructors
 *
 */
@SuppressWarnings("serial")
public class ColorChooserPanel extends JPanel
{
	private final Color[] COLORS = { Color.RED, Color.GREEN, Color.BLUE,
			                         Color.YELLOW, Color.CYAN}; 
	private JButton[] colorButtons;
	private JPanel previewPanel;
	
	/**
	 * Initializes the buttons and preview panel and adds the listener
	 * to all of the buttons.
	 */
	public ColorChooserPanel()
	{
		colorButtons = new JButton[COLORS.length];
		
		ColorButtonListener listener = new ColorButtonListener();
		
		// create our buttons and add them to the panel
		for(int i = 0; i < colorButtons.length; i++) {
			colorButtons[i] = new JButton();
			colorButtons[i].setBackground(COLORS[i]);
			colorButtons[i].addActionListener(listener);
			colorButtons[i].setPreferredSize(new Dimension(50, 50));
			this.add(colorButtons[i]);
		}
		// create our preview panel and add it to this panel
		previewPanel = new JPanel();
		previewPanel.setPreferredSize(new Dimension(200, 100));
		previewPanel.setBackground(Color.BLACK);
		this.add(previewPanel);
	}

	private class ColorButtonListener implements ActionListener
	{
		@Override
		public void actionPerformed(ActionEvent e)
		{
			JButton clicked = (JButton) e.getSource();
			previewPanel.setBackground(clicked.getBackground());
			
// OR			
//			for(int i = 0; i < colorButtons.length; i++) {
//				if(e.getSource() == colorButtons[i]) {
//					previewPanel.setBackground(COLORS[i]);
//				}
//			}
			
		}
	}
}
