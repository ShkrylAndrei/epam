package shkryl.task10.util;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class FileUtil {

    /**
     * Чтение текстового файла
     * @param filePath путь к файлу
     * @return коллекция строк, прочитанных из файла
     * @throws IOException
     */
    public static List<String> readFile(String filePath) throws IOException {
        List<String> fileString = new ArrayList<>();
        BufferedReader reader=new BufferedReader(new FileReader(filePath));
        String str;
        while ((str=reader.readLine())!=null){
            fileString.add(str);
        }
        return fileString;
    }

    /**
     * Обрабатывает считанные строки из файла, проверяет параметры на корректность написания, достает их значения
     * @param lines список считанных строк из файла
     * @return возвращает список параметров, обернутых в FileEntityWrapper
     */
    public static List<FileEntityWrapper> parseFile(List<String> lines){
        List<FileEntityWrapper> result = new ArrayList();
        for (int i = 0; i < lines.size(); ) {
            String ageParameter = lines.get(i++);
            String nameParameter = lines.get(i++);
            if(isParameterValid(ageParameter, nameParameter)) {
                String age = ageParameter.split("=")[1];
                String name = nameParameter.split("=")[1];
                result.add(new FileEntityWrapper(name, Integer.parseInt(age)));
            }
        }
        return result;

    }

    /**
     * Проверяет параметры age и name на корректность написания
     * @param ageParam строка, содержащая параметр age
     * @param nameParam строка, содержащая параметр name
     * @return возвращает true, если параметры корретные, иначе выбрасывает IllegalArgumentException
     */
    private static boolean isParameterValid(String ageParam, String nameParam){
        if(ageParam.matches("age=.+") &&  nameParam.matches("name=.+")) {
            return true;
        }
        throw new IllegalArgumentException("Файл параметров заполнен некорректно");
    }
}
