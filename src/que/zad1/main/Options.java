package que.zad1.main;

public enum Options {
    EXIT(0, "Wyjście z programu"),
    ADD(1, "Dodaj zadanie"),
    TAKE(2, "Zrób kolejne zadanie");

    private int option;
    private String description;

    Options(int option, String description) {
        this.option = option;
        this.description = description;
    }

    @Override
    public String toString() {
        return option + " - " + description;
    }
}
