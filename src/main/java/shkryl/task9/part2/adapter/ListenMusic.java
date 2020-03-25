package shkryl.task9.part2.adapter;

/**
 *
 * @author Admin
 */
public class ListenMusic implements ListenMusicI{

    @Override
    public void Listen(String type, String track) {
        if (type.equalsIgnoreCase("CD")){
            System.out.println("Слушаем трек "+track+" записанный на компакт диске");
        }else if (type.equalsIgnoreCase("FLASH")){
            System.out.println("Слушаем трек "+track+" записанный на Флешке");
        }else if (type.equalsIgnoreCase("CASSETTE")){
             ListenMusicAdapter listenMusicAdapter=new ListenMusicAdapter(type);
             listenMusicAdapter.Listen(type, track);
        }else{
            System.out.println("Данный формат не поддерживается");
        }
    }
    
}
