package LeetCode.basicalgorithms.binarysearch;

public class ArrangingCoins {
    public int arrangeCoins(int n) {  // O(1)
        return (int) (0.5*(-1 + Math.sqrt(((long)n*25)+1)));
    }

    // there are solutions which linear search O(n) and binary search O(log(n))
}
