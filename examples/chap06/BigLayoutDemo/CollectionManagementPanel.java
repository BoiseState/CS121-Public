package BigLayoutDemo;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;

/** JPanel responsible for Items and associated GUI components. 
 * @author mvail
 */
public class CollectionManagementPanel extends JPanel {
	//instance variables
	// ONLY those values that we need to access
	// in the listeners defined within this class
	private ActionListener itemButtonListener;
	private JTextField numberOfItemsTextField;
	private JPanel buttonListPanel;

	/**Configure panel components and layout.
	 * @param itemButtonListener to register with all ItemButtons
	 */
	public CollectionManagementPanel(ActionListener itemButtonListener) {
		//remember this so we can register it with any future ItemButtons
		this.itemButtonListener = itemButtonListener;

		//configure the button list panel and the scroll pane that holds it
		buttonListPanel = new JPanel();
		buttonListPanel.setLayout(new BoxLayout(buttonListPanel, BoxLayout.Y_AXIS));
		buttonListPanel.setBorder(BorderFactory.createTitledBorder("ButtonListPanel"));
		JScrollPane buttonListScroll = new JScrollPane(buttonListPanel);
		buttonListScroll.setPreferredSize(new Dimension(128,256));
		buttonListScroll.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
		buttonListScroll.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
		buttonListScroll.setBorder(BorderFactory.createTitledBorder("ButtonListScroll"));

		//configure the text field and button for determining how many ItemButtons to create
		CreateItemsListener createItemsListener = new CreateItemsListener();
		numberOfItemsTextField = new JTextField(10);
		numberOfItemsTextField.setToolTipText("Number of Items to create.\nMust be a positive integer.");
		numberOfItemsTextField.addActionListener(createItemsListener);
		JButton createItemsButton = new JButton("Create Items");
		createItemsButton.addActionListener(createItemsListener);
		//configure the panel to organize the text field and button
		JPanel createItemsPanel = new JPanel();
		createItemsPanel.setLayout(new BoxLayout(createItemsPanel, BoxLayout.X_AXIS));
		createItemsPanel.add(Box.createHorizontalGlue());
		createItemsPanel.add(numberOfItemsTextField);
		createItemsPanel.add(createItemsButton);
		createItemsPanel.add(Box.createHorizontalGlue());
		createItemsPanel.setBorder(BorderFactory.createTitledBorder("CreateItemsPanel"));

		//configure this panel to organize the button list and configuration panes/panels
		this.setLayout(new BorderLayout());
		this.add(buttonListScroll, BorderLayout.CENTER);
		this.add(createItemsPanel, BorderLayout.SOUTH);
		this.setBorder(BorderFactory.createTitledBorder("CollectionMgmtPanel"));
	}

	/** Create Items and associated ItemButtons */
	private class CreateItemsListener implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent event) {
			String numItemsString = numberOfItemsTextField.getText().trim();
			int numItems = 0;
			boolean isInteger = true;
			if (numItemsString.length() < 1) {
				isInteger = false;
			} else {
				for(int index = 0; index < numItemsString.length(); index++) {
					if (!Character.isDigit(numItemsString.charAt(index))) {
						isInteger = false;
					}
				}
				if (isInteger) {
					numItems = Integer.parseInt(numItemsString);
				}
				if (numItems < 1) {
					isInteger = false;
				}
			}
			if (!isInteger) {
				JOptionPane.showMessageDialog(CollectionManagementPanel.this, "\"" + numItemsString + "\" is not a positive integer.", "Create Items Failure", JOptionPane.ERROR_MESSAGE);
			} else {
				buttonListPanel.removeAll();
				for (int i = 0; i < numItems; i++) {
					ItemButton button = new ItemButton(new Item(Integer.toString(i+1)));
					button.addActionListener(itemButtonListener);
					buttonListPanel.add(button);
				}
				buttonListPanel.revalidate();
			}
		}
	}
}
