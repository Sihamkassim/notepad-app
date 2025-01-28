public class functionOfedit {
    Main main;
    public functionOfedit(Main main){
        this.main=main;

    }
    public  void  undo(){
        main.um.undo();
    }
    public void redo(){
        main.um.redo();

    }
}
