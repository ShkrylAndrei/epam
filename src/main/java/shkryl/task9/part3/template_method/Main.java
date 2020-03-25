package shkryl.task9.part3.template_method;

/**
 *
 * @author Admin
 */
public class Main {
    public static void main(String[] args) {
        MakeEngine engine;
        
        engine = new EnginePetrol();
        engine.loadEngine();
        System.out.println("");
        
        engine = new EngineGas();
        engine.loadEngine();
        System.out.println("");
        
    }
}
