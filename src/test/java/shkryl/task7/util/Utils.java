package shkryl.task7.util;

import java.io.*;

public class Utils {
    public static String getFileExtension(File file) {
        String fileName = file.getName();
        // если в имени файла есть точка и она не является первым символом в названии файла
        if(fileName.lastIndexOf(".") != -1 && fileName.lastIndexOf(".") != 0)
            // то вырезаем все знаки после последней точки в названии файла, то есть ХХХХХ.txt -> txt
            return fileName.substring(fileName.lastIndexOf(".")+1);
            // в противном случае возвращаем заглушку, то есть расширение не найдено
        else return "";
    }



    public static String getFileNameFromAbsoluteFileName(String path) {
        File f = new File(path);
        return f.getName();
    }

    public static String getFileAbsolutePathWithoutExtension(File file) {
        String filePath = file.getAbsolutePath();
        // если в имени файла есть точка и она не является первым символом в названии файла
        if(filePath.lastIndexOf(".") != -1 && filePath.lastIndexOf(".") != 0)
            // то вырезаем все знаки после последней точки в названии файла, то есть ХХХХХ.txt -> txt
            return filePath.substring(0, filePath.lastIndexOf("."));
            // в противном случае возвращаем заглушку, то есть расширение не найдено
        else return "";
    }

    public static byte[] readFile(String fileName) throws ClassNotFoundException {

        File f = new File(fileName + ".class");
        if (!f.isFile()) {
            throw new ClassNotFoundException("Нет такого класса " + fileName);
        }
        InputStream ins = null;

        //С помощью потока считываем файл в массив байт
        try {
            ins = new BufferedInputStream(new FileInputStream(f));
            byte[] b = new byte[(int) f.length()];
            ins.read(b);
            return b;
        }catch(IOException e){
            e.printStackTrace();
        }finally {
            try{
                ins.close();
            }catch(Exception e){
                e.printStackTrace();
            };
        }
        return null;
    }
}
