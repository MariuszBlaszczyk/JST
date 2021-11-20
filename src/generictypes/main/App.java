package generictypes.main;

import generictypes.logic.Pair;

public class App {

    public static void main(String[] args) {

        Pair<String, String> pair1 = new Pair<>("Adam", "Ewa");
        Pair<Integer, Integer> pair2 = new Pair<>(12, 15);
        Pair<Double, Double> pair3 = new Pair<>(11.1, 15.5);
        Pair<String, Integer> pair4 = new Pair<>("Jan", 2000);

        System.out.println(pair1.getT() + " " + pair1.getV());
        System.out.println(pair2.getT() + pair2.getV());
        System.out.println(pair3.getV() - pair3.getT());

        Pair.printPair(pair1);
        Pair.printPair(pair4);
    }
}
