package LeetCode.basicalgorithms.gready_I;

public class LemonadeChange {
    public boolean lemonadeChange(int[] bills) {
        int s = bills.length,
                five = 0,
                ten = 0;
        if (s == 1 & bills[0] != 5) return false;
        for (int i = 0; i < s; i++) {
            if (bills[i] == 5) five++;
            else if (bills[i] == 10) {
                five--;
                ten++;
            } else {
                five--;
                if (ten == 0) {
                    five -= 2;
                } else ten--;
            }
            if (ten < 0 || five < 0) return false;
        }
        return true;
    }

}
