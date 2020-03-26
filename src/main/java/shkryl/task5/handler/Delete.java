package shkryl.task5.handler;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import shkryl.task5.util.*;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * Класс-обработчик команды удаления строки, реализует интерфейст {@link HandlerCommand}
 */
public class Delete implements HandlerCommand {
    /**
     * Создает объект класса Delete
     *
     * @return возвращает созданный объект класса Delete
     */
    public static Delete typeCommand() {
        return new Delete();
    }

    @Override
    public String handler(String command) {
        Logger logger = LoggerFactory.getLogger(GenerateMainMenu.class);

        //Отладочная информация
        System.out.println("Мы в методе handler класса Delete получили комманду " + command);

        ParseCommand parseCommand = new ParseCommand();
        CommandArgs ca = parseCommand.parsePrintDeleteCommand(command);

        if (ca.fileName.matches(".+\\.txt")) {
            int numberString = -1;
            if (ca.lineNumber != null) {
                numberString = Integer.parseInt(ca.lineNumber);
                if (numberString <= 0) {
                    numberString = -2;
                    //Здесь обрабатываю сразу так как метод унаследованный от интерфейса
                    Helper.checkMinusNumberString();
                }
            }

            Helper.checkFileExist(ca.fileName);
            List<String> listString = Helper.readFileStrings(ca.fileName);
            if (numberString == -1) {
                numberString = listString.size();
            }
            Helper.checkInvalidNumberStringException(listString, numberString);

            if (listString.size() > 0 && numberString != -2 && listString.size() >= numberString) {
                listString.remove(numberString - 1);
                Helper.writeFile(listString, ca.fileName);

                logger.info("Строка {} была удалена из файла", numberString);
                return "string  was delete";
            }
        } else {
            Helper.checkInvalidFileName();
            logger.error("Некорректное расширение файла {} операция не была произведена", ca.fileName);
        }

        logger.info("Строка {} не была удалена из файла", ca.lineNumber);
        return "can not delete line";
    }
}
