package shkryl.task4;

/**
 * Исключение на возможность сохранение сущности
 */
public class EntityNotFound extends Exception {
    /**
     * Конструктор, принимает текст исключения
     * @param message текст исключения
     */
    public EntityNotFound(String message){
        super(message);
    }
}
