package shkryl.task10.part2;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) throws IOException {

        for (String f : Main.readFile()) {
            System.out.println(f);


        }
    }



    public static List<String> readFile() throws IOException {
        List<String> fileString = new ArrayList<>();
        BufferedReader reader=new BufferedReader(new FileReader("list_value.txt"));
        String str;
        while ((str=reader.readLine())!=null){
            fileString.add(str);
        }
        return fileString;
    }

}
