package shkryl.task11;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        List<String> uuidsString = Service.generateUIID();
        Service.uuidsStringSaveToFile("uuid.txt", uuidsString);
        long count = Service.countUUIDMoreThan100("uuid.txt");
        Service.calculationEndOfTheWorld(count);
        Service.createSausages();
    }
}
