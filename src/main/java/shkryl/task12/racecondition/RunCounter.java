package shkryl.task12.racecondition;

import static java.lang.Thread.sleep;

public class RunCounter implements Runnable {
    @Override
    public void run() {
        for (int i = 0; i < 10; i++) {
            Counter.value++;
            Counter.showValue();
            try {
                sleep(200);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

    }
}
