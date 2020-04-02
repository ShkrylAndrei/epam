package shkryl.task10.exceptions;

/**
 * Описывает ошибку отсутствия аннотации Value
 */
public class NoValueAnnotationException extends RuntimeException {
    public NoValueAnnotationException(String message) {
        super(message);
    }
}
