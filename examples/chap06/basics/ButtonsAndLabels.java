package basics;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

/**
	A simple demo for using buttons and labels and using ActionListener with buttons.
	@author amit
*/

@SuppressWarnings("serial")
public class ButtonsAndLabels extends JFrame implements ActionListener
{
	JTextArea display = new JTextArea(4,25);
	JButton button1 = new JButton("Quit");
	JButton stop = new JButton("Stop", new ImageIcon("stop.gif"));
	JButton play = new JButton("Play", new ImageIcon("play.gif"));
	JPanel panel = new JPanel();
	JLabel label1 = new JLabel("Button demo", SwingConstants.CENTER);

	public ButtonsAndLabels()
	{
        setTitle("Buttons and Labels Demo");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		button1.addActionListener(this);
		stop.addActionListener(this);
		play.addActionListener(this);

		panel.add(label1);
		panel.add(button1);
		panel.add(stop);
		panel.add(play);
		panel.add(display);

		Container c = getContentPane();
		c.add(panel);
	}

	public void actionPerformed(ActionEvent event)
	{
		JButton source = (JButton) event.getSource();

		String buttonLabel = source.getText();
		if (buttonLabel.equals("Stop"))
			display.append("Stop button was pressed\n");
		else if (buttonLabel.equals("Play"))
			display.append("Play button was pressed\n");
		else if (buttonLabel.equals("Quit"))
			quitApplication();
	}

	private void quitApplication()
	{
		System.exit(0);
	}

	public static void main (String[] args)
	{
		ButtonsAndLabels frame = new ButtonsAndLabels();
		frame.setSize(300,300);
		frame.setVisible(true);
	}

}
