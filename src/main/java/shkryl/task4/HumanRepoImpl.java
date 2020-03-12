package shkryl.task4;

import jdk.nashorn.internal.runtime.regexp.joni.constants.EncloseType;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.swing.text.html.parser.Entity;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Random;

//Это реализация репозитория для Human
//работает с сущностью Human
public class HumanRepoImpl implements EntityRepo<Human> {
    private final int CRITICAL_VALUE_GENERATE = 500;
    private final int CRITICAL_VALUE_SAVE = 300;

    private Random rnd = new Random();
    private Logger consoleAndFileLogger = LoggerFactory.getLogger(HumanRepoImpl.class);

    @Override
    public Human getOneEntity() throws EntityNotFound {

        Human entity = generateHuman();
        if(entity.getId()>CRITICAL_VALUE_GENERATE){
            consoleAndFileLogger.debug("entity with id="+entity.getId()+" not found");
            throw new EntityNotFound("Сущность с id "+ entity.getId()+" не найдена");
        }
        consoleAndFileLogger.debug("entity with id="+entity.getId()+" is generated in Repo");
        return entity;
    }

    @Override
    public List<Human> getAllEntity()  {
        List<Human> list = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            try {
                list.add(getOneEntity());
            }catch (EntityNotFound e){
                consoleAndFileLogger.debug("error when try add entity to List<Human> in Repo");
                System.out.println("EXCEPTION: "+e.toString());
            }
        }
        consoleAndFileLogger.debug("all entity was generated in Repo");
        return list;
    }

    @Override
    public void saveOneEntity(Human entity) {
        if(entity.getId()>CRITICAL_VALUE_SAVE){
            consoleAndFileLogger.debug("entity with id="+entity.getId()+" can not saves from Repo");
            throw new CanNotSaveEntity("Entity with id="+entity.getId()+" can not be saves");
        }
        System.out.println("Human entity saved:");
        consoleAndFileLogger.debug("human entity with id="+entity.getId()+" saved");
        System.out.println(entity);
    }

    @Override
    public void saveAllEntity(List<Human> listEntity) {
        for(Human human : listEntity){
            saveOneEntity(human);
        }
    }

    private Human generateHuman(){
        Random rnd=new Random();
        String[] name_array={"Андрей", "Максим", "Петр", "Семен", "Михаил"};

        int id=rnd.nextInt(1000);
        int name_random=rnd.nextInt(5);
        String name = name_array[name_random];
        Address tmpAddress=new Address();
        String[] city_array={"Тольятти","Москва","Сызрань","Ульяновск","Чебоксары"};
        int city_random=rnd.nextInt(5);
        tmpAddress.setCity(city_array[city_random]);
        String[] street_array={"Мира","Ленина","Луначарского","Куйбышева","Садовая"};
        int street_random=rnd.nextInt(5);
        tmpAddress.setStreet(street_array[street_random]);
        int house_random=rnd.nextInt(1000);
        tmpAddress.setHouse(house_random);
        int room_random=rnd.nextInt(500);
        tmpAddress.setRoom(room_random);

        Date birthDate = null;
        SimpleDateFormat sdf=new SimpleDateFormat("dd.MM.yyyy");
        try {
            int day = rnd.nextInt(28)+1;
            int month = rnd.nextInt(12)+1;
            int year = rnd.nextInt(6)+2015;
            birthDate = sdf.parse(String.format("%d.%d.%d", day, month, year));
        }catch(Exception e){
            System.out.println(e.toString());
        }
        return new Human(id, name, tmpAddress, birthDate);

    }
}
