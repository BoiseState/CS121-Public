import java.awt.Dimension;

import javax.swing.JFrame;

/**
 * Demonstrates a graphical user interface and an event listener.
 * 
 * @author Java Foundations
 */
public class PushCounterVersion2
{
   /**
    * Creates and displays the main program frame.
    * @param args
    */
   public static void main(String[] args)
   {
      JFrame frame = new JFrame("Push Counter");
      frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

      PushCounterPanelVersion2 panel = new PushCounterPanelVersion2();
      frame.getContentPane().add(panel);

      frame.pack();
      frame.setVisible(true);
      frame.setMinimumSize(new Dimension(300, 200));
   }
}
