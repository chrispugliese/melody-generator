Compile App
 
 javac --module-path /Users/chrispugliese/Libraries/javafx-sdk-24.0.1/lib \  !2573
      --add-modules javafx.controls,javafx.fxml \
      -cp lib/jfugue-5.0.9.jar \
      -d out src/com/chris/melodygen/*.java


Run App
java --module-path /Users/chrispugliese/Libraries/javafx-sdk-24.0.1/lib \   !2574
     --add-modules javafx.controls,javafx.fxml \
     -cp "lib/jfugue-5.0.9.jar:out" \
     com.chris.melodygen.MelodyMakerApp
