package shkryl.task12.chat.service;

import shkryl.task12.chat.chat.Chat;
import shkryl.task12.chat.task.Task;
import shkryl.task12.chat.task.ReaderTask;
import shkryl.task12.chat.task.UpdaterTask;
import shkryl.task12.chat.task.WriterTask;
import shkryl.task12.chat.executors.ReaderTaskExecutor;
import shkryl.task12.chat.executors.TaskExecutor;
import shkryl.task12.chat.executors.UpdaterTaskExecutor;
import shkryl.task12.chat.executors.WriterTaskExecutor;
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
    private static final int UPDATER_COUNT = 1;

    private static Logger logger = LoggerFactory.getLogger(Service.class);

    public Service() {
        chat = new Chat();
        atomicInteger = new AtomicInteger(0);
    }

    public void startChat() {
        Task writerTask = new WriterTask(chat, atomicInteger);
        Task readerTask = new ReaderTask(chat);
        Task updaterTask = new UpdaterTask(chat);

        TaskExecutor writerTaskExecutor = new WriterTaskExecutor(writerTask, 20, 60);
        TaskExecutor readerTaskExecutor = new ReaderTaskExecutor(readerTask, 30, 50);
        TaskExecutor updaterTaskExecutor = new UpdaterTaskExecutor(updaterTask, 40);


        ExecutorService executorService = Executors.newFixedThreadPool(8);

        //Передаем задачи в executerService
        for (int i = 0; i < WRITER_COUNT; i++) {
            executorService.execute(writerTaskExecutor);
        }

        for (int i = 0; i < READER_COUNT; i++) {
            executorService.execute(readerTaskExecutor);
        }
        for (int i = 0; i < UPDATER_COUNT; i++) {
            executorService.execute(updaterTaskExecutor);
        }

        executorService.shutdown();


    }
}
