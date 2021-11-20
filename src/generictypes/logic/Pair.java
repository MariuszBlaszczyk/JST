package generictypes.logic;

import java.util.Objects;

public class Pair<T, V> {

    private T t;
    private V v;

    public Pair(T t, V v) {
        this.t = t;
        this.v = v;
    }

    public T getT() {
        return t;
    }

    public V getV() {
        return v;
    }

    public static <T, V> void printPair(Pair<T, V> pair) {
        System.out.println("<" + pair.getT() + " ; " + pair.getV() + ">");
    }



    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Pair<?, ?> pair = (Pair<?, ?>) o;
        return Objects.equals(t, pair.t) && Objects.equals(v, pair.v);
    }

    @Override
    public int hashCode() {
        return Objects.hash(t, v);
    }

    @Override
    public String toString() {
        return "Pair{" +
                "t=" + t +
                ", v=" + v +
                '}';
    }
}
