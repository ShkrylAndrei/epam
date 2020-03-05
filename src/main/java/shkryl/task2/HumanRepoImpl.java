package shkryl.task2;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Random;

//Это реализация репозитория для Human
//работает с сущностью Human
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

        }
        return new Human(id, name, tmpAddress, birthDate);

    }
}
