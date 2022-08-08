import java.awt.*;
import javax.swing.*;

/**
 * Represents the panel in the LayoutDemo program that demonstrates
 * the border layout manager.
 * @author Java Foundations
 */
@SuppressWarnings("serial")
public class BorderPanel extends JPanel
{
   /**
    Sets up this panel with a button in each area of a border
    layout to show how it affects their position, shape, and size.
   */
   public BorderPanel()
   {
	   setLayout(new BorderLayout());
	  //setLayout(new BorderLayout(10, 10));

      JButton b1 = new JButton("CENTER");
      JButton b2 = new JButton("NORTH");
      JButton b3 = new JButton("SOUTH");
      JButton b4 = new JButton("EAST");
      JButton b5 = new JButton("WEST");

      add(b1, BorderLayout.CENTER);
      add(b2, BorderLayout.NORTH);
      add(b3, BorderLayout.SOUTH);
      add(b4, BorderLayout.EAST);
      add(b5, BorderLayout.WEST);
   }
}
