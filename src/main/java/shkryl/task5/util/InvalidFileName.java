package shkryl.task5.util;

/**
 * Исключение на проверку корректности файла
 */
public class InvalidFileName extends Exception {
    /**
     * Конструктор принимает текст исключения
     * @param msg текст исключения
     */
    public InvalidFileName(String msg){
        super(msg);
    }
}
