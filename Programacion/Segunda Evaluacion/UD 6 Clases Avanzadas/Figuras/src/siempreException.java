public class siempreException extends RuntimeException {
    public siempreException(){
        super("error");

    }
    public siempreException(String msj){
        super(msj) ;
    }
}
