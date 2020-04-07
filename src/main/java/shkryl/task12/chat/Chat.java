package shkryl.task12.chat;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import shkryl.task12.chat.exception.NoExistingSmsException;
import shkryl.task12.chat.exception.NoFreeSpaceException;
import shkryl.task12.deadlock.problem.Abonent;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

public class Chat {
    private List<String> chatSmsList = Collections.synchronizedList(new ArrayList<>());
    private List<String> smsBuffer = Collections.synchronizedList(new ArrayList<>());
    private final int capacity = 25;
    private static Logger logger = LoggerFactory.getLogger(Chat.class);

    public synchronized boolean addSms(String text) {
        if (chatSmsList.size() < capacity) {
            chatSmsList.add(text);
            return true;
        } else {
            smsBuffer.add(text);
            logger.info(text + " добавлено в буфер");
            throw new NoFreeSpaceException("В чате нет свободного места");
        }
    }

    public synchronized String readSms() {
        if (chatSmsList.size() > 0) {
            String sms = chatSmsList.remove(0);
            if (smsBuffer.size() != 0) {
                chatSmsList.add(smsBuffer.remove(0));
            }
            return sms;
        }
        throw new NoExistingSmsException("Нет сообщений для считывания");
    }

    public synchronized void updateSms() {
        if (chatSmsList.size() > 0) {
            int randomIndex = new Random().nextInt(chatSmsList.size());
            String text = chatSmsList.get(randomIndex);
            logger.info("Изменено: {}", text);
            chatSmsList.set(randomIndex, text + " modified");
        }
    }
}
