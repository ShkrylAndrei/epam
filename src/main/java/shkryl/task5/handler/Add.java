/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package shkryl.task5.handler;

import shkryl.task5.util.CommandArgs;
import shkryl.task5.util.Helper;
import shkryl.task5.util.ParseCommand;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 *
 * @author Admin
 */
public class Add implements HandlerCommand {

    @Override
    public String handler(String command) {        
        //Отладочная информация
        System.out.println("Мы в методе handler класса Add получили комманду "+command);
        ParseCommand parseCommand = new ParseCommand();
        CommandArgs ca  = parseCommand.parseAddCommand(command);
        int numberString = -1;
        String operation = ca.command;
        if(ca.lineNumber!=null) {
            numberString = Integer.parseInt(ca.lineNumber);
        }

        String nameFile = ca.fileName;
        String textAdd = ca.text;


        //Список строчек файла
//        List<String> listString = new ArrayList<>();
//        //кол-во строк
//        int count_string=0;

        //Проверяем если файл не существует создаем пустой
        Helper.checkFileExist(ca.fileName);
//        File fileForWork = new File(nameFile);
//        if(!fileForWork.exists()) {
//
//            try {
//                fileForWork.createNewFile(); //creating it
//            } catch (IOException e) {
//                e.printStackTrace();
//            }
//        }
        

        //Сначала считываем весь файл и считаем кол-во строк
        //чтобы потом можно было понять куда и как вставлять новую информацию
        List<String> listString = Helper.readFileStrings(ca.fileName);
//        try (FileReader fr = new FileReader(nameFile)) {
//            Scanner scan = new Scanner(fr);
//            while (scan.hasNextLine()) {
//                listString.add(scan.nextLine());
//                count_string++;
//            }
//
//        }catch (IOException e){
//              e.printStackTrace();
//        }



        
        //1е условие количество строк меньше чем добавляемая
        //и нужно добавить пустых
        if(numberString==-1){
            listString.add(textAdd);
        }else {
            int flag = 0;
            while (listString.size() < numberString) {
                listString.add("");
                flag = 1;
            }
            if (flag == 1) {
                listString.set(numberString - 1, textAdd);
            } else {
                listString.add(numberString - 1, textAdd);
            }
        }

        Helper.writeFile(listString, ca.fileName);
//        try (PrintWriter pw=new PrintWriter(nameFile)){
//            for (int i = 0; i < listString.size(); i++) {
//                String line = listString.get(i);
//                if(i!=listString.size()-1) {
//                    pw.println(line);
//                }else{
//                    pw.print(line);
//                }
//            }
//        }catch (IOException e){
//            e.printStackTrace();
//        }

        
        
        //2е если количество строк больше то
        //у нас уже есть все прочитанно
        //просто записываем до нужного номера строки
        //потом записываем свою строку
        //потом записываем остальное
        
        
        
        return "string "+textAdd+" was added";       
        //2е нужно вставить строчку между существующими
        
        
    }
    
}
