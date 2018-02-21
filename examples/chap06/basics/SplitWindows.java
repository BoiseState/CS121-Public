package basics;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.Dimension;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSplitPane;
import javax.swing.JTextArea;


/**
 * Demonstrate the use of split windows
 * @author amit
 *
 */
@SuppressWarnings("serial")
public class SplitWindows extends JFrame
{
	private JPanel panel = new JPanel();
	private JTextArea display1 = new JTextArea(10, 15);
	private JTextArea display2 = new JTextArea(10, 25);
	private JSplitPane split = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT);

	/**
	 * Setup the two split windows with scrollbars.
	 */
	public SplitWindows()
	{
		setTitle("SplitWindows demo");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		JScrollPane scroller1 = new JScrollPane(display1);
		scroller1.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
		JScrollPane scroller2 = new JScrollPane(display2);
		scroller2.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);

		split.setDividerLocation(0.33);

		// provide minimum sizes of the two components in the split pane
		Dimension minSize = new Dimension(150, 300);
		scroller1.setMinimumSize(minSize);
		scroller2.setMinimumSize(minSize);

		split.setLeftComponent(scroller1);
		split.setRightComponent(scroller2);
		// provide a preferred size for the split pane
		split.setPreferredSize(new Dimension(600, 300));

		panel.setLayout(new BorderLayout());
		panel.add(split, BorderLayout.CENTER);

		Container c1 = getContentPane();
		c1.add(panel);
	}

	/**
	 * Display some stuff in the two split windows
	 */
	public void addMessages()
	{
		split.setDividerLocation(0.4);
		for (int i = 0; i < 30; i++) {
			display1.append("I am in the left: " + i + "\n");
			display2.append("I am in the right: " + i + "\n");
		}
	}

	/**
	 * Start the main GUI
	 * @param args
	 */
	public static void main(String[] args)
	{
		SplitWindows list = new SplitWindows();
		list.setSize(600, 400);
		list.setVisible(true);

		list.addMessages();
	}
}
