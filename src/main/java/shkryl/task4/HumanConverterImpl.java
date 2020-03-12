package shkryl.task4;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class HumanConverterImpl implements Converter<Human, HumanDto> {
    private Logger onlyFileLogger = LoggerFactory.getLogger(HumanConverterImpl.class);

    @Override
    public HumanDto convetToDTO(Human entity) {
        HumanDto dto = new HumanDto();
        dto.setId(entity.getId());
        dto.setName(entity.getName());

        dto.setCity(entity.getAddress().getCity());
        dto.setStreet(entity.getAddress().getStreet());
        dto.setHouse(entity.getAddress().getHouse());
        dto.setRoom(entity.getAddress().getRoom());


        dto.setBirthDate(entity.getBirthDate());

        onlyFileLogger.debug("human entity with id = {} was converted to DTO", entity.getId());

        return dto;
    }

    @Override
    public Human convertToEntity(HumanDto dto) {
        Human entity = new Human();
        entity.setId(dto.getId());
        entity.setName(dto.getName());
        Address address = new Address(dto.getCity(),
                dto.getStreet(),
                dto.getHouse(),
                dto.getRoom()
        );

        entity.setAddress(address);
        entity.setBirthDate(dto.getBirthDate());

        onlyFileLogger.debug("DTO entity with id= {} was converted to Human entity",dto.getId());

        return entity;
    }
}
