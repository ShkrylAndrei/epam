package shkryl.task17;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import java.util.List;
import java.util.Scanner;

public class Main {

    private static Logger logger = LoggerFactory.getLogger(Main.class);

    public static void main(String[] args) throws Exception {
        Service service = new Service();
        logger.info("Старт программы");

        boolean menu = true;

        while (menu) {
            System.out.println("Выберите пункт: 1,2,3,4,5");
            System.out.println("1. Добавить новую запись");
            System.out.println("2. Редактировать выбранную запись");
            System.out.println("3. Удалить выбранную запись");
            System.out.println("4. Посмотреть записи по указанному title");
            System.out.println("Выход");

            Scanner sc = new Scanner(System.in);

            int choose = sc.nextInt();

            if (choose == 1) {
                logger.info("Пользователь выбрал добавить запись");
                System.out.println("Введите числовое значение поля category");
                int category = sc.nextInt();
                System.out.println("Введите строковое значение поля title");
                sc = new Scanner(System.in);
                String title = sc.nextLine();
                System.out.println("Введите строковое значение поля actor");
                String actor = sc.nextLine();
                System.out.println("Введите числовое значение поля price");
                int price = sc.nextInt();
                System.out.println("Введите числовое значение поля common_prod_id");
                int common_prod_id = sc.nextInt();
                boolean result = service.addProductById(category, title, actor, price, common_prod_id);
                if (result) {
                    logger.info("Запись успешно добавлена");
                } else {
                    logger.info("Не удалось добавить запись");
                }
            } else if (choose == 2) {
                logger.info("Пользователь выбрал редактировать запись");
                System.out.println("Введите идентификатор редактируемой записи");
                int id_record = sc.nextInt();
                System.out.println("Введите новое значение записи");
                Scanner getValue = new Scanner(System.in);
                String newValue = getValue.nextLine();
                boolean result = service.editProductById(id_record, newValue);
                if (result) {
                    logger.info("Запись с идентификтором " + id_record + " успешно изменена. Новое значени = " + newValue);
                } else {
                    logger.info("Не удалось изменить запись с идентификтором " + id_record);
                }
            } else if (choose == 3) {
                logger.info("Пользователь выбрал удаление записи");
                System.out.println("Введите идентификатор удалеяемой записи");
                int id_record = sc.nextInt();
                boolean result = service.removeProductById(id_record);
                if (result) {
                    logger.info("Запись с идентификтором " + id_record + " успешно удалена");
                } else {
                    logger.info("Не удалось удалить запись с идентификтором " + id_record);
                }
            } else if (choose == 4) {
                logger.info("Пользователь выбрал просмотр записи");
                System.out.println("Введите title записи");
                sc = new Scanner(System.in);
                String title = sc.nextLine();
                List<Product> list = service.readAllProductsByTitle(title);
                list.stream()
                        .forEach(System.out::println);
            } else if (choose == 5) {
                logger.info("Пользователь выбрал выход из системы");
            }
        }

        service.disconnect();

        logger.info("Завершение работы программы");
    }
}
