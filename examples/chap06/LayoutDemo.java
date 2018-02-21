import javax.swing.JFrame;
import javax.swing.JTabbedPane;

/**
 * Demonstrates the use of flow, border, grid, and box layouts
 * 
 * @author Java Foundations
 * @author CS121 Instructors
 *
 */
public class LayoutDemo {
	/**
	 * Sets up a frame containing a tabbed pane. The panel on each tab
	 * demonstrates a different layout manager.
	 * 
	 * @param args
	 */
	public static void main(String[] args)
	{
		JFrame frame = new JFrame("Layout Manager Demo");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		JTabbedPane tp = new JTabbedPane();
		tp.addTab("Intro", new IntroPanel());
		tp.addTab("Flow", new FlowPanel());
		tp.addTab("Border", new BorderPanel());
		tp.addTab("Grid", new GridPanel());
		tp.addTab("Box X", new BoxPanelXAxis());
		tp.addTab("Box Y", new BoxPanelYAxis());
		tp.addTab("Complex", new ComplexPanel());
		
		frame.getContentPane().add(tp);

		frame.pack();
		frame.setVisible(true);
	}
}
