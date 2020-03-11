/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package shkryl.task5.filter;

import shkryl.task5.handler.Add;
import shkryl.task5.handler.Delete;
import shkryl.task5.handler.HandlerCommand;
import shkryl.task5.handler.Print;
import shkryl.task5.util.InvalidCommandException;

import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author Admin
 */
public class Filter {
    private Map<String, HandlerCommand> handlerMap;
    public Filter(){
        handlerMap = new HashMap<>();
        handlerMap.put("add", new Add());
        handlerMap.put("delete", new Delete());
        handlerMap.put("print", new Print());

    }
    public void execute(String command){
        //ParseCommand parseCommand = new ParseCommand();
        //String[] listParam = parseCommand.parse(command);
        
        //отладочная информация
//        System.out.println("Filter -listParam");
//        for (int i = 0; i < listParam.length; i++) {
//            System.out.println(listParam[i]);
//
//        }
//
        
//        String operation = listParam[0];
//        int numberString = Integer.parseInt(listParam[1]);
//        String nameFile = listParam[2];
//
//        //StringBuilder textAdd = new StringBuilder();
//        String textAdd = null;
//        if (operation.equals("add")){
//             textAdd = listParam[3];
//
////
////        for (int i=1;i<listParam[3].length()-1;i++){
////            textAdd.append(listParam[3].charAt(i));
////        }
//            if (nameFile == null || nameFile.equals("")){
//                nameFile = "add.txt";
//            }
//        }//end - if (operation=="add")
//
//        //отладочная информация
//        System.out.println("operation = "+operation);


        String[] args = command.split(" ");
        if(args.length<2){

            try {
                throw new InvalidCommandException("Строка команды имеет неверный формат");
            }catch(InvalidCommandException e){
                //++ вывести через логгер c исключением:
                System.out.println("Строка команды имеет неверный формат");
            }

        }else {
            String operation = args[0];
            if(operation.equals("add") || operation.equals("print") || operation.equals("delete")){
                handlerMap.get(operation).handler(command);
            }else{
                //++ вывести через логгер без исключения:
                System.out.println("Некорректная команда");
            }
        }
    }
}
