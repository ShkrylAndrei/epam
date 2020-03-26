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
     * Логгер для класса HumanRepoImpl
     */
    private Logger consoleAndFileLogger = LoggerFactory.getLogger(HumanRepoImpl.class);

    @Override
    public Human getOneEntity() throws EntityNotFound {

        Human entity = generateHuman();
        if (entity.getId() > CRITICAL_VALUE_GENERATE) {
            consoleAndFileLogger.debug("entity with id={} not found", entity.getId());
            throw new EntityNotFound("Сущность с id " + entity.getId() + " не найдена");
        }
        consoleAndFileLogger.debug("entity with id={} is generated in Repo", entity.getId());
        return entity;
    }

    @Override
    public List<Human> getAllEntity() {
        List<Human> list = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            try {
                list.add(getOneEntity());
            } catch (EntityNotFound e) {
                consoleAndFileLogger.debug("EXCEPTION: error when try add entity to List<Human> in Repo");
            }
        }
        consoleAndFileLogger.debug("all entity was generated in Repo");
        return list;
    }

    @Override
    public void saveOneEntity(Human entity) {
        if (entity.getId() > CRITICAL_VALUE_SAVE) {
            consoleAndFileLogger.debug("entity with id={} can not saves from Repo", entity.getId());
            throw new CanNotSaveEntity("Entity with id=" + entity.getId() + " can not be saves");
        }
        consoleAndFileLogger.debug("human entity with id={} saved", entity.getId());
        //System.out.println(entity);
    }

    @Override
    public void saveAllEntity(List<Human> listEntity) {
        for (Human human : listEntity) {
            saveOneEntity(human);
        }
    }

    /**
     * Генерирует сущность Human
     *
     * @return возращает сгенерированную сущность Human
     */
    private Human generateHuman() {
        Random rnd = new Random();
        String[] arrName = {"Андрей", "Максим", "Петр", "Семен", "Михаил"};
        String[] arrCity = {"Тольятти", "Москва", "Сызрань", "Ульяновск", "Чебоксары"};
        String[] arrStreet = {"Мира", "Ленина", "Луначарского", "Куйбышева", "Садовая"};

        int id = rnd.nextInt(1000);
        String name = arrName[rnd.nextInt(5)];
        Address tmpAddress = new Address();
        tmpAddress.setCity(arrCity[rnd.nextInt(5)]);
        tmpAddress.setStreet(arrStreet[rnd.nextInt(5)]);
        tmpAddress.setHouse(rnd.nextInt(1000));
        tmpAddress.setRoom(rnd.nextInt(500));

        Date birthDate = null;
        SimpleDateFormat bithDateFormat = new SimpleDateFormat("dd.MM.yyyy");
        try {
            int day = rnd.nextInt(28) + 1;
            int month = rnd.nextInt(12) + 1;
            int year = rnd.nextInt(6) + 2015;
            birthDate = bithDateFormat.parse(String.format("%d.%d.%d", day, month, year));
        } catch (Exception e) {
            consoleAndFileLogger.debug("EXCEPTION: invalid date");
        }
        return new Human(id, name, tmpAddress, birthDate);

    }
}
