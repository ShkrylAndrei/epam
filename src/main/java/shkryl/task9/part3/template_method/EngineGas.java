package shkryl.task9.part3.template_method;

/**
 *
 * @author Admin
 */
public class EngineGas extends MakeEngine{
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
    
    
    
    @Override
    public void getEngine() {
        setTypeEngine("Газовый двигатель");
        System.out.println("Получаем со склада "+getTypeEngine());
    }

    @Override
    public void setEngine() {
        setModelCar("Nissan");
        setMaxSpeed(280);
        System.out.println(getTypeEngine()+" установлен на модель "+getModelCar()+
                           " макс. скорость "+getMaxSpeed());
        
    }   
}
