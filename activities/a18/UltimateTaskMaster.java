import javax.swing.JFrame;

/**
 * Lesson 18-19: Activity - Task Master GUI
 * 
 * This is the driver class.
 *
 * @author CS121 Instructors
 * @version [semester]
 * @author [your name]
 */
public class UltimateTaskMaster
{
	public static void main(String[] args)
	{
		JFrame frame = new JFrame("Ultimate Task Master");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		TaskMasterPanel panel = new TaskMasterPanel();
		frame.getContentPane().add(panel);
		
		frame.pack();
		frame.setVisible(true);
	}
}
