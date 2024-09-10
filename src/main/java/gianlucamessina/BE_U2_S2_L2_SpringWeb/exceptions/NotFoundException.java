package gianlucamessina.BE_U2_S2_L2_SpringWeb.exceptions;

public class NotFoundException extends  RuntimeException{
    public NotFoundException(int id){
        super("record con ID: "+id+" non trovato!");
    }
}
