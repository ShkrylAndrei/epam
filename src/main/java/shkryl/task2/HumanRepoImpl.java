package shkryl.task2;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Random;

/**
 * Реализует интерфейс EntityRepo для сущности Human
 */
public class HumanRepoImpl implements EntityRepo<Human> {

    private Random rnd = new Random();

    @Override
    public Human getOneEntity() {
        return generateHuman();
    }

    @Override
    public List<Human> getAllEntity() {
        List<Human> list = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            list.add(generateHuman());
        }
        return list;
    }

    @Override
    public void saveOneEntity(Human entity) {
        System.out.println("Human entity saved:");
        System.out.println(entity);
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
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd.MM.yyyy");
        try {
            int day = rnd.nextInt(28) + 1;
            int month = rnd.nextInt(12) + 1;
            int year = rnd.nextInt(6) + 2015;
            birthDate = simpleDateFormat.parse(String.format("%d.%d.%d", day, month, year));
        } catch (Exception e) {

        }
        return new Human(id, name, tmpAddress, birthDate);

    }
}
