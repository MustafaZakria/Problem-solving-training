package LeetCode.basicalgorithms.gready_I;

import java.util.Scanner;
import java.util.Stack;

public class SplitStringInBalancedStrings {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        String s = sc.next();
        System.out.println(balancedStringSplit(s));
    }

    public static int balancedStringSplit(String s) {
        int result = 0,
                counter = 0;
        char ch1 = 'R';
        for (char ch : s.toCharArray()) {
            if (ch == ch1) {
                counter++;
            } else {
                counter--;
            }

            if (counter == 0) {
                result++;
            }
        }

        return result;
    }
}
