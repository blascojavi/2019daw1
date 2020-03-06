package CONTROLLER;

public class IsNotNumberException extends RuntimeException {
    public IsNotNumberException(String s) {
        super("El valor introducido en el campo no es un numero");
    }
}
