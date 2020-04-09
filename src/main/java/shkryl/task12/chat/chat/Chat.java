package shkryl.task12.chat.chat;


import shkryl.task12.chat.exception.NoExistingSmsException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Chat {

    private List<SMS> chatSmsList = Collections.synchronizedList(new ArrayList());
    private List<SMS> bufferSmsList = Collections.synchronizedList(new ArrayList());
    private final int capacity = 25;
    private static Logger logger = LoggerFactory.getLogger(Chat.class);
    private Lock lock = new ReentrantLock();

    public String addSMS(String text) {
        lock.lock();
        try {
            if (chatSmsList.size() < capacity) {
                chatSmsList.add(new SMS(text));
                logger.info("Добавлено сообщение в чат {}", text);
            } else {
                bufferSmsList.add(new SMS(text));
                logger.info("Добавлено сообщение в буфер {}", text);
            }
        } finally {
            lock.unlock();
        }
        return text;
    }

    public String readSms() throws InterruptedException {
        lock.lock();
        try {
            if (!chatSmsList.isEmpty()) {
                SMS sms = chatSmsList.remove(0);
                if (!bufferSmsList.isEmpty()) {
                    chatSmsList.add(bufferSmsList.remove(0));
                }
                logger.info("Размер чата: {}", chatSmsList.size());
                logger.info("Размер буфера: {}", bufferSmsList.size());
                logger.info("Прочитанно сообщение {}",sms.getText());
                return sms.getText();
            }
        } finally {
            lock.unlock();
        }
        throw new NoExistingSmsException("Не удалось считать смс, чат пуст");
    }

    public String updateSms() {
        lock.lock();
        try {

            if (!chatSmsList.isEmpty()) {
                int randomIndex = ThreadLocalRandom.current().nextInt(chatSmsList.size());
                SMS sms = chatSmsList.get(randomIndex);
                sms.setText(sms.getText() + " modified");
                logger.info("Измененно сообщение {}",sms.getText());
                return sms.getText();
            }
        } finally {
            lock.unlock();
        }
        throw new NoExistingSmsException("Изменение сообщения не удалость, список сообщений пуст");

    }
}
