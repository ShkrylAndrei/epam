package shkryl.task9.part3.template_method;


public class EnginePetrol extends MakeEngine {

    public void installCandals() {
        System.out.println("Установка свечей зажигания");
    }

    public void addOil() {
        System.out.println("Добавлено масло");
    }

    @Override
    public void installEngine(String modelCar, int maxSpeed) {
        super.installEngine(modelCar, maxSpeed);
        installCandals();
        addOil();
    }
}
