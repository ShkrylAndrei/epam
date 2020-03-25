package shkryl.task9.part3.iterator;

/**
 *
 * @author Admin
 */
public class Main {
    public static void main(String[] args) {
        Database database = new Database();
        IIterator iterator = database.getIterator();
        while (iterator.hasNext()){
        //for (IIterator iterator = database.getIterator();iterator.hasNext();){
            String item = String.valueOf(iterator.next());
            System.out.println("Элемент базы данных "+item);
            
        }
        
    }
}
