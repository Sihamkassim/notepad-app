import java.awt.*;


public class functionOfcolor {
    Main main;
    public functionOfcolor(Main main){
        this.main=main;
    }
    public  void  colorchanger(String color){
        switch (color){
            case "White":
                main.window.getContentPane().setBackground(Color.white);
                main.textArea.setBackground(Color.white);
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
