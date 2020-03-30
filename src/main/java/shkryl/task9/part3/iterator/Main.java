package shkryl.task9.part3.iterator;

import shkryl.task9.part3.iterator.author.Author;
import shkryl.task9.part3.iterator.author.Library;
import shkryl.task9.part3.iterator.database.Database;
import shkryl.task9.part3.iterator.myiterator.MyIterator;

public class Main {
    public static void main(String[] args) {
        Database database = new Database();
        MyIterator<String> iterator = database.getIterator();
        while (iterator.hasNext()) {
            String item = iterator.getNext();
            System.out.println("Элемент базы данных " + item);

        }
        System.out.println("------------------------");

        //Перебор книг в библиотеке по авторам
        Library library = new Library();
        MyIterator<Author> iter1 = library.getIterator();
        while (iter1.hasNext()) {
            System.out.println(iter1.getNext());
        }

    }
}
