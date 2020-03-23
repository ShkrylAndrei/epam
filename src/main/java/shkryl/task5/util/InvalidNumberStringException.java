package shkryl.task5.util;

/**
 * Исключение на проверку некорректности номера строки
 */
public class InvalidNumberStringException extends RuntimeException {
    /**
     * Конструктор принимает текст исключения
     * @param msg текст исключения
     */
    public InvalidNumberStringException(String msg){
        super(msg);
    }
}
