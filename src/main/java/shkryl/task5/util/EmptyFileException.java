package shkryl.task5.util;

/**
 * Исключение на проверку пустого файла
 */
public class EmptyFileException extends RuntimeException {
    /**
     * Конструктор принимает текст исключения
     * @param msg текст исключения
     */
    EmptyFileException(String msg){
        super(msg);
    }
}
