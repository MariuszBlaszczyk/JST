package packagingtypes.zad1;

import java.math.BigInteger;

public class App {

    static int add(int... numbers) {
        int sum = 0;
        for (int value : numbers) {
            sum += value;
        }
        return sum;
    }

    static BigInteger addBI(BigInteger... numbers) {
        BigInteger result = BigInteger.ZERO;
        for (BigInteger value : numbers) {
            result = result.add(value);
        }
        return result;
    }

    public static void main(String[] args) {

        int a = 123;
        int b = 1234;
        int c = 12345;
        BigInteger bi = new BigInteger("123456789123456789");
        BigInteger bi2 = new BigInteger("987654321987654321");

        int result1 = add(a, b, c);
        BigInteger result2 = addBI(bi, bi2);

        System.out.println("int = " + result1);
        System.out.println("BI = " + result2);

    }
}
