package shkryl.task12.chat.chat;

import shkryl.task12.chat.exception.NoFreeSpaceException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import shkryl.task12.chat.executors.ReaderExecutor;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.ThreadLocalRandom;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class ChatBack {

    private static Logger logger = LoggerFactory.getLogger(ChatBack.class);
    private BlockingQueue<SMS> chatSmsQueue = new LinkedBlockingDeque<>();
    private BlockingQueue<SMS> bufferSmsQueue = new LinkedBlockingDeque<>();
    private final int capacity = 2;
    private Lock lock = new ReentrantLock();
    private Lock lock2 = new ReentrantLock();

    public boolean addSMS(String text) {
        boolean result = false;
        logger.info("Writer start");
        lock.lock();
        logger.info("Writer lock");
        if (chatSmsQueue.size() < capacity) {
            logger.info("writer if");
            logger.info("Записано: {}",text);
            chatSmsQueue.add(new SMS(text));
            logger.info("writer if end");
            result = true;
        } else {
            logger.info("writer else");
            bufferSmsQueue.add(new SMS(text));
            logger.info("Записано в буфер: {}",text);
        }

        lock.unlock();
        logger.info("writer finish");
        if (result) {
            return result;
        }

        throw new NoFreeSpaceException("В чате нет свободного места");
    }

    public String readSms() throws InterruptedException {
        lock2.lock();
        logger.info("Ридер ждет смс");
        SMS sms = chatSmsQueue.take();
        logger.info("Ридер достал смс: {}",sms.getText());

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
            sms.setText(sms.getText() + " modified");
        }
        lock.unlock();
    }
}
