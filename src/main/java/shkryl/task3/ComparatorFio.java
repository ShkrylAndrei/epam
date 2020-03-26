package shkryl.task3;

import java.util.Comparator;

/**
 * Компаратор для сортировки Human на основе Fio
 */
public class ComparatorFio implements Comparator<Human> {
    /**
     * Сравнивает два объекта класса Human
     *
     * @param o1 объект Human
     * @param o2 объект Human
     * @return возвращает 0, если ФИО объектов равен(лексиграфически), число больше нуля, если ФИО o1 больше o2, иначе - число меньше нуля
     */
    @Override
    public int compare(Human o1, Human o2) {
        if (o1.equals(o2)) return 0;
        else return o1.getFio().compareTo(o2.getFio());

    }
}
