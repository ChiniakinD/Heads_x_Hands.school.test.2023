package Exceptions;

public class AttackException extends Exception{
    public AttackException() {
        super("\"Attack\" must be at range from 1 to 30");
    }
}

