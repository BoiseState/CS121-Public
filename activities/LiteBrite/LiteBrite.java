import javax.swing.JFrame;

/**
 * Driver class for LiteBrite activities.
 * 
 * @author mvail
 */
public class LiteBrite {

	/** @param args unused */
	public static void main(String[] args) {
		JFrame frame = new JFrame("LiteBrite");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		LiteBritePanel panel = new LiteBritePanel();
		frame.getContentPane().add(panel);
		frame.pack();
		frame.setVisible(true);
	}

}
