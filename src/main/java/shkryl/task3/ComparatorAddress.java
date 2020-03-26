package shkryl.task3;

import java.util.Comparator;

/**
 * Компаратор для сортировки Human на основе Address
 */
public class ComparatorAddress implements Comparator<Human> {
    /**
     * Сравнивает два объекта класса Human
     *
     * @param o1 объект Human
     * @param o2 объект Human
     * @return возвращает 0, если адреса объектов равны, число больше нуля, если адрес o1 больше o2, иначе - число меньше нуля
     */
    @Override
    public int compare(Human o1, Human o2) {
        return o1.getAddress().compareTo(o2.getAddress());
    }
}
