package shkryl.task9.part3.iterator.database;

import shkryl.task9.part3.iterator.myiterator.MyIterable;
import shkryl.task9.part3.iterator.myiterator.MyIterator;

public class Database implements MyIterable<String> {
    private String content[] = {"one", "two", "three", "four", "five"};

    @Override
    public MyIterator<String> getIterator() {
        return new DatabaseIterator(this);
    }

    public int size() {
        return content.length;
    }

    public String getContent(int i) {
        return content[i];
    }
}
