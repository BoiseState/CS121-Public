/**
 * Demonstrates the use of escape sequences.
 *
 * Poem copyright by Amit Jain.
 * Poem illustrates syllabic pattern: Fibonacci series: 1 1 2 3 5 8 13
 *
 * @author Amit
 */
public class BlankOrDark
{
   	/**
   	 *  Prints a poem on multiple lines.
   	 */
   	public static void main(String[] args)
   	{
		System.out.print("\n\t blank or dark\n\n"+
						  	"\t blank\n"+
						  	"\t blank\n"+
						  	"\t so blank\n"+
						  	"\t i am blank\n"+
						  	"\t so very much blank\n"+
						  	"\t why should it be so perplexing?\n"+
						  	"\n"+
						  	"\t dark\n"+
						  	"\t dark\n"+
						  	"\t so dark\n"+
						  	"\t in the dark\n"+
						  	"\t pick one, blank or dark\n"+
						  	"\t the muse-- she's lurking both places.\n"+
						  "\n"+
						  /* Copyright symbol on the console */
						  (char)169 + " by Amit Jain\n"
	  					 );
   	}
}
