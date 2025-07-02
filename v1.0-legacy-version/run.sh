#!/bin/bash
JAVA_FX_PATH="/Users/chrispugliese/Libraries/javafx-sdk-24.0.1/lib"
JAVA_PATH="/opt/homebrew/Cellar/openjdk/23.0.2/libexec/openjdk.jdk/Contents/Home/bin/java"

$JAVA_PATH \
--module-path "$JAVA_FX_PATH" \
--add-modules javafx.controls,javafx.fxml \
@"$1" \
com.chris.melodygen.MelodyMakerApp
