package shkryl.task3;

import java.util.*;

public class Helper {
    public void fillList(List<Human> listHuman){
        //три дубля как по условию задачи
        Address address1=new Address("Тольятти","Ленинградская",43,45);
        Human h1=new Human("Шкрыль А.А.",37,address1);

        Address address2=new Address("Тольятти","Ленинградская",43,45);
        Human h2=new Human("Шкрыль А.А.",37,address2);

        Address address3=new Address("Самара","Мира",13,15);
        Human h3=new Human("Пучков В.С.",42,address3);

        Address address4=new Address("Самара","Мира",13,15);
        Human h4=new Human("Пучков В.С.",42,address4);

        Address address5=new Address("Ульяновск","Ленина",76,2);
        Human h5=new Human("Елизаров К.Г.",53,address5);

        Address address6=new Address("Ульяновск","Ленина",76,2);
        Human h6=new Human("Елизаров К.Г.",53,address6);

        //не дублирующиеся объекты
        Address address7=new Address("Москва","Западная",23,102);
        Human h7=new Human("Абрамян Д.А.",30,address7);

        Address address8=new Address("Санкт-Петербург","Кирова",88,1);
        Human h8=new Human("Фенов М.Д.",25,address8);

        Address address9=new Address("Сызрань","Осенняя",5,67);
        Human h9=new Human("Кутуков А.К.",25,address9);

        Address address10=new Address("Чебоксары","Чебоксарская",115,27);
        Human h10=new Human("Плотников И.П.",48,address10);
        listHuman.add(h1);
        listHuman.add(h2);
        listHuman.add(h3);
        listHuman.add(h4);
        listHuman.add(h5);
        listHuman.add(h6);
        listHuman.add(h7);
        listHuman.add(h8);
        listHuman.add(h9);
        listHuman.add(h10);

    }

    public List<Human> getDuplicateList(List<Human> listHuman) {
        List<Human> dublicateList = new ArrayList<>();
        for (int i = 0; i < listHuman.size(); i++) {
            int count_element = 1;
            for (int j = i; j < listHuman.size(); j++) {
                if (listHuman.get(i).equals(listHuman.get(j)) && i != j) {
                    dublicateList.add(listHuman.get(j));

                }

            }

        }
        return dublicateList;
    }

    public Map<Human, Integer> getDuplicateWithMap(List<Human> listHuman){
        Map<Human, Integer> mapHuman = new HashMap<>();
        for (Human h : listHuman) {
            mapHuman.put(h,mapHuman.get(h)==null?1:mapHuman.get(h)+1);

        }
        System.out.println("--------------------------------------");
        System.out.println("Выводим дубли коллекции");
        for (Map.Entry<Human, Integer> entry : mapHuman.entrySet()) {
            if (entry.getValue()>1) {
                System.out.println(entry.getKey());
            }
        }
        return mapHuman;
    }

    public void printWithoutDublicate(List<Human> listHuman, Map<Human, Integer> mapHuman){

        for (Map.Entry<Human, Integer> entry : mapHuman.entrySet()) {
            if (entry.getValue()>1) {
                Human h = entry.getKey();
                listHuman.remove(h);
            }
        }

        System.out.println("--------------------------------------");
        System.out.println("Выводим коллекцию без дублей(они удалены)");
        for (int i = 0; i < listHuman.size(); i++) {
            System.out.println((i+1)+" "+listHuman.get(i));
        }
    }


    public void sortHumanFio(List<Human> listHuman){
        ComparatorFio comparatorFio=new ComparatorFio();
        Collections.sort(listHuman, comparatorFio);
        System.out.println("--------------------------------------");
        System.out.println("Выводим коллекцию отсортированную по FIO");
        for (int i = 0; i < listHuman.size(); i++) {
            System.out.println((i+1)+" "+listHuman.get(i));
        }
    }

}
