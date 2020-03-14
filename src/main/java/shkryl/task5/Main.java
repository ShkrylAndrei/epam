/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package shkryl.task5;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import shkryl.task5.filter.Filter;
import shkryl.task5.util.GenerateMainMenu;

import java.util.Scanner;

/**
 *
 * @author Admin
 */
public class Main {


    public static void main(String[] args) {
        Logger logger = LoggerFactory.getLogger(Main.class);
        logger.info("Запуск программы");

        GenerateMainMenu.generate();

//        Filter filter = new Filter();
//        boolean m=true;
//        while (m){
//            System.out.println("");
//            System.out.println("Меню");
//            System.out.println("1. добавить строку. ");
//            System.out.println("2. удалить строку, формат команды delete НОМЕР_СТРОКИ ИМЯ_ФАЙЛА");
//            System.out.println("3. вывести на экран строку, формат команды print НОМЕР_СТРОКИ ИМЯ_ФАЙЛА");
//            System.out.println("4. Выход");
//
//            Scanner sc;
//            int parameter=-1;
//            while (parameter==-1) {
//                sc=new Scanner(System.in);
//                try {
//                   parameter = sc.nextInt();
//                } catch (Exception e) {
//                    System.out.println("Неверно выбранный пункт меню, повторите попытку");
//                    logger.debug("EXCEPTION: Неверно выбранный пункт меню, повторите попытку");
//                }
//            }// end while
//
//            if (parameter==1){
//                System.out.println("Введите комманду для добавления - формат команды add НОМЕР_СТРОКИ ИМЯ_ФАЙЛА \"ТЕКСТ\"");
//                Scanner add_sc=new Scanner(System.in);
//                String command = add_sc.nextLine();
//
//                System.out.println("Введенная комманда "+command);
//                logger.debug("Пользователь ввел комманду {}",command);
//                filter.execute(command);
//            }
//
//
//            if (parameter==2){
//                System.out.println("Введите комманду для удаления - формат команды delete НОМЕР_СТРОКИ ИМЯ_ФАЙЛА ");
//                Scanner add_sc=new Scanner(System.in);
//                String command = add_sc.nextLine();
//
//                System.out.println("Введенная комманда "+command);
//                logger.debug("Пользователь ввел комманду {}",command);
//                filter.execute(command);
//            }
//
//            if (parameter==3){
//                System.out.println("Введите комманду для печати - формат команды print НОМЕР_СТРОКИ ИМЯ_ФАЙЛА ");
//                Scanner add_sc=new Scanner(System.in);
//                String command = add_sc.nextLine();
//
//                System.out.println("Введенная комманда "+command);
//                logger.debug("Пользователь ввел комманду {}",command);
//                filter.execute(command);
//            }
//
//            if (parameter==4){
//                m=false;
//                logger.debug("Произошел выход из системы");
//            }
//
//    }//end - while (m)
    }
}
