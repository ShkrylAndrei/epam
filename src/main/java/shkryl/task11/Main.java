package shkryl.task11;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static java.time.format.DateTimeFormatter.ISO_DATE;

public class Main {
    public static void main(String[] args) {

//        UUID uuid = UUID.randomUUID();
//        List<UUID> uuids = Stream.generate(UUID::randomUUID)
//                .limit(10000)
//                .collect(Collectors.toList());
//        uuids.stream()
//                .forEach(System.out::println);
//
//
//        List<String> uuidsString = uuids.stream()
//                .map(UUID::toString)
//                .collect(Collectors.toList());
//
        Path path = Paths.get("uuid.txt");
//        try {
//            Files.write(path, uuidsString, StandardOpenOption.CREATE);
//        }catch(IOException e){
//            e.printStackTrace();
//        }




        try {

            long count = Files.lines(path)
                    .map(x->x.replaceAll("\\D", ""))
                    .map(x->x.chars().map(ch->Character.getNumericValue(ch)).sum())
                    .filter(sum -> sum > 100)
                    .count();
            System.out.println("count = "+count);
        } catch (IOException e) {
            e.printStackTrace();
        }

        //РАссчет времени Тихоокенского
        //5.6.20


        ZoneId zoneId = ZoneId.of("America/Los_Angeles");
        ZonedDateTime dateNow = ZonedDateTime.now(zoneId);
        String startDate = dateNow.format(DateTimeFormatter.ISO_DATE_TIME);
        System.out.println("start date: "+startDate);

        int n = Integer.valueOf(startDate.substring(0,2).replaceAll("\\D",""));
        int m = Integer.valueOf(startDate.substring(2,4).replaceAll("\\D",""));
        System.out.println(n+" "+m);
        dateNow = dateNow.plusMonths(n).plusDays(m);
        String lastDate = dateNow.format(DateTimeFormatter.ISO_DATE_TIME);
        System.out.println("last date: "+lastDate);




        //Пробую декодировать

//        Base64.Decoder dec = Base64.getDecoder();
//        byte[] decbytes = dec.decode("dHlwZT0n0JTQsNGC0YHQutCw0Y8nLCB3ZWlnaHQ9MTYwNSwgY29zdD01NTYz");
//        System.out.println(new String(decbytes));

        Base64.Decoder decoder = Base64.getDecoder();
        Path pathCodedFile = Paths.get("File.txt");
        try {
            List<Sausage> sausages = Files.lines(pathCodedFile)
                    .map(line->decoder.decode(line))
                    .map(String::new) //декодированная строка
                    .map(line->Arrays.stream(line.split(","))
                            .map(elem->elem.split("=")[1]).collect(Collectors.toList()))
                    .map(Sausage::new)
                    .collect(Collectors.toList());

            sausages.stream().forEach(System.out::println);
            //sausages.stream().forEach(Logger::info);
            //sausages.stream().forEach(sausage->logger.info(sausage));
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

//    public static void printSum(String str){
//        if(str.length()<36){
//            throw new ArithmeticException("less than 36");
//        }
//        String source = str;
//        str = str.replaceAll("\\D", "");
//        int sum = 0;
//        for (int i = 0; i < str.length(); i++) {
//            int val = Character.getNumericValue(str.charAt(i));
//            sum+=val;
//        }
//        System.out.println(source+" "+sum);
//    }

}
