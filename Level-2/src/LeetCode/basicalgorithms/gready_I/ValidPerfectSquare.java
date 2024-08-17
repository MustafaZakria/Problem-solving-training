package LeetCode.basicalgorithms.gready_I;

public class ValidPerfectSquare {

    public static void main(String[] args) {
        System.out.println(isPerfectSquare(808201));
    }

    public static boolean isPerfectSquare(int num) {
        if(num == 1) {
            return true;
        }
        long start = 1,
                end = num;
        System.out.println(start + " ---" + end);

        while(end >= start) {
            long mid = (start + end) / 2;
            long product = mid * mid;
            if(product == num) {
                return true;
            } else if(product > num) {
                end = mid - 1;
            } else {
                start = mid + 1;
            }
        }
        return false;
    }
}
