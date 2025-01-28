import java.awt.*;

public class functioOfformat {
    Main main;
    Font arial,comicScansMS,timesNewRoman;
    String selectedFont;
    public functioOfformat(Main main){
        this.main=main;

    }
    public void wordwrap(){
        if(main.wordWrapOn==false){
            main.wordWrapOn=true;
            main.textArea.setLineWrap(true);
            main.textArea.setWrapStyleWord(true);
            main.fwrap.setText("word wrap on");
        } else if (main.wordWrapOn==true) {
            main.wordWrapOn=false;
            main.textArea.setLineWrap(false);
            main.textArea.setWrapStyleWord(false);
            main.fwrap.setText("word wrap off");


        }
    }
    public void fontmaaker(int ffontsize){
        arial=new Font("Arial",Font.PLAIN,ffontsize);
        comicScansMS=new Font("Comic Scans MS",Font.PLAIN,ffontsize);
        timesNewRoman=new Font("Times New Roman",Font.PLAIN,ffontsize);

        setFont(selectedFont);

    }
    public void setFont(String font){
        selectedFont=font;
        switch (selectedFont){
            case "Arial":
                main.textArea.setFont(arial);
                break;
            case "CSM":
                main.textArea.setFont(comicScansMS);
                break;
            case "TNR":
                main.textArea.setFont(timesNewRoman);
                break;
        }

    }
}
