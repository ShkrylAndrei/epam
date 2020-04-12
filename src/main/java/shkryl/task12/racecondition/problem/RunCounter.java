package shkryl.task12.racecondition.problem;

public class RunCounter implements Runnable {
    @Override
    public void run() {
        for (int i = 0; i < 10; i++) {
            Counter.incrementValue();
            Counter.showValue();
        }
    }
}
