package shkryl.task3;

import java.util.Comparator;

public class ComparatorAddress implements Comparator<Human> {
    @Override
    public int compare(Human o1, Human o2) {
        return o1.getAddress().compareTo(o2.getAddress());
    }
}
