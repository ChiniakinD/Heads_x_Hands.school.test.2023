package Exceptions;

public class MinHealthException  extends Exception{
    public MinHealthException() {
        super("\"Health\" must be positive");
    }
}
