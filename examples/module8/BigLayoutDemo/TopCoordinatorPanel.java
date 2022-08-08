package BigLayoutDemo;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.BorderFactory;
import javax.swing.JPanel;

/** Top-level JPanel for BigLayoutDemo - coordinates between two sub-panels.
 * @author mvail
 */
@SuppressWarnings("serial")
public class TopCoordinatorPanel extends JPanel {
	private CollectionManagementPanel collectionPanel;
	private DisplayPanel displayPanel;
	
	/**Constructor */
	public TopCoordinatorPanel() {
		collectionPanel = new CollectionManagementPanel(new ItemButtonListener());				
		displayPanel = new DisplayPanel();
		
		this.setLayout(new BorderLayout());
		this.add(collectionPanel, BorderLayout.WEST);
		this.add(displayPanel, BorderLayout.CENTER);
		
		this.setBorder(BorderFactory.createTitledBorder("TopCoordinatorPanel"));
	}
	
	/** Load selected Item into DisplayPanel */
	private class ItemButtonListener implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent e) {
			ItemButton itemButton = (ItemButton)(e.getSource());
			displayPanel.loadItem(itemButton.getItem());
		}
	}
}
