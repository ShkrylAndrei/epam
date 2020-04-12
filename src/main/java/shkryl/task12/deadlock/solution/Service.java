package shkryl.task12.deadlock.solution;

public class Service {
    /**
     * Эмулирует ситуацию deadlock
     */
    public static void makeDeadLock() {
        CallStatus callStatus = new CallStatus();
        Abonent abonent1 = new Abonent("Ivan", callStatus);
        Abonent abonent2 = new Abonent("Petr", callStatus);
        Runnable runnable1 = () -> {
            abonent1.dialup(abonent2);
        };

        Runnable runnable2 = () -> {
            abonent2.dialup(abonent1);
        };

        new Thread(runnable1).start();
        new Thread(runnable2).start();
    }
}
