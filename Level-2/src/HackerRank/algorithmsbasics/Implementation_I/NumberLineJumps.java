package HackerRank.algorithmsbasics.Implementation_I;

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

class Result3 {

    /*
     * Complete the 'kangaroo' function below.
     *
     * The function is expected to return a STRING.
     * The function accepts following parameters:
     *  1. INTEGER x1
     *  2. INTEGER v1
     *  3. INTEGER x2
     *  4. INTEGER v2
     */

    public static String kangaroo(int x1, int v1, int x2, int v2) {
        if (!(x1 > x2 && v1 > v2) && !(x1 < x2 && v1 < v2)) {

            int sum1 = Math.min(x1, x2), sum2 = Math.max(x1, x2),
                    step1 = Math.max(v1, v2), step2 = Math.min(v1, v2);

            while (sum1 <= sum2) {
                if (sum1 == sum2) {
                    return "YES";
                }
                sum1 += step1;
                sum2 += step2;
            }
        }

        return "NO";
    }

}

public class NumberLineJumps {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));

        String[] firstMultipleInput = bufferedReader.readLine().replaceAll("\\s+$", "").split(" ");

        int x1 = Integer.parseInt(firstMultipleInput[0]);

        int v1 = Integer.parseInt(firstMultipleInput[1]);

        int x2 = Integer.parseInt(firstMultipleInput[2]);

        int v2 = Integer.parseInt(firstMultipleInput[3]);

        String result = Result3.kangaroo(x1, v1, x2, v2);

        bufferedWriter.write(result);
        bufferedWriter.newLine();

        bufferedReader.close();
        bufferedWriter.close();
    }
}
