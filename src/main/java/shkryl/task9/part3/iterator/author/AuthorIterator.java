package shkryl.task9.part3.iterator.author;

import shkryl.task9.part3.iterator.myiterator.MyIterator;

public class AuthorIterator implements MyIterator<Author> {
    private Author[] authorsArr;
    private int currentIndex;
    private int size;

    public AuthorIterator(Library library)
    {
        authorsArr = library.getAuthorArr();
        this.size = library.size();
    }

    @Override
    public boolean hasNext() {
        return currentIndex < size;
    }

    @Override
    public Author getNext() {
        return authorsArr[currentIndex++];
    }
}
