package basics;
/**
 * 
 */


import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextArea;

/**
 * Creates a JTextArea and then displays what mouse button was clicked.
 * @author amit
 *
 */
@SuppressWarnings("serial")
public class MouseButtonsDemo extends JPanel implements MouseListener
{
	JTextArea status = new JTextArea(5, 20);
	
	/**
	 * Create a JTextArea for displaying results.
	 */
	public MouseButtonsDemo() {
		setLayout(new BorderLayout());
		status.addMouseListener(this);
		add(status, BorderLayout.CENTER);
	}

	@Override
	public void mouseClicked(MouseEvent e)
	{
		if (e.getButton() == MouseEvent.BUTTON1) {
			status.append("Left button clicked\n");
		} else if (e.getButton() == MouseEvent.BUTTON2) {
			status.append("Middle button clicked\n");
		} else if (e.getButton() == MouseEvent.BUTTON3) {
			status.append("Right button clicked\n");
		} else {
			status.append("No button pressed");
		}
	}

	@Override
	public void mousePressed(MouseEvent e)
	{
		// TODO Auto-generated method stub
	}

	@Override
	public void mouseReleased(MouseEvent e)
	{
		// TODO Auto-generated method stub
	}

	@Override
	public void mouseEntered(MouseEvent e)
	{
		// TODO Auto-generated method stub
	}

	@Override
	public void mouseExited(MouseEvent e)
	{
		// TODO Auto-generated method stub
	}
	
	public static void main(String[] args) {
		
		JFrame demo = new JFrame();
		demo.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		demo.setPreferredSize(new Dimension(300, 200));
		demo.add(new MouseButtonsDemo());
		demo.pack();
		demo.setVisible(true);
	}
	
}
