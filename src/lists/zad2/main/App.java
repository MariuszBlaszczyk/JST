package lists.zad2.main;

import lists.zad2.service.Methods;


import java.util.List;

public class App {

    public static void main(String[] args) {

        List<Integer> numbers = Methods.returnList();
        Methods.showStatistic(numbers);
    }
}
