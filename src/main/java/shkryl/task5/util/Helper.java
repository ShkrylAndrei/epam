package shkryl.task5.util;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * Утилитарный класс помошник
 */
public class Helper {
    /**
     * Проверяет наличие файла, если его нет создаем пустой
     * @param nameFile принимает имя проверяемого файла
     */
    public static void checkFileExist(String nameFile){
        File fileForWork = new File(nameFile);
        if(!fileForWork.exists()) {

            try {
                fileForWork.createNewFile(); //creating it
            } catch (IOException e) {
                e.printStackTrace();
            }

            try (PrintWriter pw=new PrintWriter(nameFile)){
                  pw.println("");
            }catch (IOException e){
                e.printStackTrace();
            }
        }
    }

    /**
     * Считывает файл в коллекцию построчно
     * @param fileName имя файла
     * @return коллекция строк считанных из переданного файла
     */
    public static List<String> readFileStrings(String fileName){
        List<String> listString = new ArrayList<>();
        try (FileReader fr = new FileReader(fileName)) {
            Scanner scan = new Scanner(fr);
            while (scan.hasNextLine()) {
                listString.add(scan.nextLine());
            }
        }catch (IOException e){
            e.printStackTrace();
        }

        if (listString.size()==0){
            try {
                throw new EmptyFileException("Файл пустой операции с ним невозможны");
            } catch (EmptyFileException e) {
                System.out.println("Файл пустой операции с ним невозможны");
            }
        }

        return listString;
    }

    /**
     * Запись данных в файл
     * @param listString коллекция для записи в файл
     * @param fileName имя файла
     */
    public static void writeFile(List<String> listString, String fileName){
        try (PrintWriter pw=new PrintWriter(fileName)){
            for (int i = 0; i < listString.size(); i++) {
                String line = listString.get(i);
                if(i!=listString.size()-1) {
                    pw.println(line);
                }else{
                    pw.print(line);
                }
            }
        }catch (IOException e){
            e.printStackTrace();
        }
    }

    /**
     * Исключение на проверку корректного номера строки
     * @param listString коллекция содержащая строки
     * @param numberString номер обрабатываемой строки
     */
    public static void checkInvalidNumberStringException(List<String> listString, int numberString){
        if (listString.size()<numberString || numberString == -2){
            try {
                throw new InvalidNumberStringException("Такой строки не существует. Операция невозможна.");
            } catch (InvalidNumberStringException e) {
                //добавить логгер;
                System.out.println("Такой строки не существует. Операция невозможна.");
            }
        }
    }

    /**
     * Исключение на проверку корректного расширения файла
     */
    public static void checkInvalidFileName(){
        try {
            throw new InvalidFileName("Некорректное расширение файла. Файл должен быть с расширением txb. Операция невозможна");
        } catch (InvalidFileName invalidFileName) {
            System.out.println("Некорректное расширение файла. Файл должен быть с расширением txt. Операция невозможна");;
        }
    }

    /**
     * Исключение на проверку отрицательной или нулевой строки
     */
    public static void checkMinusNumberString(){
        try {
            throw new InvalidNumberStringException("Некорректный номер строки. Строка не может быть отрицательной или равна 0");
        } catch (InvalidNumberStringException e) {
            System.out.println("Некорректный номер строки. Строка не может быть отрицательной или равна 0");
        }
    }

    /**
     * Запрос комманды от пользователя с клавиатуры
     * @param str комментарий к запрашиваемому действию
     * @return строка, введенная пользователм
     */
    public static String getCommandFromUser(String str){
        System.out.println(str);
        Scanner add_sc=new Scanner(System.in);
        String command = add_sc.nextLine();
        return command;
    }

}
