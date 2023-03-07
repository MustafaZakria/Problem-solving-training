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

class Result7 {

    /*
     * Complete the 'stones' function below.
     *
     * The function is expected to return an INTEGER_ARRAY.
     * The function accepts following parameters:
     *  1. INTEGER n
     *  2. INTEGER a
     *  3. INTEGER b
     */

    public static List<Integer> stones(int n, int a, int b) {
        int firstElem = (n - 1) * a;
        int diff = b - a;

        List<Integer> result = new ArrayList<>();

        for(int i = 0; i < n; i++) {
            result.add(firstElem);
            firstElem += diff;
        }

        result = result.stream().distinct().collect(
                Collectors.toList());
        Collections.sort(result);
        return result;
    }

//    public static List<Integer> stones(int n, int a, int b) {
//
//        List<Integer> list = getResult(n, a, b, new ArrayList<>(), 0);
//        return list.stream().distinct().collect(
//                Collectors.toList());
//    }
//
//    private static List<Integer> getResult(int n, int a, int b, List<Integer> list, int result) {
//        if (n == 1)
//            return Arrays.asList(result);
//
//        list.addAll(getResult(n - 1, a, b, new ArrayList<>(), result + a));
//        list.addAll(getResult(n - 1, a, b, new ArrayList<>(), result + b));
//
//        return list;
//    }

}

public class ManasaAndStones {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));

        int T = Integer.parseInt(bufferedReader.readLine().trim());

        IntStream.range(0, T).forEach(TItr -> {
            try {
                int n = Integer.parseInt(bufferedReader.readLine().trim());

                int a = Integer.parseInt(bufferedReader.readLine().trim());

                int b = Integer.parseInt(bufferedReader.readLine().trim());

                List<Integer> result = Result7.stones(n, a, b);

                bufferedWriter.write(
                        result.stream()
                                .map(Object::toString)
                                .collect(joining(" "))
                                + "\n"
                );
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        });

        bufferedReader.close();
        bufferedWriter.close();
    }
}
