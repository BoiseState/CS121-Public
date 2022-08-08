import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;
import javax.swing.Timer;
import javax.swing.JFrame;
import javax.swing.JPanel;

/**
    An animated digital clock with clock logic to count time.
    @author  amit
    @author mvail converted from applet to GUI
*/

public class DigitalClock extends JPanel
{
    private int hour;
    private int minute;
    private int second;
    private final int delay = 1000; //milliseconds

    /**
        Display the digital time. 
        @param g Graphics context
        @return none
    */
    public void paintComponent(Graphics g)
    {
        g.setColor(Color.black);
        g.fillRect(0, 0, getWidth(), getHeight());
        g.setColor(Color.green);
        g.drawString(hour + ":" + minute + ":" + second, 60, 60);
    }
    

    /**
     * Increment time by one second and adjust time accordingly.
     */
    private void ticktock() 
    {
        second = second + 1;
        if (second == 60) {
            minute = minute + 1;
			second = 0;
            if (minute == 60) {
                hour = hour + 1;
				minute = 0;
                if (hour == 12)
                    hour = 0;
            }
        }
    }

    /**
     * Ask user to input time to set the clock by a pop-up dialog box.
     */
    private void getTimeFromUser()
    {
        String input;

        input = JOptionPane.showInputDialog("time (hh:mm:ss):");
        if (input == null)
            System.out.println("No input");
        else 
        {
            try 
            {
                int index1 = input.indexOf(":");
                hour = Integer.parseInt(input.substring(0,index1));
                int index2 = input.indexOf(":",index1+1);
                minute = Integer.parseInt(input.substring(index1+1,index2));
                second = Integer.parseInt(input.substring(index2+1,input.length()));
            }
            catch (NumberFormatException e)
            {
                System.out.println(e);
            }
        }
    }
    

    /**
        Ask for time input via a dialog box  and parse the time input.
        @param none
        @return void
    */
    public DigitalClock()
    {
        this.setBackground(Color.white);
        this.setPreferredSize(new Dimension(300,100));

        hour = 0;
        minute = 0;
        second = 0;
        setSize(200, 100);

        this.getTimeFromUser();
        this.setFont (new Font("Arial", Font.BOLD, 48));
        this.startAnimation();
    }
    
    /**
     * Create an animation thread that runs once per second
     */
    private void startAnimation() 
    {
        ActionListener taskPerformer = new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                ticktock();
                repaint();
            }
        };
        new Timer(delay, taskPerformer).start();
    }
    
    /**
     * sets up a JFrame and the DigitalClock panel
     * @param args unused
     */
    public static void main(String[] args) {
        JFrame frame = new JFrame("Digital Clock");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().add(new DigitalClock());
        frame.pack();
        frame.setVisible(true);
    }

}
