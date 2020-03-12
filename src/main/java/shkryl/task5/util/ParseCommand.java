/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package shkryl.task5.util;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 *
 * @author Admin
 */
public class ParseCommand {


    public CommandArgs parsePrintDeleteCommand(String str){
        //вынести в отдельное поле
        CommandArgs ca = new CommandArgs();
        String parameters[] = str.split(" ");

        //Если удаляем
        if (parameters[0].equals("delete")) {
            ca.command = "delete";
            //Если переданно имя файла
            if (parameters.length > 2) {
                ca.lineNumber = parameters[1];
                ca.fileName = parameters[2];
            } else {
                ca.lineNumber = null;
                ca.fileName = parameters[1];
            }
        }

        //Если распечатываем
        if (parameters[0].equals("print")) {
            ca.command = "print";
            //Если переданно имя файла
            if (parameters.length> 2) {
                ca.lineNumber = parameters[1];
                ca.fileName = parameters[2];
            } else {
                ca.lineNumber = null;
                ca.fileName = parameters[1];
            }
        }

        return ca;
    }

    public CommandArgs parseAddCommand(String str){
        CommandArgs ca = new CommandArgs();

        ca.command="add";


        int separateIndex = -1;
        for (int i = 0; i < str.length(); i++) {
            if(str.charAt(i)=='"'){
                separateIndex = i;
                break;
            }
        }
        String subStringWithoutSeparator = str.substring(0, separateIndex);
        String subStringWithSeparator = str.substring(separateIndex);
        String[] arrString = subStringWithoutSeparator.split(" ");
        int index = 1;
        //String secondArgument = arrString[index++];
        String secondArgument = arrString[index];

        int linesCount = -1;
        String fileName = null;
        String text = null;

        if(secondArgument.matches("\\d+") && arrString.length>2){
            linesCount = Integer.valueOf(secondArgument);
            ca.lineNumber =  String.valueOf(linesCount);
            index++;
        }



        fileName = arrString[index++];
        ca.fileName= fileName;


        text = subStringWithSeparator.replace("\"", "");
        ca.text = text;


        return ca;
    }
}
