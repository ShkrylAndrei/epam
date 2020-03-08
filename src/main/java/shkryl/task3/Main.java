package shkryl.task3;

import java.util.*;

public class Main {
    public static void main(String[] args) {

        //три дубля как по условию задачи
        Address a1=new Address("Тольятти","Ленинградская",43,45);
        Human h1=new Human("Шкрыль А.А.",37,a1);

        Address a2=new Address("Тольятти","Ленинградская",43,45);
        Human h2=new Human("Шкрыль А.А.",37,a2);

        Address a3=new Address("Самара","Мира",13,15);
        Human h3=new Human("Пучков В.С.",42,a3);

        Address a4=new Address("Самара","Мира",13,15);
        Human h4=new Human("Пучков В.С.",42,a4);

        Address a5=new Address("Ульяновск","Ленина",76,2);
        Human h5=new Human("Елизаров К.Г.",53,a5);

        Address a6=new Address("Ульяновск","Ленина",76,2);
        Human h6=new Human("Елизаров К.Г.",53,a6);

        //не дублирующиеся объекты
        Address a7=new Address("Москва","Западная",23,102);
        Human h7=new Human("Абрамян Д.А.",30,a7);

        Address a8=new Address("Санкт-Петербург","Кирова",88,1);
        Human h8=new Human("Фенов М.Д.",25,a8);

        Address a9=new Address("Сызрань","Осенняя",5,67);
        Human h9=new Human("Кутуков А.К.",25,a9);

        Address a10=new Address("Чебоксары","Чебоксарская",115,27);
        Human h10=new Human("Плотников И.П.",48,a10);

        //1. Заполнить ArrayList этими объектами.
        List<Human> listHuman=new ArrayList<>();
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
        System.out.println("--------------------------------------");
        System.out.println("Коллекция с дублями:");

        for (int i = 0; i < listHuman.size(); i++) {
            System.out.println((i+1)+" "+listHuman.get(i));
        }

        //2. Найти дубли в коллекции и вывести их в консоль.
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




        //3. Удалить дубли из коллекции.
        //не понял почему у key тип object и почему у keySet вызывается toArray
        //я бы просто написл key-Human и без toArray сделал
        //и не будет ошибкой вызывать toArray внутри foreach
//        for (Object key : mapHuman.keySet().toArray()) {
//            if (mapHuman.get(key) > 1) {
//                mapHuman.remove(key);
//            }
//        }

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

        //4. Отсортировать людей по ФИО
        ComparatorFio comparatorFio=new ComparatorFio();
        Collections.sort(listHuman, comparatorFio);
        System.out.println("--------------------------------------");
        System.out.println("Выводим коллекцию отсортированную по FIO");
        for (int i = 0; i < listHuman.size(); i++) {
            System.out.println((i+1)+" "+listHuman.get(i));
        }

        //5. Отсортировать людей по возрасту
        ComparatorAge comparatorAge=new ComparatorAge();
        Collections.sort(listHuman, comparatorAge);
        System.out.println("--------------------------------------");
        System.out.println("Выводим коллекцию отсортированную по возрасту");
        for (int i = 0; i < listHuman.size(); i++) {
            System.out.println((i+1)+" "+listHuman.get(i));
        }

        //6. Отсортировать людей по адресу (лексикографическая сортировка полного адреса)
        ComparatorAddress comparatorAddress=new ComparatorAddress();
        Collections.sort(listHuman, comparatorAddress);
        System.out.println("--------------------------------------");
        System.out.println("Выводим коллекцию отсортированную по адресу");
        for (int i = 0; i < listHuman.size(); i++) {
            System.out.println((i+1)+" "+listHuman.get(i));
        }

        //7. Создать класс User добавить в него поля ФИО, и роль которое является перечислением и
        //содержит в себе ADMIN, USER, MODERATOR

        User u1=new User("Шкрыль Андрей", Role.ADMIN);
        User u2=new User("Иванов Иван", Role.USER);
        User u3=new User("Петров Семен", Role.MODERATOR);

        //8. Необходимо написать метод в который входным значением будет являтся объект класса User,
        //метод должен на основании роли пользователя выводить приветственное сообщение, что-то вроде
        //"Приветствуем ФИО с ролью " + ОПИСАНИЕ_РОЛИ
        //описание роли должно вычисляться на основании роли пользователя, запрещено использовать
        //if и switch, а так же описание роли в перечислении.
        System.out.println("--------------------------------------");
        System.out.println("Приветствие пользователей");
        u1.greeting();
        u2.greeting();
        u3.greeting();


        //9. Написать программу сортирующую HashMap по ключу. (Создание и генерация данными какими захотите)
        Map<Integer,String> map=new HashMap<>();
        map.put(11,"Молоко");
        map.put(5,"Батон");
        map.put(3,"Чипсы");
        map.put(42,"Сметана");
        map.put(4,"Абрикосы");
        map.put(6,"Яблоки");
        Map<Integer, String> treeMap = new TreeMap<Integer, String>(map);
        System.out.println("--------------------------------------");
        System.out.println("Выводим map отсортированную по ключу");
        System.out.println(treeMap);

        //10. Написать программу сортирующую HashMap по значнию. (Создание и генерация данными какими захотите)
        //используем туже самую Map<Integer,String> map
        SortedSet<String> sortedSet = new TreeSet<String>(map.values());
        System.out.println("--------------------------------------");
        System.out.println("Выводим map отсортированную по значению");
        System.out.println(sortedSet);

        //11. Заполнить рандомными значениями LinkedList, вывести содержимое каждого элемента и его индекс.
        List<Integer> linkedList = new LinkedList<>();
        Random rnd = new Random();
        for (int i = 0; i < 100; i++) {
            linkedList.add(rnd.nextInt(100));
        }
        System.out.println("--------------------------------------");
        System.out.println("Выводим значения и номера элементов LinkedList");
        for (int i = 0; i < linkedList.size(); i++) {
            System.out.println("Элемент № "+i+" со значением "+linkedList.get(i));


        }
    }


}
