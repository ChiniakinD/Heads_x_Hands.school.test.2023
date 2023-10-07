package Exceptions;

public class DamageException extends Exception{
    public DamageException() {
        super("\"minDamage\" must be bigger than \"maxDamage\"");
    }
}
