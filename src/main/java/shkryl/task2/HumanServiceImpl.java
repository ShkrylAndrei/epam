package shkryl.task2;

import java.util.ArrayList;
import java.util.List;

//Этот сервис работает с репозиторием
//через конвертер
public class HumanServiceImpl implements Service<HumanDto>{


    private HumanRepoImpl humanRepo = new HumanRepoImpl();
    private HumanConverterImpl converter = new HumanConverterImpl();

    @Override
    public HumanDto getOneEntity() {
        Human human = humanRepo.getOneEntity();
        return converter.convetToDTO(human);
    }

    @Override
    public List<HumanDto> getAllEntity() {
        List<Human> listEntity = humanRepo.getAllEntity();
        List<HumanDto> listDTO = new ArrayList<>();
        for(Human human : listEntity){
            listDTO.add(converter.convetToDTO(human));
        }
        return listDTO;
    }

    @Override
    public void saveOneEntity(HumanDto dto) {
        Human human = converter.convertToEntity(dto);
        humanRepo.saveOneEntity(human);
    }

    @Override
    public void saveAllEntity(List<HumanDto> listDTO) {
        for(HumanDto dto : listDTO){
            humanRepo.saveOneEntity(converter.convertToEntity(dto));
        }
    }
}
