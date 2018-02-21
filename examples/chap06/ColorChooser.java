import java.awt.Dimension;

import javax.swing.JFrame;

/**
 * Demonstrates a graphical user interface and an event listener.
 *
 * @author CS121 Instructors
 */
public class ColorChooser
{
   /**
    * Creates and displays the main program frame.
    * @param args
    */
   public static void main(String[] args)
   {
      JFrame frame = new JFrame("Color Chooser");
      frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      frame.setPreferredSize(new Dimension(500, 400));

      // If we want to add something, we must get the contentPanel and add to it.
      frame.getContentPane().add(new ColorChooserPanel());

      frame.pack();
      frame.setVisible(true);
   }
}
