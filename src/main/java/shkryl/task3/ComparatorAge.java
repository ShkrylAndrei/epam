package shkryl.task3;

import java.util.Comparator;

public class ComparatorAge implements Comparator<Human> {
    @Override
    public int compare(Human o1, Human o2) {
        if (o1.getAge()-o2.getAge()==0) return 0;
        else return o1.getAge()-o2.getAge();
    }

}
