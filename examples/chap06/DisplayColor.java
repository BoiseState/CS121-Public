import java.awt.Color;
import java.awt.Dimension;

import javax.swing.JColorChooser;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

//********************************************************************
//  DisplayColor.java       Author: Lewis/Loftus
//
//  Demonstrates the use of a color chooser.
//********************************************************************


@SuppressWarnings("javadoc")
public class DisplayColor
{
   //-----------------------------------------------------------------
   //  Presents a frame with a colored panel, then allows the user
   //  to change the color multiple times using a color chooser.
   //-----------------------------------------------------------------
   public static void main(String[] args)
   {
      JFrame frame = new JFrame("Display Color");
      frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

      JPanel colorPanel = new JPanel();
      colorPanel.setBackground(Color.white);
      colorPanel.setPreferredSize(new Dimension (300, 100));

      frame.getContentPane().add(colorPanel);
      frame.pack();
      frame.setVisible(true);

      Color shade = Color.white;
      int again;

      do 
      {
         shade = JColorChooser.showDialog(frame, "Pick a Color!", shade);
         colorPanel.setBackground(shade);
         again = JOptionPane.showConfirmDialog(null,"Display another color?");
      }
      while (again == JOptionPane.YES_OPTION);
   }
}
