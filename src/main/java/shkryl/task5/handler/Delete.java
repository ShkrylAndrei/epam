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

public class Delete implements HandlerCommand {
    public static Delete typeCommand(){
        return new Delete();
    }

    @Override
    public String handler(String command) {
        Logger logger = LoggerFactory.getLogger(GenerateMainMenu.class);

        //Отладочная информация
        System.out.println("Мы в методе handler класса Delete получили комманду "+command);

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
                }
            }

            Helper.checkFileExist(ca.fileName);
            List<String> listString = Helper.readFileStrings(ca.fileName);
            if (numberString == -1) {
                numberString = listString.size();
            }
            Helper.checkInvalidNumberStringException(listString, numberString);
            logger.info("Некорректный номер строки {}",ca.lineNumber);

            if (listString.size() > 0 && numberString!=-2) {
                listString.remove(numberString - 1);
                Helper.writeFile(listString, ca.fileName);

                logger.info("Строка {} была удалена из файла",numberString);
                return "string  was delete";
            }


        }else{
            Helper.checkInvalidFileName();
            logger.info("Некорректное расширение файла {} операция не была произведена",ca.fileName);
        }

        logger.info("Строка {} не была удалена из файла",ca.lineNumber);
        return "can not delete line";

    }
}
