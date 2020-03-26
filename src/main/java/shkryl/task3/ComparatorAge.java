package shkryl.task3;

import java.util.Comparator;

/**
 * Компаратор для сортировки Human на основе Age в порядке возрастания
 */
public class ComparatorAge implements Comparator<Human> {

    @Override
    public int compare(Human o1, Human o2) {
        return o1.getAge() - o2.getAge();
    }

}
