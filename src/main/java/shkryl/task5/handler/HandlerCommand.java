package shkryl.task5.handler;

/**
 * Интерфейс-обработчик команд
 */
public interface HandlerCommand {
    /**
     * Парсит команду command, введенную с консоли
     *
     * @param command команда, введенная с консоли
     * @return возвращает результат выполнения операции
     */
    String handler(String command);
}
