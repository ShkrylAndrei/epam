package shkryl.task7.part2;

public class Main {
    public static void main(String[] args) {
        //Написать код, который будет выбрасывать java.lang.StackOverflowError
        recursion(0);
    }

    //Метод который будет вызываться рекурсивно
    public static void recursion(long par){
        System.out.println("Передали параметр "+par);
        par++;
        recursion(par);
    }
}
