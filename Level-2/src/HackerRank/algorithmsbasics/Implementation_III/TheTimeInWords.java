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

class Result18 {

    /*
     * Complete the 'timeInWords' function below.
     *
     * The function is expected to return a STRING.
     * The function accepts following parameters:
     *  1. INTEGER h
     *  2. INTEGER m
     */

    public static String timeInWords(int h, int m) {

        if (m == 0) {
            return getMapping(h, false) + " o' clock";
        } else if (m <= 30) {
            return getMapping(m, true) + " past " + getMapping(h, false);
        } else {
            return getMapping(60 - m, true) + " to " + getMapping(h + 1, false);
        }

    }

    public static String getMapping(int number, boolean isMinutes) {
        String result = switch (number) {
            case 1 -> "one";
            case 2 -> "two";
            case 3 -> "three";
            case 4 -> "four";
            case 5 -> "five";
            case 6 -> "six";
            case 7 -> "seven";
            case 8 -> "eight";
            case 9 -> "nine";
            case 10 -> "ten";
            case 11 -> "eleven";
            case 12 -> "twelve";
            case 13 -> "thirteen";
            case 14 -> "fourteen";
            case 15 -> "quarter";
            case 16 -> "sixteen";
            case 17 -> "seventeen";
            case 18 -> "eighteen";
            case 19 -> "nineteen";
            case 20 -> "twenty";
            case 21 -> "twenty one";
            case 22 -> "twenty two";
            case 23 -> "twenty three";
            case 24 -> "twenty four";
            case 25 -> "twenty five";
            case 26 -> "twenty six";
            case 27 -> "twenty seven";
            case 28 -> "twenty eight";
            case 29 -> "twenty nine";
            case 30 -> "half";
            default -> "";
        };
        if(isMinutes && number != 15 && number != 30) {
            result += " minute";
            if(number != 1) {
                result += "s";
            }
        }
        return result;
    }

}

public class TheTimeInWords {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));

        int h = Integer.parseInt(bufferedReader.readLine().trim());

        int m = Integer.parseInt(bufferedReader.readLine().trim());

        String result = Result18.timeInWords(h, m);

        bufferedWriter.write(result);
        bufferedWriter.newLine();

        bufferedReader.close();
        bufferedWriter.close();
    }
}
