package shkryl.task4;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Random;

/**
 * Реализует интерфейс EntityRepo для сущности Human
 */
public class HumanRepoImpl implements EntityRepo<Human> {
    /**
     * Максимальная величина для создания сущности
     */
    private static final int CRITICAL_VALUE_GENERATE = 500;
    /**
     * Максимальная величина для сохранения сущности
     */
    private static final int CRITICAL_VALUE_SAVE = 300;
    /**
     * Генератор случайных чисел
     */
    private Random rnd = new Random();
    /**
     * Логгер для калсса HumanRepoImpl
     */
    private Logger consoleAndFileLogger = LoggerFactory.getLogger(HumanRepoImpl.class);

    @Override
    public Human getOneEntity() throws EntityNotFound {

        Human entity = generateHuman();
        if(entity.getId()>CRITICAL_VALUE_GENERATE){
            consoleAndFileLogger.debug("entity with id={} not found",entity.getId());
            throw new EntityNotFound("Сущность с id "+ entity.getId()+" не найдена");
        }
        consoleAndFileLogger.debug("entity with id={} is generated in Repo",entity.getId());
        return entity;
    }

    @Override
    public List<Human> getAllEntity()  {
        List<Human> list = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            try {
                list.add(getOneEntity());
            }catch (EntityNotFound e){
                consoleAndFileLogger.debug("EXCEPTION: error when try add entity to List<Human> in Repo");
            }
        }
        consoleAndFileLogger.debug("all entity was generated in Repo");
        return list;
    }

    @Override
    public void saveOneEntity(Human entity) {
        if(entity.getId()>CRITICAL_VALUE_SAVE){
            consoleAndFileLogger.debug("entity with id={} can not saves from Repo",entity.getId());
            throw new CanNotSaveEntity("Entity with id="+entity.getId()+" can not be saves");
        }
        consoleAndFileLogger.debug("human entity with id={} saved",entity.getId());
        //System.out.println(entity);
    }

    @Override
    public void saveAllEntity(List<Human> listEntity) {
        for(Human human : listEntity){
            saveOneEntity(human);
        }
    }

    /**
     * Генерирует сущность Human
     *
     * @return возращает сгенерированную сущность Human
     */
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
            consoleAndFileLogger.debug("EXCEPTION: invalid date");
        }
        return new Human(id, name, tmpAddress, birthDate);

    }
}
