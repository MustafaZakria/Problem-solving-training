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

class Result11 {

    /*
     * Complete the 'climbingLeaderboard' function below.
     *
     * The function is expected to return an INTEGER_ARRAY.
     * The function accepts following parameters:
     *  1. INTEGER_ARRAY ranked
     *  2. INTEGER_ARRAY player
     */

    public static List<Integer> climbingLeaderboard(List<Integer> ranked, List<Integer> player) {

        Map<Integer, Integer> hash = new HashMap<>();
        int count = 1;
        for (int r : ranked) {
            if (!hash.containsKey(r)) {
                hash.put(r, count);
                count++;
            }
        }
        System.out.println(hash.toString());
        List<Integer> result = new ArrayList<>();
        for (Integer integer : player) {
            int rank = getRank(hash, ranked, integer);
            result.add(rank);
        }

        return result;
    }

    private static int getRank(Map<Integer, Integer> hash, List<Integer> ranked, Integer integer) {
        int start = 0,
                end = ranked.size() - 1,
                mid,
                rank = 0;

        while (end >= start) {
            mid = (start + end) / 2;
            rank = ranked.get(mid);
            if (Objects.equals(rank, integer)) {
                return hash.get(rank);
            } else if (rank > integer) {
                start = mid + 1;
            } else {
                end = mid - 1;
            }
        }

        if(integer < rank) {
            return hash.get(rank) + 1;
        }
        return hash.get(rank);
    }

}

public class ClimbingTheLeaderboard {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));

        int rankedCount = Integer.parseInt(bufferedReader.readLine().trim());

        List<Integer> ranked = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
                .map(Integer::parseInt)
                .collect(toList());

        int playerCount = Integer.parseInt(bufferedReader.readLine().trim());

        List<Integer> player = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
                .map(Integer::parseInt)
                .collect(toList());

        List<Integer> result = Result11.climbingLeaderboard(ranked, player);

        bufferedWriter.write(
                result.stream()
                        .map(Object::toString)
                        .collect(joining("\n"))
                        + "\n"
        );

        bufferedReader.close();
        bufferedWriter.close();
    }
}
