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

        List<Long> copy = new ArrayList<>(price);
        Collections.sort(copy);

        HashMap<Long, Integer> hashCopy = new HashMap<>();
        for(int i = 0; i < copy.size(); i++) {
            hashCopy.put(copy.get(i), i);
        }

        List<Long> result = new ArrayList<>();
        for(Long p : price) {
            if(!Objects.equals(p, copy.get(0))) {
                int index = hashCopy.get(p) - 1;
//                while(!hashCopy.containsValue(index) && index > 0) {
//                    index--;
//                }
//                if(hashCopy.containsValue(index))
//                    result.add(p - copy.get(index));
                if(index >= 0) {
                    System.out.println(p + "-" + copy.get(index) + "=" + (p - copy.get(index)));
                    System.out.println(index);
                    result.add(p - copy.get(index));
                }
            }
            copy.remove(p);
            hashCopy.remove(p);
            System.out.println(copy.toString());
        }

        System.out.println(result);
        return toIntExact(Collections.min(result));
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
