import javax.swing.JFrame;


/**
 * Demonstrates use of javax.swing.Timer. For a cooler example, see TimerDemoCooler.java.
 * 
 * @author CS121 Instructors
 */
public class TimerDemo
{
	/**
	 * @param args
	 */
	public static void main(String[] args)
	{
		JFrame frame = new JFrame("Timer Demo");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		frame.getContentPane().add(new TimerDemoPanel());

		frame.pack();
		frame.setVisible(true);
	}
}
