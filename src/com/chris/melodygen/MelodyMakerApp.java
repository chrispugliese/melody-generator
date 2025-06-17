package com.chris.melodygen;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import javafx.stage.FileChooser;
import javafx.stage.FileChooser.ExtensionFilter;


import org.jfugue.player.Player;
import org.jfugue.pattern.Pattern;

import java.io.File;
import java.time.LocalDateTime;

public class MelodyMakerApp extends Application {
    @Override
    public void start(Stage primaryStage) {

        final String[] melodyText = {""}; // store the melody globally inside start()

        Label outputLabel = new Label("Waiting for input...");

        // Root Note Dropdown + Text Field
        ComboBox<String> rootNoteBox = new ComboBox<>();
        rootNoteBox.getItems().addAll("C", "C#", "D", "D#", "E", "F", "F#", "G", "G#", "A", "A#", "B");
        rootNoteBox.setValue("C");

        // Scale Type
        ComboBox<String> scaleTypeBox = new ComboBox<>();
        scaleTypeBox.getItems().addAll(ScaleGenerator.getAvailableScaleTypes());
        scaleTypeBox.setValue("Dorian");

        // Melody Length
        TextField noteCountField = new TextField("8");
        noteCountField.setPromptText("Number of notes");

        // Octave Range
        ComboBox<Integer> minOctaveBox = new ComboBox<>();
        ComboBox<Integer> maxOctaveBox = new ComboBox<>();
        for (int i = 1; i <= 8; i++) {
            minOctaveBox.getItems().add(i);
            maxOctaveBox.getItems().add(i);
        }
        minOctaveBox.setValue(3);
        maxOctaveBox.setValue(5);

        // Buttons
        Button generateButton = new Button("Generate Melody");
        Button playButton = new Button("▶️ Play");
        Button downloadButton = new Button("💾 Download");

        playButton.setOnAction(e -> {
            if (melodyText[0].isEmpty()) {
              outputLabel.setText("No melody to play");
              return;
            }

            Player player = new Player();
            player.play(melodyText[0]);
        });


        // Output label

        generateButton.setOnAction(e -> {
            try {
                String root = rootNoteBox.getValue();
                String scale = scaleTypeBox.getValue();
                int length = Integer.parseInt(noteCountField.getText());
                int minOctave = minOctaveBox.getValue();
                int maxOctave = maxOctaveBox.getValue();

                MelodyGenerator generator = new MelodyGenerator();
                generator.setOctaveRange(minOctave, maxOctave); // make sure this exists!
                melodyText[0] = generator.generateMelody(root, scale, length);

                outputLabel.setText("Melody: " + melodyText[0]);
            } catch (Exception ex) {
                outputLabel.setText("Error: " + ex.getMessage());
            }
        });

        downloadButton.setOnAction(e -> {
            if (melodyText[0].isEmpty()) {
                outputLabel.setText("⚠️ No melody to download!");
                return;
            }

            FileChooser fileChooser = new FileChooser();
            fileChooser.setTitle("Save Melody As...");
            fileChooser.getExtensionFilters().add(new ExtensionFilter("MIDI files (*.mid)", "*.mid"));

            String root = rootNoteBox.getValue();
            String scale = scaleTypeBox.getValue();
            String timestamp = java.time.LocalDateTime.now().toString().replaceAll("[:.]", "-");
            fileChooser.setInitialFileName("melody_" + root + "_" + scale + "_" + timestamp + ".mid");

            File file = fileChooser.showSaveDialog(primaryStage);

            if (file != null) {
                Pattern pattern = new Pattern("V0 I[Piano] " + melodyText[0]);
                boolean success = MidiExporter.exportAsFormat1(pattern, file.getAbsolutePath());

                if (success) {
                    outputLabel.setText("Saved to: " + file.getAbsolutePath());
                } else {
                    outputLabel.setText("Could not export MIDI file");
                }
            } else {
                outputLabel.setText("Save canceled.");
            }
        });




        // Layout
        VBox layout = new VBox(10,
            new Label("Root Note:"), rootNoteBox,
            new Label("Scale Type:"), scaleTypeBox,
            new Label("Melody Length:"), noteCountField,
            new Label("Octave Range:"), new HBox(5, new Label("Min:"), minOctaveBox, new Label("Max:"), maxOctaveBox),
            generateButton, playButton, downloadButton, outputLabel
        );
        layout.setPadding(new Insets(20));

        Scene scene = new Scene(layout, 400, 600);
        primaryStage.setTitle("🎹 Melody Generator");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args){
        launch(args);
    }
    
}
