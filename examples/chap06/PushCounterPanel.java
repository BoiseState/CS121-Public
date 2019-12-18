import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 * Demonstrates a graphical user interface and an event listener.
 * 
 * @author Java Foundations
 */
@SuppressWarnings("serial")
public class PushCounterPanel extends JPanel
{
   private static final Color LIGHT_GREEN = new Color(206, 255, 199);
	 
   private int count;
   private JButton incrementButton;
   private JButton decrementButton;
   private JLabel pushCountLabel;

   /**
    * Constructor: Sets up the GUI panel
    */
   public PushCounterPanel()
   {
	  // TODO: Set background color and add border to panel.
	  //this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
	  this.setLayout(new BorderLayout());
	  this.setBorder(BorderFactory.createTitledBorder("Push Counter Panel"));
	  this.setBackground(LIGHT_GREEN);
	   
	  // initialize the components
      count = 0;
      
      // Create sub-panel for buttons.
      JPanel buttonPanel = new JPanel();
      buttonPanel.setLayout(new BoxLayout(buttonPanel, BoxLayout.X_AXIS));
      buttonPanel.setBackground(Color.BLUE);
      buttonPanel.setBorder(BorderFactory.createTitledBorder("Button Panel"));
      
      // Create and add increment button to sub-panel
      incrementButton = new JButton("increment");
      incrementButton.addActionListener(new ButtonListener());
      buttonPanel.add(incrementButton);
      
      // Create and add decrement button to sub-panel
      decrementButton = new JButton("decrement");
      decrementButton.addActionListener(new ButtonListener());
      buttonPanel.add(decrementButton);
      
      // Add button sub-panel to this PushCounterPanel
      add(buttonPanel, BorderLayout.CENTER);
      
      // Create a sub-panel for label.
      JPanel labelPanel = new JPanel();
      labelPanel.setBackground(Color.YELLOW);
      labelPanel.setBorder(BorderFactory.createTitledBorder("Label Panel"));
      labelPanel.setPreferredSize(new Dimension(200, 50));
     
      // Create and add label to sub-panel.
      pushCountLabel = new JLabel("Pushes: " + count);
      labelPanel.add(pushCountLabel);

      // Add label to sub-panel.
      add(labelPanel, BorderLayout.SOUTH);
   }

   /**
    * Represents a listener for button push (action) events.
    */
   private class ButtonListener implements ActionListener
   {
      /**
       * Updates the counter and label when the button is pushed.
       */
      public void actionPerformed(ActionEvent event)
      {
    	  // Determine which button was clicked and increment/decrement accordingly
    	  if(event.getSource() == incrementButton) // was increment clicked?
    	  {
    		  count++;
    	  }
    	  else
    	  {
    		  count--;
    	  }
    	  // replace the text of the existing label with the new text.
	      pushCountLabel.setText("Pushes: " + count);
      }
   }
}
