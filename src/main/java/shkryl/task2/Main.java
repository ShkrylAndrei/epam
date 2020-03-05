package shkryl.task2;

import java.util.List;

public class Main {
    public static void main(String[] args) {

        HumanServiceImpl service = new HumanServiceImpl();
        System.out.println("GENERATE ONE ENTITY");
        HumanDto dto = service.getOneEntity();
        service.saveOneEntity(dto);

        System.out.println();

        System.out.println("GENERATE LIST ENTITIES");
        List<HumanDto> listDTO = service.getAllEntity();
        service.saveAllEntity(listDTO);

    }


}
