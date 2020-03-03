package shkryl.task2;

//F-from, T-to
public class Converter<F, T> {
    public T convertToDTO(F entity){
        HumanDto dto = new HumanDto();
        if(entity instanceof HumanEntity){
            HumanEntity human = (HumanEntity)entity;

            dto.setId(human.getId());
            dto.setName(human.getName());

            dto.setCity(human.getAddress().getCity());
            dto.setStreet(human.getAddress().getStreet());
            dto.setHouse(human.getAddress().getHouse());
            dto.setRoom(human.getAddress().getRoom());


            dto.setBirthDate(human.getBirthDate());
        }

        return (T)dto;
    }


    public T convertToEntity(F dto){
        HumanEntity entity = new HumanEntity();
        if (dto instanceof HumanDto) {
            HumanDto humanDto=(HumanDto)dto;

            entity.setId(humanDto.getId());
            entity.setName(humanDto.getName());
            AddressEntity addressEntity = new AddressEntity(humanDto.getCity(),
                    humanDto.getStreet(),
                    humanDto.getHouse(),
                    humanDto.getRoom()
            );

            entity.setAddress(addressEntity);
            entity.setBirthDate(humanDto.getBirthDate());

        }
        return (T)entity ;
    }


    }
