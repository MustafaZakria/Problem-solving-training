package HackerRank.algorithmsbasics.sorting;

import java.io.*;
import java.util.*;
import java.util.stream.*;

import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

class Result3 {

    /*
     * Complete the 'insertionSort1' function below.
     *
     * The function accepts following parameters:
     *  1. INTEGER n
     *  2. INTEGER_ARRAY arr
     */

    public static void insertionSort1(int n, List<Integer> arr) {

        for (int i = 1; i < n; i++) {
            int temp = arr.get(i);
            int j;
            for (j = i - 1; j >= 0; j--) {
                if (arr.get(j) > temp) {
                    arr.set(j + 1, arr.get(j));
                    printArray(arr);
                } else {
                    break;
                }
            }
            arr.set(j + 1, temp);
        }
        printArray(arr);

    }

    public static void printArray(List<Integer> arr) {
        for (Integer integer : arr) {
            System.out.print(integer + " ");
        }
        System.out.println();
    }

}

public class InsertionSort1 {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(bufferedReader.readLine().trim());

        List<Integer> arr = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
                .map(Integer::parseInt)
                .collect(toList());

        Result3.insertionSort1(n, arr);

        bufferedReader.close();
    }
}
