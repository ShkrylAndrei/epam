package shkryl.task12.chat.executors;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import shkryl.task12.chat.task.Task;

import java.util.Random;
import java.util.concurrent.*;

public class UpdaterExecutor extends ChatExecutor {

    private static Logger logger = LoggerFactory.getLogger(UpdaterExecutor.class);

    public UpdaterExecutor(Task task, int period) {
        super(task, period);
    }

    @Override
    public void run() {
        Random rnd = new Random();
        while (true) {
            FutureTask<String> futureTask = new FutureTask<>(task);
            logger.info("Time: Updater "+Thread.currentThread().getName()+": time=" + period);
            try {
                Thread.sleep(TimeUnit.SECONDS.toMillis(period));
            } catch (InterruptedException e) {
                logger.error(e.getMessage());
            }
            executorService.execute(futureTask);
            try {
                String modifiedSmsText = futureTask.get();
                logger.info("Изменение Updater : {}",modifiedSmsText);
            } catch (Exception e) {
                logger.error(e.getMessage());
            }
        }
    }
}
