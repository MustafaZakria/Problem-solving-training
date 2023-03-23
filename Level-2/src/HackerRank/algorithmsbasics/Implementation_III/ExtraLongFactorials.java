package HackerRank.algorithmsbasics.Implementation_III;
import java.io.*;
        import java.math.*;
        import java.security.*;
        import java.text.*;
        import java.util.*;
        import java.util.concurrent.*;
        import java.util.function.*;
        import java.util.regex.*;
        import java.util.stream.*;
        import static java.util.stream.Collectors.joining;
        import static java.util.stream.Collectors.toList;

class Result12 {

    /*
     * Complete the 'extraLongFactorials' function below.
     *
     * The function accepts INTEGER n as parameter.
     */

    public static void extraLongFactorials(int n) {
        System.out.println(doFactorial(n));

    }

    private static BigInteger doFactorial(int n) {
        if(n == 1)
            return BigInteger.valueOf(n);
        else
            return  BigInteger.valueOf(n).multiply(doFactorial(n - 1));
    }

}

public class ExtraLongFactorials {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(bufferedReader.readLine().trim());

        Result12.extraLongFactorials(n);

        bufferedReader.close();
    }
}
