package misc;

import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Toolkit;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 * Display a quote in 4 fonts.
 * The first font is just the default font, which may be a reasonable size
 *  or something completely unusable, depending on screen resolution.
 * The second font is scaled according to the panel's width to be a reasonable small font size at any resolution.
 * The third font is scaled to be a reasonable medium font size.
 * The fourth font is scaled to be a reasonable large font size.
 * 
 * @author mvail
 */
@SuppressWarnings("serial")
public class FontScalerPanel extends JPanel {
	private JLabel unscaledFontLabel;
	private JLabel smallFontLabel;
	private JLabel mediumFontLabel;
	private JLabel largeFontLabel;
	
	public FontScalerPanel() {
		Dimension screenDim = Toolkit.getDefaultToolkit().getScreenSize();
		
		String quote = new String("Size matters not. Judge me by my size, do you?");
		unscaledFontLabel = new JLabel(quote);
		smallFontLabel = new JLabel(quote);
		mediumFontLabel = new JLabel(quote);
		largeFontLabel = new JLabel(quote);
		
		JPanel unscaledFontPanel = new JPanel(); //default FlowLayouts to center labels
		JPanel smallFontPanel = new JPanel();
		JPanel mediumFontPanel = new JPanel();
		JPanel largeFontPanel = new JPanel();
		
		unscaledFontPanel.add(unscaledFontLabel);
		smallFontPanel.add(smallFontLabel);
		mediumFontPanel.add(mediumFontLabel);
		largeFontPanel.add(largeFontLabel);
		
		this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
		this.add(Box.createVerticalGlue());
		this.add(unscaledFontPanel);
		this.add(smallFontPanel);
		this.add(mediumFontPanel);
		this.add(largeFontPanel);
		this.add(Box.createVerticalGlue());
		
		this.setPreferredSize(new Dimension(screenDim.width/3, screenDim.height/4));
	}
	
	public void paintComponent(Graphics g) {
		int width = this.getWidth();
		
		int smallFontPointSize = width / 50; //just played around to find a reasonable base size
		int mediumFontPointSize = (int)(smallFontPointSize * 1.5); //50% larger than base size
		int largeFontPointSize = (int)(smallFontPointSize * 2); //100% larger than base size
		
		Font smallFont = new Font("Helvitica", Font.PLAIN, smallFontPointSize);
		Font mediumFont = new Font("Helvitica", Font.PLAIN, mediumFontPointSize);
		Font largeFont = new Font("Helvitica", Font.PLAIN, largeFontPointSize);
		
		//unscaledFontLabel.setFont(); //don't change
		smallFontLabel.setFont(smallFont);
		mediumFontLabel.setFont(mediumFont);
		largeFontLabel.setFont(largeFont);
		
	}

}
