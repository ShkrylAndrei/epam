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

public class Print implements HandlerCommand {
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
                    //Helper.checkMinusNumberString();
                    //logger.info("Некорректный номер строки {}",ca.lineNumber);
                }
            }

            Helper.checkFileExist(ca.fileName);
            List<String> listString = Helper.readFileStrings(ca.fileName);
            Helper.checkInvalidNumberStringException(listString, numberString);
            logger.info("Некорректный номер строки {}",ca.lineNumber);

            if (listString.size() > 0) {
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
                    logger.info("Строка {} была выведена на экран",ca.lineNumber);
                }

                logger.info("Строка {} была выведена на экран",ca.lineNumber);
                return "string  was print";
            }
        }else{
            Helper.checkInvalidFileName();
            logger.info("Некорректное расширение файла {} операция не была произведена",ca.fileName);
        }

        logger.info("Строка не была напечатана на экране");
        return "can not print line";


    }
}
