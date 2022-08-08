import javax.swing.JFrame;

/**
 * Demonstrates how to replace a panel with a fresh one. Helpful for implementing
 * new game buttons.
 * 
 * @author mvail
 * @author marissa
 */
public class GameBoard
{
	/**
	 * @param args unused
	 */
	public static void main(String[] args) {
		JFrame frame = new JFrame("Panel Replacer");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().add(new GameBoardPanel());
		frame.pack();
		frame.setVisible(true);
	}
}
