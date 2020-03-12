package shkryl.task4;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.List;

//Этот сервис работает с репозиторием
//через конвертер
public class HumanServiceImpl implements Service<HumanDto>{


    private HumanRepoImpl humanRepo = new HumanRepoImpl();
    private HumanConverterImpl converter = new HumanConverterImpl();
    private Logger consoleLogger = LoggerFactory.getLogger(HumanServiceImpl.class);


    @Override
    public HumanDto getOneEntity() {
        Human human=null;
        try {
            human = humanRepo.getOneEntity();
            consoleLogger.debug("entity with id="+human.getId()+" is generated");
        }catch(EntityNotFound e){
            consoleLogger.debug("EXCEPTION: "+e.toString());
            return null;
        }
        return converter.convetToDTO(human);
    }

    @Override
    public List<HumanDto> getAllEntity() {

        List<Human> listEntity = humanRepo.getAllEntity();
        List<HumanDto> listDTO = new ArrayList<>();
        for (Human human : listEntity) {
            listDTO.add(converter.convetToDTO(human));
        }
        consoleLogger.debug("All entities are generated");
        return listDTO;
    }

    @Override
    public void saveOneEntity(HumanDto dto) {
        Human human = converter.convertToEntity(dto);
        try {
            humanRepo.saveOneEntity(human);
            consoleLogger.debug("entity with id="+human.getId()+" is saved");
        }catch(CanNotSaveEntity e){
            consoleLogger.debug("EXCEPTION: "+e.toString());
        }
    }

    @Override
    public void saveAllEntity(List<HumanDto> listDTO) {
        for(HumanDto dto : listDTO){
            try {
                humanRepo.saveOneEntity(converter.convertToEntity(dto));
            }catch(CanNotSaveEntity e){
                consoleLogger.debug("EXCEPTION: "+e.toString());
            }
        }
        consoleLogger.debug("All entities are saved");
    }
}
