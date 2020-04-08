package shkryl.task12.chat.chat;

import shkryl.task12.chat.exception.NoFreeSpaceException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.ThreadLocalRandom;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class ChatBack {

    private BlockingQueue<SMS> chatSmsQueue = new LinkedBlockingDeque<>();
    private BlockingQueue<SMS> bufferSmsQueue = new LinkedBlockingDeque<>();
    private final int capacity = 2;
    private static Logger logger = LoggerFactory.getLogger(ChatBack.class);
    private Lock lock = new ReentrantLock();
    private Lock lock2 = new ReentrantLock();

    public boolean addSMS(String text) {
        boolean result = false;
        System.out.println("Writer start");
        lock.lock();
        System.out.println("Writer lock");
        if (chatSmsQueue.size() < capacity) {
            System.out.println("writer if");
            System.out.println("Записано: "+text);
            chatSmsQueue.add(new SMS(text));
            System.out.println("writer if end");
            result = true;
        } else {
            System.out.println("writer else");
            bufferSmsQueue.add(new SMS(text));
            System.out.println("Записано в буфер: "+text);
            //logger.info(text + " добавлено в буфер");
        }

        lock.unlock();
        System.out.println("writer finish");
        if(result){
            return result;
        }

        throw new NoFreeSpaceException("В чате нет свободного места");
    }

    public String readSms() throws InterruptedException {
        lock2.lock();
        System.out.println("Ридер ждет смс");
        SMS sms = chatSmsQueue.take();
        System.out.println("Ридер достал смс: "+sms.getText());

        if (!bufferSmsQueue.isEmpty()) {
            chatSmsQueue.add(bufferSmsQueue.take());
        }
        lock2.unlock();
        return sms.getText();
    }

    public void updateSms() {
        lock.lock();
        if (!chatSmsQueue.isEmpty()) {
            int randomIndex = ThreadLocalRandom.current().nextInt(chatSmsQueue.size());
            SMS sms = (SMS) chatSmsQueue.toArray()[randomIndex];
            //logger.info("Изменено: {}", sms.getText());
            sms.setText(sms.getText()+ " modified");
        }
        lock.unlock();
    }
}
