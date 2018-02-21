import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.Timer;


/**
 * Demonstrates use of javax.swing.Timer. For a cooler example, see TimerDemoCoolerPanel.java.
 * 
 * @author CS121 Instructors
 */
@SuppressWarnings("serial")
public class TimerDemoPanel extends JPanel
{
	private static final Font TIME_FONT = new Font(Font.MONOSPACED, Font.PLAIN, 32);
	private static final int MILLIS_PER_SEC = 1000;
	private static final int SEC_PER_MIN = 60;
	private static final int SEC_PER_HOUR = 3600;
	
	private JTextField hourField;
	private JTextField minField;
	private JTextField secField;
	
	private JButton startButton;
	private JButton stopButton;
	
	private Timer timer;
	
	/**
	 * Initializes all the GUI components and creates the Timer object.
	 */
	public TimerDemoPanel()
	{
		setLayout(new BorderLayout());
		
		initTimeInputPanel();
		initButtonControlPanel();
		
		// Instantiate the timer. Delay is set to 0 initially. We will set the delay when
		// we read the time from the user.
		timer = new Timer(0, new TimerListener());
		timer.setRepeats(false); // IMPORTANT! In our case, we only want to fire the alarm once.
	}
	
	private void initTimeInputPanel()
	{
		JPanel timePanel = new JPanel();
		
		hourField = new JTextField("00");
		hourField.setFont(TIME_FONT);
		minField = new JTextField("00");
		minField.setFont(TIME_FONT);
		secField = new JTextField("00");
		secField.setFont(TIME_FONT);
		
		timePanel.add(hourField);
		timePanel.add(new JLabel(":"));
		timePanel.add(minField);
		timePanel.add(new JLabel(":"));
		timePanel.add(secField);
		
		add(timePanel, BorderLayout.CENTER);
	}
	
	private void initButtonControlPanel()
	{
		ControlButtonListener listener = new ControlButtonListener();
		
		JPanel controlPanel = new JPanel();
		
		startButton = new JButton("Start");
		startButton.addActionListener(listener);
		controlPanel.add(startButton);
		
		stopButton = new JButton("Stop");
		stopButton.addActionListener(listener);
		stopButton.setEnabled(false);
		controlPanel.add(stopButton);
		
		add(controlPanel, BorderLayout.SOUTH);
	}
	
	/**
	 * Starts and stops the timer when the buttons are clicked.
	 */
	private class ControlButtonListener implements ActionListener
	{
		@Override
		public void actionPerformed(ActionEvent e)
		{
			JButton clicked = (JButton) e.getSource();
			if(clicked == startButton)
			{
				startTimer();
			}
			else if(clicked == stopButton)
			{
				stopTimer();
			}
		}
	}
	
	/**
	 * Waits for timer to fire and lets the user know when it does.
	 */
	private class TimerListener implements ActionListener
	{
		@Override
		public void actionPerformed(ActionEvent e)
		{
			JOptionPane.showMessageDialog(null, "Alarm!");
			stopTimer();
		}
	}
	
	/**
	 * Stops the timer and toggles the start/stop buttons. 
	 */
	private void stopTimer()
	{
		timer.stop();
		startButton.setEnabled(true);
		stopButton.setEnabled(false);
	}

	/**
	 * Reads the target time from the input fields and starts the timer for the specified
	 * amount of time. If the time is invalid (<= 0 or not a number), then it will not start
	 * the timer and will pop up an error.
	 */
	private void startTimer()
	{
		try
		{
			// First, figure out how much time we need to set it for.
			int hour = Integer.parseInt(hourField.getText());
			int min = Integer.parseInt(minField.getText());
			int sec = Integer.parseInt(secField.getText());
			
			// Need to figure out milliseconds because that is what the timer takes.
			int totalMillis = (sec + (min * SEC_PER_MIN) + (hour * SEC_PER_HOUR)) * MILLIS_PER_SEC;
			
			// Instead of this big long condition, would be better to break it into a method, but
			// leaving it here for simplicity of this demo.
			if((hour < 0 || hour > 60) || (min < 0 || min > 60) || (sec < 0 || sec > 60) || totalMillis <= 0)
			{
				JOptionPane.showMessageDialog(null, "Invalid time!");
			}
			else
			{
				// Set the delay so that it fires after the desired number of seconds
				timer.setInitialDelay(totalMillis);
				// Don't forget to start it!
				timer.start();
				
				startButton.setEnabled(false); // Disable the 'Start' button while the timer is going.
				stopButton.setEnabled(true);
			}
		}
		catch(NumberFormatException e)
		{
			JOptionPane.showMessageDialog(null, "Invalid time!");
		}
	}
}
