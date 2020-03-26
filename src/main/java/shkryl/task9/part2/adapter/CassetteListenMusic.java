package shkryl.task9.part2.adapter;

public class CassetteListenMusic implements CassetteMusic {

    @Override
    public void listenCassette(String track) {
        System.out.println("Слушаем трек " + track + " записанный на Аудио кассете");
    }
}
