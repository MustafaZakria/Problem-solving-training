package LeetCode.basicalgorithms.gready_I;

public class WaterBottles {
    public int numWaterBottles(int numBottles, int numExchange) {
        int result = numBottles;
        while(numBottles >= numExchange) {
            int exchangedBottles = numBottles/numExchange;
            int reminder = numBottles%numExchange;
            numBottles = exchangedBottles + reminder;
            result += exchangedBottles;
        }
        return result;
    }
}
