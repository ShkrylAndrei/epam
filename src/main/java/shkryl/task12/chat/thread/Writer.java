package shkryl.task12.chat.thread;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import shkryl.task12.chat.Chat;

public class Writer implements Runnable {
    private int timer;
    private Chat chat;
    private String text;

    private static Logger logger = LoggerFactory.getLogger(Writer.class);

    public Writer(int timer,Chat chat,String text) {
        this.timer = timer;
        this.chat = chat;
        this.text = text;
    }

    @Override
    public void run() {
        chat.addOneSms(text);
        System.out.println("Сообщение "+text+" добавлено в общий чат");
        logger.info("Сообщение {} добавлено в общий чат",text);
    }
}
