import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.NumberFormat;
import java.text.ParseException;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.Timer;


/**
 * Demonstrates use of javax.swing.Timer. For a simpler example, see TimerDemoPanel.java.
 * 
 * @author CS121 Instructors
 */
@SuppressWarnings("serial")
public class TimerDemoCoolerPanel extends JPanel
{
	private static final Font TIME_FONT = new Font(Font.MONOSPACED, Font.PLAIN, 32);
	
	private static final int MILLIS_PER_SEC = 1000;
	private static final int SEC_PER_MIN = 60;
	private static final int SEC_PER_HOUR = 3600;
	
	private NumberFormat timeFieldFormat;
	private JTextField hourField;
	private JTextField minField;
	private JTextField secField;
	
	private JButton startStopButton;
	private JButton resetButton;
	
	private Timer timer;
	private int secondsRemaining;
	
	private int totalSeconds;
	
	/**
	 * Initializes all the GUI components and creates the Timer object.
	 */
	public TimerDemoCoolerPanel()
	{
		setLayout(new BorderLayout());
		
		initTimer();
		
		initTimeInputPanel();
		initButtonControlPanel();
	}
	
	/**
	 * Instantiate the timer. Delay is set to 1 second, meaning it will send an event every
	 *  second so we can update our GUI. We want this timer to repeat because we want to
	 *  update the passed time every second.
	 *  
	 *  We could use 2 timers. One to keep track of total time, and one to fire every second
	 *  to update the GUI. However, we decided to use one timer that fires every second and 
	 *  keep track of the number of seconds remaining in a separate variable. When the number
	 *  of seconds remaining equals 0, then we know we have passed the total amount of time.
	 */
	private void initTimer()
	{
		// Instantiate the timer. Delay is set to 1 second, meaning it will send an event every
		// second so we can update our GUI. We want this timer to repeat because we want to
		// update the passed time every second.
		timer = new Timer(MILLIS_PER_SEC, new TimerListener());
		// Note that we have not started the timer yet.
		
		totalSeconds = 0;
		secondsRemaining = 0;
	}
	
	private void initTimeInputPanel()
	{
		timeFieldFormat = NumberFormat.getIntegerInstance();
		timeFieldFormat.setMinimumIntegerDigits(2);
		timeFieldFormat.setMaximumIntegerDigits(2);
		
		JPanel timePanel = new JPanel();
		
		hourField = new JTextField();
		hourField.setFont(TIME_FONT);
		minField = new JTextField();
		minField.setFont(TIME_FONT);
		secField = new JTextField();
		secField.setFont(TIME_FONT);
		
		timePanel.add(hourField);
		timePanel.add(new JLabel(":"));
		timePanel.add(minField);
		timePanel.add(new JLabel(":"));
		timePanel.add(secField);
		
		updateTimeLabels();
		
		add(timePanel, BorderLayout.CENTER);
	}
	
	private void initButtonControlPanel()
	{
		ControlButtonListener listener = new ControlButtonListener();
		
		JPanel controlPanel = new JPanel();
		
		startStopButton = new JButton("Start");
		startStopButton.addActionListener(listener);
		controlPanel.add(startStopButton);
		
		resetButton = new JButton("Reset");
		resetButton.addActionListener(listener);
		controlPanel.add(resetButton);
		
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
			if(clicked == startStopButton)
			{
				if(!timer.isRunning()) {
					startTimer();
				} else {
					stopTimer();
				}
			}
			else if(clicked == resetButton)
			{
				resetTimer();
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
			if(secondsRemaining > 0)
			{
				secondsRemaining--;
				updateTimeLabels();
			}
			else
			{
				JOptionPane.showMessageDialog(null, "Alarm!");
				stopTimer();
			}
		}
	}
	
	/**
	 * Helper method to calculate and update all time field labels.
	 */
	private void updateTimeLabels()
	{
		int hours = secondsRemaining / SEC_PER_HOUR;
		int mins = secondsRemaining % SEC_PER_HOUR / SEC_PER_MIN;
		int secs = secondsRemaining % SEC_PER_HOUR % SEC_PER_MIN;
		
		hourField.setText(timeFieldFormat.format(hours));
		minField.setText(timeFieldFormat.format(mins));
		secField.setText(timeFieldFormat.format(secs));
	}
	
	/**
	 * Helper method to set all time field labels to editable/uneditable.
	 * @param flag true to set all to editable, false to set all to uneditable
	 */
	private void setEditableTime(boolean flag)
	{
		hourField.setEditable(flag);
		minField.setEditable(flag);
		secField.setEditable(flag);
	}
	
	/**
	 * Resets the underlying timer and hour/min/sec fields to 0. Toggles the start/reset buttons.
	 */
	private void resetTimer()
	{
		timer.stop();
		secondsRemaining = totalSeconds;
		
		updateTimeLabels();
		setEditableTime(true);
		startStopButton.setText("Start");
	}
	
	/**
	 * Stops the timer and toggles the start/reset buttons. 
	 */
	private void stopTimer()
	{
		timer.stop();
		
		updateTimeLabels();
		setEditableTime(true);
		startStopButton.setText("Start");
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
			int hour = timeFieldFormat.parse(hourField.getText()).intValue();
			int min = timeFieldFormat.parse(minField.getText()).intValue();
			int sec = timeFieldFormat.parse(secField.getText()).intValue();
			
			// Calculate the number of seconds.
			int inputSeconds = (sec + (min * SEC_PER_MIN) + (hour * SEC_PER_HOUR));
			
			// Instead of this big long condition, would be better to break it into a method, but
			// leaving it here for simplicity of this demo.
			if((hour < 0 || hour > 60) || (min < 0 || min > 60) || (sec < 0 || sec > 60) || inputSeconds <= 0)
			{
				JOptionPane.showMessageDialog(null, "Invalid time!");
			}
			else
			{
				// Set total and remaining seconds to the input if it was valid.
				totalSeconds = secondsRemaining = inputSeconds;
				
				// Start the timer. We already set the repeated delay to 1 second in the constructor.
				// Every time it fires, we will decrement the number of secondsRemaining.
				timer.start();
				
				startStopButton.setText("Stop");
				setEditableTime(false);
			}
		}
		catch(ParseException e)
		{
			JOptionPane.showMessageDialog(null, "Invalid time!");
		}
	}
}
