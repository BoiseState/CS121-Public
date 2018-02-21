import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ButtonGroup;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;

/**
 * Demonstrates the use of radio buttons with nested panels.
 * 
 * @author Java Foundations (modified by amit)
 */
@SuppressWarnings("serial")
public class QuoteOptionsPanel extends JPanel
{
   private JLabel quote;
   private JRadioButton comedy, philosophy, carpentry;
   private String comedyQuote, philosophyQuote, carpentryQuote;

	/**
	 * Sets up a panel with a label and a set of radio buttons that control its
	 * text.
	 */
	public QuoteOptionsPanel()
	{
		comedyQuote = "An elephant is a mouse with an operating system.";
		philosophyQuote = "Take it easy, but take it!";
		carpentryQuote = "Think twice. Code once.";

		quote = new JLabel(comedyQuote);
		quote.setFont(new Font("Helvetica", Font.BOLD, 24));

		JPanel quotePanel = new JPanel();
		quotePanel.add(quote);

		comedy = new JRadioButton("Comedy");
		comedy.setBackground(Color.green);
		philosophy = new JRadioButton("Philosophy");
		philosophy.setBackground(Color.green);
		carpentry = new JRadioButton("Carpentry");
		carpentry.setBackground(Color.green);

		ButtonGroup group = new ButtonGroup();
		group.add(comedy);
		group.add(philosophy);
		group.add(carpentry);

		QuoteListener listener = new QuoteListener();
		comedy.addActionListener(listener);
		philosophy.addActionListener(listener);
		carpentry.addActionListener(listener);

		JPanel buttonPanel = new JPanel();
		buttonPanel.add(comedy);
		buttonPanel.add(philosophy);
		buttonPanel.add(carpentry);
		comedy.setSelected(true);

		quotePanel.setPreferredSize(new Dimension(700, 50));
		add(quotePanel);
		add(buttonPanel);

		setBackground(Color.green);

		Color lightGreen = new Color(206, 255, 199);
		setBackground(lightGreen);
		setPreferredSize(new Dimension(750, 120));
	}

	
	/**
	 * Represents the listener for all radio buttons
	 */
	private class QuoteListener implements ActionListener
	{
		/**
		 * Sets the text of the label depending on which radio
		 * button was pressed.
		 */
		public void actionPerformed(ActionEvent event)
		{
			Object source = event.getSource();

			if (source == comedy) {
				quote.setText(comedyQuote);
			} else if (source == philosophy) {
				quote.setText(philosophyQuote);
			} else {
				quote.setText(carpentryQuote);
			}
		}
	}
}
