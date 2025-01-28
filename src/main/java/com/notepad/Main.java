package com.notepad;

import javax.swing.*;
import javax.swing.event.UndoableEditEvent;
import javax.swing.event.UndoableEditListener;
import javax.swing.undo.UndoManager;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Main implements ActionListener {
    JFrame window;
    JTextArea textArea;
    JScrollPane scroll;
    boolean wordWrapOn = false;

    // Adding menu on the top of the window
    JMenuBar tmenu;
    JMenu menuFile, menuEdit, menuFormat, menuColor;
    JMenuItem inew, iopen, isave, isaveas, iexit;
    
    // File operations
    FileOperations fileOps = new FileOperations(this);
    
    // Format operations
    JMenuItem fwrap, fFontArial, fFontCSMS, fFontTNR, fFontsize8, fFontsize12, fFontsize16, fFontsize20, fFontsize24, fFontsize28;
    JMenu ffont, ffontsize;
    FormatOperations formatOps = new FormatOperations(this);
    ColorOperations colorOps = new ColorOperations(this);

    JMenuItem eRedo, eUndo;
    UndoManager um = new UndoManager();
    EditOperations editOps = new EditOperations(this);

    JMenuItem color1, color2, color3;

    public static void main(String[] args) {
        new Main();
    }

    public Main() {
        createWindow();
        createTextArea();
        createMenuBar();
        createFileMenu();
        createFormatMenu();
        createColorMenu();
        createEditMenu();

        formatOps.selectedFont = "Arial";
        formatOps.createFont(16);
        formatOps.wordWrap();

        colorOps.changeColor("White");

        window.setVisible(true);
    }

    public void createWindow() {
        window = new JFrame("Notepad");
        window.setSize(700, 600);
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    public void createTextArea() {
        textArea = new JTextArea();
        textArea.getDocument().addUndoableEditListener(
                new UndoableEditListener() {
                    @Override
                    public void undoableEditHappened(UndoableEditEvent e) {
                        um.addEdit(e.getEdit());
                    }
                }
        );

        scroll = new JScrollPane(textArea, JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED, JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
        scroll.setBorder(BorderFactory.createEmptyBorder());
        window.add(scroll);
    }

    public void createMenuBar() {
        tmenu = new JMenuBar();
        window.setJMenuBar(tmenu);
        menuFile = new JMenu("File");
        menuEdit = new JMenu("Edit");
        menuFormat = new JMenu("Format");
        menuColor = new JMenu("Color");

        tmenu.add(menuFile);
        tmenu.add(menuEdit);
        tmenu.add(menuFormat);
        tmenu.add(menuColor);
    }

    public void createFileMenu() {
        inew = new JMenuItem("New");
        inew.addActionListener(this);
        inew.setActionCommand("New");
        menuFile.add(inew);

        iopen = new JMenuItem("Open");
        iopen.addActionListener(this);
        iopen.setActionCommand("Open");
        menuFile.add(iopen);

        isave = new JMenuItem("Save");
        isave.addActionListener(this);
        isave.setActionCommand("Save");
        menuFile.add(isave);

        isaveas = new JMenuItem("Save As");
        isaveas.addActionListener(this);
        isaveas.setActionCommand("Save As");
        menuFile.add(isaveas);

        iexit = new JMenuItem("Exit");
        iexit.addActionListener(this);
        iexit.setActionCommand("Exit");
        menuFile.add(iexit);
    }

    public void createFormatMenu() {
        fwrap = new JMenuItem("Word Wrap: Off");
        fwrap.addActionListener(this);
        fwrap.setActionCommand("Word Wrap");
        menuFormat.add(fwrap);

        ffont = new JMenu("Font");
        menuFormat.add(ffont);

        fFontArial = new JMenuItem("Arial");
        fFontArial.addActionListener(this);
        fFontArial.setActionCommand("Arial");
        ffont.add(fFontArial);

        fFontTNR = new JMenuItem("Times New Roman");
        fFontTNR.addActionListener(this);
        fFontTNR.setActionCommand("TNR");
        ffont.add(fFontTNR);

        fFontCSMS = new JMenuItem("Comic Sans MS");
        fFontCSMS.addActionListener(this);
        fFontCSMS.setActionCommand("CSMS");
        ffont.add(fFontCSMS);

        ffontsize = new JMenu("Font Size");
        menuFormat.add(ffontsize);

        createFontSizeMenuItem("8");
        createFontSizeMenuItem("12");
        createFontSizeMenuItem("16");
        createFontSizeMenuItem("20");
        createFontSizeMenuItem("24");
        createFontSizeMenuItem("28");
    }

    private void createFontSizeMenuItem(String size) {
        JMenuItem item = new JMenuItem(size);
        item.addActionListener(this);
        item.setActionCommand(size);
        ffontsize.add(item);
    }

    public void createColorMenu() {
        color1 = new JMenuItem("White");
        color1.addActionListener(this);
        color1.setActionCommand("White");
        menuColor.add(color1);

        color2 = new JMenuItem("Gray");
        color2.addActionListener(this);
        color2.setActionCommand("Gray");
        menuColor.add(color2);

        color3 = new JMenuItem("Black");
        color3.addActionListener(this);
        color3.setActionCommand("Black");
        menuColor.add(color3);
    }

    public void createEditMenu() {
        eUndo = new JMenuItem("Undo");
        eUndo.addActionListener(this);
        eUndo.setActionCommand("Undo");
        menuEdit.add(eUndo);

        eRedo = new JMenuItem("Redo");
        eRedo.addActionListener(this);
        eRedo.setActionCommand("Redo");
        menuEdit.add(eRedo);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String command = e.getActionCommand();

        switch (command) {
            // File Menu
            case "New": fileOps.newFile(); break;
            case "Open": fileOps.openFile(); break;
            case "Save": fileOps.save(); break;
            case "Save As": fileOps.saveAs(); break;
            case "Exit": fileOps.exit(); break;

            // Edit Menu
            case "Undo": editOps.undo(); break;
            case "Redo": editOps.redo(); break;

            // Format Menu
            case "Word Wrap": formatOps.wordWrap(); break;
            case "Arial":
            case "TNR":
            case "CSMS":
                formatOps.setFont(command);
                break;
            case "8":
            case "12":
            case "16":
            case "20":
            case "24":
            case "28":
                formatOps.createFont(Integer.parseInt(command));
                break;

            // Color Menu
            case "White":
            case "Gray":
            case "Black":
                colorOps.changeColor(command);
                break;
        }
    }
}
