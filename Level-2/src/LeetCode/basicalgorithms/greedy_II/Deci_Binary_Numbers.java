package LeetCode.basicalgorithms.greedy_II;

import java.lang.reflect.Array;
import java.util.ArrayList;

public class Deci_Binary_Numbers {
    public int minPartitions(String n) {
        String[] array = n.split("");
        int max = Integer.MIN_VALUE;
        for(int i = 0; i < array.length; i++) {
            int intValue = Integer.parseInt(array[i]);
            if(intValue > max) {
                max = intValue;
            }
        }
        return max;
    }
}
