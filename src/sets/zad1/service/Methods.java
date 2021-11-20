package sets.zad1.service;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;
import java.util.TreeSet;

public class Methods {

    public static TreeSet<String> names(Path path) {
        try {
            List<String> namesList = Files.readAllLines(path, StandardCharsets.UTF_8);
            return new TreeSet<>(namesList);
        } catch (IOException e) {
            throw new IllegalStateException(e.getMessage());
        }
    }

    public static void getInfo(TreeSet<String> set) {
        if (set.isEmpty()) {
            throw new IllegalArgumentException("Set is empty");
        }
        System.out.println("Liczba imion w zbiorze: " + set.size());
        System.out.println("Pierwsze imię: " + set.first());
        System.out.println("Ostatnie imię: " + set.last());
    }
}





