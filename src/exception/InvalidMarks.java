package exception;

public class InvalidMarks extends RuntimeException {
    public InvalidMarks() {
        super("Invalid marks");
    }
}
