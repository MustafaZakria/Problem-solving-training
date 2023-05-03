package HackerRank.datastructures.StackandQueue;

import java.io.*;
import java.util.*;

class Solution {
    static Stack<Integer> enqueuedStack = new Stack<>();
    static Stack<Integer> dequeuedStack = new Stack<>();

    public static void enqueue(int element) {
        enqueuedStack.push(element);
    }

    public static void dequeue() {
        if (dequeuedStack.isEmpty()) {
            while (!enqueuedStack.isEmpty()) {
                dequeuedStack.push(enqueuedStack.pop());
            }
        }
        dequeuedStack.pop();
    }

    public static int print() {
        if (dequeuedStack.isEmpty()) {
            while (!enqueuedStack.isEmpty()) {
                dequeuedStack.push(enqueuedStack.pop());
            }
        }
        return dequeuedStack.peek();
    }
}

public class QueueUsingTwoStacks {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int q = scanner.nextInt();
        for(int i = 0; i < q; i++) {
            int queryType = scanner.nextInt();
            switch (queryType) {
                case 1 -> {
                    int input = scanner.nextInt();
                    Solution.enqueue(input);
                }
                case 2 -> Solution.dequeue();
                case 3 -> System.out.println(Solution.print());
            }
        }
    }
}