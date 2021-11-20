package sets.zad2.logic;

public enum UserChoose {
    ADD_PRODUCT(0), EXIT(1);

    private int value;

    UserChoose(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }

    public static UserChoose fromValue(int userNumber) {
        UserChoose[] values = values();
        for (UserChoose options : values) {
            if (options.getValue() == userNumber) {
                return options;
            }
        }
        throw new IllegalStateException("Error option");
    }

    @Override
    public String toString() {
        return "userChoose{" +
                "value=" + value +
                '}';
    }
}
