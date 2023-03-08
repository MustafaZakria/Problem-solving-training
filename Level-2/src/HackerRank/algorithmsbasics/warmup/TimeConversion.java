package HackerRank.algorithmsbasics.warmup;

import java.io.*;

import static java.util.stream.Collectors.joining;

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

public class TimeConversion {
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
