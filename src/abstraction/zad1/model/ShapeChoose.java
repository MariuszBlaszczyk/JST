package abstraction.zad1.model;

public enum ShapeChoose {
    RECTANGLE(0), CIRCLE(1), TRIANGLE(2);

    private int value;

    ShapeChoose(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }

    public static ShapeChoose fromValue(int userValue) {
        ShapeChoose[] values = values();
        for (ShapeChoose size : values) {
            if (size.getValue() == userValue)
                return size;
        }
        return null;
    }

    @Override
    public String toString() {
        return "ShapeChoose{" +
                "value=" + value +
                '}';
    }
}
