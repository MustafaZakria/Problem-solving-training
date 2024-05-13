package LeetCode.basicalgorithms.gready_I;

public class GuessNumberHigher_Lower {}

// *** no library called GuessGame ***

//public class Solution extends GuessGame {
//    public int guessNumber(int n) {
//        long mid = (1 + n) / 2;
//        long start = 1;
//        long end = n;
//        int guess = guess((int)mid);
//        while( end > start) {
//            if(guess == 0)
//                return (int)mid;
//            if(guess == -1) {
//                end = mid - 1;
//            } else {
//                start = mid + 1;
//            }
//            mid = start + (end - start) / 2;
//            guess = guess((int)mid);
//        }
//        return (int)mid;
//    }
//}


