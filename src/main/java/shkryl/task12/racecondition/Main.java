package shkryl.task12.racecondition;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Main {


    public static void main(String[] args) {
        Thread thread1 = new Thread(new RunCounter());
        Thread thread2 = new Thread(new RunCounter());
        thread1.start();
        thread2.start();

    }


}
