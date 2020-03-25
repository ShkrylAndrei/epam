package shkryl.task9.part3.iterator.author;

import shkryl.task9.part3.iterator.myiterator.MyIterable;
import shkryl.task9.part3.iterator.myiterator.MyIterator;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Library implements MyIterable<Author> {
    List<Author> authors;

    public Library() {
        authors = new ArrayList<>();
        authors.addAll(Arrays.asList(new Author("Иванов"), new Author("Петров"),
                new Author("Семенов"), new Author("Игорев"), new Author("Бобров")));
    }


    @Override
    public MyIterator<Author> getIterator() {
        return new AuthorIterator(authors);
    }
}
