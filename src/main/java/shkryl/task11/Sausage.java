package shkryl.task11;

import java.util.List;

public class Sausage {
    String type;
    int weight;
    long cost;

    public Sausage(String type, int weight, long cost) {
        this.type = type;
        this.weight = weight;
        this.cost = cost;
    }




    public Sausage(List<String> list) {
        this(list.get(0).replace("'", ""),
                Integer.parseInt(list.get(1)),
                Long.parseLong(list.get(2)));
    }

    @Override
    public String toString() {
        return "Sausage{" +
                "type='" + type + '\'' +
                ", weight=" + weight +
                ", cost=" + cost +
                '}';
    }
}
