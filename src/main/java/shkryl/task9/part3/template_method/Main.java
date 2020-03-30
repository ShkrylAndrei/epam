package shkryl.task9.part3.template_method;


public class Main {
    public static void main(String[] args) {
        MakeEngine engine;

        engine = new EnginePetrol();
        engine.processEngine("Бензиновый двигатель", "Лада", 180);
        System.out.println("");

        engine = new EngineGas();
        engine.processEngine("Газовый двигатель", "Nissan", 280);
        System.out.println("");
    }
}
