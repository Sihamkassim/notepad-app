import javax.swing.*;
import javax.swing.event.UndoableEditEvent;
import javax.swing.event.UndoableEditListener;
import javax.swing.undo.UndoManager;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main implements ActionListener {
    JFrame window;

    JTextArea textArea;
    JScrollPane scroll;
    boolean wordWrapOn=false;
//adding menu on the top of the window
    JMenuBar tmenu;
    JMenu menuFile,menuEdit,menuFormat,menuColor;
    JMenuItem inew,iopen,isave,isaveas,iexit;
    //file
    functioOffile f=new functioOffile(this);
    //format
    JMenuItem fwrap,fFontArial,fFontCSMS,fFontTNR,fFontsize8,fFontsize12,fFontsize16,fFontsize20,fFontsize24,fFontsize28;
    JMenu ffont,ffontsize;
    functioOfformat ff=new functioOfformat(this);
    functionOfcolor fc=new functionOfcolor(this);

    JMenuItem eRedo,eUndo;
    UndoManager um=new UndoManager();
    functionOfedit edit=new functionOfedit(this);

    JMenuItem color1,color2,color3;
    public static void main(String[] args) {
        //TIP Press <shortcut actionId="ShowIntentionActions"/> with your caret at the highlighted text
        // to see how IntelliJ IDEA suggests fixing it.
        new Main();
    }
    public Main(){
        Window();
        creatTextarea();
        creatmenubar();
        creatfilemenu();
        creatformatmenu();
        colormenu();
        editmenu();

        ff.selectedFont="Arial";
        ff.fontmaaker(16);
        ff.wordwrap();

        fc.colorchanger("white");

        window.setVisible(true);

    }
    public void Window(){
        window=new JFrame("Notepad");
        window.setSize(700,600);
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
    public void creatTextarea(){
        textArea=new JTextArea();

        textArea.getDocument().addUndoableEditListener(
                new UndoableEditListener() {
                    @Override
                    public void undoableEditHappened(UndoableEditEvent e) {
                        um.addEdit(e.getEdit());
                    }
                }
        );

        scroll=new JScrollPane(textArea,JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED,JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
        scroll.setBorder(BorderFactory.createEmptyBorder());
        window.add(scroll);
    }
    public void creatmenubar(){
        tmenu=new JMenuBar();
        window.setJMenuBar(tmenu);
        menuFile=new JMenu("file");
        menuEdit=new JMenu("Edit");
        menuFormat=new JMenu("Format");
        menuColor=new JMenu("Color");

        tmenu.add(menuFile);
        tmenu.add(menuEdit);
        tmenu.add(menuFormat);
        tmenu.add(menuColor);


    }
    public void creatfilemenu(){
        inew=new JMenuItem("New");
        inew.addActionListener(this);
        inew.setActionCommand("New");
        menuFile.add(inew);

        iopen=new JMenuItem("Open");
        iopen.addActionListener(this);
        iopen.setActionCommand("Open");
        menuFile.add(iopen);

        isave=new JMenuItem("save");
        isave.addActionListener(this);
        isave.setActionCommand("Save");
        menuFile.add(isave);


        isaveas=new JMenuItem("Save As");
        isaveas.addActionListener(this);
        isaveas.setActionCommand("Save As");
        menuFile.add(isaveas);

        iexit=new JMenuItem("Exit");
        iexit.addActionListener(this);
        iexit.setActionCommand("Exit");
        menuFile.add(iexit);

    }
    public void creatformatmenu(){
        fwrap =new JMenuItem("Word Wrap:off");
        fwrap.addActionListener(this);
        fwrap.setActionCommand("Word Wrap");
        menuFormat.add(fwrap);

        ffont=new JMenu("Font");
        menuFormat.add(ffont);


        fFontArial=new JMenuItem("Arial");
        fFontArial.addActionListener(this);
        fFontArial.setActionCommand("Arial");
        ffont.add(fFontArial);

        fFontTNR=new JMenuItem("TNR");
        fFontTNR.addActionListener(this);
        fFontTNR.setActionCommand("TNR");
        ffont.add(fFontTNR);

        fFontCSMS=new JMenuItem("CSMS");
        fFontCSMS.addActionListener(this);
        fFontCSMS.setActionCommand("CSMS");
        ffont.add(fFontCSMS);



        ffontsize=new JMenu("Font Size");
        menuFormat.add(ffontsize);

        fFontsize8=new JMenuItem("8");
        fFontsize8.addActionListener(this);
        fFontsize8.setActionCommand("8");
        ffontsize.add(fFontsize8);

        fFontsize12=new JMenuItem("12");
        fFontsize12.addActionListener(this);
        fFontsize12.setActionCommand("12");
        ffontsize.add(fFontsize8);

        fFontsize16=new JMenuItem("16");
        fFontsize16.addActionListener(this);
        fFontsize16.setActionCommand("16");
        ffontsize.add(fFontsize16);

        fFontsize20=new JMenuItem("20");
        fFontsize20.addActionListener(this);
        fFontsize20.setActionCommand("20");
        ffontsize.add(fFontsize20);

        fFontsize24=new JMenuItem("24");
        fFontsize24.addActionListener(this);
        fFontsize24.setActionCommand("24");
        ffontsize.add(fFontsize24);

        fFontsize28=new JMenuItem("28");
        fFontsize28.addActionListener(this);
        fFontsize28.setActionCommand("28");
        ffontsize.add(fFontsize28);
    }
    public void colormenu(){
        color1=new JMenuItem("White");
        color1.addActionListener(this);
        color1.setActionCommand("White");
        menuColor.add(color1);

        color2=new JMenuItem("Gray");
        color2.addActionListener(this);
        color2.setActionCommand("Gray");
        menuColor.add(color2);

        color3=new JMenuItem("Black");
        color3.addActionListener(this);
        color3.setActionCommand("Black");
        menuColor.add(color3);

    }
    public void editmenu(){

        eUndo=new JMenuItem("Undo");
        eUndo.addActionListener(this);
        eUndo.setActionCommand("Undo");
        menuEdit.add(eUndo);

        eRedo=new JMenuItem("Redo");
        eRedo.addActionListener(this);
        eRedo.setActionCommand("Redo");
        menuEdit.add(eRedo);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String command=e.getActionCommand();
        switch (command){
            case "New": f.newFile(); break;
            case "Open":f.openFile(); break;
            case "Save As":f.saveas(); break;
            case "Save":f.save(); break;
            case "Edit":f.exit(); break;
            case "Word Wrap":ff.wordwrap(); break;

            case "8":ff.fontmaaker(8); break;
            case "12":ff.fontmaaker(12); break;
            case "16":ff.fontmaaker(16); break;
            case "24":ff.fontmaaker(24); break;
            case "20":ff.fontmaaker(20); break;
            case "28":ff.fontmaaker(28); break;

            case "AiaArl":ff.setFont("Arial");break;
            case "CSM":ff.setFont("CSM");break;
            case "TNR":ff.setFont("TNR");break;

            case "White":fc.colorchanger("White");break;
            case "Gray":fc.colorchanger("Gray");break;
            case "Black":fc.colorchanger("Black");break;

            case "Undo":edit.undo();break;
            case "Redo":edit.redo();break;
        }

    }
}