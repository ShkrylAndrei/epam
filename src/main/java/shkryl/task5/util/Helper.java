package shkryl.task5.util;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Helper {
    public static void checkFileExist(String nameFile){
        //Проверяем если файл не существует создаем пустой
        File fileForWork = new File(nameFile);
        if(!fileForWork.exists()) {

            try {
                fileForWork.createNewFile(); //creating it
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public static List<String> readFileStrings(String fileName){
        //Список строчек файла
        List<String> listString = new ArrayList<>();
        //Сначала считываем весь файл и считаем кол-во строк
        //чтобы потом можно было понять куда и как удалять информацию
        try (FileReader fr = new FileReader(fileName)) {
            Scanner scan = new Scanner(fr);
            while (scan.hasNextLine()) {
                listString.add(scan.nextLine());
            }

        }catch (IOException e){
            e.printStackTrace();
        }
        return listString;
    }

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


    public static void checkInvalidNumberStringException(List<String> listString, int numberString){
        if (listString.size()<numberString){
            try {
                throw new InvalidNumberStringException("Такой строки не существует. Операция невозможна.");
            } catch (InvalidNumberStringException e) {
                //добавить логгер;
                System.out.println("Такой строки не существует. Операция невозможна.");
            }
        }
    }

}
