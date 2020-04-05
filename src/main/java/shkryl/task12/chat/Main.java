package shkryl.task12.chat;

import shkryl.task12.chat.thread.Writer;
import shkryl.task12.racecondition.RunCounter;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

public class Main {
    //Количество Writer
    private static final int countWriter = 5;
    //Количество Reader
    private static final int countReader = 5;
    //Количество Updater
    private static final int countUpdater = 3;


    public static void main(String[] args) {
        Chat chat = new Chat();

        ExecutorService executorService = Executors.newFixedThreadPool(10);

        executorService.submit(new Writer(10, chat, "Hello"));

        executorService.shutdown();
//        executorService.submit(new RunCounter());
//        executorService.submit(new RunCounter());
//        executorService.submit(new RunCounter());

//        ReadWriteLock readWriteLock = new ReentrantReadWriteLock();
//        readWriteLock.readLock().lock();
//        readWriteLock.readLock().unlock();
//        readWriteLock.writeLock().lock();
//        readWriteLock.writeLock().unlock();

    }
}
