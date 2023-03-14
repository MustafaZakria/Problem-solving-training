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

class Result16 {

    /*
     * Complete the 'encryption' function below.
     *
     * The function is expected to return a STRING.
     * The function accepts STRING s as parameter.
     */

    public static String encryption(String s) {

        int charCount = 0;
        for (char ch : s.toCharArray()) {
            if (ch != ' ') {
                charCount++;
            }
        }

        int rows = (int) Math.floor(Math.sqrt(charCount));
        int cols = (int) Math.ceil(Math.sqrt(charCount));

        if (rows * cols < charCount) {
            rows++;
        }
        String[] allStrings = new String[rows];
        Arrays.fill(allStrings, "");
        int count = 0,
                index = 0;
        for (char ch : s.toCharArray()) {
            if (ch != ' ') {
                allStrings[index] += ch;
                count++;
            }
            if (count == cols) {
                index++;
                count = 0;
            }
        }

        StringBuilder result = new StringBuilder();
        for (int i = 0; i < cols; i++) {
            for (String str : allStrings) {
                if (i < str.length()) {
                    result.append(str.charAt(i));
                }
            }
            result.append(' ');
        }
        return result.toString();
    }

}

public class Encryption {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));

        String s = bufferedReader.readLine();

        String result = Result16.encryption(s);

        bufferedWriter.write(result);
        bufferedWriter.newLine();

        bufferedReader.close();
        bufferedWriter.close();
    }
}
