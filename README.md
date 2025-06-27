# 🎵 MelodyMaker

A simple Java application that generates a random melody in a chosen key, plays it, and exports it as a MIDI file you can use in DAWs like Ableton, Logic, or FL Studio.

The main idea came from not having an idea at all. Instead of looking for external tools or plug-ins, I figured I'd build one myself. The more I start to develop and get a sense for what direction I want to go in, the more it will be useable in a production workflow. Plus, I want to learn Java lol.

---

## ⚡ Try It Now

🎉 Download and run MelodyMaker on your computer without building anything:

👉 [Download MelodyMaker via JDeploy](https://www.jdeploy.com/~melody-generator-prj)

Available for macOS, Windows, and Linux.

---

## ✨ Features

- 🎼 Random melody generation based on musical key (e.g., C Major)
- 🎹 Audio playback powered by JFugue
- 💾 MIDI export
- 🖥️ GUI built with JavaFX
- 🎛️ Drag-and-drop compatibility with major DAWs
- 🧩 Modular, extensible Java codebase

---

## 🚀 Getting Started

📄 [Setup Instructions](setup.md)

> 📦 Note: You **do not need to build or publish this app via `jdeploy`** — that’s handled privately.

### 📦 Folder Structure

```plaintext
melody-generator-prj/
├── src/com/chris/melodygen/
│   └── *.java
├── lib/
│   ├── jfugue-5.0.9.jar
│   └── javafx-sdk-24.0.1/
├── assets/
│   └── generated.mid
├── out/                ← compiled class output
├── jdeploy/            ← for internal packaging only
├── package.json        ← do not use unless publishing
├── README.md
```

### 🔮 Roadmap

- ✅ Basic GUI functionality
- ✅ Octave shifts
- ✅ MIDI export
- Rhythm pattern
- Note length variations
- DAW integration

### 📜 License
MIT — free to use and share.

### 👋 Author
@chrispugliese

