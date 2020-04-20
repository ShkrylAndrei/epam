package shkryl.task17;

import java.sql.Connection;
import java.sql.DriverManager;
import java.util.List;

public class Main {

    public static void main(String[] args) throws Exception{
        Service service = new Service();
        //service.removeProductById(2);
        //service.editProductById(372, "ACADEMY GRACELAND ACE");
        List<Product> list = service.readAllProductsByTitle("ACE");

        list.stream()
                .forEach(System.out::println);


    }
}
