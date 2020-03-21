package shkryl.task7.part1;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        //Написать код, который будет выбрасывать java.lang.OutOfMemoryError, при ограничении heap 20мб (-Xmx20m)
        Integer[] arrayOfInt;
        List<Integer[]> arrayList = new ArrayList<>();
        int count = 0;
        while (true) {
            //в принципе одной этой строчки достаточно чтобы вылезло OutOfMemory
            //сразу создаем огроменный массив
            arrayOfInt = new Integer[Integer.MAX_VALUE];
            //конец убивающей строчки
            arrayList.add(arrayOfInt);
            System.out.println("Добавлен объект "+count);
            count++;
        }
    }
}

