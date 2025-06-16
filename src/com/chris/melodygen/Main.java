package com.chris.melodygen;

import org.jfugue.player.Player;
import org.jfugue.midi.MidiFileManager;
import org.jfugue.pattern.Pattern;
import java.io.File;
import java.util.Scanner;
import java.util.Set;

public class Main{
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        MelodyGenerator generator = new MelodyGenerator();


        System.out.println("Welcome to the Random Melody Generator!");

        // get root note
        System.out.print("Enter a root note!: ");
        String rootNote = scanner.nextLine().trim().toUpperCase();

        // list available scales

        Set<String> availableScales = ScaleGenerator.getAvailableScaleTypes();
        System.out.println("\nAvailable Scales: ");
        for (String scale : availableScales){
            System.out.println("- " + scale);
        }

        // get scale type
        System.out.print("\nEnter a scale type (case sensitive, exactly as listed above): ");
        String scaleType = scanner.nextLine().trim();

        // melody length
        System.out.print("How many notes should the melody have? ");
        int length = Integer.parseInt(scanner.nextLine().trim());

        // generate melody
        String melody = generator.generateMelody(rootNote, scaleType, length);
        System.out.println("Generated melody: " + melody);
        

        Player player = new Player();
        player.play(melody);

        Pattern pattern = new Pattern("V0 I[PIANO] " + melody);
        boolean success = MidiExporter.exportAsFormat1(pattern, "assets/generated.mid");

        if (!success){
            System.out.println("There was a problem exporting the MIDI file.");
        }

        scanner.close();
    }
}    
