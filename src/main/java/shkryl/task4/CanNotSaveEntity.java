package shkryl.task4;

/**
 * Исключение на возможность сохранение сущности
 */
public class CanNotSaveEntity extends RuntimeException {
    /**
     * Конструктор принимает текст исключения
     * @param message текст исключения
     */
    public CanNotSaveEntity(String message){
        super(message);
    }
}
