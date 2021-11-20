package collections.zad1;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

class Lotto {
    private static final int NO_OF_NUMBERS = 49;
    public static final int MAX_NUMBERS = 6;

    private List<Integer> numbers = new ArrayList<>();
    private List<Integer> lottoResult;

    Lotto() {
        generate();
        randomize();
    }

    List<Integer> getLottoResult() {
        return lottoResult;
    }

    void generate() {
        for (int i = 1; i <= NO_OF_NUMBERS; i++) {
            numbers.add(i);
        }
    }

    void randomize() {
        Collections.shuffle(numbers);
        lottoResult = numbers.subList(0, 6);
    }

    int checkResult(List<Integer> userNumbers) {
        int found = 0;
        for (int i = 0; i < MAX_NUMBERS; i++) {
            if (lottoResult.contains(userNumbers.get(i)))
                found++;
        }
        return found;
    }
}