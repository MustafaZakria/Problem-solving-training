package HackerRank.algorithmsbasics.sorting;

import java.io.*;
import java.util.*;
import java.util.stream.*;

import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

class Result13 {

    /*
     * Complete the 'activityNotifications' function below.
     *
     * The function is expected to return an INTEGER.
     * The function accepts following parameters:
     *  1. INTEGER_ARRAY expenditure
     *  2. INTEGER d
     */

    public static int activityNotifications(List<Integer> expenditure, int d) {
        int result = 0;

        int[] counting_list = new int[201];

        for (int i = 0; i < d; i++)
            counting_list[expenditure.get(i)]++;

        int medianPos = d / 2;    //lower number in case even
        if (d % 2 != 0)
            medianPos++;

        for (int i = d; i < expenditure.size(); i++) {
            double median = getMedian(counting_list, medianPos, d);
            if (expenditure.get(i) >= (median * 2))
                result++;

            //do queueing
            counting_list[expenditure.get(i)]++;
            counting_list[expenditure.get(i - d)]--;

        }

        return result;
    }

    private static double getMedian(int[] counting_list, int medianPos, int end) {
        long counter = 0;
                int left = 0;
        while (counter < medianPos) {
            counter += counting_list[left];
            left++;
        }

        int right = left; //for even days
        left--;

        if (end % 2 != 0 || counter > medianPos) //counter > median for if redundant numbers in medians
            return left;

        while (counting_list[right] == 0) //get right by find another number in counting_list
            right++;

        return ((double) right + left) / 2;
    }
}

public class FraudulentActivityNotifications {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));

        String[] firstMultipleInput = bufferedReader.readLine().replaceAll("\\s+$", "").split(" ");

        int n = Integer.parseInt(firstMultipleInput[0]);

        int d = Integer.parseInt(firstMultipleInput[1]);

        List<Integer> expenditure = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
                .map(Integer::parseInt)
                .collect(toList());

        int result = Result13.activityNotifications(expenditure, d);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedReader.close();
        bufferedWriter.close();
    }
}

