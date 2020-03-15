/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

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

/**
 *
 * @author Admin
 */
public class Add implements HandlerCommand {

    public static Add typeCommand(){
        return new Add();
    }

    @Override
    public String handler(String command) {
        Logger logger = LoggerFactory.getLogger(GenerateMainMenu.class);

        //Отладочная информация
        System.out.println("Мы в методе handler класса Add получили комманду "+command);

        ParseCommand parseCommand = new ParseCommand();
        CommandArgs ca  = parseCommand.parseAddCommand(command);


        if(ca.fileName.matches(".+\\.txt")) {
            int numberString = -1;
            String operation = ca.command;
            if (ca.lineNumber != null) {
                numberString = Integer.parseInt(ca.lineNumber);
                if (numberString<0){
                    Helper.checkMinusNumberString();
                    return "can not add operation";

                }
            }

            String nameFile = ca.fileName;
            String textAdd = ca.text;

            //Проверяем если файл не существует создаем пустой
            Helper.checkFileExist(ca.fileName);
            logger.info("Пользователь ввел не существующий файл {} создали новый",ca.fileName);

            //Сначала считываем весь файл и считаем кол-во строк
            //чтобы потом можно было понять куда и как вставлять новую информацию
            List<String> listString = Helper.readFileStrings(ca.fileName);

            //условие количество строк меньше чем добавляемая
            //и нужно добавить пустых
            if (numberString == -1) {
                listString.add(textAdd);
            } else {
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
            logger.info("Добавили данные в файл {}",ca.fileName);


            return "string " + textAdd + " was added";
        }//end  if(ca.fileName.matches(".+\\.txt"))
        else{
            Helper.checkInvalidFileName();
            logger.info("Некорректное расширение файла {} операция не была произведена",ca.fileName);

            return "can not add operation";
        }
    }
    
}
