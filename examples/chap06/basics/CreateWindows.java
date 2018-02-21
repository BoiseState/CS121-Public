package basics;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

/**
	A simple demo showing how to create and dispose new windows. 
	@author amit
*/

@SuppressWarnings("serial")
public class CreateWindows extends JFrame implements ActionListener
{
	JTextArea display1 = new JTextArea(4,25);
	JTextArea display2 = new JTextArea(2,20);
	JButton quitButton = new JButton("Quit");
	JButton createButton = new JButton("Create");
	JButton disposeButton = new JButton("Dispose");
	JPanel panel = new JPanel();
	JLabel label1 = new JLabel("Button demo", SwingConstants.CENTER);
	JFrame window; 

	public CreateWindows()
	{
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		quitButton.addActionListener(this);
		createButton.addActionListener(this);

		panel.add(label1);
		panel.add(quitButton);
		panel.add(createButton);
		panel.add(display1);

		Container c = getContentPane();
		c.add(panel);
	}

	public void actionPerformed(ActionEvent event)
	{
		Object source =  event.getSource();

		if (source == quitButton)
			quitApplication();
		else if (source == createButton)
		{
			if (window != null) window.dispose();
			createNewWindow();
		}
		else if (source == disposeButton)
		{
			if (window != null) window.dispose();
		}
	}

	private void createNewWindow()
	{
		window = new JFrame("New Window");
		JPanel panel1 = new JPanel();
		panel1.setLayout(new GridLayout(2,1,1,1));
		panel1.setBorder(BorderFactory.createTitledBorder("A little experiment"));

		panel1.add(display2);
		disposeButton.addActionListener(this);
		panel1.add(disposeButton);

		window.getContentPane().add(panel1);
		window.setSize(250,100);
		window.setVisible(true);
	}

	private void quitApplication()
	{
		System.exit(0);
	}

	public static void main (String[] args)
	{
		CreateWindows frame = new CreateWindows();
		frame.setSize(300,300);
		frame.setVisible(true);
	}

}
