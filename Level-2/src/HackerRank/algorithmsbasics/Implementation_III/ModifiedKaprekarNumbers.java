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

class Result2 {

    /*
     * Complete the 'kaprekarNumbers' function below.
     *
     * The function accepts following parameters:
     *  1. INTEGER p
     *  2. INTEGER q
     */

    public static void kaprekarNumbers(int p, int q) {
        String result = "";

        for (int i = p; i <= q; i++) {
            int len = Integer.toString(i).length();
            long pow =(long) Math.pow(i, 2);

            int lenPow = Long.toString(pow).length();

            String l = Long.toString(pow).substring(0, lenPow - len);
            String r = Long.toString(pow).substring(lenPow - len, lenPow);

            int sum = Integer.parseInt(r);
            if(!l.equals(""))
                sum += Integer.parseInt(l);

            if(sum == i)
                result += (i + " ");
        }

        if(result.equals(""))
            System.out.println("INVALID RANGE");
        else
            System.out.println(result);
    }
//1 9 45 55 99 297 703 999 2223 2728 4950 5050 7272 7777 9999 17344 22222 77778 82656 95121 99999
//1 9 45 55 99 297 703 999 2223 2728 4950 5050 7272 7777 9999 17344 22222
}

public class ModifiedKaprekarNumbers {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        int p = Integer.parseInt(bufferedReader.readLine().trim());

        int q = Integer.parseInt(bufferedReader.readLine().trim());

        Result2.kaprekarNumbers(p, q);

        bufferedReader.close();
    }
}
