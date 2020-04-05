package shkryl.task12.racecondition;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Main {


    public static void main(String[] args) {
        ExecutorService executorService = Executors.newFixedThreadPool(4);

        executorService.submit(new RunCounter());
        executorService.submit(new RunCounter());
        executorService.submit(new RunCounter());
        executorService.submit(new RunCounter());


        executorService.shutdown();

    }


}
