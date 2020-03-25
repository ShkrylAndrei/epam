package shkryl.task9.part2.adapter;

/**
 *
 * @author Admin
 */
public class ListenMusicAdapter implements ListenMusicI{
    private CassetteListenMusic cassetteListenMusic;
    
    public ListenMusicAdapter(String type){
        if (type.equalsIgnoreCase("CASSETTE")){
            cassetteListenMusic = new CassetteListenMusic();
        }
    }
    
    @Override
    public void Listen(String type, String track) {
        if (type.equalsIgnoreCase("CASSETTE")){
            cassetteListenMusic.listenCassette(track);
        }
    }    
    
        
    
}
