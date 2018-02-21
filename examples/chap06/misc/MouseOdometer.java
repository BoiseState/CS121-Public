package misc;


import java.awt.Dimension;
import javax.swing.JFrame;

/**
 * A mouse odometer.
 * @author amit
 *
 */
@SuppressWarnings("serial")
public class MouseOdometer extends JFrame
{

	public static void main(String[] args) {
		
		MouseOdometer mouseMeter = new MouseOdometer();
		mouseMeter.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		mouseMeter.setPreferredSize(new Dimension(300, 200));
		mouseMeter.add(new MouseOdometerPanel());
		mouseMeter.pack();
		mouseMeter.setVisible(true);
	}
}
