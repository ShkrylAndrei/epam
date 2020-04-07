package shkryl.task12.racecondition;

public class Counter {
    private static int value=0;

    public static void incrementValue(){
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
