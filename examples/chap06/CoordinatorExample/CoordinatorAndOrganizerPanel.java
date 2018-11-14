package CoordinatorExample;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

/** Example GUI demonstrating coordination of components between panels.
 * This panel is the top-level panel, so it sets up and contains all other components of the GUI (either directly or indirectly).
 * As such, it is also capable of serving as a coordinator between events coming from one subpanel's components and another subpanel's components.
 * @author mvail
 */
@SuppressWarnings("serial")
public class CoordinatorAndOrganizerPanel extends JPanel {
	private DisplayPanel displayPanel;
	private JButton rectangleButton, ovalButton;
	private Color shapeColor;
	private DisplayPanel.Shape shape;
	
	/** Set up the whole GUI - panels, components, and listeners */
	public CoordinatorAndOrganizerPanel() {
		this.setLayout(new BorderLayout());
		
		//set up colorChooserPanel - responsible for creating a grid of color buttons -
		//pass in a listener reference to the panel constructor, to be added to all color buttons
		ColorButtonListener colorListener = new ColorButtonListener();
		ColorChooserPanel colorChooserPanel = new ColorChooserPanel(colorListener);
		
		//set up shape choosing panel
		rectangleButton = new JButton("Rectangle");
		ovalButton = new JButton("Oval");
		rectangleButton.setEnabled(false);
		shape = DisplayPanel.Shape.RECTANGLE;
		ShapeButtonListener shapeListener = new ShapeButtonListener();
		rectangleButton.addActionListener(shapeListener);
		ovalButton.addActionListener(shapeListener);
		JPanel shapesPanel = new JPanel();
		shapesPanel.add(rectangleButton);
		shapesPanel.add(ovalButton);
		
		//set up control panel to organize colorChooserPanel and shapesPanel
		JPanel controlsPanel = new JPanel();
		controlsPanel.setLayout(new BoxLayout(controlsPanel, BoxLayout.Y_AXIS));
		controlsPanel.add(Box.createVerticalGlue());
		controlsPanel.add(colorChooserPanel);
		controlsPanel.add(shapesPanel);
		controlsPanel.add(Box.createVerticalGlue());
		
		//set up displayPanel where colored shape will be displayed
		displayPanel = new DisplayPanel();
		displayPanel.setPreferredSize(new Dimension(200,200));
		
		//add sub panels to this panel
		add(controlsPanel, BorderLayout.WEST);
		add(displayPanel, BorderLayout.CENTER);
	}
	
	/** Repaint the display panel in response to user choosing a new color or shape */
	private void updateDisplay() {
		displayPanel.paintShape(shape, shapeColor);
	}
	
	/** Listener that will respond to color button events */
	private class ColorButtonListener implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent e) {
			JButton button = (JButton)(e.getSource());
			shapeColor = button.getBackground();
			updateDisplay();
		}		
	}
	
	/** Listener that will respond to shape button events */
	private class ShapeButtonListener implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent arg0) {
			rectangleButton.setEnabled(!rectangleButton.isEnabled()); //toggle button
			ovalButton.setEnabled(!ovalButton.isEnabled()); //toggle button
			if (rectangleButton.isEnabled()) { //indicates ovalButton was pressed
				shape = DisplayPanel.Shape.OVAL;
			} else { //rectangleButton was pressed
				shape = DisplayPanel.Shape.RECTANGLE;
			}
			updateDisplay();
		}
	}
}
