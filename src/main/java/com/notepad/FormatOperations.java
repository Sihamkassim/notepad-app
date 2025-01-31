

package com.notepad;

import java.awt.*;

public class FormatOperations {
    private Main main;
    private Font arial, comicSansMS, timesNewRoman;
    public String selectedFont;

    public FormatOperations(Main main) {
        this.main = main;
    }

    public void wordWrap() {
        if (!main.wordWrapOn) {
            main.wordWrapOn = true;
            main.textArea.setLineWrap(true);
            main.textArea.setWrapStyleWord(true);
            main.fwrap.setText("Word Wrap: On");
        } else {
            main.wordWrapOn = false;
            main.textArea.setLineWrap(false);
            main.textArea.setWrapStyleWord(false);
            main.fwrap.setText("Word Wrap: Off");
        }
    }

    public void createFont(int fontSize) {
        arial = new Font("Arial", Font.PLAIN, fontSize);
        comicSansMS = new Font("Comic Sans MS", Font.PLAIN, fontSize);
        timesNewRoman = new Font("Times New Roman", Font.PLAIN, fontSize);

        setFont(selectedFont);
    }

    public void setFont(String font) {
        selectedFont = font;
        switch (selectedFont) {
            case "Arial":
                main.textArea.setFont(arial);
                break;
            case "CSMS":
                main.textArea.setFont(comicSansMS);
                break;
            case "TNR":
                main.textArea.setFont(timesNewRoman);
                break;
        }
    }
}
