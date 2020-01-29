import javax.sound.midi.InvalidMidiDataException;
import javax.sound.midi.MidiUnavailableException;

/**
 * Plays a one octave scale starting at middle c.
 * 
 * @author Marissa Schmidt
 */
public class SoundScape
{
	public static void main(String[] args)
	{
		try
		{
			// Creates a new MidiPlayer instance.
			MidiPlayer player = new MidiPlayer();
			
			// Plays one octave scale starting at middle c - (c, d, e, f, g, a, b, c)
			player.addNote(MidiPlayer.MIDDLE_C, 0, 1);
			
			player.addNote(MidiPlayer.MIDDLE_C + 2, 1, 2);
			
			player.addNote(MidiPlayer.MIDDLE_C + 4, 2, 3);
			
			player.addNote(MidiPlayer.MIDDLE_C + 5, 3, 4);
			
			// Changes instrument to xylophone at beat 4
			player.changeInstrument(13, 4);
			
			player.addNote(MidiPlayer.MIDDLE_C + 7, 4, 5);
			
			player.addNote(MidiPlayer.MIDDLE_C + 9, 5, 6);
			
			// Changes instrument to cello at beat 6
			player.changeInstrument(42, 6);
			
			player.addNote(MidiPlayer.MIDDLE_C + 11, 6, 7);
			
			player.addNote(MidiPlayer.MIDDLE_C + 12, 7, 8);
			
			
			// Just for reading list of available instruments. We won't leave this in our final version.
			player.printInstrumentList();
			
			//******************************************
			// DO NOT MODIFY ANYTHING AFTER THIS LINE
			//******************************************
			player.play(); // plays the song
		}
		catch(MidiUnavailableException | InvalidMidiDataException e)
		{
			System.out.println("Failed to initialize the MIDI player.");
			e.printStackTrace();
		}
	}
}
