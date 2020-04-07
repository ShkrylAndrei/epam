package shkryl.task11;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Arrays;
import java.util.Base64;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Service {
    private static Logger logger = LoggerFactory.getLogger(Service.class);

    /**
     * Генерирует коллекцию с 10000 раномными элементами UUID
     *
     * @return возращает сгенерированную коллекцию
     */
    public static List<String> generateUIID() {
        UUID uuid = UUID.randomUUID();
        List<UUID> uuids = Stream.generate(UUID::randomUUID)
                .limit(10000)
                .collect(Collectors.toList());

        List<String> uuidsString = uuids.stream()
                .map(UUID::toString)
                .collect(Collectors.toList());
        return uuidsString;
    }

    /**
     * Сохраняет переданную коллекцию, в качестве параметра, в файл
     *
     * @param fileName    имя файла
     * @param uuidsString обрабатываемая коллекция
     */
    public static void uuidsStringSaveToFile(String fileName, List<String> uuidsString) {
        Path path = Paths.get(fileName);
        try {
            Files.write(path, uuidsString, StandardOpenOption.CREATE);
        } catch (IOException e) {
            logger.error(e.getMessage());
        }
    }

    /**
     * Считает количетсво элементов в файле, содержащим UUID строки, у которых сумма цифр больше 100
     *
     * @param fileName имя обрабатываемого файла
     * @return количество строк UUID, в которых сумма чисел больше 100
     */
    public static long countUUIDMoreThan100(String fileName) {
        Path path = Paths.get(fileName);
        long count = 0;
        try {
            count = Files.lines(path)
                    .map(x -> x.replaceAll("\\D", ""))
                    .map(x -> x.chars().map(ch -> Character.getNumericValue(ch)).sum())
                    .filter(sum -> sum > 100)
                    .count();
            logger.info("Количество элементов, сумма которых больше 100 = {}", count);
        } catch (IOException e) {
            logger.error(e.getMessage());
        }
        return count;
    }

    /**
     * Добавляет лидирующие нули, если длина числа count меньше 4
     *
     * @param count количество строк UUID, в которых сумма чисел больше 100
     * @return строку count длиной 4 символа
     */
    private static String getValidCount(long count) {
        String countString = String.valueOf(count);
        StringBuilder sb = new StringBuilder();

        while (sb.length() + countString.length() < 4) {
            sb.append(0);
        }
        return sb.toString() + countString;
    }

    /**
     * Рассчитывает дату конца света на основе count
     *
     * @param count количество строк UUID, в которых сумма чисел больше 100
     */
    public static void calculationEndOfTheWorld(long count) {
        ZoneId zoneId = ZoneId.of("America/Los_Angeles");
        ZonedDateTime dateNow = ZonedDateTime.now(zoneId);
        String startDate = dateNow.format(DateTimeFormatter.ISO_DATE_TIME);
        logger.info("Текущая дата: {}", startDate);
        String countString = getValidCount(count);
        int n = Integer.parseInt(countString.substring(0, 2));
        int m = Integer.parseInt(countString.substring(2, 4));
        logger.info("n = {}", n);
        logger.info("m = {}", m);

        dateNow = dateNow.plusMonths(n).plusDays(m);
        String lastDate = dateNow.format(DateTimeFormatter.ISO_DATE_TIME);
        logger.info("Дата конца света: {}", lastDate);
    }

    /**
     * Создает объекты типа Sausage, данные для полей объектов
     * берутся из файла File.txt, декодируются из формата base64
     */
    public static void createSausages() {
        Base64.Decoder decoder = Base64.getDecoder();
        Path pathCodedFile = Paths.get("File.txt");
        try {
            List<Sausage> sausages = Files.lines(pathCodedFile)
                    .map(line -> decoder.decode(line))
                    .map(String::new) //декодированная строка
                    .map(line -> Arrays.stream(line.split(","))
                            .map(elem -> elem.split("=")[1]).collect(Collectors.toList()))
                    .map(Sausage::new)
                    .collect(Collectors.toList());

            sausages.stream().forEach(sausage -> logger.info("{}", sausage));
        } catch (IOException e) {
            logger.error(e.getMessage());
        }
    }
}
