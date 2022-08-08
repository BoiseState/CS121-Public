import java.io.File;

/**
 * Demonstrates command-line validation.
 * @author marissa
 */
public class CommandLineValidation 
{
    public static final int MAX_CHARS = 80;
    
    public static void main(String[] args)
    {
        String filename;
        int numChars = MAX_CHARS; 
        
        // validate there are 2 arguments
        if (args.length != 2)
        {
            System.err.println("Usage: java CommandLineValidation <filename> <num_chars_per_line>");
            System.exit(1);
        }
        
        // validate 1st argument is a name of a file that exists
        filename = args[0];
        File file = new File(filename);
        if(!file.exists())
        {
            System.err.println("Invalid filename: " + args[0] + ". File does not exist.");
            System.exit(1);
        }
            
        // validate 2nd argument is an integer between 1 and 80
        try {
            numChars = Integer.parseInt(args[1]);

            if(numChars < 1 || numChars > 80)
            {
                System.err.println("num_chars_per_line must be between 1 and 80.");
                System.exit(1);
            }
        } catch (NumberFormatException e) {
            System.err.println("Argument [" + args[1] + "] must be an integer.");
            System.exit(1);
        }

        System.out.println("Arguments accepted!");
        System.out.println("filename: " + filename);
        System.out.println("num_chars_per_line: " + numChars);
    }
}
