# 🎵 MelodyMaker

A simple Java application that generates a random melody in a chosen key, plays it, and exports it as a MIDI file you can use in DAWs like Ableton, Logic, or FL Studio.

The idea came from not having an idea at all. Instead of looking for external tools or plug-ins, I figured I'd build one myself. As development continues, the app will evolve into something more usable in a real production workflow. Plus, I want to learn Java lol.

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

## 🚀 Project Versions

### ✅ `v2-maven-version/` — Current Version (Clean Build)
> Rebuilt using **Maven** for dependency management and maintainability.

📦 Automatically handles:
- JavaFX
- JFugue
- Java 17+ compatibility

### 📦 Build & Run

```bash
cd v2-maven-version
mvn clean install
mvn exec:java
```

### 📁 `v1-legacy-version/` — Original Version (Deprecated)
> First implementation using JDeploy and custom scripts.
> Kept for archival purposes — use the Maven version (v2-maven-version/) for further development.

### 📦 Folder Structure

```plaintext
melody-generator-prj/
├── v1-legacy-version/      ← original JDeploy-based project
│   ├── src/
│   ├── lib/
│   ├── run.sh, assets/
│   └── jdeploy/
├── v2-maven-version/       ← clean Maven-based rebuild
│   ├── pom.xml
│   └── src/main/java/
├── README.md
```

### 🔮 Roadmap

- ✅ Basic GUI functionality
- ✅ Octave shifts
- ✅ MIDI export
- ✅ Rhythm pattern
- Note length variations
- DAW integration

### 📜 License
MIT — free to use and share.

### 👋 Author
@chrispugliese

