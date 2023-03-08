package HackerRank.algorithmsbasics.warmup;

import java.io.*;
import java.util.*;
import java.util.stream.*;

import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

class Result5 {

    /*
     * Complete the 'plusMinus' function below.
     *
     * The function accepts INTEGER_ARRAY arr as parameter.
     */

    public static void plusMinus(List<Integer> arr) {
        int posCount = 0,
                negCount = 0;
        for (int i = 0; i < arr.size(); i++) {
            if (arr.get(i) > 0)
                posCount++;
            else if (arr.get(i) < 0)
                negCount++;
        }
        int zeroCount = arr.size() - (posCount + negCount);
        System.out.printf("%.6f", (double) posCount / arr.size());
        System.out.println();
        System.out.printf("%.6f", (double) negCount / arr.size());
        System.out.println();
        System.out.printf("%.6f", (double) zeroCount / arr.size());

    }

}

public class PlusMinus {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(bufferedReader.readLine().trim());

        List<Integer> arr = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
                .map(Integer::parseInt)
                .collect(toList());

        Result5.plusMinus(arr);

        bufferedReader.close();
    }
}
