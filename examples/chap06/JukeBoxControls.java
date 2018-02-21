
import java.applet.AudioClip;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.net.MalformedURLException;
import java.net.URL;
import java.io.File;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JApplet;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 * The jukebox control panel.
 * 
 * @author Lewis/Loftus/Amit
 * 
 */

@SuppressWarnings("serial")
public class JukeBoxControls extends JPanel
{
	private JLabel titleLabel;
	private JComboBox<String> musicCombo;
	private JButton stopButton, playButton;
	private JPanel buttonPanel;
	
	private final int NUM_SONGS = 6;
	private AudioClip[] music;
	private AudioClip current;
	
	private String[] fileNames = {"", "westernBeat.wav", "classical.wav", "jeopardy.au", 
			                      "newAgeRythm.wav", "eightiesJam.wav", "hitchcock.wav"};

	/**
	 * Sets up the GUI for the jukebox.
	 */
	public JukeBoxControls()
	{
		setupMusic();

		titleLabel = new JLabel("Java Juke Box");
		titleLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
		
		setupComboBox();
		setupButtons();
		setupMainPanel();	

		musicCombo.addActionListener(new ComboListener());
		stopButton.addActionListener(new ButtonListener());
		playButton.addActionListener(new ButtonListener());

		current = null;
	}
	
	/**
	 * Sets up the play list from music file names.
	 */
	private void setupMusic() 
	{
		music = new AudioClip[NUM_SONGS + 1];
		music[0] = null; // Corresponds to "Make a Selection..."
		
		// Obtain and store the audio clips to play
		for (int i = 1; i < music.length; i++) 
		{
			try {
				URL songURL = new URL("file", "localhost", "songs" + File.separator + fileNames[i]);
				music[i] = JApplet.newAudioClip(songURL);
			} catch (MalformedURLException e) {
				System.err.println("JukeBox: malformed song URL" + fileNames[i]);
			}
		}		
	}
	

	/**
	 * Sets up the main panel.
	 */
	private void setupMainPanel() 
	{
		setPreferredSize(new Dimension(300, 100));
		setBackground(Color.lightGray);
		setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
		
		add(Box.createRigidArea(new Dimension(0, 5)));
		add(titleLabel);
		add(Box.createRigidArea(new Dimension(0, 5)));
		add(musicCombo);
		add(Box.createRigidArea(new Dimension(0, 5)));
		add(buttonPanel);
		add(Box.createRigidArea(new Dimension(0, 5)));
	}


	/**
	 * Sets up the buttons panel.
	 */
	private void setupButtons() 
	{
		playButton = new JButton("Play", new ImageIcon("play.gif"));
		playButton.setBackground(Color.white);
		//Sets up Alt-p as keyboard shortcut
		playButton.setMnemonic('p');
		
		stopButton = new JButton("Stop", new ImageIcon("stop.gif"));
		stopButton.setBackground(Color.white);
		//Sets up Alt-s as keyboard shortcut
		stopButton.setMnemonic('s');

		buttonPanel = new JPanel();
		buttonPanel.setLayout(new BoxLayout(buttonPanel, BoxLayout.X_AXIS));
		buttonPanel.add(playButton);
		buttonPanel.add(Box.createRigidArea(new Dimension(5, 0)));
		buttonPanel.add(stopButton);
		buttonPanel.setBackground(Color.lightGray);
	}


	/**
	 * Sets up the combo box.
	 */
	private void setupComboBox() 
	{
		// Create the list of strings for the combo box options
		String[] musicNames = { "Make A Selection...", "Western Beat",
				"Classical Melody", "Jeopardy Theme", "New Age Rythm",
				"Eighties Jam", "Alfred Hitchcock's Theme" };

		musicCombo = new JComboBox<String>(musicNames);
		musicCombo.setAlignmentX(Component.CENTER_ALIGNMENT);
	}

	/**
	 * Represents the action listener for the combo box.
	 */
	private class ComboListener implements ActionListener
	{
		/**
		 *  Stops playing the current selection (if any) and resets
		 *  the current selection to the one chosen.
		 */
		public void actionPerformed(ActionEvent event)
		{
			if (current != null) {
				current.stop();
			}  

			current = music[musicCombo.getSelectedIndex()];
		}
	}

	
	/**
	 * Represents the action listener for both control buttons.
	 */
	private class ButtonListener implements ActionListener
	{
		/**
		 *  Stops the current selection (if any) in either case. If
		 *  the play button was pressed, start playing it again.
		 */
		public void actionPerformed(ActionEvent event)
		{
			if (current != null) {
				current.stop();
			}

			if (event.getSource() == playButton) {
				if (current != null) {
					current.play();
				}
			}	
		}
	}
}
