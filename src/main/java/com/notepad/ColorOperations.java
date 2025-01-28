package com.notepad;

import java.awt.*;

public class ColorOperations {
    private Main main;

    public ColorOperations(Main main) {
        this.main = main;
    }

    public void changeColor(String color) {
        switch (color) {
            case "White":
                main.window.getContentPane().setBackground(Color.WHITE);
                main.textArea.setBackground(Color.WHITE);
                main.textArea.setForeground(Color.BLACK);
                break;
            case "Gray":
                main.window.getContentPane().setBackground(Color.GRAY);
                main.textArea.setBackground(Color.GRAY);
                main.textArea.setForeground(Color.YELLOW);
                break;
            case "Black":
                main.window.getContentPane().setBackground(Color.BLACK);
                main.textArea.setBackground(Color.BLACK);
                main.textArea.setForeground(Color.MAGENTA);
                break;
        }
    }
}
