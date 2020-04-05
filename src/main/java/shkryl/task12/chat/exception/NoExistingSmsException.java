package shkryl.task12.chat.exception;

public class NoExistingSmsException extends RuntimeException {
    public NoExistingSmsException(String message) {
        super(message);
    }
}
