package shkryl.task3;

import java.util.Comparator;

/**
 * Компаратор для сортировки Human на основе Age
 */
public class ComparatorAge implements Comparator<Human> {
    /**
     * Сравнивает два объекта класса Human
     *
     * @param o1 объект Human
     * @param o2 объект Human
     * @return возвращает 0, если возраст объектов равен, число больше нуля, если возраст o1 больше o2, иначе - число меньше нуля
     */
    @Override
    public int compare(Human o1, Human o2) {
        return o1.getAge() - o2.getAge();
    }

}
