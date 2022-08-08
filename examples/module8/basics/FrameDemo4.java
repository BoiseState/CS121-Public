package basics;

import java.awt.event.*;
import java.io.File;

import javax.swing.*;

/**
  Create a a main window and a sub-window.
  @author amit 
*/

@SuppressWarnings("serial")
public class FrameDemo4 extends JFrame implements WindowListener
{
	public FrameDemo4()
	{
		super("FrameDemo4: main window");
		addWindowListener(this);
		setSize(400, 300);
	}

	public void createWindow()
	{
		JFrame frame1 = new JFrame("FrameDemo4: subwindow");
		frame1.setSize(600,100);
		frame1.setVisible(true);
		// we choose not to attach a listener to this frame
	}

	public void windowClosing (WindowEvent event) 
	{
		System.exit(0);
	}
	public void windowActivated (WindowEvent event) {}
	public void windowDeactivated (WindowEvent event) {}
	public void windowClosed (WindowEvent event) {}
	public void windowDeiconified (WindowEvent event) {}
	public void windowIconified (WindowEvent event) {}
	public void windowOpened (WindowEvent event) {}


	public static void main(String[] args)
	{
		FrameDemo4 main = new FrameDemo4();
		main.setVisible(true);

		main.createWindow();
	}
	
}
