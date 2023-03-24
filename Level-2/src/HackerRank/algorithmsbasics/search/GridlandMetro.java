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

import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

class Result5 {

    /*
     * Complete the 'gridlandMetro' function below.
     *
     * The function is expected to return an INTEGER.
     * The function accepts following parameters:
     *  1. INTEGER n
     *  2. INTEGER m
     *  3. INTEGER k
     *  4. 2D_INTEGER_ARRAY track
     */

    public static long gridlandMetro(int n, int m, int k, List<List<Integer>> track) {
        long totalCells = (long) n * m;
        long totalBusyCells = 0;

        Map<Integer, List<int[]>> map = new HashMap<>();
        for (List<Integer> t : track) {
            int r = t.get(0);
            int c1 = t.get(1);
            int c2 = t.get(2);

            if (!map.containsKey(r)) {
                map.put(r, new ArrayList<>());
            }
            map.get(r).add(new int[]{c1, c2});
        }

        for (int r : map.keySet()) {
            List<int[]> intervals = mergeIntervals(map.get(r));
            for (int[] interval : intervals) {
                totalBusyCells += interval[1] - interval[0] + 1;
            }
        }

        return totalCells - totalBusyCells;
    }

    private static List<int[]> mergeIntervals(List<int[]> intervals) {
        if (intervals == null || intervals.size() == 0) {
            return new ArrayList<>();
        }

        Collections.sort(intervals, (a, b) -> a[0] - b[0]);
        List<int[]> merged = new ArrayList<>();
        merged.add(intervals.get(0));

        for (int i = 1; i < intervals.size(); i++) {
            int[] curr = intervals.get(i);
            int[] last = merged.get(merged.size() - 1);

            if (curr[0] <= last[1]) {
                last[1] = Math.max(last[1], curr[1]);
            } else {
                merged.add(curr);
            }
        }

        return merged;
    }

}

public class GridlandMetro {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));

        String[] firstMultipleInput = bufferedReader.readLine().replaceAll("\\s+$", "").split(" ");

        int n = Integer.parseInt(firstMultipleInput[0]);

        int m = Integer.parseInt(firstMultipleInput[1]);

        int k = Integer.parseInt(firstMultipleInput[2]);

        List<List<Integer>> track = new ArrayList<>();

        IntStream.range(0, k).forEach(i -> {
            try {
                track.add(
                        Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
                                .map(Integer::parseInt)
                                .collect(toList())
                );
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        });

        long result = Result5.gridlandMetro(n, m, k, track);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedReader.close();
        bufferedWriter.close();
    }
}
