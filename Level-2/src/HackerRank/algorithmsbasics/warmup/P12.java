package HackerRank.algorithmsbasics.warmup;

import java.io.*;

import static java.lang.Math.toIntExact;
import static java.util.stream.Collectors.joining;

class Result12 {

    /*
     * Complete the 'superDigit' function below.
     *
     * The function is expected to return an INTEGER.
     * The function accepts following parameters:
     *  1. STRING n
     *  2. INTEGER k
     */

    public static int superDigit(String n, int k) {

        long sum = 0;
        for (int i = 0; i < n.length(); i++)
            sum += Integer.parseInt(String.valueOf(n.charAt(i)));

        sum *= k;
        return calcSuperDigit(sum);
    }

    private static int calcSuperDigit(Long number) {
        if (Long.toString(number).length() == 1)
            return toIntExact(number);

        long temp = 0;
        while (number > 0) {
            temp += (number % 10);
            number /= 10;
        }

        return calcSuperDigit(temp);
    }

}

public class P12 {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));

        String[] firstMultipleInput = bufferedReader.readLine().replaceAll("\\s+$", "").split(" ");

        String n = firstMultipleInput[0];

        int k = Integer.parseInt(firstMultipleInput[1]);

        int result = Result12.superDigit(n, k);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedReader.close();
        bufferedWriter.close();
    }
}
