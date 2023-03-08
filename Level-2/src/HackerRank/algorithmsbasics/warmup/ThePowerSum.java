package HackerRank.algorithmsbasics.warmup;

import java.io.*;

import static java.util.stream.Collectors.joining;

class Result10 {

    /*
     * Complete the 'powerSum' function below.
     *
     * The function is expected to return an INTEGER.
     * The function accepts following parameters:
     *  1. INTEGER X
     *  2. INTEGER N
     */
    public static int powerSum(int X, int N) {

        return calcResult(X, N, 1, 0, 0);
    }

    private static int calcResult(int x, int n, int counter, int carry, int result) {
        int sum = carry + (int) Math.pow(counter, n);
        if(sum == x)
            return 1;
        if(sum > x)
            return 0;

        result += calcResult(x, n, counter+1, sum, 0);
        result += calcResult(x, n, counter+1, carry, 0);

        return result;
    }

}

public class ThePowerSum {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));

        int X = Integer.parseInt(bufferedReader.readLine().trim());

        int N = Integer.parseInt(bufferedReader.readLine().trim());

        int result = Result10.powerSum(X, N);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedReader.close();
        bufferedWriter.close();

    }
}
