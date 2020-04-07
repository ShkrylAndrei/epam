package shkryl.task12.deadlock.problem;

public class Service {
    public static void makeDeadLock(){
        Abonent abonent1 = new Abonent("Ivan");
        Abonent abonent2 = new Abonent("Petr");
        Runnable runnable1 = ()->{
            abonent1.dialup(abonent2);
        };

        Runnable runnable2 = ()->{
            abonent2.dialup(abonent1);
        };

        new Thread(runnable1).start();
        new Thread(runnable2).start();
    }
}
