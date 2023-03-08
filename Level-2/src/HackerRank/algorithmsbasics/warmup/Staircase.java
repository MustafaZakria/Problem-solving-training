package HackerRank.algorithmsbasics.warmup;

import java.io.*;

import static java.util.stream.Collectors.joining;

class Result6 {

    /*
     * Complete the 'staircase' function below.
     *
     * The function accepts INTEGER n as parameter.
     */

    public static void staircase(int n) {
        for (int i = 0; i < n; i++) {
            int noOfStairs = (i + 1);
            for (int j = 0; j < n; j++) {
                if (j >= n - noOfStairs)
                    System.out.print("#");
                else
                    System.out.print(" ");
            }
            System.out.println();
        }

    }

}

public class Staircase {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(bufferedReader.readLine().trim());

        Result6.staircase(n);

        bufferedReader.close();
    }
}
