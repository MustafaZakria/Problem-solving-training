package LeetCode.basicalgorithms.gready_I;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.PriorityQueue;

public class LastStoneWeight {

    public static void main(String[] args) {
        int i = lastStoneWeight(new int[]{2, 4, 7 ,1, 8, 1});
        System.out.println(i);
    }

    public static int lastStoneWeight(int[] stones) {
        PriorityQueue<Integer> queue = new PriorityQueue<>(Comparator.reverseOrder());
        for (int i : stones) {
            queue.add(i);
        }
        while (queue.size() > 1) {
            queue.add(queue.poll() - queue.poll());
        }

        return queue.poll();
    }

}
