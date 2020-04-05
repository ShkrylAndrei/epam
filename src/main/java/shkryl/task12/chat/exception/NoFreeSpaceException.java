package shkryl.task12.chat.exception;

public class NoFreeSpaceException extends RuntimeException {
    public NoFreeSpaceException(String message) {
        super(message);
    }
}
