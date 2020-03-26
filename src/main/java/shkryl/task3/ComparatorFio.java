package shkryl.task3;

import java.util.Comparator;

/**
 * Компаратор для сортировки Human на основе Fio в алфавитном порядке
 */
public class ComparatorFio implements Comparator<Human> {

    @Override
    public int compare(Human o1, Human o2) {
        if (o1.equals(o2)) return 0;
        else return o1.getFio().compareTo(o2.getFio());

    }
}
