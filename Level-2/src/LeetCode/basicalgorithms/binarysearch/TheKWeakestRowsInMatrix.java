package LeetCode.basicalgorithms.binarysearch;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class TheKWeakestRowsInMatrix {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int m = sc.nextInt();
        int n = sc.nextInt();

        int[][] matrix = new int[m][n];
        for (int i = 0; i < m; i++) {
            for (int k = 0; k < n; k++) {
                matrix[i][k] = sc.nextInt();
            }
        }

        int k = sc.nextInt();

        int[] result = kWeakestRows(matrix, k);
        for (int i : result) {
            System.out.println(i);
        }
    }

    public static int[] kWeakestRows(int[][] mat, int k) {
        int m = mat.length,
                n = mat[0].length;
        Set<Integer> score = new LinkedHashSet<>();

        for (int col = 0; col < n; col++) {
            for (int row = 0; row < m; row++) {
                if (mat[row][col] == 0) {
                    score.add(row);
                }
            }
        }

        score.addAll(IntStream.range(0, m).boxed().toList());  //to add rows that don't have zeros.

        int[] result = new int[k];
        int counter = 0;
        for (Integer ele : score) {
            if (counter < k) {
                result[counter] = ele;
                counter++;
            } else {
                break;
            }
        }
        return result;
    }
}
