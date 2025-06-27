package com.chris.melodygen;
import com.chris.melodygen.ScaleGenerator;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;

public class MelodyGenerator {
    private Random random = new Random();

    private int minOctave = 3;
    private int maxOctave = 5;
    private int bpm = 120;
    private String noteLength = "q"; // Default to quarter notes
    private boolean randomizeNoteLengths = false;

    // Note length mappings
    private static final String[] NOTE_LENGTHS = {"w", "h", "q", "i", "s"}; // whole, half, quarter, eighth, sixteenth
    private static final String[] NOTE_LENGTH_NAMES = {"Whole", "Half", "Quarter", "Eighth", "Sixteenth"};

    public String generateMelody(String rootNote, String scaleType, int length){
        String[] scale;
        try{
            scale = ScaleGenerator.generateScale(rootNote, scaleType);
        } catch (IllegalArgumentException e) {
            System.out.println("Error: " + e.getMessage());
            return "";
        }

        StringBuilder melody = new StringBuilder();
        for (int i = 0; i < length; i++){
            String note = scale[random.nextInt(scale.length)];

            int octave = minOctave + random.nextInt(maxOctave - minOctave + 1);
            
            // Add note with octave
            melody.append(note).append(octave);
            
            // Add note length
            if (randomizeNoteLengths) {
                String randomLength = NOTE_LENGTHS[random.nextInt(NOTE_LENGTHS.length)];
                melody.append(randomLength);
            } else {
                melody.append(noteLength);
            }
            
            melody.append(" ");
        }

        return melody.toString().trim();
    }

    public void setOctaveRange(int min, int max) {
        this.minOctave = min;
        this.maxOctave = max;
    }

    public void setBPM(int bpm) {
        this.bpm = bpm;
    }

    public int getBPM() {
        return bpm;
    }

    public void setNoteLength(String noteLength) {
        this.noteLength = noteLength;
    }

    public String getNoteLength() {
        return noteLength;
    }

    public void setRandomizeNoteLengths(boolean randomize) {
        this.randomizeNoteLengths = randomize;
    }

    public boolean isRandomizeNoteLengths() {
        return randomizeNoteLengths;
    }

    public static String[] getNoteLengthNames() {
        return NOTE_LENGTH_NAMES;
    }

    public static String[] getNoteLengths() {
        return NOTE_LENGTHS;
    }
}
