package shkryl.task3;

import java.util.*;

/**
 * Утилитарный класс для работы с коллекцией
 */
public class Helper {
    /**
     * Заполняет коллекцию значениями
     *
     * @param listHuman коллекция Human для заполнения
     */
    public void fillList(List<Human> listHuman) {
        //три дубля как по условию задачи
        Address address1 = new Address("Тольятти", "Ленинградская", 43, 45);
        Human human1 = new Human("Шкрыль А.А.", 37, address1);

        Address address2 = new Address("Тольятти", "Ленинградская", 43, 45);
        Human human2 = new Human("Шкрыль А.А.", 37, address2);

        Address address3 = new Address("Самара", "Мира", 13, 15);
        Human human3 = new Human("Пучков В.С.", 42, address3);

        Address address4 = new Address("Самара", "Мира", 13, 15);
        Human human4 = new Human("Пучков В.С.", 42, address4);

        Address address5 = new Address("Ульяновск", "Ленина", 76, 2);
        Human human5 = new Human("Елизаров К.Г.", 53, address5);

        Address address6 = new Address("Ульяновск", "Ленина", 76, 2);
        Human human6 = new Human("Елизаров К.Г.", 53, address6);

        //не дублирующиеся объекты
        Address address7 = new Address("Москва", "Западная", 23, 102);
        Human human7 = new Human("Абрамян Д.А.", 30, address7);

        Address address8 = new Address("Санкт-Петербург", "Кирова", 88, 1);
        Human human8 = new Human("Фенов М.Д.", 25, address8);

        Address address9 = new Address("Сызрань", "Осенняя", 5, 67);
        Human human9 = new Human("Кутуков А.К.", 25, address9);

        Address address10 = new Address("Чебоксары", "Чебоксарская", 115, 27);
        Human human10 = new Human("Плотников И.П.", 48, address10);

        listHuman.add(human1);
        listHuman.add(human2);
        listHuman.add(human3);
        listHuman.add(human4);
        listHuman.add(human5);
        listHuman.add(human6);
        listHuman.add(human7);
        listHuman.add(human8);
        listHuman.add(human9);
        listHuman.add(human10);

    }

    /**
     * Определяет дубликаты в коллекции
     *
     * @param listHuman коллекция Human для поиска дубликатов
     * @return возвращает коллекцию Human содержащую дубли
     */
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

    /**
     * Опредаляет дубликаты в коллекции используя Map
     *
     * @param listHuman коллекция Human для поиска дубликатов
     * @return возращает коллекцию Map, где в качестве ключа содержиться количество элементов
     */
    public Map<Human, Integer> getDuplicateWithMap(List<Human> listHuman) {
        Map<Human, Integer> mapHuman = new HashMap<>();
        for (Human h : listHuman) {
            mapHuman.put(h, mapHuman.get(h) == null ? 1 : mapHuman.get(h) + 1);

        }
        System.out.println("--------------------------------------");
        System.out.println("Выводим дубли коллекции");
        for (Map.Entry<Human, Integer> entry : mapHuman.entrySet()) {
            if (entry.getValue() > 1) {
                System.out.println(entry.getKey());
            }
        }
        return mapHuman;
    }

    /**
     * Удаляет из коллекции дубли и выводит их на экран
     *
     * @param listHuman коллекция Human для удаления в ней дубликатов
     * @param mapHuman  коллекция, содержащая количество дублей для каждого элемента, если они есть
     */
    public void printWithoutDublicate(List<Human> listHuman, Map<Human, Integer> mapHuman) {

        for (Map.Entry<Human, Integer> entry : mapHuman.entrySet()) {
            if (entry.getValue() > 1) {
                Human h = entry.getKey();
                listHuman.remove(h);
            }
        }

        System.out.println("--------------------------------------");
        System.out.println("Выводим коллекцию без дублей(они удалены)");
        for (int i = 0; i < listHuman.size(); i++) {
            System.out.println((i + 1) + " " + listHuman.get(i));
        }
    }

    /**
     * Сортировка коллекции по ФИО
     *
     * @param listHuman сортируемая коллекция
     */
    public void sortHumanFio(List<Human> listHuman) {
        ComparatorFio comparatorFio = new ComparatorFio();
        Collections.sort(listHuman, comparatorFio);
        System.out.println("--------------------------------------");
        System.out.println("Выводим коллекцию отсортированную по FIO");
        for (int i = 0; i < listHuman.size(); i++) {
            System.out.println((i + 1) + " " + listHuman.get(i));
        }
    }

    /**
     * Сортировка по Возрасту
     *
     * @param listHuman сортируемая коллекция
     */
    public void sortHumanAge(List<Human> listHuman) {
        ComparatorAge comparatorAge = new ComparatorAge();
        Collections.sort(listHuman, comparatorAge);
        System.out.println("--------------------------------------");
        System.out.println("Выводим коллекцию отсортированную по возрасту");
        for (int i = 0; i < listHuman.size(); i++) {
            System.out.println((i + 1) + " " + listHuman.get(i));
        }
    }

    /**
     * Сортировка по Адресу
     *
     * @param listHuman сортируемая коллекция
     */
    public void sortHumanAddress(List<Human> listHuman) {
        ComparatorAddress comparatorAddress = new ComparatorAddress();
        Collections.sort(listHuman, comparatorAddress);
        System.out.println("--------------------------------------");
        System.out.println("Выводим коллекцию отсортированную по адресу");
        for (int i = 0; i < listHuman.size(); i++) {
            System.out.println((i + 1) + " " + listHuman.get(i));
        }
    }

    /**
     * Заполняет коллекцию Map значениями и сортирует ее по ключу
     *
     * @param map сортируемая коллекция Map
     */
    public void fillAndsortMapOnKey(Map<Integer, String> map) {
        map.put(11, "Молоко");
        map.put(5, "Батон");
        map.put(3, "Чипсы");
        map.put(42, "Сметана");
        map.put(4, "Абрикосы");
        map.put(6, "Яблоки");
        Map<Integer, String> treeMap = new TreeMap<Integer, String>(map);
        System.out.println("--------------------------------------");
        System.out.println("Выводим map отсортированную по ключу");
        System.out.println(treeMap);
    }

    /**
     * Сортирует коллекцию Map по значению
     *
     * @param map сортируемая коллекция Map
     */
    public void sortMapOnvalue(Map<Integer, String> map) {
        SortedSet<String> sortedSet = new TreeSet<String>(map.values());
        System.out.println("--------------------------------------");
        System.out.println("Выводим map отсортированную по значению");
        System.out.println(sortedSet);
    }

    /**
     * Создает LinkedList, заполняет его значениями и выводт значения коллекции на экран
     */
    public void generateLinkedList() {
        List<Integer> linkedList = new LinkedList<>();
        Random rnd = new Random();
        for (int i = 0; i < 100; i++) {
            linkedList.add(rnd.nextInt(100));
        }
        System.out.println("--------------------------------------");
        System.out.println("Выводим значения и номера элементов LinkedList");
        for (int i = 0; i < linkedList.size(); i++) {
            System.out.println("Элемент № " + i + " со значением " + linkedList.get(i));
        }
    }

}
