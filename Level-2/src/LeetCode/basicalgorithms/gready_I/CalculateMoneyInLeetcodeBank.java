package LeetCode.basicalgorithms.gready_I;

public class CalculateMoneyInLeetcodeBank {
    public int totalMoney(int n) {
        int iterator = 0,
                result = 0;
        while(n >= 7) {
            result += (28+(iterator*7));
            n -= 7;
            iterator++;
        }
        result += ((n*(n+1)/2)+(iterator*n));
        return result;
    }
}
