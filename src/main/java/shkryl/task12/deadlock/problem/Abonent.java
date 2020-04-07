package shkryl.task12.deadlock.problem;

public class Abonent {
    private String name;

    public Abonent(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public synchronized void dialup(Abonent abonent){
        try {
            Thread.sleep(100);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("Набираем номер "+abonent.getName());
        abonent.switchMusicOn();
    }

    public synchronized void switchMusicOn(){
        System.out.println("Включаем музыку на телефоне "+getName());
    }
}
