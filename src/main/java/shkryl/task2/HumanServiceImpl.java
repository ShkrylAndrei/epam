package shkryl.task2;

import java.util.ArrayList;
import java.util.List;

/**
 * Реализация сервиса для HumanDto, работает с репозитарием через конвертер
 */
public class HumanServiceImpl implements Service<HumanDto> {

    /**
     * Репозиторий для сущности Human
     */
    private HumanRepoImpl humanRepo = new HumanRepoImpl();
    /**
     * Конвертер для сущности Human
     */
    private HumanConverterImpl converter = new HumanConverterImpl();

    @Override
    public HumanDto getOneEntity() {
        Human human = humanRepo.getOneEntity();
        return converter.convertToDTO(human);
    }

    @Override
    public List<HumanDto> getAllEntity() {
        List<Human> listEntity = humanRepo.getAllEntity();
        List<HumanDto> listDTO = new ArrayList<>();
        for (Human human : listEntity) {
            listDTO.add(converter.convertToDTO(human));
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
        for (HumanDto dto : listDTO) {
            humanRepo.saveOneEntity(converter.convertToEntity(dto));
        }
    }
}
