package shkryl.task12.deadlock.solution;

/**
 * Параметры вызова
 */
public class CallStatus {
    private Abonent initiator;


    public synchronized void setInitiator(Abonent abonent){
        if(this.initiator == null) {
            this.initiator = abonent;
        }
    }

    public Abonent getInitiator(){
        return initiator;
    }
}
