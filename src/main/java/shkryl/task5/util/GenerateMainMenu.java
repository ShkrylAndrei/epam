package shkryl.task5.util;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import shkryl.task5.Main;
import shkryl.task5.filter.Filter;

import java.util.Scanner;

public class GenerateMainMenu {

    public static void generate(){
        Logger logger = LoggerFactory.getLogger(GenerateMainMenu.class);
        Filter filter = new Filter();
        boolean m=true;
        while (m){
            System.out.println("");
            System.out.println("Меню");
            System.out.println("1. добавить строку. ");
            System.out.println("2. удалить строку, формат команды delete НОМЕР_СТРОКИ ИМЯ_ФАЙЛА");
            System.out.println("3. вывести на экран строку, формат команды print НОМЕР_СТРОКИ ИМЯ_ФАЙЛА");
            System.out.println("4. Выход");

            Scanner sc;
            int parameter=-1;

            while (parameter==-1) {
                try {
                    sc=new Scanner(System.in);
                    parameter = sc.nextInt();
                } catch (Exception e) {
                    System.out.println("Неверно выбранный пункт меню, повторите попытку");
                    logger.error("EXCEPTION: Неверно выбранный пункт меню, повторите попытку, пользователь ввел {}",parameter);
                }

            }// end while

            if (parameter==1){
                //System.out.println("Введите комманду для добавления - формат команды add НОМЕР_СТРОКИ ИМЯ_ФАЙЛА \"ТЕКСТ\"");
                //Scanner add_sc=new Scanner(System.in);
                //String command = add_sc.nextLine();
                String command = Helper.getCommandFromUser("Введите комманду для добавления - формат команды add НОМЕР_СТРОКИ ИМЯ_ФАЙЛА \"ТЕКСТ\"");

                System.out.println("Введенная комманда "+command);
                logger.info("Пользователь ввел комманду {}",command);
                filter.execute(command);
            }


            if (parameter==2){
//                System.out.println("Введите комманду для удаления - формат команды delete НОМЕР_СТРОКИ ИМЯ_ФАЙЛА ");
//                Scanner add_sc=new Scanner(System.in);
//                String command = add_sc.nextLine();
                String command = Helper.getCommandFromUser("Введите комманду для удаления - формат команды delete НОМЕР_СТРОКИ ИМЯ_ФАЙЛА ");


                System.out.println("Введенная комманда "+command);
                logger.info("Пользователь ввел комманду {}",command);
                filter.execute(command);
            }

            if (parameter==3){
//                System.out.println("Введите комманду для печати - формат команды print НОМЕР_СТРОКИ ИМЯ_ФАЙЛА ");
//                Scanner add_sc=new Scanner(System.in);
//                String command = add_sc.nextLine();
                String command = Helper.getCommandFromUser("Введите комманду для печати - формат команды print НОМЕР_СТРОКИ ИМЯ_ФАЙЛА ");


                System.out.println("Введенная комманда "+command);
                logger.info("Пользователь ввел комманду {}",command);
                filter.execute(command);
            }

            if (parameter==4){
                m=false;
                logger.info("Произошел выход из системы");
            }

        }//end - while (m)
    }

}
