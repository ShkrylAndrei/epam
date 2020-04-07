package shkryl.task12.decisionracecondition;

public class Counter {
    private static int value=0;

    public synchronized static void incrementValue(){
        int val = value;
        try {
            Thread.sleep(100);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        val = val + 1;
        value = val;
    }
    public static void showValue(){
        System.out.println(value);
    }
}
