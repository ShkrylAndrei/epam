package shkryl.task12.chat.chat;


import shkryl.task12.chat.exception.NoExistingSmsException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.ThreadLocalRandom;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Chat {

    private BlockingQueue<SMS> chatSmsQueue = new LinkedBlockingDeque<>();
    private BlockingQueue<SMS> bufferSmsQueue = new LinkedBlockingDeque<>();
    private final int capacity = 25;
    private static Logger logger = LoggerFactory.getLogger(ChatBack.class);
    private Lock lock = new ReentrantLock();

    public String addSMS(String text) {
//        try {
//            lock.lock();
        if (chatSmsQueue.size() < capacity) {
//            System.out.println("Запись: Writer "+Thread.currentThread().getName()+": Записано: "+text);
            chatSmsQueue.add(new SMS(text));
        } else {
            bufferSmsQueue.add(new SMS(text));
//            System.out.println("Запись: Writer "+Thread.currentThread().getName()+": Записано в буфер: "+text);
            //logger.info(text + " добавлено в буфер");
        }
//        }finally {
//            lock.unlock();
//        }
        return text;
    }

    public String readSms() throws InterruptedException {
//        try {
//            lock.lock();
        SMS sms = chatSmsQueue.take();

        //System.out.println("Ридер "+Thread.currentThread().getName()+" достал смс: "+sms.getText());
        if (!bufferSmsQueue.isEmpty()) {
            chatSmsQueue.add(bufferSmsQueue.take());
        }
        return sms.getText();
//        }finally {
//            lock.unlock();
//        }
    }

    public String updateSms() {
//        try {
//            lock.lock();
        if (!chatSmsQueue.isEmpty()) {
            int randomIndex = ThreadLocalRandom.current().nextInt(chatSmsQueue.size());
            SMS sms = (SMS) chatSmsQueue.toArray()[randomIndex];
            //logger.info("Изменено: {}", sms.getText());
//              System.out.println("Изменение: Updater : "+sms.getText()+ " modified");
            sms.setText(sms.getText() + " modified");
            return sms.getText();
        }
//        }finally {
//            lock.unlock();
//        }

        throw new NoExistingSmsException("Изменение сообщения не удалость, список сообщений пуст");
    }
}
