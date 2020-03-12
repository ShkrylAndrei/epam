package shkryl.task4;

//Unchecked exception
public class CanNotSaveEntity extends RuntimeException {
    public CanNotSaveEntity(String message){
        super(message);
    }
}
