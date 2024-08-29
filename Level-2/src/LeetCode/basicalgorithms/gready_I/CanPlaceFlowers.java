package LeetCode.basicalgorithms.gready_I;

class CanPlaceFlowers {
    public boolean canPlaceFlowers(int[] flowerbed, int n) {
        int count = 0,
                s = flowerbed.length;
        if(n == 0) return true; //case n = 0
        if(s == 1 && flowerbed[0] == 0) return true; //case 1 size

        if(s > 1 && flowerbed[0] == 0 && flowerbed[1] == 0) { //boundries
            count++;
            flowerbed[0]=1;
        }
        if(s > 2 && flowerbed[s - 1] == 0 && flowerbed[s - 2] == 0) { //boundries
            count++;
            flowerbed[s - 1]=1;
        }
        for(int i = 1; i < s - 1; i+=2) { //rest
            if (flowerbed[i] == 1){
                continue;
            } else if (flowerbed[i - 1] == 0 && flowerbed[i + 1] == 0) {
                count++;
                flowerbed[i]=1;
            } else i--;
        }

        return count >= n;
    }
}
