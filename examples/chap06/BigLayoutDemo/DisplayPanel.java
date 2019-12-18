import java.awt.BorderLayout;
import java.awt.Dimension;
import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

/**JPanel that displays info related to an Item.
 * @author mvail
 */
public class DisplayPanel extends JPanel {
	//instance variables
	// ONLY those values that we need to access
	// in the listeners defined within this class
	private JLabel itemLabel;
	private JTextArea itemTextArea;
	
	/** Initialize and layout components to display information about an Item */
	public DisplayPanel() {
		//instantiate and initialize labels to include in infoPanel
		JLabel itemLabelLabel = new JLabel("Item: ");
		itemLabel = new JLabel("[none]");
		//configure infoPanel and add components
		JPanel infoPanel = new JPanel();
		infoPanel.setLayout(new BoxLayout(infoPanel, BoxLayout.X_AXIS));
		infoPanel.setBorder(BorderFactory.createTitledBorder("InfoPanel"));
		infoPanel.add(Box.createHorizontalGlue());
		infoPanel.add(itemLabelLabel);
		infoPanel.add(itemLabel);
		infoPanel.add(Box.createHorizontalGlue());
		
		//instantiate and configure the text area
		itemTextArea = new JTextArea();
		itemTextArea.setLineWrap(true);
		itemTextArea.setWrapStyleWord(true);
		itemTextArea.setEditable(false);
		itemTextArea.setBorder(BorderFactory.createTitledBorder("ItemTextArea"));
		//set up the scroll pane to hold the text area
		JScrollPane itemTextScroll = new JScrollPane(itemTextArea);
		itemTextScroll.setPreferredSize(new Dimension(200,200));
		itemTextScroll.setBorder(BorderFactory.createTitledBorder("ItemTextScroll"));

		//set up this DisplayPanel's layout and add sub-panels/panes
		this.setLayout(new BorderLayout());
		this.add(infoPanel, BorderLayout.NORTH);
		this.add(itemTextScroll, BorderLayout.CENTER);
		this.setBorder(BorderFactory.createTitledBorder("DisplayPanel"));
	}

	/** Update components to report on the given Item
	 * @param item the Item being reported
	 */
	public void loadItem(Item item) {
		itemLabel.setText(item.toString());
		String content = "This text area is displaying some info about Item:\n\t" + item.toString();
		content += "\n\n\nThe item's hash code is:\n\t" + item.hashCode();
		content += "\n\n\nThe item's class is:\n\t" + item.getClass();
		content += "\n\n\nIn case you forgot, this text area is displaying some info about Item:\n\t" + item.toString();
		content += "\n\n\nDid I mention the item's hash code is:\n\t" + item.hashCode();
		itemTextArea.setText(content);				
		this.revalidate();
	}
}
