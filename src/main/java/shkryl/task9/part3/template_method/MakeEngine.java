package shkryl.task9.part3.template_method;

public class MakeEngine {
    private String typeEngine;
    private String modelCar;
    private int maxSpeed;

    public String getTypeEngine() {
        return typeEngine;
    }

    public void setTypeEngine(String typeEngine) {
        this.typeEngine = typeEngine;
    }

    public int getMaxSpeed() {
        return maxSpeed;
    }

    public void setMaxSpeed(int maxSpeed) {
        this.maxSpeed = maxSpeed;
    }

    public String getModelCar() {
        return modelCar;
    }

    public void setModelCar(String modelCar) {
        this.modelCar = modelCar;
    }

    public final void processEngine(String typeEngine,String modelCar,int maxSpeed) {
        deliverEngine(typeEngine);
        checkEngineDefect(typeEngine);
        installEngine(modelCar,maxSpeed);
    }

    public void deliverEngine(String typeEngine){
        setTypeEngine(typeEngine);
        System.out.println("Получаем со склада " + getTypeEngine());
    }

    public void checkEngineDefect(String typeEngine){
        System.out.println("Двигатель прошел проверку на дефекты, готов к становке");
    }

    public void installEngine(String modelCar,int maxSpeed){
        setModelCar(modelCar);
        setMaxSpeed(maxSpeed);
        System.out.println(getTypeEngine() + " установлен на модель " + getModelCar() +
                " макс. скорость " + getMaxSpeed());
    }
}