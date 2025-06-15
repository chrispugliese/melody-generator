package com.chris.melodygen;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;


public class MelodyGenerator {
    private static final Map<String, String[]> MAJOR_SCALES = new HashMap<>();

    static{
        MAJOR_SCALES.put("C", new String[]{"C", "D", "E", "F", "G", "A", "B"});
        MAJOR_SCALES.put("G", new String[]{"G", "A", "B", "C", "D", "E", "F#"});
        MAJOR_SCALES.put("D", new String[]{"D", "E", "F#", "G", "A", "B", "C#"});
    }

        private Random random = new Random();

        public String generateMelody(String key, int length){
            String[] scale = MAJOR_SCALES.getOrDefault(key, MAJOR_SCALES.get("C"));
            StringBuilder melody = new StringBuilder();

            for (int i = 0; i < length; i++){
                String note = scale[random.nextInt(scale.length)];
                melody.append(note).append("q ");
            }

            return melody.toString().trim();
    }
    
}
