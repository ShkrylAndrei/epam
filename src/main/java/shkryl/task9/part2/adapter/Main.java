package shkryl.task9.part2.adapter;

/**
 *
 * @author Admin
 */
public class Main {
    public static void main(String[] args) {
        ListenMusic listenMusic = new ListenMusic();
        
        listenMusic.Listen("CD","Руки вверх - Алешка");
        listenMusic.Listen("FLASH", "Полина Гагарина - Нет");
        listenMusic.Listen("CASSETTE","Высоцкий - Высота");      
    }
}
