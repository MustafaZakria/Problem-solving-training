package HackerRank.algorithmsbasics.sorting;

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

class Result9 {

    /*
     * Complete the 'countingSort' function below.
     *
     * The function is expected to return an INTEGER_ARRAY.
     * The function accepts INTEGER_ARRAY arr as parameter.
     */

    public static List<Integer> countingSort(List<Integer> arr) {
        int max = Collections.max(arr) + 1;
        Integer[] tempArray = new Integer[max];
        for (int i = 0; i < max; i++)
            tempArray[i] = 0;
        for (Integer integer : arr)
            tempArray[integer]++;
        for (int k = 1; k < max; k++)
            tempArray[k] += tempArray[k - 1];

        Integer[] result = new Integer[arr.size()];
        for (int l = result.length - 1; l >= 0; l--) {
            result[tempArray[arr.get(l)] - 1] = arr.get(l);
            tempArray[arr.get(l)]--;
        }
        return Arrays.asList(result);
    }

}

public class P9 {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(bufferedReader.readLine().trim());

        List<Integer> arr = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
                .map(Integer::parseInt)
                .collect(toList());

        List<Integer> result = Result9.countingSort(arr);

        bufferedWriter.write(
                result.stream()
                        .map(Object::toString)
                        .collect(joining(" "))
                        + "\n"
        );

        bufferedReader.close();
        bufferedWriter.close();
    }
}

