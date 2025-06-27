package com.chris.melodygen;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.control.CheckBox;
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

        // BPM Control
        TextField bpmField = new TextField("120");
        bpmField.setPromptText("BPM (60-200)");

        // Note Length Selection
        ComboBox<String> noteLengthBox = new ComboBox<>();
        noteLengthBox.getItems().addAll(MelodyGenerator.getNoteLengthNames());
        noteLengthBox.setValue("Quarter");

        // Randomize Note Lengths Checkbox
        CheckBox randomizeLengthsBox = new CheckBox("Randomize note lengths");

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
                int bpm = Integer.parseInt(bpmField.getText());
                
                // Validate BPM
                if (bpm < 60 || bpm > 200) {
                    outputLabel.setText("Error: BPM must be between 60 and 200");
                    return;
                }

                // Get note length from selection
                String noteLengthName = noteLengthBox.getValue();
                String noteLength = "";
                String[] noteLengthNames = MelodyGenerator.getNoteLengthNames();
                String[] noteLengths = MelodyGenerator.getNoteLengths();
                for (int i = 0; i < noteLengthNames.length; i++) {
                    if (noteLengthNames[i].equals(noteLengthName)) {
                        noteLength = noteLengths[i];
                        break;
                    }
                }

                MelodyGenerator generator = new MelodyGenerator();
                generator.setOctaveRange(minOctave, maxOctave);
                generator.setBPM(bpm);
                generator.setNoteLength(noteLength);
                generator.setRandomizeNoteLengths(randomizeLengthsBox.isSelected());
                
                melodyText[0] = generator.generateMelody(root, scale, length);

                outputLabel.setText("Melody: " + melodyText[0]);
            } catch (NumberFormatException ex) {
                outputLabel.setText("Error: Please enter valid numbers for BPM and melody length");
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
                try {
                    int bpm = Integer.parseInt(bpmField.getText());
                    Pattern pattern = new Pattern("V0 I[Piano] " + melodyText[0]);
                    boolean success = MidiExporter.exportAsFormat1(pattern, file.getAbsolutePath(), bpm);

                    if (success) {
                        outputLabel.setText("Saved to: " + file.getAbsolutePath());
                    } else {
                        outputLabel.setText("Could not export MIDI file");
                    }
                } catch (NumberFormatException ex) {
                    outputLabel.setText("Error: Invalid BPM value");
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
            new Label("BPM:"), bpmField,
            new Label("Note Length:"), noteLengthBox,
            randomizeLengthsBox,
            new Label("Octave Range:"), new HBox(5, new Label("Min:"), minOctaveBox, new Label("Max:"), maxOctaveBox),
            generateButton, playButton, downloadButton, outputLabel
        );
        layout.setPadding(new Insets(20));

        Scene scene = new Scene(layout, 400, 700);
        primaryStage.setTitle("🎹 Melody Generator");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args){
        launch(args);
    }
    
}
