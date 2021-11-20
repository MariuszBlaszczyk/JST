package packagingtypes.zad1;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.math.BigInteger;

public class Main {

    public static void main(String[] args) {

        final String filename = "src/packagingtypes/zad1/numbers.txt";

        try
                (FileReader fr = new FileReader(filename);
                 BufferedReader br = new BufferedReader(fr);
                ) {
            int a = Integer.parseInt(br.readLine());
            int b = Integer.parseInt(br.readLine());
            int c = Integer.parseInt(br.readLine());
            BigInteger bi1 = new BigInteger(br.readLine());
            BigInteger bi2 = new BigInteger(br.readLine());
            System.out.println("a + b + c = " + (a + b + c));
            System.out.println("bi1 + bi2 = " + (bi1.add(bi2)));
        } catch (IOException e) {
            System.out.println(e.getMessage());
            ;
        }
    }
}
