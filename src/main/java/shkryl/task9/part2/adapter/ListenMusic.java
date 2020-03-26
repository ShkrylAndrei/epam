package shkryl.task9.part2.adapter;

/**
 *
 * @author Admin
 */
public class ListenMusic implements Music {

    @Override
    public void Listen(String type, String track) {
        if (type.equalsIgnoreCase("CD")){
            System.out.println("Слушаем трек "+track+" записанный на компакт диске");
        }else if (type.equalsIgnoreCase("FLASH")){
            System.out.println("Слушаем трек "+track+" записанный на Флешке");
        }else if (type.equalsIgnoreCase("CASSETTE")){
             CassetteMusicAdapter cassetteMusicAdapter =new CassetteMusicAdapter(type);
             cassetteMusicAdapter.Listen(type, track);
        }else{
            System.out.println("Данный формат не поддерживается");
        }
    }
    
}
