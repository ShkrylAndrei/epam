package shkryl.task12.chat.executors;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import shkryl.task12.chat.task.Task;

import java.util.concurrent.*;

public abstract class TaskExecutor implements Runnable {
    protected Task task;
    protected ExecutorService executorService;
    protected int secFrom;
    protected int secTo;
    protected int period;

    private static Logger logger = LoggerFactory.getLogger(TaskExecutor.class);

    public TaskExecutor(Task task, int secFrom, int secTo) {
        this.executorService = Executors.newSingleThreadExecutor();
        this.task = task;
        this.secFrom = secFrom;
        this.secTo = secTo;
    }

    public TaskExecutor(Task task, int period) {
        this.executorService = Executors.newSingleThreadExecutor();
        this.task = task;
        this.period = period;
    }

    public String executeTask(int time) throws ExecutionException, InterruptedException {
        FutureTask<String> futureTask = new FutureTask<>(task);
        logger.info("Time "+getClass().getSimpleName()+": "+Thread.currentThread().getName()+": time=" + time);
        try {
            Thread.sleep(TimeUnit.SECONDS.toMillis(time));
        } catch (InterruptedException e) {
            logger.error(e.getMessage());
        }
        executorService.execute(futureTask);
        return futureTask.get();
    }
}
