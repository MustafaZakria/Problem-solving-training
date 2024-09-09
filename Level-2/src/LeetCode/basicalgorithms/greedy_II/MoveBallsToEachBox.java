package LeetCode.basicalgorithms.greedy_II;

import java.util.Arrays;

public class MoveBallsToEachBox {

    public static void main(String[] args) {
        System.out.println(Arrays.toString(minOperations("001011")));
    }

    public static int[] minOperations(String boxes) {
        String[] stringArray = boxes.split("");
        int[] intArray = new int[boxes.length()];
        for (int i = 0; i < stringArray.length; i++) {
            intArray[i] = Integer.parseInt(stringArray[i]);
        }

        int[] result = new int[boxes.length()];

        int onesBefore = 0,
                onesAfter = 0;

        result[0] = 0;
        for (int i = 1; i < intArray.length; i++) {
            result[0] += (intArray[i] * i);
            onesAfter += intArray[i];
        }
        for (int i = 1; i < intArray.length; i++) {
            onesBefore += intArray[i - 1];
            onesAfter -= intArray[i];
            result[i] = result[i - 1] + onesBefore - intArray[i] - onesAfter;
        }
        return result;
    }
}
