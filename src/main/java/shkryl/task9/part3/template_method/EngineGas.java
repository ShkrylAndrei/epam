package shkryl.task9.part3.template_method;


public class EngineGas extends MakeEngine {

    public void installGasBallone() {
        System.out.println("Установка газового балона");
    }

    public void refuelGasBallone() {
        System.out.println("Газовый балон запрален");
    }

    @Override
    public void installEngine(String modelCar, int maxSpeed) {
        super.installEngine(modelCar, maxSpeed);
        installGasBallone();
        refuelGasBallone();
    }
}
