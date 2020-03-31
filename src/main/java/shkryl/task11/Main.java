package shkryl.task11;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Main {
    public static void main(String[] args) {
        //Одним стримом сгенерировать коллекцию с 10000 рандомными элементами UUID.
        Stream<String> stream = Stream.generate(() ->
                Double.toString(Math.random() * 1000)).limit(10);

        stream.forEach(System.out::println);


        //Запись строк в файл
        Path path = Paths.get("random_elements.txt");
        try {
            Files.write(path, Arrays.asList("first line", "second line"), StandardCharsets.UTF_8);
        } catch (IOException e) {
            e.printStackTrace();
        }

        //Одним стримом считать этот файл и посчитать количество элементов UUID, в которых сумма цифр > 100
       // Path path = Paths.get("random_elements.txt");
        System.out.println();
        try {
            System.out.println(Files.lines(path, StandardCharsets.UTF_8)
                    .collect(Collectors.joining(System.lineSeparator())));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
