package shkryl.task2;

public class Main {
    public static void main(String[] args) {
        ServiceWorkWithDB rDB=new ServiceWorkWithDB();
        HumanDto humanDto=rDB.getOneEntity();
        System.out.println("Выводим одну сущность");
        rDB.saveOneEntity(humanDto);

        System.out.println("--------------------");
        System.out.println("Выводим все сущности");

        rDB.saveAllEntity(rDB.getAllEntity());
    }


}
