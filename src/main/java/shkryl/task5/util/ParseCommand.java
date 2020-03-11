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
        return null;
    }

    public CommandArgs parseAddCommand(String str){
        CommandArgs ca = new CommandArgs();

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
        String secondArgument = arrString[index++];

        int linesCount = -1;
        String fileName = null;
        String text = null;
        if(secondArgument.matches("\\d+")){
            linesCount = Integer.valueOf(secondArgument);
            ca.lineNumber =  String.valueOf(linesCount);
        }


        fileName = arrString[index++];
        ca.fileName= fileName;


        text = subStringWithSeparator.replace("\"", "");
        ca.text = text;





        //отладочная информация
//        System.out.println("Parse command");
//        for (int i = 0; i < listString.length; i++) {
//            System.out.println(listString[i]);
//        }
        return ca;
    }
}
