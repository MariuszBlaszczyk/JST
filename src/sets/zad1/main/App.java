package sets.zad1.main;

import sets.zad1.service.Methods;

import java.nio.file.Path;
import java.util.Collection;
import java.util.Collections;
import java.util.TreeSet;

public class App {

    public static void main(String[] args) {

        String filename = "src/sets/zad1/names.txt";

        TreeSet<String> names = Methods.names(Path.of(filename));
        System.out.println(names);
        Methods.getInfo(names);



        TreeSet<String> namesReverse = (TreeSet<String>) names.descendingSet();
        System.out.println(namesReverse);
        Methods.getInfo(namesReverse);
    }
}
