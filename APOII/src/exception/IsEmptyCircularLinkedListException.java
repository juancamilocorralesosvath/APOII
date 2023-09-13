package exception;

public class IsEmptyCircularLinkedListException extends Exception{
    private String message;

    public IsEmptyCircularLinkedListException(String message){
        // hago llamado al constructor padre.
        super(message);
        this.message = message;
    }

    @Override
    public String getMessage() {
        return message;
    }
}
