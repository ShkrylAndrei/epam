package shkryl.task12.deadlock.problem;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import shkryl.task12.racecondition.problem.Counter;

public class Abonent {
    private String name;

    private static Logger logger = LoggerFactory.getLogger(Abonent.class);

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
        logger.info("Набираем номер {}",abonent.getName());
        abonent.switchMusicOn();
    }

    public synchronized void switchMusicOn(){
        logger.info("Включаем музыку на телефоне {}",getName());
    }
}
