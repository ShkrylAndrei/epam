package shkryl.task12.chat.service;

import shkryl.task12.chat.Chat;
import shkryl.task12.chat.exception.NoExistingSmsException;

import java.util.Random;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.atomic.AtomicInteger;

public class Service {
    private Chat chat;
    private AtomicInteger atomicInteger;
    public Service() {
        chat = new Chat();
        atomicInteger = new AtomicInteger(0);
    }

    public void startChat(){
        Callable writer = ()->{
            int i = 0;
            while (i == 0) {
                int time = new Random().nextInt(4000) + 1000;
                Thread.sleep(time);
                String text = String.valueOf(atomicInteger.incrementAndGet());
                System.out.println("Отправлено: " + text);
                chat.addSms(text);
            }
            return "";
        };

        Callable reader = ()->{
            int i = 0;
            while (i == 0) {
                int time = new Random().nextInt(4000) + 2000;
                Thread.sleep(time);
                try {
                    String text = chat.readSms();
                    System.out.println("Сичтано: " + text);
                }catch(NoExistingSmsException e){
                    System.out.println(e);
                }
            }
            return "";
        };

        Callable updater = ()->{
            int i = 0;
            while (i == 0) {

                int time = new Random().nextInt(4000) + 2000;
                Thread.sleep(time);
                chat.updateSms();
            }
            return "";
        };



        int writerCount = 2;
        int readerCount = 2;
        int updaterCount = 1;

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
