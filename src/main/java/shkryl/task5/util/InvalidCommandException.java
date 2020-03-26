package shkryl.task5.util;

/**
 * Исключение на неккоректную комманду
 */
public class InvalidCommandException extends RuntimeException{
    /**
     * Конструктор, принимает текст исключения
     *
     * @param msg текст исключения
     */
    public InvalidCommandException(String msg){
        super(msg);
    }
}
