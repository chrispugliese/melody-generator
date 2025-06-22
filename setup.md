# 🛠️ Setup Instructions for MelodyMaker

Welcome! This guide will walk you through setting up and running the MelodyMaker project locally. This is intended for developers or contributors who want to run the project from source.

---

## ✅ Prerequisites

Before you begin, ensure you have the following installed on your system:

* Java JDK 17 or later
* [JFugue 5.0.9 JAR file](https://github.com/davidkoelle/jfugue/releases)
* [JavaFX SDK 24](https://gluonhq.com/products/javafx/)

---

## 📁 Directory Structure (After Setup)

```
melody-generator-prj/
├── src/com/chris/melodygen/*.java     # Java source files
├── lib/jfugue-5.0.9.jar               # JFugue library
├── out/                               # Compiled output (created later)
├── assets/                            # MIDI output folder
└── Libraries/javafx-sdk-24.0.1/       # JavaFX SDK extracted here
```

---

## 🧰 Compilation Instructions

1. Open Terminal in the root of the project.

2. Run the following to compile the app:

```bash
javac \
  --module-path ~/Libraries/javafx-sdk-24.0.1/lib \
  --add-modules javafx.controls,javafx.fxml \
  -cp lib/jfugue-5.0.9.jar \
  -d out \
  src/com/chris/melodygen/*.java
```

---

## ▶️ Run the App

After compiling, run the app with:

```bash
java \
  --module-path ~/Libraries/javafx-sdk-24.0.1/lib \
  --add-modules javafx.controls,javafx.fxml \
  -cp "lib/jfugue-5.0.9.jar:out" \
  com.chris.melodygen.MelodyMakerApp
```

> On Windows, use `;` instead of `:` in the classpath.

---

## 🧪 Output

* A melody will be printed in the terminal.
* The generated MIDI will be saved to `assets/generated.mid`.
* Audio will play automatically using JFugue.

---

## 🔗 Optional: Run via jDeploy

If you prefer not to build manually, you can install and run using npm:

```bash
npx melody-generator-prj
```

This uses the published JAR on npm and launches the app without needing Java or JavaFX locally.

---

## 🙋 Questions?

Feel free to open an issue on [GitHub](https://github.com/chrispugliese/melody-generator) or reach out to the author.

Happy composing! 🎶
