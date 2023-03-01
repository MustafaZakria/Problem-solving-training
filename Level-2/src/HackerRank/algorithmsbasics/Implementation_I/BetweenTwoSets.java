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

class Result4 {

    /*
     * Complete the 'getTotalX' function below.
     *
     * The function is expected to return an INTEGER.
     * The function accepts following parameters:
     *  1. INTEGER_ARRAY a
     *  2. INTEGER_ARRAY b
     */

    public static int getTotalX(List<Integer> a, List<Integer> b) {
        int max = Collections.max(a);
        int min = Collections.min(b);

        List<Integer> result = new ArrayList<>();

        for(int i = max; i <= min; i++)
            result.add(i);


        //for array a
        for(int i = 0; i < result.size(); i++) {
            for (Integer integer : a) {
                if (result.get(i) % integer != 0) {
                    result.set(i, -1);
                    break;
                }

            }
        }

        int counter = 0;
        //for array b
        for(int i = 0; i < result.size(); i++) {
            if(result.get(i) != -1) {
                for (Integer element : b) {
                    if (element % result.get(i) != 0) {
                        result.set(i, -1);
                        break;
                    }
                }
                if(result.get(i) != -1)
                    counter++;
            }
        }

        return counter;
    }

}

public class BetweenTwoSets {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));

        String[] firstMultipleInput = bufferedReader.readLine().replaceAll("\\s+$", "").split(" ");

        int n = Integer.parseInt(firstMultipleInput[0]);

        int m = Integer.parseInt(firstMultipleInput[1]);

        List<Integer> arr = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
                .map(Integer::parseInt)
                .collect(toList());

        List<Integer> brr = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
                .map(Integer::parseInt)
                .collect(toList());

        int total = Result4.getTotalX(arr, brr);

        bufferedWriter.write(String.valueOf(total));
        bufferedWriter.newLine();

        bufferedReader.close();
        bufferedWriter.close();
    }
}
