package shkryl.task10.util;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class FileUtil {

    public static List<String> readFile(String filePath) throws IOException {
        List<String> fileString = new ArrayList<>();
        BufferedReader reader=new BufferedReader(new FileReader(filePath));
        String str;
        while ((str=reader.readLine())!=null){
            fileString.add(str);
        }
        return fileString;
    }

    public static List<FileEntityWrapper> parseFile(List<String> lines){
        List<FileEntityWrapper> result = new ArrayList();
        for (int i = 0; i < lines.size(); ) {
            String age = lines.get(i++).split("=")[1];
            String name = lines.get(i++).split("=")[1];
            result.add(new FileEntityWrapper(name, Integer.parseInt(age)));
        }
        return result;
    }
}
