package shkryl.task9.part3.iterator;

/**
 *
 * @author Admin
 */
public class Database implements IContainer{
    private String content[] = {"one","two","three","four","five"};
    
    
    @Override
    public IIterator getIterator() {
        return new DatabaseIterator();
    }
    
    private class DatabaseIterator implements IIterator{
        private int index;
        
        @Override
        public boolean hasNext() {
            return index<content.length;
        }

        @Override
        public Object next() {
            if (this.hasNext()){
                return content[index++];
            }
            return null;
        }
        
    }
}
