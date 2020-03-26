package shkryl.task9.part3.iterator.database;

import shkryl.task9.part3.iterator.myiterator.MyIterator;

public class DatabaseIterator implements MyIterator<String> {

    private Database dataBase;
    private int index;


    public DatabaseIterator(Database dataBase) {
        this.dataBase = dataBase;
    }

    @Override
    public boolean hasNext() {
        return index < dataBase.size();
    }

    @Override
    public String getNext() {
        if (this.hasNext()) {
            return dataBase.getContent(index++);
        }
        return null;
    }


}
