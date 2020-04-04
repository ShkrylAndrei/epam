package shkryl.task11;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        //Одним стримом сгенерировать коллекцию с 10000 рандомными элементами UUID.
        List<String> uuidsString = Service.generateUIID();
        //Записать в файл
        Service.uuidsStringSaveToFile("uuid.txt", uuidsString);
        //Одним стримом считать этот файл и посчитать количество элементов UUID, в которых сумма цифр > 100
        Service.countUUIDMoreThan100("uuid.txt");
        //Рассчитываем дату конца света
        Service.calculationEndOfTheWorld();
        //Создаем объекты сосиски, данные берем из файла File.txt, предварительно декодировав их
        Service.createSausages();
    }
}
