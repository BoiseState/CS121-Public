package converter2;

import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.NumberFormat;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;



/**
   This version of the Converter class presents a more elaborate GUI for
   interacting with the MetricConverter class. In the previous version
   the user had to type in their input. In this version a numeric key
   pad is used to input miles.

	@author Java, Java, Java
	@author Modified by Amit Jain.
 */


@SuppressWarnings("serial")
public class Converter extends JPanel implements ActionListener
{ 
    private final static int NBUTTONS = 12;  

    private JLabel prompt = new JLabel("Distance in miles: "); 
    private JTextField input = new JTextField(6);
    private JTextArea display = new JTextArea(10,20);
    private JButton convert = new JButton("Convert!");
    private JPanel keypadPanel = new JPanel();
  
    private JButton[] keyPad;           // An array of buttons
    private String[] labels =           // An array of button labels
                { "1","2","3",
                  "4","5","6",
                  "7","8","9",
                  "C","0","." };
    

    /**
     *  Converter() constructor sets the layout and adds
     *  components to the top-level JFrame. Note that components
     *  are added to the ContentPane rather to the JFrame itself.
     */
    public Converter() 
	{
        setLayout(new FlowLayout()); 
        initKeyPad();
        
        add(prompt);
        add(input);
        add(convert);  
        add(display);
        
        add(keypadPanel);
        display.setLineWrap( true );
        display.setEditable( false );
    
        convert.addActionListener(this);   
        input.addActionListener(this);
    }
    
  
    /**
     *  initKeyPad() creates an array of JButtons and organizes them
     *   into a graphical key pad panel. Note that you must distinguish
     *   the JButton array, an internal memory structure, from the 
     *   key pad panel, a graphical object that appears in the user interface.
     */
    private void initKeyPad() 
	{   
		//comment the following line and see what happens 
  	    keypadPanel.setLayout(new GridLayout(4,3,1,1));
  	    
        keyPad = new JButton[NBUTTONS];             // Create the array itself
        for(int k = 0; k < keyPad.length; k++) {    // For each button
            keyPad[k] = new JButton(labels[k]);      // Create a labeled button
            keyPad[k].addActionListener(this);      // and add a listener
            keypadPanel.add(keyPad[k]);             // then add it to the panel
        } 
    }
    

    /**
     *  actionPerformed() handles all action events for the program.
     *   It must distinguish whether the user clicked on what of the
     *   buttons on the keypad or on the "Convert" or "Input" button.
     *  @param e -- the ActionEvent which prompted this method call
     */
	public void actionPerformed(ActionEvent e)
	{
		if (e.getSource() == convert || e.getSource() == input) {
			double miles = Double.parseDouble(input.getText());
			double km = MetricConverter.milesToKm(miles);
			NumberFormat formatter = NumberFormat.getInstance();
			formatter.setMaximumFractionDigits(2);
			display.append(miles + " miles equals " + formatter.format(km)
					+ " kilometers\n");
			input.setText("");
		} else { // A keypad button was pressed
			// activated for any of the keypad buttons
			JButton b = (JButton) e.getSource();
			if (b.getText().equals("C"))
				input.setText("");
			else
				input.setText(input.getText() + b.getText());
		}
	}

    /**
     *  main() creates an instance of this (Converter) class and sets
     *   the size and visibility of its JFrame. 
     */
    public static void main(String args[]) 
	{
        JFrame f = new JFrame("Converter");
        Converter mainPanel = new Converter();
        f.getContentPane().add(mainPanel);
        f.setSize(400, 300);  
        f.setVisible(true);
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    } 
} 
