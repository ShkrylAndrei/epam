package shkryl.task12.chat.executors;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import shkryl.task12.chat.task.Task;

import java.util.Random;

public class WriterTaskExecutor extends TaskExecutor {

    private static Logger logger = LoggerFactory.getLogger(WriterTaskExecutor.class);

    public WriterTaskExecutor(Task task, int secFrom, int secTo) {
        super(task, secFrom, secTo);
    }

    @Override
    public void run() {
        Random rnd = new Random();
        while (true) {
            int time = rnd.nextInt(secTo - secFrom) + secFrom;
            try {
                String writedSmsText = executeTask(time);
                logger.info("Запись Writer :" + Thread.currentThread().getName() + ": Записано: " + writedSmsText);
            } catch (Exception e) {
                logger.error(e.getMessage());
            }
        }
    }
}
