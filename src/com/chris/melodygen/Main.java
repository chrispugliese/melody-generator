package com.chris.melodygen;

import org.jfugue.player.Player;
import org.jfugue.midi.MidiFileManager;
import org.jfugue.pattern.Pattern;
import java.io.File;

public class Main{
    public static void main(String[] args){
        MelodyGenerator generator = new MelodyGenerator();
        String melody = generator.generateMelody("D", "Dorian", 8);
        
        System.out.println("Generated melody: [" + melody + "]");

        Player player = new Player();
        player.play(melody);

        try{
            Pattern pattern = new Pattern();
            pattern.add("V0");
            pattern.add("I[Piano]");
            pattern.add(melody);

            File midiFile = new File("assets/generated.mid");
            MidiFileManager.savePatternToMidi(pattern, midiFile);
            System.out.println("✅ MIDI exported to: " + midiFile.getAbsolutePath());
        } catch (Exception e){
            System.out.println("❌ Failed to export MIDI: " + e.getMessage());

        }
}    }
