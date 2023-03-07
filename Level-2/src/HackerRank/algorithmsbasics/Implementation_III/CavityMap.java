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

class Result6 {

    /*
     * Complete the 'cavityMap' function below.
     *
     * The function is expected to return a STRING_ARRAY.
     * The function accepts STRING_ARRAY grid as parameter.
     */

    public static List<String> cavityMap(List<String> grid) {

        for(int i = 1; i < grid.size() - 1; i++) {
            String str = grid.get(i);
            for(int j = 1; j < str.length() - 1; j++) {
                int target = str.charAt(j) - '0';
                int top = grid.get(i + 1).charAt(j) - '0';
                int bottom = grid.get(i - 1).charAt(j) - '0';
                int right = str.charAt(j + 1) - '0';
                int left = str.charAt(j - 1) - '0';

                if(target > top && target > bottom && target > right && target > left) {

                    str = str.substring(0, j) + 'X' + str.substring(j + 1);
                    grid.set(i, str);
                }
            }
        }
        return grid;
    }

}


public class CavityMap {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(bufferedReader.readLine().trim());

        List<String> grid = IntStream.range(0, n).mapToObj(i -> {
                    try {
                        return bufferedReader.readLine();
                    } catch (IOException ex) {
                        throw new RuntimeException(ex);
                    }
                })
                .collect(toList());

        List<String> result = Result6.cavityMap(grid);

        bufferedWriter.write(
                result.stream()
                        .collect(joining("\n"))
                        + "\n"
        );

        bufferedReader.close();
        bufferedWriter.close();
    }
}
