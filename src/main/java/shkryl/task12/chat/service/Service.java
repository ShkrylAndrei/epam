package shkryl.task12.chat.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import shkryl.task12.chat.Chat;
import shkryl.task12.chat.exception.NoExistingSmsException;
import shkryl.task12.chat.exception.NoFreeSpaceException;

import java.util.Random;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.atomic.AtomicInteger;

public class Service {
    private Chat chat;
    private AtomicInteger atomicInteger;
    //Количество Writer
    private static final int writerCount = 3;
    //Количество Reader
    private static final int readerCount = 3;
    //Количество Updater
    private static final int updaterCount = 1;

    private static Logger logger = LoggerFactory.getLogger(Service.class);

    public Service() {
        chat = new Chat();
        atomicInteger = new AtomicInteger(0);
    }

    public void startChat(){
        Callable writer = ()->{
            int i = 0;
            while (i == 0) {
                int time = new Random().nextInt(40000) + 20000;
                Thread.sleep(time);
                String text = "сообщение №"+String.valueOf(atomicInteger.incrementAndGet());
                try {
                    chat.addSms(text);
                    logger.info("Добавлено: " + text);
                }catch(NoFreeSpaceException e){
                    logger.error("В чате нет свободного места для добавления сообщений");
                }
            }
            return "";
        };

        Callable reader = ()->{
            int i = 0;
            while (i == 0) {
                int time = new Random().nextInt(20000) + 30000;
                Thread.sleep(time);
                try {
                    String text = chat.readSms();
                    logger.info("Считано: " + text);
                }catch(NoExistingSmsException e){
                    logger.error("Нет сообщений для считывания");
                }
            }
            return "";
        };

        Callable updater = ()->{
            int i = 0;
            while (i == 0) {
                int time = 40000;
                Thread.sleep(time);
                chat.updateSms();
            }
            return "";
        };

        //Запускаем потоки
        ExecutorService executorService = Executors.newFixedThreadPool(writerCount+readerCount+updaterCount);

        for (int i = 0; i < writerCount; i++) {
            executorService.submit(writer);
        }
        for (int i = 0; i < readerCount; i++) {
            executorService.submit(reader);
        }

        for (int i = 0; i < updaterCount; i++) {
            executorService.submit(updater);
        }

        executorService.shutdown();
    }
}
