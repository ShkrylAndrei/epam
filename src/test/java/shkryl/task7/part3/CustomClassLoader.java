package shkryl.task7.part3;

import shkryl.task7.util.Utils;

public class CustomClassLoader extends ClassLoader {
    //Переопределяем метод findClass, которому надо передать путь к файлу с расширением .class
    @Override
    protected Class<?> findClass(String absoluteFileName) throws ClassNotFoundException {
        //Проверяем, существует ли такой файл
        byte[] bytes = null;
        bytes = Utils.readFile(absoluteFileName);
        if(bytes!=null) {

            Class c = defineClass(Utils.getFileNameFromAbsoluteFileName(absoluteFileName), bytes, 0, bytes.length);
            return c;
        }

        throw new ClassNotFoundException("Проблемы с байт кодом");
    }


}