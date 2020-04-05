package shkryl.task12.deadlock;

import static java.lang.Thread.sleep;

public class WorkThread1 implements Runnable {
    @Override
    public void run() {
        synchronized (Main.value1){
            System.out.println("Thread 1: Holding value1");
            Main.value1++;

            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("Thread 1: Waiting for value2...");
            synchronized (Main.value2){
                Main.value2++;
                System.out.println("Thread 1: Holding value1 and value2...");

            }
        }
    }
}
