package shkryl.task9.part3.template_method;

/**
 *
 * @author Admin
 */
public abstract class MakeEngine {
    public final void loadEngine(){
        getEngine();
        setEngine();
    }
    
    public abstract void getEngine();
    
    public abstract void setEngine();
}