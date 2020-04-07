package shkryl.task12.deadlock.solution;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import shkryl.task12.racecondition.problem.Counter;

/**
 * Телефонный абонент
 */
public class Abonent {
    private String name;

    private CallStatus callStatus;

    private static Logger logger = LoggerFactory.getLogger(Abonent.class);

    public Abonent(String name, CallStatus callStatus) {

        this.name = name;
        this.callStatus = callStatus;
    }

    /**
     * Проверяет, является ли наш абонент инициатором вызова
     * @return возращает true, если является, false - в противном случае
     */
    public boolean isInitiator() {
        return callStatus.getInitiator().equals(this);
    }

    public boolean equals(Object ob) {
        Abonent abonent = (Abonent) ob;
        return abonent.name.equals(name);
    }

    public String getName() {
        return name;
    }

    /**
     * Инициатор набирает собеседника
     * @param abonent собеседник
     */
    public synchronized void dialup(Abonent abonent) {
        logger.info("Набираем номер {}",abonent.getName());
        callStatus.setInitiator(this);
        try {
            Thread.sleep(100);
        } catch (InterruptedException e) {
            logger.error(e.getMessage());
        }
        //Если собеседник не является тем, кто звонит, значит, звонят ему и нужно включить у его телефона мелодию вызова
        if (!abonent.isInitiator()) {
            abonent.switchMusicOn();
        }

    }

    /**
     * Включает мелодию вызова у собеседника
     */
    public synchronized void switchMusicOn() {
        logger.info("Включаем мелодию вызова на телефоне {}", getName());
    }
}
