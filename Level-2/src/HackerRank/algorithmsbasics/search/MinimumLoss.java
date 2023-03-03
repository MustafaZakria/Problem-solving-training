package HackerRank.algorithmsbasics.search;

import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.function.*;
import java.util.regex.*;
import java.util.stream.*;

import static java.lang.Math.toIntExact;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

class Result7 {

    /*
     * Complete the 'minimumLoss' function below.
     *
     * The function is expected to return an INTEGER.
     * The function accepts LONG_INTEGER_ARRAY price as parameter.
     */

    public static int minimumLoss(List<Long> price) {

        long minLoss = Integer.MAX_VALUE;

        ArrayList<Long> p2 = new ArrayList<>(price);

        Collections.sort(p2);


        for (int i = price.size() - 1; i > 0; i--) {
            long a = p2.get(i);
            long b = p2.get(i - 1);
            if (a - b < minLoss && price.indexOf(a) < price.indexOf(b))
                minLoss = a - b;
        }

        return Math.toIntExact(minLoss);
    }

}

public class MinimumLoss {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(bufferedReader.readLine().trim());

        List<Long> price = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
                .map(Long::parseLong)
                .collect(toList());

        int result = Result7.minimumLoss(price);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedReader.close();
        bufferedWriter.close();
    }
}
