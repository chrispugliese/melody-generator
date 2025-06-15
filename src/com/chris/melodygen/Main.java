package com.chris.melodygen;

import org.jfugue.player.Player;

public class Main{
    public static void main(String[] args){
        MelodyGenerator generator = new MelodyGenerator();
        String melody = generator.generateMelody("C", 8);
        
        System.out.println("Generated melody: [" + melody + "]");
        
        Player player = new Player();
        player.play(melody);
    }
}