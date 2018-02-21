package basics;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.io.File;
import java.io.IOException;
import java.awt.Image;

import javax.swing.BorderFactory;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JLabel;



/**
 * Demonstrate how to load a scrollable image and display in a JPanel.
 * Unlike the example LoadImage.java, this one reads the
 * image via a private method contained in this class.
 * @author amit
 *
 */
@SuppressWarnings("serial")
public class LoadScrollableImage extends JFrame
{
	JTextField statusLine = new JTextField(30);
	JLabel imgLabel = new JLabel();

	public LoadScrollableImage(File imageFile) 
	{
		setTitle("Load Image Demo");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		JPanel imagePanel = new JPanel();
		imagePanel.setBorder(BorderFactory.createEtchedBorder());
		
		Image img = readImage(imageFile);
		if (img != null) {
			imgLabel = new JLabel(new ImageIcon(img));
		}
		imagePanel.add(imgLabel);

		JScrollPane scrollpane = new JScrollPane(imagePanel);
		scrollpane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
		scrollpane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
		scrollpane.setPreferredSize(new Dimension(250, 200));
		
		JPanel mainPanel = new JPanel();
		mainPanel.setLayout(new BorderLayout());
		mainPanel.add(scrollpane, BorderLayout.CENTER);
		mainPanel.add(statusLine, BorderLayout.SOUTH);
		
		getContentPane().add(mainPanel);
	}
	
	
	/**
	 * @param photoFile
	 */
	private Image readImage(File photoFile) 
	{
		Image img = null;
		try {
			if (photoFile == null) {
				photoFile = new File("photogui-logo.jpg");
			}
			img = ImageIO.read(photoFile);
			statusLine.setText("Read photo " + photoFile + " successfully.");
		} catch (IOException e) {
			statusLine.setText("Photo " + photoFile + " could not be read!");
		}
		
		return img;
	}
	

	/**
	 * Create the main frame and add the image panel to it.
	 * @param args
	 */
	public static void main(String[] args)
	{
		if (args.length == 0) {
			System.err.println("Usage: java LoadImage <image filename>");
			System.exit(1);
		}
		File imageFile = new File(args[0]);
		LoadScrollableImage f = new LoadScrollableImage(imageFile);
		f.pack();
		f.setVisible(true);
	}
}
