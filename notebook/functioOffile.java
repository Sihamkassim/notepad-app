import java.awt.*;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;

public class functioOffile {
    Main main;
    String fileName;
    String fileAddress;
    public functioOffile(Main main){
        this.main=main;

    }
    public void newFile(){
        main.textArea.setText("");
        main.window.setTitle("New");
        fileName=null;
        fileAddress=null;
    }
    public void openFile(){
        FileDialog fd=new FileDialog(main.window,"Open",FileDialog.LOAD);
        fd.setVisible(true);
        if (fd.getFile()!=null){
            fileName=fd.getFile();
            fileAddress=fd.getDirectory();
            main.window.setTitle(fileName);

        }
        try{
            BufferedReader R=new BufferedReader(new FileReader(fileAddress + fileName));
            main.textArea.setText("");
            String lines=null;
            while ((lines = R.readLine())!=null){
                main.textArea.append(lines + "\n");
            }
            R.close();

        }catch (Exception e){
            System.out.println("file not opend!");
        }
    }

    public void save(){
        if(fileName==null){
            saveas();

        }
        else{
            try{
                FileWriter fw=new FileWriter(fileAddress + fileName);
                fw.write(main.textArea.getText());
                main.window.setTitle(fileName);
                fw.close();


            }catch(Exception e){
                System.out.println("something wrong");
            }

        }

    }
    public void saveas(){
        FileDialog fd=new FileDialog(main.window,"saveas",FileDialog.SAVE);
        fd.setVisible(true);
        if(fd.getFile()!=null){
            fileName=fd.getFile();
            fileAddress=fd.getDirectory();
            main.window.setTitle(fileName);
        }
        try{
            FileWriter fw=new FileWriter(fileAddress + fileName);
            fw.write(main.textArea.getText());
            fw.close();

        }catch (Exception e){
            System.out.println("something wrong");
        }
    }
    public void exit(){
        System.exit(0);
    }


}
