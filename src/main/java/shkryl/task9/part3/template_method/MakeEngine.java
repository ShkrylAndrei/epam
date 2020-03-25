package shkryl.task9.part3.template_method;

/**
 *
 * @author Admin
 */
public abstract class MakeEngine {
    public final void processEngine(){
        deliverEngine();
        installEngine();
    }
    
    public abstract void deliverEngine();
    
    public abstract void installEngine();
}