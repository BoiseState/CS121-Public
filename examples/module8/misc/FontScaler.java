package misc;

import javax.swing.JFrame;

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
public class FontScaler extends JFrame {

	public static void main(String[] args) {
		JFrame gui = new JFrame("Font Scaler");
		gui.setDefaultCloseOperation(EXIT_ON_CLOSE);
		gui.getContentPane().add(new FontScalerPanel());
		gui.pack();
		gui.setLocationRelativeTo(null); //center
		gui.setVisible(true);
	}
}
