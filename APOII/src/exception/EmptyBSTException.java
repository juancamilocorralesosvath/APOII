package exception;

public class EmptyBSTException extends Exception {
    private String message;

    public EmptyBSTException(String message){
        // hago llamado al constructor padre.
        super(message);
        this.message = message;
    }

    @Override
    public String getMessage() {
        return message;
    }
}
