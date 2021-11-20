package iterator.zad1.main;

import java.util.Collection;
import java.util.Iterator;
import java.util.Map;
import java.util.TreeMap;

public class App {

    public static void main(String[] args) {

        Map<String, Person> personMap = new TreeMap<>();

        personMap.put("Lewandowski", new Person("Robert", "Lewandowski", 32));
        personMap.put("Milik", new Person("Arkadiusz", "Milik", 27));
        personMap.put("Glik", new Person("Kamil", "Glik", 35));
        personMap.put("Piszczek", new Person("Łukasz", "Piszczek", 40));
        personMap.put("Fabiański", new Person("Łukasz", "Fabiański", 23));

        Collection<Person> values = personMap.values();
        Iterator<Person> iterator = values.iterator();
        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }

    }
}
