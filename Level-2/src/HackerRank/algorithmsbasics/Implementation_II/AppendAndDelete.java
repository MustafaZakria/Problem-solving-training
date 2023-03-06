package HackerRank.algorithmsbasics.Implementation_II;

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

class Result8 {

    /*
     * Complete the 'appendAndDelete' function below.
     *
     * The function is expected to return a STRING.
     * The function accepts following parameters:
     *  1. STRING s
     *  2. STRING t
     *  3. INTEGER k
     */

    public static String appendAndDelete(String s, String t, int k) {

        if (k >= (s.length() + t.length()))
            return "Yes";

        int matched = 0;
        for(int i = 0; i < s.length() && i < t.length(); i++) {
            if(s.charAt(i) != t.charAt(i)) {
                break;
            }
            matched++;
        }
        k -= (s.length() - matched);
        int remainingOp = t.length() - matched;
        if(k == remainingOp || (k > remainingOp && (k - remainingOp) % 2 == 0))
            return "Yes";

        return "No";
    }

}

public class AppendAndDelete {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));

        String s = bufferedReader.readLine();

        String t = bufferedReader.readLine();

        int k = Integer.parseInt(bufferedReader.readLine().trim());

        String result = Result8.appendAndDelete(s, t, k);

        bufferedWriter.write(result);
        bufferedWriter.newLine();

        bufferedReader.close();
        bufferedWriter.close();
    }
}
