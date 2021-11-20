package comparator.zad1.main;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Random;

public class App {

    static int generateNumber() {
        return new Random().nextInt(101);
    }

    static Integer[] createArray() {
        Integer[] array = new Integer[20];
        for (int i = 0; i < array.length; i++) {
            array[i] = generateNumber();
        }
        return array;
    }

    public static void main(String[] args) {

        Integer[] intArray = createArray();

        System.out.println("NIEPOSORTOWANA");
        System.out.println(Arrays.toString(intArray));

        Arrays.sort(intArray);
        System.out.println("POSORTOWANA ROSNĄCO");
        System.out.println(Arrays.toString(intArray));

        Arrays.sort(intArray, new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return Integer.compare(o2,o1);
            }
        });
        System.out.println("POSORTOWANA MALEJĄCO");
        System.out.println(Arrays.toString(intArray));
    }
}
