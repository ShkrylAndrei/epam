package shkryl.task12.chat.executors;

import shkryl.task12.chat.task.Task;

import java.util.Random;
import java.util.concurrent.*;

public class WriterExecutor extends ChatExecutor {

    public WriterExecutor(Task task, int secFrom, int secTo) {
        super(task, secFrom, secTo);
    }

    @Override
    public void run() {
        Random rnd = new Random();
        while(true){
            FutureTask<String> futureTask = new FutureTask<>(task);
            int time = rnd.nextInt(secTo-secFrom) + secFrom;
            System.out.println("Time: Writer "+Thread.currentThread().getName()+": time=" + time);
            try {
                Thread.sleep(TimeUnit.SECONDS.toMillis(time));
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            executorService.execute(futureTask);
            try {
                String writedSmsText = futureTask.get();
                System.out.println("Запись: Writer "+Thread.currentThread().getName()+": Записано: "+writedSmsText);
            } catch (Exception e) {
                System.out.println(e);
            }
        }

    }
}
