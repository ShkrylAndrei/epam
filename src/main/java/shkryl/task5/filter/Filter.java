package shkryl.task5.filter;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import shkryl.task5.handler.Add;
import shkryl.task5.handler.Delete;
import shkryl.task5.handler.HandlerCommand;
import shkryl.task5.handler.Print;
import shkryl.task5.util.GenerateMainMenu;
import shkryl.task5.util.InvalidCommandException;

import java.util.HashMap;
import java.util.Map;

/**
 * Предоставляет метод парсинга команды, введенной с консоли
 */
public class Filter {

    public Filter() {
    }

    /**
     * Парсит команду command, проверяет ее на корректность
     * Если command имеет неверный формат, генерирует {@link InvalidCommandException}
     * запускает выполнение команды
     *
     * @param command команда, введенная с консоли
     */
    public void execute(String command) {
        Logger logger = LoggerFactory.getLogger(Filter.class);

        String[] args = command.split(" ");
        if (args.length < 2) {
            try {
                throw new InvalidCommandException("Строка команды имеет неверный формат");
            } catch (InvalidCommandException e) {
                 System.out.println("Строка команды имеет неверный формат");
                 logger.error("Строка команды имеет неверный формат, количество параметров не может быть меньше 2");
            }
        } else {
            String operation = args[0];
            if (operation.equals("add") || operation.equals("print") || operation.equals("delete")) {
                if (operation.equals("add")) {
                    System.out.println(Add.typeCommand().handler(command));
                } else if (operation.equals("print")) {
                    System.out.println(Print.typeCommand().handler(command));
                } else if (operation.equals("delete")) {
                    System.out.println(Delete.typeCommand().handler(command));
                }

            } else {
                 System.out.println("Некорректная команда");
                 logger.info("Некорректная комманда");
            }
        }
    }
}
