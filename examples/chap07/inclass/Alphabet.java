package inclass;

/**
 * Demonstrates how to initialize an array 3 different ways.
 * The first two show what not to do in this case.
 * @author CS121 Instructors
 *
 */
public class Alphabet
{
	public static final int NUM_LETTERS = 26;
	
	public static void main(String[] args)
	{
		char[] alphabet1 = new char[NUM_LETTERS];
		
		alphabet1[0] = 'a';
		alphabet1[1] = 'b';
		alphabet1[2] = 'c';
		alphabet1[3] = 'd';
		alphabet1[4] = 'e';
		alphabet1[5] = 'f';
		alphabet1[6] = 'g';
		alphabet1[7] = 'h';
		alphabet1[8] = 'i';
		alphabet1[9] = 'j';
		alphabet1[10] = 'k';
		alphabet1[11] = 'l';
		alphabet1[12] = 'm';
		alphabet1[13] = 'n';
		alphabet1[14] = 'o';
		alphabet1[15] = 'p';
		alphabet1[16] = 'q';
		alphabet1[17] = 'r';
		alphabet1[18] = 's';
		alphabet1[19] = 't';
		alphabet1[20] = 'u';
		alphabet1[21] = 'v';
		alphabet1[22] = 'w';
		alphabet1[23] = 'x';
		alphabet1[24] = 'y';
		alphabet1[25] = 'z';
		// What is wrong with this picture...? Sooooo tedious
		
		char[] alphabet2 = {'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h',
				'i', 'j', 'k', 'l', 'm', 'n', 'o', 'p', 'q',
				'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z'};
		// Think we can do better?
		
		char[] alphabet3 = new char[NUM_LETTERS];
		for(int i = 0; i < alphabet3.length; i++)
		{
			alphabet3[i] = (char)('a' + i);
		}
	}
}
