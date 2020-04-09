package shkryl.task12.chat.executors;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import shkryl.task12.chat.task.Task;

import java.util.Random;


public class UpdaterTaskExecutor extends TaskExecutor {

    private static Logger logger = LoggerFactory.getLogger(UpdaterTaskExecutor.class);

    public UpdaterTaskExecutor(Task task, int period) {
        super(task, period);
    }

    @Override
    public void run() {
        Random rnd = new Random();
        while (true) {
            try {
                String modifiedSmsText = executeTask(period);
                logger.info("Изменение Updater : {}", modifiedSmsText);
            } catch (Exception e) {
                logger.error(e.getMessage());
            }
        }
    }
}
