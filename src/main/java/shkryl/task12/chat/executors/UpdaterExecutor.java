package shkryl.task12.chat.executors;

import shkryl.task12.chat.task.Task;

import java.util.Random;
import java.util.concurrent.*;

public class UpdaterExecutor extends ChatExecutor {


    public UpdaterExecutor(Task task, int period) {
        super(task, period);
    }

    @Override
    public void run() {
        Random rnd = new Random();
        while(true){
            FutureTask<String> futureTask = new FutureTask<>(task);

            try {
                Thread.sleep(TimeUnit.SECONDS.toMillis(period));
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            executorService.execute(futureTask);
            try {
                String modifiedSmsText = futureTask.get();
                System.out.println("Изменение: Updater : "+modifiedSmsText);
            } catch (Exception e) {
                System.out.println(e);
            }
        }
    }
}
