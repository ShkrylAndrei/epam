package shkryl.task9.part3.iterator.author;

import shkryl.task9.part3.iterator.myiterator.MyIterator;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class AuthorIterator implements MyIterator<Author> {
    private List<Author> authorsList;
    private int currentIndex;

    public AuthorIterator(List<Author> authors) {
        authorsList = authors;
    }

    @Override
    public boolean hasNext() {
        return currentIndex < authorsList.size();
    }

    @Override
    public Author getNext() {
        return authorsList.get(currentIndex++);
    }
}
