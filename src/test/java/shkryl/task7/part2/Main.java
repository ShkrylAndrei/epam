package shkryl.task7.part2;

public class Main {
    public static void main(String[] args) {
        //Написать код, который будет выбрасывать java.lang.StackOverflowError
        Recursion(0);
    }

    //Метод который будет вызываться рекурсивно
    public static void Recursion(long par){
        System.out.println("Передали параметр "+par);
        par++;
        Recursion(par);

    }
}
