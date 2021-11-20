package maps.zad1.logic;

public enum Options {
    EXIT(0), ADD_EMPLOYEE(1), FIND_EMPLOYEE(2);

    private int value;

    Options(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }

    public static Options getOptionsFromUser(int userOption) {
        if (userOption < 0) {
            throw new IllegalArgumentException("User number error");
        }
        Options[] options = values();
        for (Options option : options) {
            if (option.getValue() == userOption) {
                return option;
            }
        }
        return null;
    }

    @Override
    public String toString() {
        return "Value: " + value;
    }
}
