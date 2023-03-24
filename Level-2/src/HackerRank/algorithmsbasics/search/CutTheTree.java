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

class Result12 {

    /*
     * Complete the 'cutTheTree' function below.
     *
     * The function is expected to return an INTEGER.
     * The function accepts following parameters:
     *  1. INTEGER_ARRAY data
     *  2. 2D_INTEGER_ARRAY edges
     */

    public static int cutTheTree(List<Integer> data, List<List<Integer>> edges) {

        int n = data.size();

        int totalSum = 0;
        for(int d : data) {
            totalSum += d;
        }

        List<Integer>[] adjList = new List[n];
        for( int i = 0; i < n; i++) {
            adjList[i] = new ArrayList<>();
        }

        for(List<Integer> edge : edges) {
            int u = edge.get(0) - 1;
            int v = edge.get(1) - 1;
            adjList[u].add(v);
            adjList[v].add(u);
        }

        Boolean[] visited = new Boolean[n];
        for(int i = 0 ; i < n; i++) {
            visited[i] = false;
        }
        int[] subtreeSum = new int[n];
        dfs(data, subtreeSum, visited, adjList, 0);

        int min = Integer.MAX_VALUE;
        for (int i = 1; i < n; i++) {
            int temp = Math.abs(totalSum - 2 * subtreeSum[i]);
            if(temp < min) {
                min = temp;
            }
        }

        return min;
    }

    private static void dfs(List<Integer> data, int[] subtreeSum, Boolean[] visited, List<Integer>[] adjList, int i) {
        visited[i] = true;
        subtreeSum[i] += data.get(i);

        for(int neighbour : adjList[i]) {
            if(!visited[neighbour]) {
                dfs(data, subtreeSum, visited, adjList, neighbour);
                subtreeSum[i] += subtreeSum[neighbour];
            }
        }
    }

}

public class CutTheTree {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(bufferedReader.readLine().trim());

        List<Integer> data = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
                .map(Integer::parseInt)
                .collect(toList());

        List<List<Integer>> edges = new ArrayList<>();

        IntStream.range(0, n - 1).forEach(i -> {
            try {
                edges.add(
                        Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
                                .map(Integer::parseInt)
                                .collect(toList())
                );
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        });

        int result = Result12.cutTheTree(data, edges);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedReader.close();
        bufferedWriter.close();
    }
}
