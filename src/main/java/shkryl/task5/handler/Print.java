package shkryl.task5.handler;

import shkryl.task5.util.CommandArgs;
import shkryl.task5.util.Helper;
import shkryl.task5.util.InvalidNumberStringException;
import shkryl.task5.util.ParseCommand;

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
        //Отладочная информация
        System.out.println("Мы в методе handler класса Print получили комманду "+command);

        ParseCommand parseCommand = new ParseCommand();
        CommandArgs ca  = parseCommand.parsePrintDeleteCommand(command);

        if(ca.fileName.matches(".+\\.txt")) {
            int numberString = -1;
            if (ca.lineNumber != null) {
                numberString = Integer.parseInt(ca.lineNumber);
                if (numberString<0){
                    numberString=-2;
                    //Здесь обрабатываю сразу так как метод унаследованный от интерфейса
                    Helper.checkMinusNumberString();
                }
            }

            Helper.checkFileExist(ca.fileName);
            List<String> listString = Helper.readFileStrings(ca.fileName);
            Helper.checkInvalidNumberStringException(listString, numberString);

            if (listString.size() > 0) {
                if (numberString == -1) {
                    int lastIndex = listString.size() - 1;
                    System.out.println("Печатаем строку: " + listString.get(lastIndex));
                } else if (numberString == -2){
                    System.out.println("Нечего выводить строка имеет отрицательное значение");
                    return "can not print line";
                }else {
                    System.out.println("Печатаем строку: " + listString.get(numberString - 1));
                }

                return "string  was print";
            }
        }else{
            Helper.checkInvalidFileName();
        }

        return "can not print line";


    }
}
