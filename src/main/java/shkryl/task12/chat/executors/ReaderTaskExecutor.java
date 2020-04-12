package shkryl.task12.chat.executors;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import shkryl.task12.chat.task.Task;

import java.util.Random;

public class ReaderTaskExecutor extends TaskExecutor {

    private static Logger logger = LoggerFactory.getLogger(ReaderTaskExecutor.class);

    public ReaderTaskExecutor(Task task, int secFrom, int secTo) {
        super(task, secFrom, secTo);
    }

    @Override
    public void run() {
        Random rnd = new Random();
        while (true) {
            int time = rnd.nextInt(secTo - secFrom) + secFrom;
            try {
                String smsText = executeTask(time);
                logger.info("Чтение: Ридер " + Thread.currentThread().getName() + " достал смс: " + smsText);
            } catch (Exception e) {
                logger.error(e.getMessage());
            }
        }
    }
}
