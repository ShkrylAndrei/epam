package shkryl.task12.chat.executors;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import shkryl.task12.chat.task.Task;

import java.util.Random;
import java.util.concurrent.*;

public class WriterExecutor extends ChatExecutor {

    private static Logger logger = LoggerFactory.getLogger(WriterExecutor.class);

    public WriterExecutor(Task task, int secFrom, int secTo) {
        super(task, secFrom, secTo);
    }

    @Override
    public void run() {
        Random rnd = new Random();
        while(true){
            FutureTask<String> futureTask = new FutureTask<>(task);
            int time = rnd.nextInt(secTo-secFrom) + secFrom;
            logger.info("Time: Writer "+Thread.currentThread().getName()+": time=" + time);
            try {
                Thread.sleep(TimeUnit.SECONDS.toMillis(time));
            } catch (InterruptedException e) {
                logger.error(e.getMessage());
            }
            executorService.execute(futureTask);
            try {
                String writedSmsText = futureTask.get();
                logger.info("Запись Writer :"+Thread.currentThread().getName()+": Записано: "+writedSmsText);
            } catch (Exception e) {
                logger.error(e.getMessage());
            }
        }

    }
}
