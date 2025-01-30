 Notepad Application

A simple Java Swing-based notepad application with features like file operations, text formatting, and themes.

Features

- File Operations (New, Open, Save, Save As)
- Text Formatting (Font family, size, word wrap)
- Color Themes (White, Gray, Black)
- Edit Operations (Undo, Redo)

 Requirements

- Java 11 or higher
- Maven

How to Run in Visual Studio

1. Open the project in Visual Studio
2. Make sure you have the following extensions installed:
   - Extension Pack for Java
   - Project Manager for Java
   - Maven for Java

3. Open the project:
   - File -> Open Folder
   - Select the `notepad-app` folder

4. Run the application:
   - Open `src/main/java/com/notepad/Main.java`
   - Click the Run button (▶️) or press F5

 Project Structure

```
notepad-app/
├── src/
│   └── main/
│       └── java/
│           └── com/
│               └── notepad/
│                   ├── Main.java
│                   ├── FileOperations.java
│                   ├── FormatOperations.java
│                   ├── ColorOperations.java
│                   └── EditOperations.java
├── pom.xml
└── README.md

