package sets.zad2.logic;

public enum EvaluatedOption {
    DISCARD_PRODUCT(0), REPLACE_PRODUCT(1);

    private int value;

    EvaluatedOption(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }

    public static EvaluatedOption fromValue(int userOption) {
        EvaluatedOption[] options = values();
        for (EvaluatedOption option : options) {
            if (option.getValue() == userOption) {
                return option;
            }
        }
        return null;
    }

    @Override
    public String toString() {
        return "EvaluatedOption{" +
                "value=" + value +
                '}';
    }
}
