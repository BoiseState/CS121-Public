import java.awt.Dimension;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

/**
 * Demonstrates putting a JTextArea in a JScrollPane.
 * @author mvail
 */
public class TextAreaTest {

	/**
	 * @param args unused
	 */
	public static void main(String[] args)
	{
		JFrame frame = new JFrame("Text Area Test");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		// Instead of creating a new JPanel class, we are just creating a defaut JPanel
		JPanel primary = new JPanel();
		
		JTextArea textArea = new JTextArea();
		textArea.setWrapStyleWord(true);
		textArea.setText("Here's some text.\n\nLook! Multiple lines.\nIsn't that cool?\n\nTry adding another line.\n");
		
		JScrollPane scrollPane = new JScrollPane(textArea);
		scrollPane.setPreferredSize(new Dimension(200, 120));//text area will fill scroll pane and panel will expand to contain scroll pane
		scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS); //can make scroll bar always show
		
		primary.add(scrollPane);
		
		frame.getContentPane().add(primary);
		frame.pack();
		frame.setVisible(true);
	}
}