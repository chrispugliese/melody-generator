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

public class MelodyMakerApp extends Application {
    @Override
    public void start(Stage primaryStage) {
        // 🎵 Root Note Dropdown + Text Field
        ComboBox<String> rootNoteBox = new ComboBox<>();
        rootNoteBox.getItems().addAll("C", "C#", "D", "D#", "E", "F", "F#", "G", "G#", "A", "A#", "B");
        rootNoteBox.setValue("C");

        // 📜 Scale Type
        ComboBox<String> scaleTypeBox = new ComboBox<>();
        scaleTypeBox.getItems().addAll(ScaleGenerator.getAvailableScaleTypes());
        scaleTypeBox.setValue("Major");

        // 🔢 Melody Length
        TextField noteCountField = new TextField("8");
        noteCountField.setPromptText("Number of notes");

        // 🎚️ Octave Range
        ComboBox<Integer> minOctaveBox = new ComboBox<>();
        ComboBox<Integer> maxOctaveBox = new ComboBox<>();
        for (int i = 1; i <= 8; i++) {
            minOctaveBox.getItems().add(i);
            maxOctaveBox.getItems().add(i);
        }
        minOctaveBox.setValue(3);
        maxOctaveBox.setValue(5);

        // 🎛️ Buttons
        Button generateButton = new Button("Generate Melody");
        Button playButton = new Button("▶️ Play");
        Button randomizeButton = new Button("🎲 Randomize");
        Button replayButton = new Button("🔁 Replay");
        Button downloadButton = new Button("💾 Download");

        // 🪄 Output label
        Label outputLabel = new Label("Waiting for input...");

        // 🧱 Layout
        VBox layout = new VBox(10,
            new Label("Root Note:"), rootNoteBox,
            new Label("Scale Type:"), scaleTypeBox,
            new Label("Melody Length:"), noteCountField,
            new Label("Octave Range:"), new HBox(5, new Label("Min:"), minOctaveBox, new Label("Max:"), maxOctaveBox),
            generateButton, playButton, randomizeButton, replayButton, downloadButton,
            outputLabel
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
