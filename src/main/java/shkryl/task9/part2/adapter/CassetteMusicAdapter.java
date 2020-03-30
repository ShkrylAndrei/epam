package shkryl.task9.part2.adapter;

public class CassetteMusicAdapter implements Music {
    private CassetteListenMusic cassetteListenMusic;

    public CassetteMusicAdapter(String type) {
        if (type.equalsIgnoreCase("CASSETTE")) {
            cassetteListenMusic = new CassetteListenMusic();
        }
    }

    @Override
    public void Listen(String type, String track) {
        if (type.equalsIgnoreCase("CASSETTE")) {
            cassetteListenMusic.listenCassette(track);
        }
    }
}
