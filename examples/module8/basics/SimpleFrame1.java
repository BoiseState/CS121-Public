package basics;

import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

import javax.swing.JFrame;


/**
  A simple demo of a JFrame and how to listen for window events.
  @author amit
 */

@SuppressWarnings("serial")
public class SimpleFrame1 extends JFrame implements WindowListener
{
	public SimpleFrame1()
	{
		super("Frame Demonstration");
		addWindowListener(this);
		setSize(300, 300);
	}

	public void windowClosing (WindowEvent event) 
	{
		System.exit(0);
	}

	public void windowActivated (WindowEvent event) 
	{
		System.out.println("Window was activated.");
	}

	public void windowDeactivated (WindowEvent event) 
	{
		System.out.println("Window was de-activated.");
	}

	public void windowClosed (WindowEvent event) {}
	public void windowDeiconified (WindowEvent event) {}
	public void windowIconified (WindowEvent event) {}
	public void windowOpened (WindowEvent event) {}

}
