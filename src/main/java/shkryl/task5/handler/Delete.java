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

public class Delete implements HandlerCommand {
    public static Delete typeCommand(){
        return new Delete();
    }

    @Override
    public String handler(String command) {
        //Отладочная информация
        System.out.println("Мы в методе handler класса Delete получили комманду "+command);

        ParseCommand parseCommand = new ParseCommand();
        CommandArgs ca  = parseCommand.parsePrintDeleteCommand(command);

        if(ca.fileName.matches(".+\\.txt")) {
            int numberString = -1;
            if (ca.lineNumber != null) {
                numberString = Integer.parseInt(ca.lineNumber);
                if (numberString<0){
                    numberString=-2;
                }
            }

            Helper.checkFileExist(ca.fileName);
            List<String> listString = Helper.readFileStrings(ca.fileName);
            if (numberString == -1) {
                numberString = listString.size();
            }
            Helper.checkInvalidNumberStringException(listString, numberString);

            if (listString.size() > 0 && numberString!=-2) {
                listString.remove(numberString - 1);
                Helper.writeFile(listString, ca.fileName);

                return "string  was delete";
            }


        }else{
            Helper.checkInvalidFileName();
        }


        return "can not delete line";

    }
}
