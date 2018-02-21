import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 * Demonstrates a graphical user interface and an event listener.
 * 
 * @author Java Foundations
 */
@SuppressWarnings("serial")
public class PushCounter2 extends JPanel implements ActionListener
{
	private static final Color LIGHT_GREEN = new Color(206, 255, 199);
	private int count;
	private JButton push;
	private JLabel label;

	/**
	 * Constructor: Sets up the GUI.
	 */
	public PushCounter2()
	{
		count = 0;

		push = new JButton("Push Me!");
		push.addActionListener(this);

		label = new JLabel("Pushes: " + count);

		add(push);
		add(label);

		setBackground(LIGHT_GREEN);
		setPreferredSize(new Dimension(300, 40));
	}

	/**
	 * Updates the counter and label when the button is pushed.
	 */
	public void actionPerformed(ActionEvent event)
	{
		count++;
		label.setText("Pushes: " + count);
	}

	/**
	 * Creates and displays the main program frame.
	 * 
	 * @param args
	 */
	public static void main(String[] args)
	{
		JFrame frame = new JFrame("Push Counter");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		PushCounter2 panel = new PushCounter2();
		frame.getContentPane().add(panel);

		frame.pack();
		frame.setVisible(true);
	}
}
