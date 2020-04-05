package shkryl.task12.deadlock;

public class Main {
    public static Integer value1 = 0;
    public static Integer value2 = 0;

    public static void main(String[] args) {
        WorkThread1 workThread1 = new WorkThread1();
        WorkThread2 workThread2 = new WorkThread2();

        System.out.println("Начало выполнения потоков");
        workThread1.run();
        workThread2.run();
        System.out.println("Потоки успешно завершили свою работу");

    }
}
