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

class Result1 {

    /*
     * Complete the 'bigSorting' function below.
     *
     * The function is expected to return a STRING_ARRAY.
     * The function accepts STRING_ARRAY unsorted as parameter.
     */


    public static List<String> bigSorting(List<String> unsorted) {

        unsorted.sort(new Comparator<Object>() {

            @Override
            public int compare(Object o1, Object o2) {

                String a = (String) o1;
                String b = (String) o2;

                if (a.length() > b.length()) {
                    return 1;
                } else if (b.length() > a.length()) {
                    return -1;
                }

                for (int i = 0; i < a.length(); i++) {
                    if (a.charAt(i) > b.charAt(i)) {
                        return 1;
                    } else if (a.charAt(i) < b.charAt(i)) {
                        return -1;
                    }

                }
                return 0;
            }
        });
        return unsorted;
    }

}

public class P1 {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(bufferedReader.readLine().trim());

        List<String> unsorted = IntStream.range(0, n).mapToObj(i -> {
                    try {
                        return bufferedReader.readLine();
                    } catch (IOException ex) {
                        throw new RuntimeException(ex);
                    }
                })
                .collect(toList());

        List<String> result = Result1.bigSorting(unsorted);

        bufferedWriter.write(
                result.stream()
                        .collect(joining("\n"))
                        + "\n"
        );

        bufferedReader.close();
        bufferedWriter.close();
    }
}

