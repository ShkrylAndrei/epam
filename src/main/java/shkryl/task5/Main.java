package shkryl.task5;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import shkryl.task5.util.GenerateMainMenu;

public class Main {

    public static void main(String[] args) {
        Logger logger = LoggerFactory.getLogger(Main.class);
        logger.info("Запуск программы");

        GenerateMainMenu.generate();
    }
}
