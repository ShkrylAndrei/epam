package shkryl.task12.chat.service;

import shkryl.task12.chat.chat.Chat;
import shkryl.task12.chat.task.Task;
import shkryl.task12.chat.task.ReaderTask;
import shkryl.task12.chat.task.UpdaterTask;
import shkryl.task12.chat.task.WriterTask;
import shkryl.task12.chat.executors.ReaderExecutor;
import shkryl.task12.chat.executors.ChatExecutor;
import shkryl.task12.chat.executors.UpdaterExecutor;
import shkryl.task12.chat.executors.WriterExecutor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


import java.util.concurrent.*;
import java.util.concurrent.atomic.AtomicInteger;

public class Service {
    private Chat chat;
    private AtomicInteger atomicInteger;
    //Количество Writer
    private static final int WRITER_COUNT = 3;
    //Количество Reader
    private static final int READER_COUNT = 3;
    //Количество Updater
    private static final int UPDATER_COUNT = 3;

    private static Logger logger = LoggerFactory.getLogger(Service.class);

    public Service() {
        chat = new Chat();
        atomicInteger = new AtomicInteger(0);
    }

    public void startChat() {
        Task writerTask = new WriterTask(chat, atomicInteger);
        Task readerTask = new ReaderTask(chat);
        Task updaterTask = new UpdaterTask(chat);

        ChatExecutor writerExecutor = new WriterExecutor(writerTask, 20, 60);
        ChatExecutor readerExecutor = new ReaderExecutor(readerTask, 30, 50);
        ChatExecutor updaterExecutor = new UpdaterExecutor(updaterTask, 40);

        ExecutorService executorServiceWriter = Executors.newFixedThreadPool(2);
        ExecutorService executorServiceReader = Executors.newFixedThreadPool(2);
        ExecutorService executorServiceUpdater = Executors.newFixedThreadPool(2);


        for (int i = 0; i < WRITER_COUNT; i++) {
            executorServiceWriter.execute(writerExecutor);
        }

        for (int i = 0; i < READER_COUNT; i++) {
            executorServiceReader.execute(readerExecutor);
        }
        for (int i = 0; i < UPDATER_COUNT; i++) {
            executorServiceUpdater.execute(updaterExecutor);
        }

        executorServiceWriter.shutdown();
        executorServiceReader.shutdown();
        executorServiceUpdater.shutdown();


    }
}
