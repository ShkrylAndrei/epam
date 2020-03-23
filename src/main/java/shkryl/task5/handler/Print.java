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
 * Класс-обработчик команды печати выбранной строки, реализует интерфейст {@link HandlerCommand}
 */
public class Print implements HandlerCommand {
    /**
     * Создает объект класса Print
     * @return возвращает объект класса Print
     */
    public static Print typeCommand(){
        return new Print();
    }

    @Override
    public String handler(String command) {
        Logger logger = LoggerFactory.getLogger(Print.class);

        //Отладочная информация
        System.out.println("Мы в методе handler класса Print получили комманду "+command);

        ParseCommand parseCommand = new ParseCommand();
        CommandArgs ca  = parseCommand.parsePrintDeleteCommand(command);

        if(ca.fileName.matches(".+\\.txt")) {
            int numberString = -1;
            if (ca.lineNumber != null) {
                numberString = Integer.parseInt(ca.lineNumber);
                if (numberString<=0){
                    numberString=-2;
                    //Здесь обрабатываю сразу так как метод унаследованный от интерфейса
                    Helper.checkMinusNumberString();
                    //logger.info("Некорректный номер строки {}",ca.lineNumber);
                }
            }

            Helper.checkFileExist(ca.fileName);
            List<String> listString = Helper.readFileStrings(ca.fileName);
            Helper.checkInvalidNumberStringException(listString, numberString);

            if (listString.size() > 0 && listString.size()>=numberString) {
                if (numberString == -1) {
                    int lastIndex = listString.size() - 1;
                    System.out.println("Печатаем строку: " + listString.get(lastIndex));
                } else if (numberString == -2){
                    System.out.println("Нечего выводить строка имеет отрицательное значение или равна нулю");
                    //logger.info("Некорректный номер строки {}",ca.lineNumber);
                    logger.info("Операция print не была выполнена");
                    return "can not print line";
                }else {
                    System.out.println("Печатаем строку: " + listString.get(numberString - 1));
                }

                logger.info("Строка {} была выведена на экран",ca.lineNumber);
                return "string  was print";
            }
        }else{
            Helper.checkInvalidFileName();
            logger.error("Некорректное расширение файла {} операция не была произведена",ca.fileName);
        }

        logger.info("Строка не была напечатана на экране");
        return "can not print line";


    }
}
