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
   // private Map<String, HandlerCommand> handlerMap;
    public Filter(){
//        handlerMap = new HashMap<>();
//        handlerMap.put("add", new Add());
//        handlerMap.put("delete", new Delete());
//        handlerMap.put("print", new Print());

    }
    public void execute(String command){



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
                //System.out.println(handlerMap.get(operation).handler(command));
                if (operation.equals("add")){
                    System.out.println(Add.typeCommand().handler(command));
                }else if (operation.equals("print")){
                    System.out.println(Print.typeCommand().handler(command));
                }else if (operation.equals("delete")){
                    System.out.println(Delete.typeCommand().handler(command));
                }

            }else{
                //++ вывести через логгер без исключения:
                System.out.println("Некорректная команда");
            }
        }
    }
}
