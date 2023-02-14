package HackerRank.algorithmsbasics.warmup;

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

class Result7 {

    /*
     * Complete the 'miniMaxSum' function below.
     *
     * The function accepts INTEGER_ARRAY arr as parameter.
     */

    public static void miniMaxSum(List<Integer> arr) {
        int minIndex = -1,
                maxIndex = -1;
        for (int i = 0; i < arr.size(); i++) {
            if (minIndex == -1 || arr.get(i) < arr.get(minIndex))
                minIndex = i;
            if (maxIndex == -1 || arr.get(i) > arr.get(maxIndex))
                maxIndex = i;
        }

        long sumMin = 0,
                sumMax = 0;
        for (int i = 0; i < arr.size(); i++) {
            if (i != minIndex)
                sumMax += arr.get(i);
            if (i != maxIndex)
                sumMin += arr.get(i);
        }

        System.out.println(sumMin + " " + sumMax);
    }

}

public class P7 {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        List<Integer> arr = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
                .map(Integer::parseInt)
                .collect(toList());

        Result7.miniMaxSum(arr);

        bufferedReader.close();
    }
}
