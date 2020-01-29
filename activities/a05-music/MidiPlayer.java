import javax.sound.midi.Instrument;
import javax.sound.midi.InvalidMidiDataException;
import javax.sound.midi.MidiEvent;
import javax.sound.midi.MidiSystem;
import javax.sound.midi.MidiUnavailableException;
import javax.sound.midi.Sequence;
import javax.sound.midi.Sequencer;
import javax.sound.midi.ShortMessage;
import javax.sound.midi.Synthesizer;
import javax.sound.midi.Track;
/**
 * MidiPlayer can be used to play a sequence of notes on a MIDI device. A sequence of notes can be programmed
 * into the player using the provided addNote methods. The instrument used to play the note can be changed using
 * the changeInstrument method. After the notes are programmed, you can play the sequence of notes using the play method.
 * 
 * <code>
 * MidiPlayer player = new MidiPlayer();
 * player.addNote(60, 0, 1); // 60 is middle C. Note starts at beat 0 and ends at beat 1.
 * player.changeInstrument(13);
 * player.play();
 * </code>
 * 
 * @author Marissa Schmidt
 *
 */
public class MidiPlayer
{
	public static final int DEFAULT_CHANNEL = 0;    // midi channel 1
	public static final int DEFAULT_VELOCITY = 127; // 0 - 127 volume/brightness
	public static final int DEFAULT_TEMPO = 60; 	  // bpm
	public static final int TICKS_PER_BEAT = 1000;
	
	public static final int MIDDLE_C = 60;
	
	private Track track;
	private Sequencer sequencer;
	
	/**
	 * Creates a new MidiPlayer instance.
	 * 
	 * @throws MidiUnavailableException 
	 * @throws InvalidMidiDataException 
	 */
	public MidiPlayer() throws MidiUnavailableException, InvalidMidiDataException
	{
		sequencer = MidiSystem.getSequencer();
		if(sequencer == null) {
			System.err.println("Error: sequencer device not supported.");
		} else {
			sequencer.open();
			sequencer.setTempoInBPM(DEFAULT_TEMPO);
			
			Sequence sequence = new Sequence(Sequence.PPQ, TICKS_PER_BEAT);
			track = sequence.createTrack();
			sequencer.setSequence(sequence);
		}
		
	}

	/**
	 * Adds a note to the player. The note will play at the starting time and continue to play until the
	 * ending time. The notes for some instruments fade out and will not span the entire time.
	 * 
	 * @param note The note to play (60 is middle C).
	 * @param startTime The time to start playing the note (in seconds).
	 * @param endTime The time to stop playing the note (in seconds).
	 */
	public void addNote(int note, double startTime, double endTime)
	{
		addNote(note, startTime, endTime, DEFAULT_VELOCITY);
	}
	
	/**
	 * Adds a note to the player. The note will play at the starting time and continue to play until the
	 * ending time. The notes for some instruments fade out and will not span the entire time.
	 * 
	 * @param note The note to play (60 is middle C).
	 * @param startTime The time to start playing the note (in seconds).
	 * @param endTime The time to stop playing the note (in seconds).
	 * @param volume The volume of the note (0 - 127).
	 */
	public void addNote(int note, double startTime, double endTime, int volume)
	{
		addEvent(ShortMessage.NOTE_ON, DEFAULT_CHANNEL, note, volume, startTime);
		addEvent(ShortMessage.NOTE_OFF, DEFAULT_CHANNEL, note, volume, endTime);
	}
	
	/**
	 * Sets the tempo in beats per minute.
	 * @param bpm Beats per minute.
	 */
	public void setTempo(int bpm)
	{
		sequencer.setTempoInBPM(bpm);
	}
	
	/**
	 * Changes the instrument for the player starting at the provided time.
	 * @param instrument The instrument id. This will differ on various machines. You can play with the numbers. 
	 * @param time The time to change the instrument.
	 */
	public void changeInstrument(int instrument, double time)
	{
		addEvent(ShortMessage.PROGRAM_CHANGE, DEFAULT_CHANNEL, instrument, 0, time);
	}
	
	/**
	 * Plays the sequence of notes programmed into the player. This should be the last method you call.
	 */
	public void play()
	{
		sequencer.start();
		while(sequencer.isRunning()) {
			Thread.yield();
		}
        sequencer.stop();
        sequencer.close();
	}

	/**
	 * Prints the list of available instruments to the console. For debugging purposes only.
	 */
	public void printInstrumentList()
	{
		Synthesizer synth;
		try {
			synth = MidiSystem.getSynthesizer();
			synth.open();
			for(Instrument i : synth.getLoadedInstruments()) {
				System.out.println(i);
			}
		} catch (MidiUnavailableException e) {
			System.out.println("Failed to load list.");
		}
	}
	
	
	/**
	 * 
	 * @param command
	 * @param channel
	 * @param note
	 * @param velocity
	 * @param time
	 */
	private void addEvent(int command, int channel, int note, int velocity, double time)
	{
		ShortMessage message;
		try {
			message = new ShortMessage(command, channel, note, velocity);
			MidiEvent event = new MidiEvent(message, (int)(time * 1000));
			track.add(event);
		} catch (InvalidMidiDataException e) {
			System.err.println("Failed to add event to track: " + command);
			e.printStackTrace();
		}
	}
}
