
/**
    Illustrate how to use command line arguments.
    Run it as follows:

    java CmdLineArgs <string> <int> <double>

    @author amit

*/

public class CmdLineArgs
{
    public static void main (String[] args)
    {
        if (args.length != 3) {
            System.err.println("Usage: java CmdLineArgs <string> <int> <double>");
            System.exit(1);
        }

        for (int i=0; i<args.length; i++)
        {
            System.out.println("command line argument " + i + " = "+args[i]);
        }

        String first = args[0];
        int second = Integer.parseInt(args[1]);
        double third = Double.parseDouble(args[2]);

        System.out.println("After parsing: " + first + " " + second + " " + third);
    }

}
