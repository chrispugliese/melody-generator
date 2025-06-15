# 🎵 Random Melody Generator

A simple Java application that generates a random melody in a chosen key, plays it, and exports it as a MIDI file you can use in DAWs like Ableton, Logic, or FL Studio.

The main idea came from not having an idea at all. Instead of looking for external tools or plug-ins, I figured I'd build one myself. The more I start to develop and get a sense for what direction I want to go in, the more it will be useable in a production workflow. Plus, I want to learn Java lol.

---

## ✨ Features

- ✅ Random melody generation based on musical key (e.g., C Major)
- ✅ JFugue-powered note playback
- ✅ MIDI file export to `assets/generated.mid`
- ✅ Drag-and-drop compatible with DAWs like Ableton
- ✅ Modular Java codebase, easy to expand

---

## 🚀 Getting Started

### 🧰 Requirements
- Java 8+
- JFugue 5.0.9 ([Download JAR](https://github.com/davidkoelle/jfugue/releases))
- Terminal or IDE (IntelliJ, VS Code, etc.)

### 📦 Folder Structure

```plaintext
random-melody-generator/
├── src/com/chris/melodygen/
│ ├── Main.java
│ └── MelodyGenerator.java
├── lib/jfugue-5.0.9.jar
├── assets/generated.mid
└── README.md
```
### 🛠️ Compile & Run

```bash
javac -cp lib/jfugue-5.0.9.jar -d out src/com/chris/melodygen/*.java
java -cp "lib/jfugue-5.0.9.jar:out" com.chris.melodygen.Main
- On Windows, use ; instead of : in the classpath.
```

### 📝 Output Example

```vbnet
Generated melody: [Cq Dq Gq Eq Fq Bq Aq Cq]
✅ MIDI exported to: /path/to/assets/generated.mid
```

### 🔮 Planned Features

- Support for all other keys & scales
- Rhythm pattern
- Octave shifts
- Note length variations
- GUI?
- DAW integration

### 📜 License
MIT — free to use, modify, and share.

### 👋 Author
@chrispugliese

