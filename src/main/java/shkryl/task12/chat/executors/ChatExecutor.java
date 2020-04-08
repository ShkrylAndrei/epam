package shkryl.task12.chat.executors;

import shkryl.task12.chat.task.Task;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public abstract class ChatExecutor implements Runnable {
    protected Task task;
    protected ExecutorService executorService;
    protected int secFrom;
    protected int secTo;
    protected int period;

    public ChatExecutor(Task task, int secFrom, int secTo) {
        this.executorService = Executors.newSingleThreadExecutor();
        this.task = task;
        this.secFrom = secFrom;
        this.secTo = secTo;
    }

    public ChatExecutor(Task task, int period) {
        this.executorService = Executors.newSingleThreadExecutor();
        this.task = task;
        this.period = period;
    }



}
