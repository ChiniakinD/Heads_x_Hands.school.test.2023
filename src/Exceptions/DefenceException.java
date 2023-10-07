package Exceptions;

public class DefenceException extends Exception{
    public DefenceException() {
        super("\"Defence\" must be at range from 1 to 30");
    }
}
