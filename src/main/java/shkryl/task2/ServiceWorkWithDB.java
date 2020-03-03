package shkryl.task2;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Random;

public class ServiceWorkWithDB implements WorkWithDB<HumanDto>{


    @Override
    public HumanDto getOneEntity() {
        return generateHuman();
    }

    @Override
    public List<HumanDto> getAllEntity() {
        //почему сюда не передался тип T из объявления интерфейса????
        //по идее надо подставлять T подставил HumanDto
        List<HumanDto> listHumanDto=new ArrayList<>();
        for (int i=0;i<10;i++){
            listHumanDto.add(generateHuman());
        }

        return listHumanDto;
    }

    @Override
    public void saveOneEntity(HumanDto dto) {
         Converter<HumanDto,HumanEntity> converter = new Converter<>();
         HumanEntity entity = converter.convertToEntity(dto);
         System.out.println(entity);
    }

    @Override
    public void saveAllEntity(List<HumanDto> dtoList) {
        Converter<HumanDto, HumanEntity> converter = new Converter<>();
        for (int i = 0; i < dtoList.size(); i++) {
            HumanEntity humanEntity = converter.convertToEntity(dtoList.get(i));
            System.out.println(humanEntity);
        }
    }

    public HumanDto generateHuman(){

        Random rnd=new Random();
        String[] name_array={"Андрей", "Максим", "Петр", "Семен", "Михаил"};

        int id=rnd.nextInt(1000);
        int name_random=rnd.nextInt(5);
        String name = name_array[name_random];
        AddressEntity tmpAddress=new AddressEntity();
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
        HumanEntity humanEntity = new HumanEntity(id, name, tmpAddress, birthDate);

        Converter<HumanEntity, HumanDto> converter = new Converter<>();
        return converter.convertToDTO(humanEntity);

    }
}
