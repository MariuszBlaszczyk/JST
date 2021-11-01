package writingandreadingafile.zad1.logic;

import abstraction.zad1.model.ShapeChoose;

public enum Read {

    FROM_USER(1), FROM_FILE(2);

    private int value;

    Read(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }

    public static Read fromValue(int userValue) {
        Read[] values = values();
        for (Read value : values) {
            if (value.getValue() == userValue)
                return value;
        }
        return null;
    }


    @Override
    public String toString() {
        return "Read{" +
                "value=" + value +
                '}';
    }
}
