/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package shkryl.task5;

import shkryl.task5.filter.Filter;

import java.util.Scanner;

/**
 *
 * @author Admin
 */
public class Main {
    public static void main(String[] args) {


        Filter filter = new Filter();
        boolean m=true;
        while (m){
            System.out.println("");
            System.out.println("Меню");
            System.out.println("1. добавить строку. ");
            System.out.println("2. удалить строку, формат команды delete НОМЕР_СТРОКИ ИМЯ_ФАЙЛА");
            System.out.println("3. вывести на экран строку, формат команды print НОМЕР_СТРОКИ ИМЯ_ФАЙЛА");
            System.out.println("4. Выход");           
            
            Scanner sc=new Scanner(System.in);
            int parameter=sc.nextInt();
            
            if (parameter==1){
                System.out.println("Введите комманду для добавления - формат команды add НОМЕР_СТРОКИ ИМЯ_ФАЙЛА \"ТЕКСТ\"");
                Scanner add_sc=new Scanner(System.in);
                String command = add_sc.nextLine();

                System.out.println("Введенная комманда "+command);
                filter.execute(command);
            }
        
    }
    }
}
