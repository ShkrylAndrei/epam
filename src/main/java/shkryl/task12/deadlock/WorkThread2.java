package shkryl.task12.deadlock;

import static java.lang.Thread.sleep;

public class WorkThread2 implements Runnable {
    @Override
    public void run() {
        synchronized (Main.value2){
            System.out.println("Thread 2: Holding value2");
            Main.value2++;

            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("Thread 2: Waiting for value1...");
            synchronized (Main.value1){
                Main.value1++;
                System.out.println("Thread 2: Holding value2 and value1...");

            }
        }
    }
}
