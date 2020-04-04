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

    public static void uuidsStringSaveToFile(String fileName, List<String> uuidsString) {
        Path path = Paths.get(fileName);
        try {
            Files.write(path, uuidsString, StandardOpenOption.CREATE);
        } catch (IOException e) {
            logger.error(e.getMessage());
        }
    }

    public static void countUUIDMoreThan100(String fileName) {
        Path path = Paths.get(fileName);
        try {
            long count = Files.lines(path)
                    .map(x -> x.replaceAll("\\D", ""))
                    .map(x -> x.chars().map(ch -> Character.getNumericValue(ch)).sum())
                    .filter(sum -> sum > 100)
                    .count();
            logger.info("Количество элементов, сумма которых больше 100 = {}", count);
        } catch (IOException e) {
            logger.error(e.getMessage());
        }
    }

    public static void calculationEndOfTheWorld() {
        ZoneId zoneId = ZoneId.of("America/Los_Angeles");
        ZonedDateTime dateNow = ZonedDateTime.now(zoneId);
        String startDate = dateNow.format(DateTimeFormatter.ISO_DATE_TIME);

        int n = Integer.valueOf(startDate.substring(0, 2).replaceAll("\\D", ""));
        int m = Integer.valueOf(startDate.substring(2, 4).replaceAll("\\D", ""));

        dateNow = dateNow.plusMonths(n).plusDays(m);
        String lastDate = dateNow.format(DateTimeFormatter.ISO_DATE_TIME);
        logger.info("Дата конца света: {}", lastDate);
    }

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
