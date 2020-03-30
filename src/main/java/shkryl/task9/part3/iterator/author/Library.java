package shkryl.task9.part3.iterator.author;

import shkryl.task9.part3.iterator.myiterator.MyIterable;
import shkryl.task9.part3.iterator.myiterator.MyIterator;

public class Library implements MyIterable<Author> {
    private Author[] authors;
    private int currentIndex;

    public Library() {
        authors = new Author[100];
        add(new Author("Иванов"));
        add(new Author("Петров"));
        add(new Author("Семенов"));
        add(new Author("Игорев"));
        add(new Author("Бобров"));
    }

    private void add(Author author) {
        authors[currentIndex++] = author;
    }

    public int size(){
        return currentIndex;
    }

    public Author[] getAuthorArr(){
        return authors;
    }

    @Override
    public MyIterator<Author> getIterator() {
        return new AuthorIterator(this);
    }
}
