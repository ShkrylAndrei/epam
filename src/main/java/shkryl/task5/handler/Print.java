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
    @Override
    public String handler(String command) {

        ParseCommand parseCommand = new ParseCommand();
        CommandArgs ca  = parseCommand.parsePrintDeleteCommand(command);

        int numberString=-1;
        if (ca.lineNumber!=null) {
            numberString = Integer.parseInt(ca.lineNumber);
        }

        Helper.checkFileExist(ca.fileName);
        List<String> listString = Helper.readFileStrings(ca.fileName);
        Helper.checkInvalidNumberStringException(listString, numberString);

        if(numberString==-1){
            int lastIndex = listString.size()-1;
            System.out.println("Печатаем строку: "+listString.get(lastIndex));
        }else{
            System.out.println("Печатаем строку: "+listString.get(numberString-1));
        }

        return "string  was print";


    }
}
