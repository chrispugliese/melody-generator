package com.chris.melodygen;
import com.chris.melodygen.ScaleGenerator;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;

public class MelodyGenerator {
    private Random random = new Random();

    private int minOctave = 3;
    private int maxOctave = 5;

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
            melody.append(note).append(octave).append(" ");
        }

        return melody.toString().trim();
    }

    public void setOctaveRange(int min, int max) {
        this.minOctave = min;
        this.maxOctave = max;
    }
}
