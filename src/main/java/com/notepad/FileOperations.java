package com.notepad;

import java.awt.*;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;

public class FileOperations {
    private Main main;
    private String fileName;
    private String fileAddress;

    public FileOperations(Main main) {
        this.main = main;
    }

    public void newFile() {
        main.textArea.setText("");
        main.window.setTitle("New");
        fileName = null;
        fileAddress = null;
    }

    public void openFile() {
        FileDialog fd = new FileDialog(main.window, "Open", FileDialog.LOAD);
        fd.setVisible(true);
        
        if (fd.getFile() != null) {
            fileName = fd.getFile();
            fileAddress = fd.getDirectory();
            main.window.setTitle(fileName);

            try (BufferedReader br = new BufferedReader(new FileReader(fileAddress + fileName))) {
                main.textArea.setText("");
                String line;
                while ((line = br.readLine()) != null) {
                    main.textArea.append(line + "\n");
                }
            } catch (Exception e) {
                System.out.println("Error opening file: " + e.getMessage());
            }
        }
    }

    public void save() {
        if (fileName == null) {
            saveAs();
        } else {
            try (FileWriter fw = new FileWriter(fileAddress + fileName)) {
                fw.write(main.textArea.getText());
                main.window.setTitle(fileName);
            } catch (Exception e) {
                System.out.println("Error saving file: " + e.getMessage());
            }
        }
    }

    public void saveAs() {
        FileDialog fd = new FileDialog(main.window, "Save As", FileDialog.SAVE);
        fd.setVisible(true);

        if (fd.getFile() != null) {
            fileName = fd.getFile();
            fileAddress = fd.getDirectory();
            main.window.setTitle(fileName);

            try (FileWriter fw = new FileWriter(fileAddress + fileName)) {
                fw.write(main.textArea.getText());
            } catch (Exception e) {
                System.out.println("Error saving file: " + e.getMessage());
            }
        }
    }

    public void exit() {
        System.exit(0);
    }
}
