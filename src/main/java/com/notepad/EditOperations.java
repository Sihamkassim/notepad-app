
package com.notepad;

public class EditOperations {
    private Main main;

    public EditOperations(Main main) {
        this.main = main;
    }

    public void undo() {
        main.um.undo();
    }

    public void redo() {
        main.um.redo();
    }
}
