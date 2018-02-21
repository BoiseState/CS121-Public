import java.awt.*;
import javax.swing.*;

/**
 * Represents the panel in the LayoutDemo program that demonstrates the border
 * layout manager.
 * 
 * @author Java Foundations
 */
@SuppressWarnings("serial")
public class ComplexPanel extends JPanel
{
	/** 
	 * Sets up this panel with a button in each area of a border
	 * layout to show how it affects their position, shape, and size.
	 */
   public ComplexPanel()
   {
	   setLayout(new BorderLayout(10, 10));
	   
	   JPanel northPanel = new FlowPanel();
	   JPanel southPanel = new BoxPanelXAxis();
	   JPanel eastPanel = new BoxPanelYAxis();
	   JPanel centerPanel = new GridPanel();
	   
	   add(northPanel, BorderLayout.NORTH);
	   add(southPanel, BorderLayout.SOUTH);
	   add(eastPanel, BorderLayout.EAST);
	   add(centerPanel, BorderLayout.CENTER);
   }
}
