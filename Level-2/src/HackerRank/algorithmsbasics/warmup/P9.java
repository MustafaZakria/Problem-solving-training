package HackerRank.algorithmsbasics.warmup;

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

class Result9 {

    /*
     * Complete the 'timeConversion' function below.
     *
     * The function is expected to return a STRING.
     * The function accepts STRING s as parameter.
     */
    //00:00:00PM
    public static String timeConversion(String s) {
        int hour = Integer.parseInt(s.substring(0, 2));
        String restOfTime = s.substring(2, 8);
        String timeFormat = s.substring(8);

        if (timeFormat.equals("PM")) {
            if(hour != 12)
                hour += 12;
        } else {
            if (hour == 12)
                hour -= 12;
        }

        if (hour < 10)
            return Integer.toString(0) + hour + restOfTime;
        return hour + restOfTime;
    }
}

public class P9 {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));

        String s = bufferedReader.readLine();

        String result = Result9.timeConversion(s);

        bufferedWriter.write(result);
        bufferedWriter.newLine();

        bufferedReader.close();
        bufferedWriter.close();
    }
}
